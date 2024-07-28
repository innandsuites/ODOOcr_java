/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pos.bk;

import be.pos.adm.dat.ProductoDB;
import be.pos.adm.ent.Producto;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class OperacionArchivo {
    
    ProductoDB prodb;
    Calendar calendar;
    File file;
//    DataOutputStream dos;
//    FileOutputStream fos;
    PrintWriter pw;
    String nombre;
    List<Producto> prolis;
    

    public OperacionArchivo() {
        prolis = new ArrayList<Producto>();
        prodb = new ProductoDB();
        calendar = new GregorianCalendar();
        nombre = String.valueOf(calendar.get(Calendar.DAY_OF_YEAR))+String.valueOf(calendar.get(Calendar.YEAR))+".dat";
//        file = new File("c:\\"+calendar.get(Calendar.DAY_OF_YEAR)+calendar.get(Calendar.YEAR)+".dat");
//        file = new File("C:\\Usuarios\\daniel\\respaldo.dat");
       
//        file = new File("c:\\");
        
        
    }
    
    
    public void respaldo(){
        
        try{
             pw = new PrintWriter("C:\\elenroque\\"+nombre, "UTF-8");
             prolis = prodb.listaCompleta();
             for(Producto p : prolis){
                 pw.println(p.getId() + " " + p.getNombre() + " " + p.getDetalle() + " " + p.getPrecio_compra()
                  + " " + p.getGanancia() + " " + p.getCantidad() + " " + p.getIva() + " " + p.getPrecio());
             }
             
             pw.close();
//            if(!file.exists()){
//                file.createNewFile();
//                System.out.println("no existe");
//            }
//            fos = new FileOutputStream(nombre);
//            dos = new DataOutputStream(fos);
//            dos.writeUTF("little test for files\n");
//            dos.flush();
//            fos.close();
        
    }
        catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null,"Error archivo no existe");
            
        }
        catch(IOException err){
            JOptionPane.showMessageDialog(null,"Error en archivo al escribir");
            
        }
            
        }
        
}
