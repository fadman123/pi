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
public class Avis {
    
    
    private int id;
    private String name;
    private String email;
    private String comm;
    private String pourcentage;
    private int user_id;
    

    public Avis(int id, String name, String email, String comm, String pourcentage,int user_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.comm = comm;
        this.pourcentage=pourcentage;
        this.user_id=user_id;
    }

    public Avis(String name, String email, String comm, String pourcentage, int user_id) {
        this.name = name;
        this.email = email;
        this.comm = comm;
        this.pourcentage = pourcentage;
        this.user_id = user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", name=" + name + ", email=" + email + ", comm=" + comm + ", pourcentage=" + pourcentage + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComm() {
        return comm;
    }

    public String getPourcentage() {
        return pourcentage;
    }
    
}
