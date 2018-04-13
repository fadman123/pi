/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entite.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;



import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutController implements Initializable {

    @FXML
    private TextArea email;
    @FXML
    private TextArea titre;
    @FXML
    private TextField text;
    @FXML
    private ComboBox<String> service;
    
  private ReclamationService sReclamation=new ReclamationService();
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sReclamation.combo(service);
    }    

    @FXML
    private void add(ActionEvent event) throws IOException, AddressException {
      int b=sReclamation.combov(service.getValue());
      int c=IdentificationController.getIdCnx();
      Date actuelle = new Date();
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      String dat = dateFormat.format(actuelle);
      if(isValidEmailAddress(email.getText())&&(!titre.getText().equals(""))&&(!text.getText().equals("")))
         {  
      try {
            
            Reclamation reclamation = new Reclamation(titre.getText(), text.getText(), email.getText(), dat, b, c);
         
          sReclamation.ajouterReclamation(reclamation);

        } catch (NumberFormatException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

        titre.setText("");
        text.setText("");
        email.setText("");
        
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));}
         else{
         
         
         Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(" Invalid");
                alert.setContentText("verifiez les champs");
                alert.showAndWait();
         
         }
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));
        
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
