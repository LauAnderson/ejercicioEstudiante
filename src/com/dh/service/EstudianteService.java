package com.dh.service;

import com.dh.dao.IDao;
import com.dh.entity.Estudiante;

import java.util.List;

public class EstudianteService {
    private IDao<Estudiante> estudianteIDao;

    public IDao<Estudiante> getEstudianteIDao() { //Métodos accesores
        return estudianteIDao;
    }

    public void setEstudianteIDao(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }

    //Métodos que delega la responsabilidad de las acciones al Dao
    public void guardarEstudiante(Estudiante e){
        estudianteIDao.guardar(e);
    }

    public  void eliminarEstudiante(Long id){
        estudianteIDao.eliminar(id);
    }

    public Estudiante buscarEstudiante(Long id){
        return estudianteIDao.buscar(id);
    }

    public List<Estudiante> buscarTodos(){
        return estudianteIDao.buscarTodos();
    }
}