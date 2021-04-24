package br.challengwl.challengewl.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.challengwl.challengewl.Model.CafeDaManha;
import br.challengwl.challengewl.Services.NativeScriptQueries;

@RestController
@RequestMapping("/cafedamanha")
public class CafeDaManhaController {
    private final NativeScriptQueries _nativeScriptQueries;

    public CafeDaManhaController( NativeScriptQueries nativequeries){
        _nativeScriptQueries = nativequeries;
    }

    @CrossOrigin
    @GetMapping("/")
    public List<CafeDaManha> getOpcoesCafe(){
        return _nativeScriptQueries.getAllOpcoesDeCafe("select * from db_cafe order by id");
    }


    @CrossOrigin
    @PostMapping("/incluir")
    public void inserirNovaOpcaoCafe(@RequestBody CafeDaManha cafeDaManha) throws Exception{
        if(!cafeDaManha.toString().isBlank()){
            _nativeScriptQueries.execute("insert into db_cafe(descricao) values ('"+cafeDaManha.getDescricao()+"')");
        }
    }


    @CrossOrigin
    @GetMapping("/{id}")
    public void removerOpcao(@PathVariable("id") Long Id){
        _nativeScriptQueries.execute("delete from db_cafe where id="+Id);
    }

    @CrossOrigin
    @PostMapping("/alterar/{id}")
    public void atualizarOpcaoCafe(@PathVariable("id") Long id, @RequestBody CafeDaManha cafeDaManha) throws Exception{
        if(!cafeDaManha.toString().isBlank()){
            _nativeScriptQueries.execute("update db_cafe set descricao='"+cafeDaManha.getDescricao()+"' where id="+id);
        }
    }


}
