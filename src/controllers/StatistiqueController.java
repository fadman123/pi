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
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart pc;
    ObservableList<PieChart.Data> stat=FXCollections.observableArrayList();

    ArrayList<String> service = new ArrayList<String>();
     ArrayList<Integer> id = new ArrayList<Integer>();
    @FXML
    private PieChart pc1;
    @FXML
    private Label label2;
    @FXML
    private Label label0;
    @FXML
    private Label label1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        

    try {
           
            
            DataSource myDB = DataSource.getInsatance();
            Statement stm2 = myDB.getConnection().createStatement();
            Statement stm4 = myDB.getConnection().createStatement();
            Statement stm0 = myDB.getConnection().createStatement();
             Statement stm7 = myDB.getConnection().createStatement();
              Statement stm8 = myDB.getConnection().createStatement();
            
            
            ResultSet rest10=stm0.executeQuery("select count(r.id) from reclamation r ");
               while(rest10.next())
               {
                   
                double z=rest10.getInt(1);
                
                   
            
             ResultSet rest1=stm4.executeQuery("select count(r.service) from reclamation r where r.service=1 ");
               while(rest1.next())
               {
                   
                double  a=rest1.getInt(1);
                
                   double b=a/z;
                  label0.setText("YOGA="+b*100);
               }
               
               
               ResultSet rest12=stm7.executeQuery("select count(r.service) from reclamation r where r.service=2 ");
               while(rest12.next())
               {
                   
                double  a=rest12.getInt(1);
                
                   double b=a/z;
                  label1.setText("géneraliste="+b*100);
               }
               
               
               
               ResultSet rest13=stm8.executeQuery("select count(r.service) from reclamation r where r.service=3 ");
               while(rest13.next())
               {
                   
                double  a=rest13.getInt(1);
                
                   double b=a/z;
                  label2.setText("cardiologue="+b*100);
               }
               }
            
   ResultSet rest=stm2.executeQuery("select s.nom,count(r.service) as id from service s , reclamation r where s.id=r.service  group By s.nom ");
              
              
               
   
   
            while(rest.next())
               {
                   service.add(rest.getString(1));
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
    
