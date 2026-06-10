package com.ferbo.gestion.core.commons.dao;

import java.util.Optional;

public interface GenericDAO<T, ID> 
{
    Optional<T> buscarPorId(ID id);
    void guardar(T entity);
    void actualizar(T entity);
    void eliminar(T entity);
}
