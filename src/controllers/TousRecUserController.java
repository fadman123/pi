/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.prism.impl.Disposer;
import entite.Reclamation;
import entite.service;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import service.ButtonCellU;
import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TousRecUserController implements Initializable {

    @FXML
    private TableView<Reclamation> tableReclamation;
    @FXML
    private TableColumn<Reclamation, String> service;
    @FXML
    private TableColumn<Reclamation, String> titre;
    @FXML
    private TableColumn<Reclamation, String> text;
    @FXML
    private TableColumn<Disposer.Record,Boolean> consulter;
    @FXML
    private Label servicel;
    @FXML
    private Label emaill;
    @FXML
    private Label textl;
    @FXML
    private Label titrel;
    int b,c;
 private ReclamationService sReclamation=new ReclamationService();
    @FXML
    private Button retourner;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichetableview();
        tableReclamation.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldvalue, newValue) ->selectionItemTable(newValue));
    }    
    
    
    public void selectionItemTable(Reclamation Reclamation){
         b =Reclamation.getId();
         c=Reclamation.getService();
         servicel.setText(sReclamation.selectService(Reclamation.getService()).getNom());
        
         titrel.setText(Reclamation.getTitre());
          textl.setText(Reclamation.getText());
           emaill.setText(Reclamation.getEmail());}
    
    
    
    
    
     public void affichetableview(){
        int c=IdentificationController.getIdCnx();
       
            titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            text.setCellValueFactory(new PropertyValueFactory<>("text"));
               
            service.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
               
               service  s=sReclamation.selectService(param.getValue().getService());

                
                return new SimpleStringProperty(s.getNom());
            }
        });
            
            
            
             List<Reclamation> list = sReclamation.getbyid(c);
           ObservableList<Reclamation> items = FXCollections.observableArrayList(list);
           tableReclamation.setItems(items);
    
    
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
                return new ButtonCellU();
            }

        });
            
            
            
             List<Reclamation> list1 = sReclamation.getAll();
           ObservableList<Reclamation> item = FXCollections.observableArrayList(list);
           tableReclamation.setItems(item);
           
       
    }

    @FXML
    private void Retourner(ActionEvent event) throws IOException {
         PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));
    }
    
    
    
    
    
    
    
    
    
    
    
}
