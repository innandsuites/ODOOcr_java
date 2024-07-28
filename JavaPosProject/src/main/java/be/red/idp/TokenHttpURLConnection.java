/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.red.idp;

import be.files.FileCredential;
import be.pos.ent.Credencial;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dann
 */
public class TokenHttpURLConnection {

    FileCredential fcred;
    Credencial cred;
    private final String USER_AGENT = "Mozilla/5.0";

    public String getToken(int ambiente) {
        String resp = "null";
        fcred = new FileCredential();
        cred = fcred.leerArchivo(ambiente);
        String url = cred.oauth;

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            //con.setRequestProperty("User-Agent", "Windows NT 6.3");
            //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            
            String urlParameters = "username="+URLEncoder.encode(cred.usuario, StandardCharsets.UTF_8)+"&grant_type=password&password="+URLEncoder.encode(cred.clave, StandardCharsets.UTF_8)+"&client_id="+URLEncoder.encode(cred.clientid, StandardCharsets.UTF_8);
            
            con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
                resp = response.toString();
		in.close();

		//print result
		System.out.println(response.toString());
        } catch (IOException ex) {
            Logger.getLogger(TokenHttpURLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resp;
    }

}
