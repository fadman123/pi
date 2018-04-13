/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;



/**
 *
 * @author ASUS
 */
public class Reclamation {
    
    private int id;
    private String titre;
    private String text;
    private String email;
    private int service;
    private String date;
    private int user_id;

    

    public Reclamation(String titre, String text, String email, String date, int service , int user_id) {
        
        this.titre = titre;
        this.text = text;
        this.email = email;
       this.service=service;
        this.date = date;
        this.user_id=user_id;
    }
    
    public Reclamation(int id,String titre, String text, String email, int service, String date , int user_id) {
        this.id=id;
        this.titre = titre;
        this.text = text;
        this.email = email;
       this.service=service;
        this.date = date;
        this.user_id=user_id;
    
    
    }
    

    public Reclamation(int id, String titre, String text, int service, String date, int user_id) {
        this.id = id;
        this.titre = titre;
        this.text = text;
        this.service = service;
        this.date = date;
        this.user_id = user_id;
    }

   

    public int getUser_id() {
        return user_id;
    }

    public Reclamation() {
        
    }

    

    


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getText() {
        return text;
    }

    public String getEmail() {
        return email;
    }

    public int getService() {
        return service;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setService(int service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", titre=" + titre + ", text=" + text + ", email=" + email + ", service=" + service + ", date=" + date + '}';
    }

}
