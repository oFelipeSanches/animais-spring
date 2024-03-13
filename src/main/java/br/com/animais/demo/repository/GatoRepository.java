package br.com.animais.demo.repository;

import br.com.animais.demo.model.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatoRepository extends JpaRepository<Gato, Long> {
}
