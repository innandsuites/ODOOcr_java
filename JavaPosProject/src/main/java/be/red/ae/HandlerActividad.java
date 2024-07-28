/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.red.ae;

import obj.act.eco.JsonActividad;
import be.pos.ent.Token;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.*;

/**
 *
 * @author daniel
 */
public class HandlerActividad {

    List lista;
    HttpMhAe http;
    JsonActividad ja;

     public JsonActividad getActividadRaw(String cedula) {
        http = new HttpMhAe();
        lista = new ArrayList<String>();
        ja = new JsonActividad();
        
        try {

            String jsonString = http.sendGet(cedula);
            //JSONObject obj = new JSONObject(jsonString);
            ja =  new Gson().fromJson(jsonString, JsonActividad.class);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return ja;
    }

    public List getActividad(String cedula) {
        http = new HttpMhAe();
        lista = new ArrayList<String>();
        try {

            String jsonString = http.sendGet(cedula);
            JSONObject obj = new JSONObject(jsonString);
            //String pageName = obj.getJSONObject("pageInfo").getString("pageName");

            JSONArray arr = obj.getJSONArray("actividades"); // notice that `"posts": [...]`
            for (int i = 0; i < arr.length(); i++) {
                //String post_id = arr.getJSONObject(i).getString("descripcion");
                String line = arr.getJSONObject(i).toString();
                lista.add(line);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return lista;
    }

}
