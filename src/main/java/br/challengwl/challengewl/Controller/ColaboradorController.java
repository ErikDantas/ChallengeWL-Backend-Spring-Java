package br.challengwl.challengewl.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.challengwl.challengewl.Model.Colaborador;
import br.challengwl.challengewl.Services.NativeScriptQueries;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    
    //private final ColaboradorRepository _colaboradorRepository;
    private final NativeScriptQueries _nativeScriptQueries;


    public ColaboradorController(NativeScriptQueries queries ){
        this._nativeScriptQueries=queries;
    }

    @CrossOrigin
    @GetMapping("/")
    public List<Colaborador> getColaboradores(){
        return _nativeScriptQueries.getAllColaboradores("select * from db_colaborador order by nome");
    }


    @CrossOrigin
    @PostMapping("/incluir")
    public void novoColaborador(@RequestBody Colaborador colaborador){
        _nativeScriptQueries.execute("insert into db_colaborador(nome, cpf, cafe_da_manha) values('"+colaborador.getNome()+"', '"+colaborador.getCpf()+"', '"+colaborador.getCafeDaManha()+"')");
    }


    @CrossOrigin
    @GetMapping("/{cpf}")
    public void removerColaborador(@PathVariable("cpf") String cpf){
        _nativeScriptQueries.execute("delete from db_colaborador where cpf='"+cpf+"'");
    }

    @CrossOrigin
    @PostMapping("/alterar/{cpf}")
    public void atualizarColaborador(@PathVariable("cpf") String cpf, @RequestBody Colaborador colaborador){
        if(!colaborador.toString().isBlank()){
            _nativeScriptQueries.execute("update db_colaborador set nome='"+colaborador.getNome()+"', cpf='"+colaborador.getCpf()+"', cafe_da_manha='"+colaborador.getCafeDaManha()+"' where cpf='"+cpf+"'");
        }
    }
}
