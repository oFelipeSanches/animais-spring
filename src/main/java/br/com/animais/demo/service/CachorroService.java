package br.com.animais.demo.service;

import br.com.animais.demo.model.Cachorro;
import br.com.animais.demo.model.Domesticos;
import br.com.animais.demo.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CachorroService implements CrudService<Cachorro> {
    @Autowired
    private CachorroRepository cachorroRepository;

    @Override
    public List<Cachorro> listar() {
        return null;
    }

    @Override
    public Cachorro criar(Cachorro entity) {
        return null;
    }

    @Override
    public Cachorro atualizar(Long id, Cachorro upadatedEntity) {
        return null;
    }

    @Override
    public boolean verificaID(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public Optional<Cachorro> buscaPorID(Long id) {
        return this.cachorroRepository.findById(id);
    }
}
