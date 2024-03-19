package br.com.animais.demo.service;

import br.com.animais.demo.model.Domesticos;

import java.util.List;

public interface CrudService<T extends Domesticos> {
    List<T> listar();
    T criar(T entity);
    T atualizar(Long id, T upadatedEntity);

    boolean verificaID(Long id);

    boolean delete(Long id);
}
