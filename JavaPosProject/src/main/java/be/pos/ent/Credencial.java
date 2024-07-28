/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.pos.ent;

/**
 *
 * @author jdaniel
 */
public class Credencial {

    public String usuario;
    public String clave;
    public String ambiente;
    public String api;
    public String oauth;
    public String clientid;

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getOauth() {
        return oauth;
    }

    public void setOauth(String oauth) {
        this.oauth = oauth;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    public Credencial(String usuario, String clave, String ambiente, String api, String oauth, String clientid) {
        this.usuario = usuario;
        this.clave = clave;
        this.ambiente = ambiente;
        this.api = api;
        this.oauth = oauth;
        this.clientid = clientid;
    }

    public Credencial() {
    }

}
