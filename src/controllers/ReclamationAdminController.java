/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.prism.impl.Disposer;
import com.sun.prism.impl.Disposer.Record;
import static controllers.AjoutController.isValidEmailAddress;
import entite.Reclamation;
import entite.service;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import service.ButtonCell;
import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationAdminController implements Initializable {
    Integer b ,c;
    @FXML
    private TableView<Reclamation> tableReclamation;
    private TableColumn<Reclamation, Integer> id;
    @FXML
    private TableColumn<Reclamation, String> service;
    @FXML
    private TableColumn<Reclamation, String> titre;
    @FXML
    private TableColumn<Reclamation, String> text;
    private Label Labelid;
    private Label Labelservice;
    private Label Labeltitre;
    private Label Labeltext;
    private Label Labelemail;
    private Label Labeldate;
    
    private ReclamationService sReclamation=new ReclamationService();
    @FXML
    private Button Modifier;
    @FXML
    private Button supprimer;
    private TextField idtxt;
    @FXML
    private TextField servicetxt;
    @FXML
    private TextField titretxt;
    @FXML
    private TextField texttxt;
    @FXML
    private TextField emailtxt;
   // private TextField datetxt;
    @FXML
    private TableColumn<Disposer.Record,Boolean> consulter;
    @FXML
    private Button retourner;
    @FXML
    private ComboBox<String> serv;

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
          sReclamation.combo(serv);
         b =Reclamation.getId();
         c=Reclamation.getService();
        servicetxt.setText(sReclamation.selectService(Reclamation.getService()).getNom());
         titretxt.setText(Reclamation.getTitre());
          texttxt.setText(Reclamation.getText());
           emailtxt.setText(Reclamation.getEmail());
           //datetxt.setText(Reclamation.getDate());
           serv.getSelectionModel().select(servicetxt.getText());
    }
    
    
    public void affichetableview(){
        
        //id.setCellValueFactory(new PropertyValueFactory<>("id"));
            titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            text.setCellValueFactory(new PropertyValueFactory<>("text"));
            
            service.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
               
               service  s=sReclamation.selectService(param.getValue().getService());

                
                return new SimpleStringProperty(s.getNom());
                
                 }
        });
            
            
            
            
            
            consulter.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        consulter.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }

        });
            
            
            
             List<Reclamation> list = sReclamation.getAll();
           ObservableList<Reclamation> items = FXCollections.observableArrayList(list);
           tableReclamation.setItems(items);
           
       
    }

    @FXML
    private void modifier(ActionEvent event) {
         servicetxt.setText(serv.getValue());
       int        d=sReclamation.selectidSer(serv.getValue()).getId();
       int  index =tableReclamation.getSelectionModel().getSelectedIndex();
       if(isValidEmailAddress(emailtxt.getText())&&(!titretxt.getText().equals(""))&&(!texttxt.getText().equals("")))
         {  
           Reclamation reclamation=new Reclamation();
             reclamation.setId(b);
           reclamation.setService(d);
           reclamation.setTitre(titretxt.getText());
           reclamation.setText((texttxt.getText()));
           //reclamation.setDate(datetxt.getText());
           reclamation.setEmail(emailtxt.getText());
           sReclamation.modifierReclamation(reclamation,b);
           tableReclamation.getItems().set(index, reclamation);
           clearField();
    }
    
     else{
         
         
         Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(" Invalid");
                alert.setContentText("verifier les champs");
                alert.showAndWait();
         
         }
    }
    
    
    
    
    
    
    
    

    @FXML
    private void supprimer(ActionEvent event) {
        Reclamation reclamation =tableReclamation.getSelectionModel().getSelectedItem();
        if(reclamation==null)
            return;
        
        sReclamation.supprimerReclamation(reclamation,b);
         tableReclamation.getItems().remove(reclamation);
        
        
    }

   
    
    
    
    private void clearField() {
       // idtxt.setText("");
        texttxt.setText("");
        servicetxt.setText("");
        titretxt.setText("");
        emailtxt.setText("");
        //datetxt.setText("");
    }    


    @FXML
    private void retourner(ActionEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeAdmin.fxml"))));
    }

    private void consulter(ActionEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/AdminConsulter.fxml"))));
    }
    
    public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}
    
    
    
    
}

