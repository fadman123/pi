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
public class comment {
    private int id;
    private  int id_user;
    private int idr;
    private String commentaire;
    private String date;
    private String vue;

    public comment(int id_user, int idr, String commentaire, String date) {
        this.id_user = id_user;
        this.idr = idr;
        this.commentaire = commentaire;
        this.date = date;
    }

    @Override
    public String toString() {
        return "comment{" + "id=" + id + ", id_user=" + id_user + ", idr=" + idr + ", commentaire=" + commentaire + ", date=" + date + ", vue=" + vue + '}';
    }

    
    
    
    
    
    public comment(int id, int id_user, int idr, String commentaire, String date, String vue) {
        this.id = id;
        this.id_user = id_user;
        this.idr = idr;
        this.commentaire = commentaire;
        this.date = date;
        this.vue = vue;
    }
    public comment (){}

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getIdr() {
        return idr;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getDate() {
        return date;
    }

    public String getVue() {
        return vue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }
    
    
}
