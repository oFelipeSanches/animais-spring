package br.com.animais.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cachorro extends Domesticos {
    @NotNull
    private String raca;

    public Cachorro(String nome, int idade, String sexo, String docil, Long id, String raca) {
        super(nome, idade, sexo, docil, id);
        this.raca = raca;
    }

    public Cachorro() {
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
