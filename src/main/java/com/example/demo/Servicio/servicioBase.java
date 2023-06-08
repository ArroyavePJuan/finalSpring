package com.example.demo.Servicio;

import java.util.List;

public interface servicioBase <E> {

    public List<E> buscarTodos() throws Exception;
    public E buscarPorId( Integer id) throws Exception;
    public E registrar (E datos) throws Exception;
    public E actualizar (Integer id, E datosNuevos) throws Exception;
    public boolean eliminar (Integer id) throws Exception;

}
