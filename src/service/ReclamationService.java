/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Reclamation;
import cnx.DataSource;
import entite.User;
import entite.service;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;

/**
 *
 * @author ASUS
 */
public class ReclamationService {

    Connection connection;

    public ReclamationService() {
        connection = DataSource.getInsatance().getConnection();
    }

    public void ajouterReclamation(Reclamation R) {

        String req = "insert into reclamation (titre,text,email,date,service,user_id) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setString(1, R.getTitre());
            preparedStatement.setString(2, R.getText());
            preparedStatement.setString(3, R.getEmail());
            preparedStatement.setString(4, R.getDate());
            preparedStatement.setInt(5, R.getService());
            preparedStatement.setInt(6, R.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerReclamation(Reclamation R, int id) {

        String query = "delete from reclamation where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, R.getId());
            preparedStatement.executeUpdate();
            System.out.println("delete OK!");
        } catch (SQLException ex) {
            System.out.println("Probleme de suppression!");
        }

    }

    public void modifierReclamation(Reclamation R, int id) {

        try {
            PreparedStatement preparedStatement;
            String req;
            req = "UPDATE reclamation SET `titre`=?,`text`=?,`email`=?,`service`=? WHERE id = " + id;

            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setString(1, R.getTitre());
            preparedStatement.setString(2, R.getText());
            preparedStatement.setString(3, R.getEmail());
            preparedStatement.setInt(4, R.getService());
            //preparedStatement.setString(5, R.getDate());

            preparedStatement.executeUpdate();
            System.out.println("Modification OK!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }

    public List<Reclamation> getAll() {
        PreparedStatement preparedStatement;
        List<Reclamation> ReclamationAL = new ArrayList<>();
        String req = "select * from reclamation";

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Reclamation reclamation = new Reclamation(resultSet.getInt("id"), resultSet.getString("titre"), resultSet.getString("text"), resultSet.getString("email"), resultSet.getInt("service"), resultSet.getString("date"), resultSet.getInt("user_id"));
                ReclamationAL.add(reclamation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ReclamationAL;
    }
    
   
    public List<Reclamation> getbyid(int s) {
        PreparedStatement preparedStatement;
        List<Reclamation> ReclamationAL = new ArrayList<>();
        String req = "select * from reclamation where user_id=" + s;

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Reclamation reclamation = new Reclamation(resultSet.getInt("id"), resultSet.getString("titre"), resultSet.getString("text"), resultSet.getString("email"), resultSet.getInt("service"), resultSet.getString("date"), resultSet.getInt("user_id"));
                ReclamationAL.add(reclamation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ReclamationAL;
    }
    
    
    
    
    public int m(int id){
    
     int a=0;
        String req = "select user_id from reclamation  where id="+id;
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               a=resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    
    }
    
    
    
    public int getByNom(int id){
    
     int a=0;
        String req = "select id from reclamation  where text="+id;
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               a=resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    
    }
    
    
    public void combo(ComboBox combo) {
        String req = "select id,nom from service";
        PreparedStatement preparedStatement;
   
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                combo.getItems().add(resultSet.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public service selectService(int id) {
        service s = new service();

        String req = "select * from service where id =" + id + "";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s.setId(resultSet.getInt(1));
                s.setDepartement_id(resultSet.getInt(2));
                s.setNom(resultSet.getString(3));
                s.setDescription(resultSet.getString(4));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    
    public service selectidSer(String d) {
        service s = new service();

        String req = "select * from service where nom ='"+d+"'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s.setId(resultSet.getInt(1));
                s.setDepartement_id(resultSet.getInt(2));
                s.setNom(resultSet.getString(3));
                s.setDescription(resultSet.getString(4));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    
   
    
    
    
    
    
     public int combov(String s) {
         int a=0;
        String req = "select id from service where nom='"+s+"'";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               a=resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
        
    
    
    
    
    
    public Reclamation recherche(int id) throws SQLException{
        PreparedStatement preparedStatement;
        Reclamation R= new Reclamation();
                String req = "select * from reclamation where id=?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1,id);
                
                 ResultSet resultSet = preparedStatement.executeQuery();
                 while (resultSet.next())
                
                 {
                     R.setTitre(resultSet.getString(4));
                     R.setText(resultSet.getString(5));
                     R.setDate(resultSet.getString(8));
                     
                     R.setEmail(resultSet.getString(6));
                 }
                 return R;
    }

    
    public List<Reclamation> getbynew() {
        String s="";
        PreparedStatement preparedStatement;
        List<Reclamation> ReclamationAL = new ArrayList<>();
        String req = "select * from reclamation where dispo = '' ";

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Reclamation reclamation = new Reclamation(resultSet.getInt("id"), resultSet.getString("titre"), resultSet.getString("text"), resultSet.getString("email"), resultSet.getInt("service"), resultSet.getString("date"), resultSet.getInt("user_id"));
                ReclamationAL.add(reclamation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ReclamationAL;
    }
    
    
    
    
     public void setDispo( int id){
           
       
       
       
        try {
            PreparedStatement preparedStatement;
            String req;
            req = "UPDATE reclamation SET dispo = 'a' WHERE id = " + id;

            preparedStatement = connection.prepareStatement(req);

            
            

            preparedStatement.executeUpdate();
            System.out.println("Modification OK!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }
    
     
      public String rec (int m){
        String l="";
        String req = "select titre from reclamation where id='"+m+"'";
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
     
     
     
     
}
