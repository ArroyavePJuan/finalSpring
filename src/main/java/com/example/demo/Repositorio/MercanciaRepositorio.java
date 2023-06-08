package com.example.demo.Repositorio;


import com.example.demo.Entidad.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia, Integer> {

}
