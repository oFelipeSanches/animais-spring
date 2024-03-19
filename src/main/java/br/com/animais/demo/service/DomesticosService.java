package br.com.animais.demo.service;

import br.com.animais.demo.model.Domesticos;
import br.com.animais.demo.repository.DomesticosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomesticosService implements CrudService<Domesticos> {

    @Autowired
    private DomesticosRepository domesticosRepository;

    @Override
    public List<Domesticos> listar() {
        return domesticosRepository.findAll();
    }

    @Override
    public Domesticos criar(Domesticos domesticos) {
        return domesticosRepository.save(domesticos);
    }

    @Override
    public Domesticos atualizar(Long id, Domesticos domesticos) {
        if(domesticosRepository.existsById(id)) {
            domesticos.setId(id);
            return domesticosRepository.save(domesticos);
        }
        return null;
    }


    private boolean verificaID(Long id) {
        return this.domesticosRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(domesticosRepository.existsById(id)) {
            domesticosRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
