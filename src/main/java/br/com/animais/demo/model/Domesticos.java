package br.com.animais.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

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

    public Domesticos() {
    }

    public Domesticos(String tipo, String nome, int idade, String sexo, Long id) {
        super(tipo, nome, idade, sexo);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
