package br.com.animais.demo.controller;

import br.com.animais.demo.model.Cachorro;
import br.com.animais.demo.service.CachorroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {

    @Autowired
    CachorroService cachorroService;

    @GetMapping
    public List<Cachorro> getAllCachorros() {
        return cachorroService.listar();
    }

    @PostMapping
    public Cachorro criar(@Valid @RequestBody Cachorro cachorro) {
        return cachorroService.criar(cachorro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cachorro cachorro) {
        if(cachorroService.atualizar(id, cachorro) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(cachorro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(cachorroService.delete(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/{id}")
    public Optional<Cachorro> buscaPorID(@PathVariable Long id) {
        return this.cachorroService.buscaPorID(id);
    }

}
