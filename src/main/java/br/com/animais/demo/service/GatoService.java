package br.com.animais.demo.service;

import br.com.animais.demo.model.Gato;
import br.com.animais.demo.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatoService implements CrudService<Gato> {
    @Autowired
    private GatoRepository gatoRepository;


    @Override
    public List<Gato> listar() {
        return gatoRepository.findAll();
    }

    @Override
    public Gato criar(Gato gato) {
        return gatoRepository.save(gato);
    }

    @Override
    public Gato atualizar(Long id, Gato gato) {
        if(verificaID(id)) {
            gato.setId(id);
            return gatoRepository.save(gato);
        }
        return null;
    }

    @Override
    public boolean verificaID(Long id) {
        return this.gatoRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(verificaID(id)) {
            gatoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Gato> buscaPorID(Long id) {
        return this.gatoRepository.findById(id);
    }
}
