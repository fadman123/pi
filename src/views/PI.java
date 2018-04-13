/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class PI extends Application {
    
    private Stage stage;
    private static PI instance;
    private Scene scene;
    public PI() throws IOException, InterruptedException {
        instance = this;
        scene = new Scene(FXMLLoader.load(getClass().getResource("/views/identification.fxml")));

    }
     public static PI getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setScene(this.scene);
        stage.initStyle(StageStyle.DECORATED);// reduire et fermer decoredet* - 
        stage.centerOnScreen();
        stage.show();
    }
      public void changescene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
