/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import entite.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheController implements Initializable {

    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, Integer> id;
    @FXML
    private TableColumn<Reclamation, String> titre;
    @FXML
    private TableColumn<Reclamation, String> text;
    @FXML
    private TableColumn<Reclamation, String> email;
    @FXML
    private TableColumn<Reclamation, String> date;
    @FXML
    private TableColumn<Reclamation, String> service;
      
    
    private ReclamationService sReclamation=new ReclamationService();
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button Ajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            text.setCellValueFactory(new PropertyValueFactory<>("text"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            service.setCellValueFactory(new PropertyValueFactory<>("service"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            //service.setCellValueFactory(new PropertyValueFactory<>("service_id"));
            //columnUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
            //columnSpecialiste.setCellValueFactory(new PropertyValueFactory<>("id_calendrier"));

            List<Reclamation> list = sReclamation.getAll();//chargina liste bech n3abeha fi able view

            ObservableList<Reclamation> items = FXCollections.observableArrayList(list);//bech n3abiwha baaed fi tabview //bech nhot fih les objets taa liste

           
        

            
            table.setItems(items);
            
            
    }    
    
    
    

    @FXML
    private void affiche(ActionEvent event) throws IOException {
    PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Ajout.fxml"))));
   
    }

    @FXML
    private void modi(ActionEvent event) throws IOException {
        
        
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/modifier.fxml"))));
    }
    
    
}
