package br.com.animais.demo.controller;

import br.com.animais.demo.model.Domesticos;
import br.com.animais.demo.service.CrudService;
import br.com.animais.demo.service.DomesticosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domesticos")
public class DomesticosController {

    @Autowired
    DomesticosService domesticosService;

    @GetMapping
    public List<Domesticos> getAllDomesticos() {
        return domesticosService.listar();
    }

    @PostMapping
    public Domesticos criar(@Valid @RequestBody Domesticos domesticos) {
        return this.domesticosService.criar(domesticos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Domesticos domesticos) {
        if(domesticosService.atualizar(id, domesticos) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(domesticos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (domesticosService.delete(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

}
