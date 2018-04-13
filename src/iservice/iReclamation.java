/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entite.Reclamation;

/**
 *
 * @author ASUS
 */
public interface iReclamation {
    
    public void ajouterReclamation (Reclamation R);
    public void supprimerReclamation (Reclamation R,int id);
    public void modifierReclamation(Reclamation R,int id);
    public void recherche (int id);
    
}
