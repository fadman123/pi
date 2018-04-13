/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.prism.impl.Disposer;
import controllers.AdminConsulterController;
import entite.Reclamation;
import entite.comment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.AnchorPane;
import views.PI;

/**
 *
 * @author ASUS
 */
public class Buttoncom extends TableCell<Disposer.Record, Boolean>{
     final Button cellButton = new Button("consulter");
    
     
     
     
      public Buttoncom() {

        //Action when the button is pressed
        cellButton.setOnAction((ActionEvent t) -> {
            // get Selected Item
            comment prodcourant = (comment) Buttoncom.this.getTableView().getItems().get(Buttoncom.this.getIndex());
            //remove selected item from the table list
            System.out.println("ID du Reclamation   " + prodcourant.getIdr());
        
            
            AdminConsulterController l = new AdminConsulterController();

            
            l.redirect(String.valueOf(prodcourant.getIdr()));
            AnchorPane pane = new AnchorPane();
            try {
               PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/AdminConsulter.fxml"))));
            } catch (IOException ex) {
                Logger.getLogger(AdminConsulterController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        });
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (!empty) {
            setGraphic(cellButton);
        }
    }

}
