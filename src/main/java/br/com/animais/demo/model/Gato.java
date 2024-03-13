package br.com.animais.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Gato extends Domesticos {
    private String corPelagem;

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }
}
