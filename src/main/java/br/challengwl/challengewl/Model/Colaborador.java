package br.challengwl.challengewl.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="db_colaborador")
public class Colaborador {
    
    
    private String Nome;
    @Id
    private String Cpf;
    @Column(unique = true)
    private String CafeDaManha;

    public String getCafeDaManha() {
        return CafeDaManha;
    }
    public void setCafeDaManha(String cafeDaManha) {
        CafeDaManha = cafeDaManha;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getCpf() {
        return Cpf;
    }
    public void setCpf(String cpf) {
        Cpf = cpf;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CafeDaManha == null) ? 0 : CafeDaManha.hashCode());
        result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
        result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Colaborador other = (Colaborador) obj;
        if (CafeDaManha == null) {
            if (other.CafeDaManha != null)
                return false;
        } else if (!CafeDaManha.equals(other.CafeDaManha))
            return false;
        if (Cpf == null) {
            if (other.Cpf != null)
                return false;
        } else if (!Cpf.equals(other.Cpf))
            return false;
        if (Nome == null) {
            if (other.Nome != null)
                return false;
        } else if (!Nome.equals(other.Nome))
            return false;
        return true;
    }

    
}
