package com.example.demo.Repositorio;

import com.example.demo.Entidad.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository<Zona, Integer> {

}
