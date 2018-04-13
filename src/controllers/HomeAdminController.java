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
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeAdminController implements Initializable {

    @FXML
    private Button affiche;
    @FXML
    private Button statistique;
    @FXML
    private Button newreclamation;
    @FXML
    private Button newcommentaire;
    @FXML
    private Button Avis;
    @FXML
    private Button statistique1;
    @FXML
    private Button newcommentaire1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/ReclamationAdmin.fxml"))));
    }

    @FXML
    private void statistique(ActionEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/statistique.fxml"))));
        
    }

    @FXML
    private void newreclamation(ActionEvent event) throws IOException {
                PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/NewReclamation.fxml"))));

    }

    @FXML
    private void newcommentaire(ActionEvent event) throws IOException {
                PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/NewCommentaire.fxml"))));

    }

    @FXML
    private void Avis(ActionEvent event) throws IOException {
                        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/ConsulterAvis.fxml"))));

    }

    @FXML
    private void statistique1(ActionEvent event) throws IOException {
                                PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/statistiqueAvis.fxml"))));

    }
    
}
