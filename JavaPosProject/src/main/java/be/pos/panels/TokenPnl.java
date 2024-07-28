/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package be.pos.panels;

import be.db.DerbyIdp;
import be.pos.ent.Token;
import be.red.idp.TokenHttpClient;
import be.red.idp.TokenHttpURLConnection;
import javax.swing.JInternalFrame;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jdaniel
 */
public class TokenPnl extends javax.swing.JPanel {

    /**
     * Creates new form TokenPnl
     */
    JInternalFrame jif;
    DerbyIdp di = new DerbyIdp();

    public TokenPnl(JInternalFrame jif2)  {
        initComponents();
        jif = jif2;
        buttonGroup1.add(jCheckBox1);
        buttonGroup1.add(jCheckBox2);
        buttonGroup1.add(jCheckBox3);
        Token t = new Token();
        try {
            t = di.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(TokenPnl.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.setText(t.access_token);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(450, 365));

        jLabel1.setText("Ambiente");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produccion", "Pruebas" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("HttpURLConnection");

        jCheckBox2.setText("HttpClient");

        jCheckBox3.setText("jCheckBox3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int index = jComboBox1.getSelectedIndex();
        String resp = "null";
        jTextArea1.setText("");
        Token token;
        int rows=0;
        DerbyIdp di = new DerbyIdp();
        jTextArea1.setText(String.valueOf(index));
        if (jCheckBox1.isSelected()) {
            TokenHttpURLConnection idp = new TokenHttpURLConnection();
            resp = idp.getToken(index);
            token =  new Gson().fromJson(resp, Token.class);
            token.id = "produccion";
            //token.expires = (Date)LocalDate.now();
            token.expires_str = LocalDateTime.now().toString();
            rows = di.update(token);
            if(rows>0)JOptionPane.showMessageDialog(null,"se actualizaron " +rows+" filas");
            //jTextArea1.setText(token.access_token +"\n expires: " +token.expires_in);
        }
        if (jCheckBox2.isSelected()) {
            TokenHttpClient idp = new TokenHttpClient();
            resp = idp.getToken(index);
            token =  new Gson().fromJson(resp, Token.class);
            token.id = "pruebas";
            rows = di.update(token);
            if(rows>0)JOptionPane.showMessageDialog(null,"se actualizaron " +rows+" filas");
             jTextArea1.setText(token.access_token);

        }
        
        

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
