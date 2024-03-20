package br.com.animais.demo.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@MappedSuperclass
public abstract class AnimalBase {

    @NotNull
    private String nome;
    @NotNull
    private int idade;
    @NotNull
    @Pattern(regexp = "^[MF]$", message = "Apenas M ou F de Masculino ou Feminino serão aceitas")
    private String sexo;

    public AnimalBase() {

    }

    public AnimalBase(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
