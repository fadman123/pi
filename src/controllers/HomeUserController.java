/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import service.IdentificationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeUserController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private Button monreclamation;
    @FXML
    private Button tousrec;
    @FXML
    private Label Nom;
    @FXML
    private Label email;
    private IdentificationService sIden=new IdentificationService();
    @FXML
    private Button avis;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int c=IdentificationController.getIdCnx();
        Nom.setText(sIden.ml(c));
        email.setText(sIden.em(c));
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Ajout.fxml"))));
    }

    @FXML
    private void monreclamation(ActionEvent event) throws IOException {
         PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/MonReclamation.fxml"))));
        
    }


    @FXML
    private void tousrec(ActionEvent event) throws IOException {
                PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/tousRec.fxml"))));

        
        
        
        
    }

    @FXML
    private void avis(ActionEvent event) throws IOException {
         PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Avis.fxml"))));
        
    }
    
}
