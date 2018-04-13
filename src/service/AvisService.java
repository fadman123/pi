/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cnx.DataSource;
import entite.Avis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AvisService {
    
    Connection connection;

    public AvisService() {
        connection = DataSource.getInsatance().getConnection();
    }
     public void ajouterAvis(Avis A) {

        String req = "insert into avis (name,email,comm,pourcentage,user_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setString(1, A.getName());
            preparedStatement.setString(2, A.getEmail());
            preparedStatement.setString(3, A.getComm());
            preparedStatement.setString(4, A.getPourcentage());
             preparedStatement.setInt(5, A.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
    public List<Avis> getAll() {
        PreparedStatement preparedStatement;
        List<Avis> a = new ArrayList<>();
        String req = "select * from avis";

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Avis avis = new Avis(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("comm"), resultSet.getString("pourcentage"), resultSet.getInt("user_id"));

                a.add(avis);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    
    
    public void supprimerAvis (Avis a, int id) {

        String query = "delete from avis where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, a.getId());
            preparedStatement.executeUpdate();
            System.out.println("delete OK!");
        } catch (SQLException ex) {
            System.out.println("Probleme de suppression!");
        }

    }
}
