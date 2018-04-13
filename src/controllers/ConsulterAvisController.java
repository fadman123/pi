/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entite.Avis;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.AvisService;
import service.IdentificationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsulterAvisController implements Initializable {
 int b;

    @FXML
    private TableView<Avis> tableNewComm;
    @FXML
    private TableColumn<Avis, String> nom;
    @FXML
    private TableColumn<Avis, String> commentaire;
    @FXML
    private Label noml;
    @FXML
    private Label coml;
    @FXML
    private Label pourl;
    @FXML
    private ImageView image;
    @FXML
    private TableColumn<Avis, String> pourcentage;
 private AvisService sAvis=new AvisService();
    @FXML
    private Button retourner;
    @FXML
    private Button supprimer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         affichetableview();
        tableNewComm.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldvalue, newValue) ->selectionItemTable(newValue));
        
    }    
    
    
     public void selectionItemTable(Avis avis){
         
        String n=avis.getName();
        b =avis.getId();
        noml.setText(avis.getName());
         coml.setText(avis.getComm());
          pourl.setText(avis.getPourcentage());
     image.setImage(new Image("/views/"+n+".jpg"));
     }
          
    
    
    public void affichetableview(){
        
        
            nom.setCellValueFactory(new PropertyValueFactory<>("name"));
            commentaire.setCellValueFactory(new PropertyValueFactory<>("comm"));
            pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
            
            
            
            List<Avis> list1 = sAvis.getAll();
           ObservableList<Avis> item = FXCollections.observableArrayList(list1);
           tableNewComm.setItems(item);
            }

    @FXML
    private void retourner(ActionEvent event)throws IOException {
                 PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeAdmin.fxml"))));

    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        Avis avis =tableNewComm.getSelectionModel().getSelectedItem();
        if(avis==null)
            return;
        
        sAvis.supprimerAvis(avis,(b));
         tableNewComm.getItems().remove(avis);
    }
    
}
