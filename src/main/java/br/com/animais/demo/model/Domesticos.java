package br.com.animais.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Domesticos extends AnimalBase {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @NotNull
    @Pattern(regexp = "^[SN]$", message = "Apenas S para sim ou N não indicando se o animal é docil")
    private String docil;

    public Domesticos() {
    }

    public Domesticos(String nome, int idade, String sexo, String docil, Long id) {
        super(nome, idade, sexo);
        this.docil = docil;
        this.id = id;
    }

    public String getDocil() {
        return docil;
    }

    public void setDocil(String docil) {
        this.docil = docil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
