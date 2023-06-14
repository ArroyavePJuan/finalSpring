package com.example.demo.Servicio;

import com.example.demo.Entidad.Mercancia;
import com.example.demo.Repositorio.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio implements servicioBase<Mercancia>{

    @Autowired
    protected MercanciaRepositorio mercanciaRepositorio;


    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        try {
            List<Mercancia>mercancias=mercanciaRepositorio.findAll();
            return mercancias;

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                return mercanciaOptional.get();
            }else{
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia datos) throws Exception {
        try{
            Mercancia mercanciaGuardada = mercanciaRepositorio.save(datos);
            return mercanciaGuardada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional = mercanciaRepositorio.findById(id);
            if(mercanciaOptional.isPresent()){
                Mercancia mercanciaActualizada = mercanciaRepositorio.save(datosNuevos);
                return mercanciaActualizada;
            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                mercanciaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}