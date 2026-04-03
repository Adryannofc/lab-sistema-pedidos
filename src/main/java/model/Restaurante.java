package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante extends Usuario{
    private String cnpj;

    protected Restaurante(){}

    public Restaurante(String nome, String email, String senha, String telefone, String cnpj) {
        super(nome, email, senha, telefone, TipoUsuario.RESTAURANTE);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
