/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.red.ae;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
//import org.json.JSONObject;
//import org.json.XML;

/**
 *
 * @author jdaniel
 */
public class HttpMhAe {

    // HTTP GET request
    private final String USER_AGENT = "Mozilla/5.0";

    public String sendGet(String cedula) throws Exception {
        StringBuffer response = new StringBuffer();
        
            
        try{
        String url = "https://api.hacienda.go.cr/fe/ae?identificacion=" + cedula;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
       

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        
        in.close();
        }

        catch(IOException e){JOptionPane.showMessageDialog(null, e.getMessage());}

        //print result
//        JSONObject json = new JSONObject(response.toString());
//        String xml = XML.toString(json);
//        System.out.println(response.toString());
//        System.out.println("objeto org.json: " +xml);
        return response.toString();

    }

    // HTTP POST request
    public void sendPost() throws Exception {

        String url = "https://api.hacienda.go.cr/fe/ae?identificacion=701850132";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        //con.setRequestProperty("User-Agent", "Windows NT 6.3");
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

        //String urlParameters = "identificacion=701850132";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        //wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : ");
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
