/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entite.Reclamation;
import entite.comment;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import service.CommentaireService;
import service.ReclamationService;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UserConsulterController implements Initializable {

    @FXML
    private AnchorPane afRec;
    @FXML
    private Label datetxt;
    @FXML
    private Label titretxt;
    @FXML
    private Text texttxt;
    @FXML
    private TextArea commenter;
    @FXML
    private Pane panecommentaire;
    private CommentaireService sCommentaire=new CommentaireService();
 int icon=IdentificationController.getIdCnx();
    int a = 20 ;
    private static int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ReclamationService rs = new ReclamationService();
        try {
            Reclamation r = rs.recherche(id);
            datetxt.setText(r.getDate());
            titretxt.setText(r.getTitre());
            texttxt.setText(r.getText());
        } catch (SQLException ex) {
            Logger.getLogger(AdminConsulterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CommentaireService cs = new CommentaireService();
        List<comment> comments = new ArrayList<>();
        
        for( comment c : cs.getbyid(id))
        {
            Label l = new Label();
           
            
            
            l.setText(c.getCommentaire());
            l.setLayoutX(0);
            l.setLayoutY(a);
            a=a+20;
          
            l.setStyle("-fx-font-weight: bold;-fx-fill :  #BA2E45");
           
            panecommentaire.getChildren().addAll(l);
            
        }
        
       
    }    

    
     public void redirect(String ide) {
        
        System.out.println(id);
        UserConsulterController.id = Integer.parseInt(ide);
        
    }
    
    
    
    @FXML
    private void retourner(MouseEvent event) throws IOException {
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeUser.fxml"))));
    }

    @FXML
    private void ajouter(MouseEvent event) throws IOException {
        int cid=IdentificationController.getIdCnx();
        Date actuelle = new Date();
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      String dat = dateFormat.format(actuelle);
        try {
            
            comment c = new comment(cid,id,commenter.getText(),dat);

          sCommentaire.ajouterCommentaire(c);

            
        } catch (NumberFormatException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/UserConsulter.fxml"))));
        
    }
    }
    
