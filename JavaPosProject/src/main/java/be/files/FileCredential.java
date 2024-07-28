/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.files;

import be.pos.panels.IdpPnl;
import be.pos.ent.Credencial;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Dann
 */
public class FileCredential {
    public Credencial leerArchivo(int index){
        Credencial cred;
        String filename = "error.xml";
        cred = new Credencial();
        if (index == 0) {
            filename = "prod.xml";
        }
        if (index == 1) {
            filename = "sandbox.xml";
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filename));

            doc.getDocumentElement().normalize();

            // get <staff>
            NodeList list = doc.getElementsByTagName("Ambiente");
            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get staff's attribute
                    cred.setAmbiente(element.getAttribute("id"));

                    // get text
                    cred.setUsuario(element.getElementsByTagName("Usuario").item(0).getTextContent());
                    cred.setClave(element.getElementsByTagName("Clave").item(0).getTextContent());
                    cred.setApi(element.getElementsByTagName("Api").item(0).getTextContent());
                    cred.setOauth(element.getElementsByTagName("Oauth").item(0).getTextContent());
                    cred.setClientid(element.getElementsByTagName("Clientid").item(0).getTextContent());
                    
                }
               
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(IdpPnl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(IdpPnl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IdpPnl.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        return cred;
    }
    
}
