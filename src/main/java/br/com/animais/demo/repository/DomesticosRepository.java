package br.com.animais.demo.repository;

import br.com.animais.demo.model.Domesticos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomesticosRepository extends JpaRepository<Domesticos, Long> {
}
