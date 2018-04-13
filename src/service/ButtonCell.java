package service;

import com.sun.prism.impl.Disposer.Record;
import controllers.AdminConsulterController;
import entite.Reclamation;

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
import static views.PI.main;


/**
 *
 * @author marwen b-al
 */
public class ButtonCell extends TableCell<Record, Boolean> {

    final Button cellButton = new Button("consulter");

    public ButtonCell() {

        //Action when the button is pressed
        cellButton.setOnAction((ActionEvent t) -> {
            // get Selected Item
            Reclamation prodcourant = (Reclamation) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
            //remove selected item from the table list
            System.out.println("ID du Reclamation   " + prodcourant.getId());
            AdminConsulterController l = new AdminConsulterController();

            l.redirect(String.valueOf(prodcourant.getId()));
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
