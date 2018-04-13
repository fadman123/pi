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
public class service {
    private int id;
    private int departement_id;
    private String nom;
    private String description;
    private int Rating;
    private String monImage;

    public service(int id, int departement_id, String nom, String description, int Rating, String monImage) {
        this.id = id;
        this.departement_id = departement_id;
        this.nom = nom;
        this.description = description;
        this.Rating = Rating;
        this.monImage = monImage;
    }

    public service() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartement_id(int departement_id) {
        this.departement_id = departement_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public void setMonImage(String monImage) {
        this.monImage = monImage;
    }

    public int getId() {
        return id;
    }

    public int getDepartement_id() {
        return departement_id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return Rating;
    }

    public String getMonImage() {
        return monImage;
    }

    @Override
    public String toString() {
        return "service{" + "id=" + id + ", departement_id=" + departement_id + ", nom=" + nom + ", description=" + description + ", Rating=" + Rating + ", monImage=" + monImage + '}';
    }
    
}
