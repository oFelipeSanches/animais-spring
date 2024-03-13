package br.com.animais.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Cachorro extends Domesticos {
    private String raca;

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
