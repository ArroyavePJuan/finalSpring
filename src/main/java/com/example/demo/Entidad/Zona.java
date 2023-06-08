package com.example.demo.Entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "zonas")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idZona")
    private Integer id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="volumenMaximo", nullable = false)
    private Integer volumenMaximo;

    @OneToMany(mappedBy = "zona")
    private List<Mercancia> mercancias;

    public Zona() {
    }

    public Zona(Integer id, String nombre, Integer volumenMaximo, List<Mercancia> mercancias) {
        this.id = id;
        this.nombre = nombre;
        this.volumenMaximo = volumenMaximo;
        this.mercancias = mercancias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVolumenMaximo() {
        return volumenMaximo;
    }

    public void setVolumenMaximo(Integer volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }

    public List<Mercancia> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<Mercancia> mercancias) {
        this.mercancias = mercancias;
    }
}
