package com.dh.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> { //Recibe el tipo cómo parámetro
    public T guardar(T t); //Métodos que van a sobreescribirse
    public void eliminar (Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();

}
