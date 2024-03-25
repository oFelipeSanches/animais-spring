package br.com.animais.demo.controller;

import br.com.animais.demo.model.Gato;
import br.com.animais.demo.service.GatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gatos")
public class GatoController {

    @Autowired
    GatoService gatoService;

    @GetMapping
    public List<Gato> getAllGatos() {
        return gatoService.listar();
    }

    @PostMapping
    public Gato criar(@Valid @RequestBody Gato gato) {
        return gatoService.criar(gato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Gato gato) {
        if(gatoService.atualizar(id, gato) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(gato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(gatoService.delete(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/{id}")
    public Optional<Gato> buscaPorID(@PathVariable Long id) {
        return this.gatoService.buscaPorID(id);
    }

}
