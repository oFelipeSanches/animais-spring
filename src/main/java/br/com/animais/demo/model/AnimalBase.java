package br.com.animais.demo.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@MappedSuperclass
public abstract class AnimalBase {
    @NotNull
    @Pattern(regexp = "^(Cachorro|Gato)$", message = "Apenas Cachorro ou Gato é possível")
    private String tipo;
    @NotNull
    private String nome;
    @NotNull
    private int idade;
    @NotNull
    @Pattern(regexp = "^[MF]$", message = "Apenas M ou F de Masculino ou Feminino serão aceitas")
    private String sexo;

    public AnimalBase() {

    }

    public AnimalBase(String tipo, String nome, int idade, String sexo) {
        this.tipo = tipo;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
