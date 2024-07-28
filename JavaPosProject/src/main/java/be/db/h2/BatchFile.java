/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.db.h2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jdaniel
 */
public class BatchFile {
    public static void main(String[] args) throws IOException, InterruptedException{
        
//        Runtime.getRuntime().exec("cmd /c start C:\\Users\\jdaniel\\Documents\\BaseDatos\\h2\\bin\\h2.bat");
    Runtime.getRuntime().exec("C:\\Users\\jdaniel\\Documents\\BaseDatos\\h2\\bin\\h2.bat");
    TimeUnit.MINUTES.sleep(1);
}
}