/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class bddControl {
    
    public ResultSet rs;
    public PreparedStatement ps;
    public Statement st;
    private Connection connection;
    public String sql;
    
    public bddControl(){}
    
    public void Select(String valores, String nomTabla){

        if(valores == null)
            valores = "*";
        
        sql = "SELECT "+valores+" FROM "+nomTabla;

         try{
            
            connection = Conectar.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                

            }

        }catch (SQLException e){}
        
    }
    
    public void Select(String valores, String nomTabla, String accion, String nomCampo, String value){

        if(valores == null)
            valores = "*";
        
        sql = "SELECT "+valores+" FROM "+nomTabla+"WHERE"+nomCampo+"="+"'"+value+"'";
        
        boolean encontrado = false;
        
         try{
            
            connection = Conectar.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){

                encontrado = true;

            }

            
        }catch (SQLException e){}
        
    }
    
    
    
    
}
