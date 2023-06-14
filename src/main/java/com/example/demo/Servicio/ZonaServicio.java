package com.example.demo.Servicio;

import com.example.demo.Entidad.Zona;
import com.example.demo.Repositorio.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicio implements servicioBase<Zona>{

    @Autowired
    private ZonaRepositorio zonaRepositorio;

    @Override
    public List<Zona> buscarTodos() throws Exception {
        try {
            List<Zona> zonas = zonaRepositorio.findAll();
            return zonas;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                return zonaOptional.get();
            }else {
                throw new Exception("No se encontro la zona");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona registrar(Zona datos) throws Exception {
        try {
            Zona zonaGuardada = zonaRepositorio.save(datos);
            return zonaGuardada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona actualizar(Integer id, Zona datosNuevos) throws Exception {
        try{
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                Zona zonaActualizada = zonaRepositorio.save(datosNuevos);
                return zonaActualizada;
            }else {
                throw new Exception("No se encontro la zona");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                zonaRepositorio.deleteById(id);
                return true;
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
