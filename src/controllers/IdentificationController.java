/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cnx.DataSource;
import entite.User;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IdentificationController implements Initializable {

    @FXML
    private TextArea log;
    @FXML
    private Button cnx;
    @FXML
    private Button annuler;
    @FXML
    private PasswordField mot;
    private static int idCnx;

    public static int getIdCnx() {
        return idCnx;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void cnx(ActionEvent event) throws IOException, SQLException {
        
        DataSource myDB = DataSource.getInsatance();
            Statement stm2 = myDB.getConnection().createStatement();
            ResultSet rest2=stm2.executeQuery("select * from user where name = '"+log.getText()+"'");
            System.out.println(log.getText());
            User user = new User();
            while(rest2.next())
            {
                user.setId(rest2.getInt(1));
                user.setName(rest2.getString(2));
                user.setEmail(rest2.getString(3));
                user.setRole(rest2.getString(4));
                user.setPass(rest2.getString(5));
                
       
                
            
            }
            idCnx =user.getId();
            
            
            
            if (user.getRole().equals("admin") )
       {
           PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeAdmin.fxml"))));
       }
            else if (user.getRole().equals("user"))
            {
                PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));
            }
    
            else 
            {
                Alert alert=new Alert(Alert.AlertType.WARNING);
       alert.setTitle("Update");
       alert.setHeaderText("invald mot de passe");
       alert.setContentText("");
       alert.showAndWait();
            }
            }
    


    @FXML
    private void annuler(ActionEvent event) {
    }
    
}
