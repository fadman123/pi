/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cnx.DataSource;
import entite.Reclamation;
import entite.User;
import entite.comment;
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
public class CommentaireService {
    Connection connection;
    public CommentaireService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
    public void ajouterCommentaire(comment C) {

        String req = "insert into comment (id_user,idr,commentaire,date) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            
            preparedStatement = connection.prepareStatement(req);
            
           
            preparedStatement.setInt(1, C.getId_user());
            preparedStatement.setInt(2, C.getIdr());
            preparedStatement.setString(3, C.getCommentaire());
            preparedStatement.setString(4, C.getDate());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    public void supprimerCommentaire (comment C, int id) {

        String query = "delete from comment where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, C.getId());
            preparedStatement.executeUpdate();
            System.out.println("delete OK!");
        } catch (SQLException ex) {
            System.out.println("Probleme de suppression!");
        }

    }
    
    
    public void modifierCommentaire(comment C, int id) {

        try {
            PreparedStatement preparedStatement;
            String req;
            req = "UPDATE reclamation SET `commentaire`=? WHERE id = " + id;

            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setString(1, C.getCommentaire());
            

            preparedStatement.executeUpdate();
            System.out.println("Modification OK!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }
    
    
     public List<comment> getAll() {
        PreparedStatement preparedStatement;
        List<comment> commentAL = new ArrayList<>();
        String req = "select * from comment";

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                comment com = new comment(resultSet.getInt("id"), resultSet.getInt("id_user"), resultSet.getInt("idr"), resultSet.getString("commentaire"), resultSet.getString("date"), resultSet.getString("vue"));
                commentAL.add(com);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commentAL;
    }
    
    
       public List<comment> getbyid(int s) {
        PreparedStatement preparedStatement;
        List<comment> coAL = new ArrayList<>();
        String req = "select * from comment where idr=" + s;

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                comment co = new comment(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getInt("idr"),resultSet.getString("commentaire"),resultSet.getString("date"),resultSet.getString("vue"));
                coAL.add(co);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coAL;
    }
    
       
       public void setVue(int id){
           
       
       
       
        try {
            PreparedStatement preparedStatement;
            String req;
            req = "UPDATE comment SET  vue= 'a' WHERE idr = " + id;

            preparedStatement = connection.prepareStatement(req);

            
            

            preparedStatement.executeUpdate();
            System.out.println("Modification OK!");
        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
        }
    }
       
        public List<comment> getbynew() {
        
        PreparedStatement preparedStatement;
        List<comment> comm = new ArrayList<>();
        String req = "select * from comment where vue = '' and not id_user='4' ";

        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

comment co = new comment(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getInt("idr"),resultSet.getString("commentaire"),resultSet.getString("date"),resultSet.getString("vue"));
        comm.add(co);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comm;
    }
    
      public User selectnom(int id) {
       
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

      
       public Reclamation selectRec(int id) {
       
        Reclamation r = new Reclamation();

        String req = "select id,text from reclamation where id =" + id + "";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                r.setId(resultSet.getInt(1));
                r.setText(resultSet.getString(2));
                               

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
      
      
      
      
      
}



