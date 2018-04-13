/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.github.sarxos.webcam.Webcam;
import entite.Avis;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import service.AvisService;
import service.IdentificationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AvisController implements Initializable {

    @FXML
    private ImageView avis1;
    @FXML
    private ImageView image;
    Webcam webcam;
    String a;
    @FXML
    private Button ajouter;
    @FXML
    private TextArea com;
     private IdentificationService sIden=new IdentificationService();
      private AvisService sAvis=new AvisService();
    @FXML
    private Button pos;
    @FXML
    private Button ret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void avis1(MouseEvent event) {
        image.setImage(new Image("/views/0e.png"));
       a="0";
        
    }

    @FXML
    private void avis2(MouseEvent event) {
         image.setImage(new Image("/views/25e.png"));
         a="25";
    }

    @FXML
    private void avis3(MouseEvent event) {
        image.setImage(new Image("/views/50e.png"));
        a="50";
    }

    @FXML
    private void avis4(MouseEvent event) {
        image.setImage(new Image("/views/100e.png"));
        a="100";
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
    
     
      int c=IdentificationController.getIdCnx();
      String em=sIden.em(c);
      String n=sIden.n(c);
           
    
        try {
            
            Avis avis = new Avis(n,em,com.getText(),a, c);

             sAvis.ajouterAvis(avis);

            
        } catch (NumberFormatException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

        com.setText("");
        
        
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));
}

    @FXML
    private void posez(ActionEvent event) throws IOException {
        int c=IdentificationController.getIdCnx();
        String n=sIden.n(c);
        webcam = Webcam.getDefault();
       
        webcam.open();
        try {
            ImageIO.write(webcam.getImage(), "JPG", new File ("src/views/"+n+".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(AvisController.class.getName()).log(Level.SEVERE, null, ex);
            
          webcam.close();  
        }
        
        
        
    }

    private void voir(ActionEvent event) throws IOException {
         PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/camera.fxml"))));
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
         PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));
    }

   

   

}