package com.dh;

import com.dh.dao.EstudianteDaoH2;
import com.dh.entity.Estudiante;
import com.dh.service.EstudianteService;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();

        estudiante.setId(1L); //La L es de long
        estudiante.setNombre("Laura");
        estudiante.setApellido("Anderson");

        EstudianteService estudianteService = new EstudianteService();
        //Seteamos una estrategia de persistencia, es decir un Dao
        estudianteService.setEstudianteIDao(new EstudianteDaoH2());

        estudianteService.guardarEstudiante(estudiante);


    }
}
