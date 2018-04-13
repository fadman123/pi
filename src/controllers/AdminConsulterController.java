/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entite.Reclamation;
import entite.User;
import entite.comment;
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
import java.util.*;
import javafx.scene.control.Alert;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import service.IdentificationService;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminConsulterController implements Initializable {
    private static int id;
String subject="centre sante";
        String text="Admin a commenté  votre commentaire sur le site sante";
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
    private ReclamationService sReclamation=new ReclamationService();
private CommentaireService sCommentaire=new CommentaireService();
 private IdentificationService sIden=new IdentificationService();
 int icon=IdentificationController.getIdCnx();
    int a = 20 ;
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
            Label ll =new Label();
            if (icon==4)
            {
             ll.setText("ADMIN : ");
            l.setLayoutY(a);
            }
            
            l.setText(c.getCommentaire());
            l.setLayoutX(0);
            l.setLayoutY(a);
            a=a+20;
            ll.setStyle("-fx-font-weight: bold;-fx-fill : #BA2E59");
            l.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
            panecommentaire.getChildren().addAll(l);
        }
        
        
        
        
    }    
    
    
    public void redirect(String ide) {
        
        System.out.println(id);
        AdminConsulterController.id = Integer.parseInt(ide);
        
    }

    @FXML
    private void ajouter(MouseEvent event) throws SQLException, IOException {
        
        
        
        
        
        
        
        
        
        int c=IdentificationController.getIdCnx();
             int em=sReclamation.m(id);
             IdentificationService is = new IdentificationService();
             User u= is.selectIden(em);
             String ema=u.getEmail();
            
        int cid=IdentificationController.getIdCnx();
        Date actuelle = new Date();
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      String dat = dateFormat.format(actuelle);
        try {
            
            comment cm = new comment(cid,id,commenter.getText(),dat);

            if (texttxt.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Veuillez remplirele champ");
                alert.setHeaderText(null);
                alert.setContentText("commentaire n a pas ajouté!");
                alert.showAndWait();
        
        }else{
          sCommentaire.ajouterCommentaire(cm);
          if (cid==4)
       {
       sReclamation.setDispo(id);
       sCommentaire.setVue(id);
       
        
        send(ema,subject,text);
          
          }
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/AdminConsulter.fxml"))));
        
    }
    
    
    
    
    @FXML
    private void vue() {
      }

    
    
    
    
    @FXML
    private void retourner(MouseEvent event) throws IOException {
         PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/ReclamationAdmin.fxml"))));
    }
    
   
    
    
   
    public static void send(String to, String subject, String text) {
          
        final String username = "test@idealconstruction.tn";
        final String password = "test123456";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.idealconstruction.tn");
        //props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
             InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText("" + " " + text);
            Transport.send(message);
            System.out.println("Mail sent ");
        } catch (MessagingException ex) {
            // pretend no connexion
            
            // prompt error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Mail couldn't be sent , please check your internet connexion");
            alert.showAndWait();
            //Navigator.LoadScene(Navigator.authentification);
        }
    }
    
    
    
    
    }
    
    
    

