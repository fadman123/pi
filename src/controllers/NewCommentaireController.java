/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.prism.impl.Disposer;
import entite.Reclamation;
import entite.User;
import entite.comment;
import entite.service;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import service.ButtonCell;
import service.ButtonCellU;
import service.Buttoncom;
import service.CommentaireService;
import service.IdentificationService;
import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class NewCommentaireController implements Initializable {

    private ReclamationService sReclamation=new ReclamationService();
    private CommentaireService sComment=new CommentaireService();
    private IdentificationService sIden=new IdentificationService();
    
    
    @FXML
    private TableColumn<Disposer.Record,Boolean> consulter;
    @FXML
    private Label noml;
    @FXML
    private Label reclamationl;
    @FXML
    private Label commentairel;
    @FXML
    private TableView<comment> tableNewComm;
    @FXML
    private TableColumn<comment, String> nom;
    @FXML
    private TableColumn<comment, String> Reclam;
    @FXML
    private TableColumn<comment, String> commentaire;
    @FXML
    private Button retourner;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       affichetableview();
        tableNewComm.getSelectionModel().selectedItemProperty().addListener(
               (observable, oldvalue, newValue) ->selectionItemTable(newValue));
    }    
    
     
     
    public void selectionItemTable(comment comment){
        
        int ir=comment.getIdr();
          int c=comment.getId_user();
            noml.setText(sIden.ml(c));
            reclamationl.setText(sReclamation.rec(ir));
           commentairel.setText(comment.getCommentaire());
           }
    
    
   
    
    
    
     public void affichetableview(){
         
        
         Reclam.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<comment, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<comment, String> param) {
               
               Reclamation  r=sComment.selectRec(param.getValue().getIdr());

                
                return new SimpleStringProperty(r.getText());
                
                 }
        });
         
         
         nom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<comment, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<comment, String> param) {
               
               User  s=sComment.selectnom(param.getValue().getId_user());

                
                return new SimpleStringProperty(s.getName());
                
                 }
        });
         
         
         
         consulter.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        consulter.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new Buttoncom();
            }

        });
         
         
         
         
         
         
         
         
         
         
            
            
             commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
    
             List<comment> list = sComment.getbynew();
           ObservableList<comment> items = FXCollections.observableArrayList(list);
           tableNewComm.setItems(items);
           
       
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
                PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeAdmin.fxml"))));

        
    }

    
    
    
    
}
