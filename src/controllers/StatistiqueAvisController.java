/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cnx.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import views.PI;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class StatistiqueAvisController implements Initializable {

    @FXML
    private PieChart pc;
    
    ObservableList<PieChart.Data> stat=FXCollections.observableArrayList();

      ArrayList<String> Avis = new ArrayList<String>();
     ArrayList<Integer> id = new ArrayList<Integer>();
    @FXML
    private Label label0;
    @FXML
    private Label label25;
    @FXML
    private Label label50;
    @FXML
    private Label label100;
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    
        double a=0,c=0,d=0;
     
     try {
           
            
            DataSource myDB = DataSource.getInsatance();
            Statement stm = myDB.getConnection().createStatement();
            Statement stm2 = myDB.getConnection().createStatement();
            Statement stm4 = myDB.getConnection().createStatement();
            Statement stm5 = myDB.getConnection().createStatement();
            Statement stm7 = myDB.getConnection().createStatement();
             Statement stm8 = myDB.getConnection().createStatement();
            
            ResultSet rest0=stm.executeQuery("select count(pourcentage) from avis ");
               while(rest0.next())
               {
                   
                double   z=rest0.getInt(1);
                   
                   
            
             ResultSet rest2=stm4.executeQuery("select count(a.pourcentage) as nbr from avis a where a.pourcentage='0' ");
               while(rest2.next())
               {
                   
                   a=rest2.getInt(1);
                
                   double b=a/z;
                   label0.setText("pourcentage pour avis 0% ="+b*100);
               }
               
               ResultSet rest3=stm5.executeQuery("select count(a.pourcentage) as nbr from avis a where a.pourcentage='25' ");
               while(rest3.next())
               {
                   
                     c=rest3.getInt(1);
                
                   double n=c/z;
                   label25.setText("pourcentage pour avis 25% ="+n*100);
               }
               
               ResultSet rest7=stm7.executeQuery("select count(a.pourcentage) as nbr from avis a where a.pourcentage='50' ");
               while(rest7.next())
               {
                   
                     c=rest7.getInt(1);
                
                   double n=c/z;
                   label50.setText("pourcentage pour avis 50% ="+n*100);
               }
               
               
                ResultSet rest8=stm8.executeQuery("select count(a.pourcentage) as nbr from avis a where a.pourcentage='100' ");
               while(rest8.next())
               {
                   
                     c=rest8.getInt(1);
                
                   double n=c/z;
                   label100.setText("pourcentage pour avis 100% ="+n*100);
               }
               }
            
            
               
               ResultSet rest=stm2.executeQuery("select a.pourcentage,count(a.pourcentage) as id from avis a group By a.pourcentage ");
      
  
    
               while(rest.next())
               {
                     Avis.add(rest.getString(1));
                     id.add(rest.getInt(2));
                     stat.add(new PieChart.Data(rest.getString(1),rest.getInt(2)));
               }
               
    }
    catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        pc.setAnimated(true);

        
        pc.maxHeight(1000);
       pc.setData(stat);
       
       
       
      
        
       }
     
     
        
    

    @FXML
    private void retourner(ActionEvent event) throws IOException {
                        PI.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/HomeAdmin.fxml"))));

    }
    
}





 
             