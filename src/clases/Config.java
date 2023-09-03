package clases;

import clases.bdd.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Config {
    
    private Connection connection;
    private PreparedStatement prepareStatement;
    private Statement statement;
    private ResultSet resultSet;
    
    private String id, categoria, inscripcion, mensualidad, instructor, dias, hora1, ampm1, hora2, ampm2;
    
    public ArrayList getCategorias(){

        ArrayList cate = new ArrayList();
        cate.add(0,"----------");
        int i = 1;
        
        try{
            connection = Conectar.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT categoria FROM configcategoria");

            while(resultSet.next()){
                String add = resultSet.getString("categoria"); cate.add(i, add);
                i = i + 1;
            }
            
            return cate;
        }catch (SQLException ex){}
        
        return null;
    }
    
    public ArrayList getMembresias(){

        ArrayList memb = new ArrayList();
        memb.add(0,"----------");
        int i = 1;
        
        try{
            connection = Conectar.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT membresia FROM configmembresias");

            while(resultSet.next()){
                String add = resultSet.getString("membresia"); memb.add(i, add);
                i = i + 1;
            }
            
            return memb;
        }catch (SQLException ex){}
        
        return null;
    }
    
    public ArrayList getFederativas(){

        ArrayList fedes = new ArrayList();
        fedes.add(0,"----------");
        int i = 1;
        
        try{
            connection = Conectar.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT tipofederacion FROM configcompetencia WHERE tipo='federativa'");

            while(resultSet.next()){
                String add = resultSet.getString("tipofederacion"); fedes.add(i, add);
                i = i + 1;
            }
            
            return fedes;
        }catch (SQLException ex){}
        
        return null;
    }
    
    public ArrayList getNoFederativas(){

        ArrayList fedes = new ArrayList();
        fedes.add(0,"----------");
        int i = 1;
        
        try{
            connection = Conectar.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT tipofederacion FROM configcompetencia WHERE tipo='nofederativa'");

            while(resultSet.next()){
                String add = resultSet.getString("tipofederacion"); fedes.add(i, add);
                i = i + 1;
            }
            
            return fedes;
        }catch (SQLException ex){}
        
        return null;
    }
    
    public float getCostoSakura(String tipo){

        if(tipo.equals("inscripcion")){
            
            float costoInscripcion = 0;
        
            try{
                connection = Conectar.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM configsakura");

                while(resultSet.next()){
                    costoInscripcion = resultSet.getFloat("inscripcion");
                }

                return costoInscripcion;
            }catch (SQLException ex){}
        
            return 0;
            
        }
        
        if(tipo.equals("membresia")){
            
            float costoInscripcion = 0;
        
            try{
                connection = Conectar.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM configsakura");

                while(resultSet.next()){
                    costoInscripcion = resultSet.getFloat("membresia");

                }

                return costoInscripcion;
            }catch (SQLException ex){}

            return 0;
        }
        
        float costoInscripcion = 0;
        
        try{
            connection = Conectar.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM configsakura WHERE ");

            while(resultSet.next()){
                costoInscripcion = resultSet.getFloat("inscripcion");
  
            }
            
            return costoInscripcion;
        }catch (SQLException ex){}
        
        return 0;
    }
    
    public ArrayList getSexos(){

        ArrayList cate = new ArrayList();
        
        cate.add(0, "----------");
        cate.add(1, "Masculino");
        cate.add(2, "Femenino");
            
        return cate;

    }
    
    public void getMetadatosCategoria(String categoria){
        
        try{
            
            connection = Conectar.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM configcategoria WHERE categoria = '"+categoria+"'");
            
            while(resultSet.next()){

                String add1 = resultSet.getString("id"); setId(add1);
                
                String add2 = resultSet.getString("categoria"); setCategoria(add2);
                
                String add3 = resultSet.getString("inscripcion"); setInscripcion(add3);
                
                String add4 = resultSet.getString("mensualidad"); setMensualidad(add4);
                
                String add5 = resultSet.getString("instructor"); setInstructor(add5);
                
                String add6 = resultSet.getString("dias"); setDias(add6);
                
                String add7 = resultSet.getString("hora1"); setHora1(add7);
                
                String add8 = resultSet.getString("hora2"); setHora2(add8);
                
                String add9 = resultSet.getString("ampm1"); setAmpm1(add9);
                
                String add10 = resultSet.getString("ampm2"); setAmpm2(add10);
            }
        }catch(SQLException ex){}
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(String inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
    
    public String getInstructor(){
        return instructor;
    }

    public String getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(String mensualidad) {
        this.mensualidad = mensualidad;
    }
    
    public String getDias(){
        return dias;
    }
    
    public void setDias(String dias){
        this.dias = dias;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public String getAmpm1() {
        return ampm1;
    }

    public void setAmpm1(String ampm1) {
        this.ampm1 = ampm1;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    public String getAmpm2() {
        return ampm2;
    }

    public void setAmpm2(String ampm2) {
        this.ampm2 = ampm2;
    }
    
    
  
}
