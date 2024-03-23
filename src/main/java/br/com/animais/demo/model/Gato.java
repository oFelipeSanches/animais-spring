package br.com.animais.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Gato extends Domesticos {
    @NotNull
    private String corPelagem;

    public Gato(String nome, int idade, String sexo, String docil, Long id, String corPelagem) {
        super(nome, idade, sexo, docil, id);
        this.corPelagem = corPelagem;
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }
}
