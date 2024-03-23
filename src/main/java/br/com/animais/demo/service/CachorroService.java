package br.com.animais.demo.service;

import br.com.animais.demo.model.Cachorro;
import br.com.animais.demo.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CachorroService implements CrudService<Cachorro> {

    @Autowired
    private CachorroRepository cachorroRepository;

    @Override
    public List<Cachorro> listar() {
        return cachorroRepository.findAll();
    }

    @Override
    public Cachorro criar(Cachorro cachorro) {
        return cachorroRepository.save(cachorro);
    }

    @Override
    public Cachorro atualizar(Long id, Cachorro cachorro) {
        if(verificaID(id)) {
            cachorro.setId(id);
            return cachorroRepository.save(cachorro);
        }
        return null;
    }

    @Override
    public boolean verificaID(Long id) {
        return this.cachorroRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(verificaID(id)) {
            cachorroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Cachorro> buscaPorID(Long id) {
        return this.cachorroRepository.findById(id);
    }
}
