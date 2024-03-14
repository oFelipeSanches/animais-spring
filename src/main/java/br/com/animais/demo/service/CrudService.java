package br.com.animais.demo.service;

import br.com.animais.demo.model.Domesticos;

import java.util.List;

public interface CrudService<T> {
    List<T> listar();
    T get(Long id);
    T criar(T entity);
    T atualizar(Long id, T upadatedEntity);

    Domesticos update(Long id, Domesticos updatedDomesticos);

    boolean delete(Long id);
}
