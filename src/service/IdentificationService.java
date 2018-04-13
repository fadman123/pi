/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cnx.DataSource;
import entite.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class IdentificationService {
    
    Connection connection;

    public IdentificationService() {
        connection = DataSource.getInsatance().getConnection();
    }

    
    public String ml (int m){
        String l="";
        String req = "select name from user where id='"+m+"'";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               l=resultSet.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public String em (int m){
        String l="";
        String req = "select email from user where id='"+m+"'";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               l=resultSet.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
     public String n (int m){
        String l="";
        String req = "select name from user where id='"+m+"'";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               l=resultSet.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    
     public User selectIden(int id) {
        User u = new User();

        String req = "select * from user where id =" + id + "";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u.setId(resultSet.getInt(1));
                u.setName(resultSet.getString(2));
                u.setRole(resultSet.getString(3));
                 u.setPass(resultSet.getString(4));
                  u.setEmail(resultSet.getString(5));
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
     
     
     
     
     
     
     
     
     
}
