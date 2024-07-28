/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.red.idp;

import be.files.FileCredential;
import be.pos.ent.Credencial;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Dann
 */
public class TokenHttpClient {
    
    FileCredential fcred;
    Credencial cred;
    
    public String getToken(int ambiente){
        String resp = "null";
        
        fcred = new FileCredential();
        cred = fcred.leerArchivo(ambiente);
        String url = cred.oauth;
        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", cred.usuario));
        urlParameters.add(new BasicNameValuePair("password", cred.clave));
        urlParameters.add(new BasicNameValuePair("grant_type", "password"));
        urlParameters.add(new BasicNameValuePair("client_id", cred.clientid));

        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TokenHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
            Logger.getLogger(TokenHttpClient.class.getName()).log(Level.INFO, result);
            
        } catch (IOException ex) {
            Logger.getLogger(TokenHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TokenHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return resp;
        
        
    }
    
}
