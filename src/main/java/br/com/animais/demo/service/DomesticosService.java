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
        return null;
    }

    @Override
    public Domesticos get(Long id) {
        return null;
    }

    @Override
    public Domesticos criar(Domesticos entity) {
        return null;
    }

    @Override
    public Domesticos atualizar(Long id, Domesticos upadatedEntity) {
        return null;
    }

    private boolean verificaID(Long id) {
        return this.domesticosRepository.existsById(id);
    }

    @Override
    public Domesticos update(Long id, Domesticos updatedDomesticos) {
        Domesticos existingDomesticos = get(id);

        existingDomesticos.setTipo(updatedDomesticos.getTipo());
        existingDomesticos.setNome(updatedDomesticos.getNome());
        existingDomesticos.setIdade(updatedDomesticos.getIdade());
        existingDomesticos.setSexo(updatedDomesticos.getSexo());

        return domesticosRepository.save(existingDomesticos);
    }


    @Override
    public boolean delete(Long id) {
        if (this.verificaID(id)) {
            this.domesticosRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
