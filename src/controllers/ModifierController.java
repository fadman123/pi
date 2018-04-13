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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierController implements Initializable {

    @FXML
    private Button annuler;
    @FXML
    private TextArea email;
    @FXML
    private TextArea titre;
    @FXML
    private TextField text;
    @FXML
    private ComboBox<?> service;
    @FXML
    private Button modifier;
     private ReclamationService sReclamation=new ReclamationService();
    @FXML
    private AnchorPane table;
    @FXML
    private Label id;
    @FXML
    private Button rechercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) throws IOException {
        
        
        
        String titr = titre.getText();
        
        String tex = text.getText();
        String em = email.getText();
        String ser= service.getTypeSelector();

        //Reclamation reclamation = new Reclamation( titr, tex, em, ser);
        //reclamation.setId(Integer.parseInt(idnew));
       // sReclamation.modifierReclamation(Reclamation);
        List<Reclamation> list = sReclamation.getAll();//chargina liste bech n3abeha fi able view 

        ObservableList<Reclamation> items = FXCollections.observableArrayList(list);//bech n3abiwha baaed fi tabview //bech nhot fih les objets taa liste 

       // table.setItems(items);

        titre.setText("");
        text.setText("");
        email.setText("");
       // service.setText("");
       
    }

    //@FXML
   // private void recherche(ActionEvent event) {
        
       // String ida =id.getText();
       //int idaa=Integer.parseInt(ida);
       // ReclamationService rs=new ReclamationService();
       // Reclamation r=rs.recherche(idaa);
       // titre.setText(r.getTitre());
       // text.setText(r.getText());
       // email.setText(r.getEmail());
        
   // }
    
}
