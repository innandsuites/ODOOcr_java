/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pos.rest;

import be.pos.adm.dat.ProductoDB;
import be.pos.adm.ent.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class OperacionArchivo {
    
    ProductoDB prodb;
    Producto producto;
    BufferedReader br;
    FileInputStream fis;
    InputStream is;
    File file;
    String[] toques;
    String linea;
    String path;
    List<Producto> prolis;
    int cpint;
    double cpdouble;
    

    public OperacionArchivo() {
//        prolis = new ArrayList<Producto>();
        prodb = new ProductoDB();
        path= "C:\\elenroque\\";
       

       
        
    }
    
    public void restaurar(String nombre){
        
        try{
            file = new File(path+nombre);
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
//            for(String linea : br.readLine())
            while((linea = br.readLine()) != null) {
                producto = new Producto();
                System.out.println(linea);
//                toques = linea.split(" ");
                toques = linea.split("\\s+");
                producto.setId(toques[0]);
                producto.setNombre(toques[1]);
                cpdouble = Double.valueOf(toques[(toques.length) - 1]);
                producto.setPrecio(cpdouble);
                cpdouble = Double.valueOf(toques[(toques.length) - 2]);
                producto.setIva(cpdouble);
                cpint = Integer.valueOf(toques[(toques.length) - 3]);
                producto.setCantidad(cpint);
                cpdouble = Double.valueOf(toques[(toques.length) - 4]);
                producto.setGanancia(cpdouble);
                cpdouble = Double.valueOf(toques[(toques.length) - 5]);
                producto.setPrecio_compra(cpdouble);
                prodb.agregar(producto);
//                prolis.add(producto);
                
                   
//                for(int i = 0; i <= 1; i++){
//                    producto.setId(toques[i]);
//                    producto.setNombre(toques[i]);
//                }
//                for(int j = (toques.length - 1); j >= (toques.length - 5) ; j--){
//                    if(j == toques.length - 3){
//                        cpint = Integer.valueOf(toques[j]);
//                    }
//                    else{
//                    cpdouble = Double.valueOf(toques[j]);
//                    producto.setPrecio(cpdouble);
//                    
                  
                
                }
            
            br.close();
            JOptionPane.showMessageDialog(null,"RESTAURACION FINALIZADA");
//            for(Producto p : prolis){
//                 System.out.println(p.getId() + " " + p.getNombre() + " " + p.getDetalle() + " " + p.getPrecio_compra()
//                  + " " + p.getGanancia() + " " + p.getCantidad() + " " + p.getIva() + " " + p.getPrecio());
//             }
        }
         catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null,"Error archivo no existe");
            
        }
        catch(IOException err){
            JOptionPane.showMessageDialog(null,"Error en archivo al escribir");
            
        }
        
    }
    

    
        
}
