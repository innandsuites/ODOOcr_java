/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pos;

import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class ClasePrincipal {
    
   
    
    public static void main(String[] args){
        
         PosForm pos = new PosForm();
         pos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
         pos.setVisible(true);
        
        
    }
    
}
