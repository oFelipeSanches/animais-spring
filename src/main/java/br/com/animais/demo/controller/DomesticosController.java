package br.com.animais.demo.controller;

import br.com.animais.demo.model.Domesticos;
import br.com.animais.demo.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domesticos")
public class DomesticosController {

    @Autowired
    private CrudService<Domesticos> domesticosService;

    @GetMapping
    public List<Domesticos> getAllDomesticos() {
        return domesticosService.listar();
    }

    @GetMapping("/{id}")
    public Domesticos getDomesticosById(@PathVariable Long id) {
        return domesticosService.getById(id);
    }

}
