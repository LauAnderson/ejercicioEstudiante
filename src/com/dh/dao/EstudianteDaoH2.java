package com.dh.dao;

import com.dh.entity.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Estudiante guardar(Estudiante estudiante)  {
        //Pasos para guardar en una base de datos

        //1. Creamos una conexión y un objeto preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //2. Levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //3. Creamos una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            preparedStatement.setLong(1, estudiante.getId());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setString(3, estudiante.getApellido());

            //4. Ejecutamos sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return estudiante;

    }

    @Override
    public void eliminar(Long id) {
        //1. Creamos una conexión y un objeto preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //2. Levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //3. Creamos una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE id = ?");
            preparedStatement.setLong(1, id);


            //4. Ejecutamos sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Estudiante buscar(Long id) {
        //1. Creamos una conexión, un objeto preparedStatement y al estudiante
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante estudiante = null;

        try {
            //2. Levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //3. Creamos una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE id = ?");
            preparedStatement.setLong(1, id);


            //4. Ejecutamos sentencia
            ResultSet result = preparedStatement.executeQuery(); //Me devuelve un resultado
            //5. Recorro los registros de ese resultado
            while (result.next()){
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                estudiante = new Estudiante(); // Si se encuentra el estudiante lo instanciamos
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);



            }
            preparedStatement.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        //1. Creamos una conexión, un objeto preparedStatement y una lista de estudiantes
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Estudiante> estudiantes = new ArrayList<>();

        try {
            //2. Levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //3. Creamos una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes");



            //4. Ejecutamos sentencia
            ResultSet result = preparedStatement.executeQuery(); //Me devuelve un resultado
            //5. Recorro los registros de ese resultado
            while (result.next()){
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Estudiante estudiante = new Estudiante(); // Si se encuentra el estudiante lo instanciamos
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

                estudiantes.add(estudiante);





            }
            preparedStatement.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiantes;
    }
}
