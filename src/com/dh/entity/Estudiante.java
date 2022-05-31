package com.dh.entity;

public class Estudiante {
    private Long id;
    private String nombre; //Atributos
    private String apellido;

    public Long getId() { //Métodos accesores
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
