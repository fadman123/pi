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
public class User {
    private int id;
    private String name;
    private String email;
    private String pass;
    private String Role;

    public User(int id, String name, String email, String Role, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Role = Role;
        this.pass=pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
    public User(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return Role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name =name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", Role=" + Role + '}';
    }
    
    
    
    
    
    
}
