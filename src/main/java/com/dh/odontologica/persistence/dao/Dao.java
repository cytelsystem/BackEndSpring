package com.dh.odontologica.persistence.dao;

import java.util.List;

public interface Dao<T> {

    public T crear(T t);
    public void eliminar(Long id);
    public T actualizar(T t);
    public T consultarPorId(Long id);
    List<T> consultarTodos();
}