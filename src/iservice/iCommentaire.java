/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entite.comment;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface iCommentaire {
    public void ajouterCommentaire (comment C);
     public void supprimerCommentaire (comment C,int id);
     public void modifierCommentaire(comment C, int id);
     
      
    
}
