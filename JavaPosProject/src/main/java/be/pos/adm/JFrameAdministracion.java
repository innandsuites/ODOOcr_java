package be.pos.adm;

import be.pos.adm.dat.ProductoDB;
import be.pos.adm.dat.RendimientoDB;
import be.pos.adm.dat.UsuarioDB;
import be.pos.adm.ent.Producto;
import be.pos.adm.ent.Rendimiento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oficina
 */
public class JFrameAdministracion extends javax.swing.JFrame {

    DefaultTableModel modelo;
    int int_copy;
    double dle_copy;
    String str_copy;
    String[] datos;
    Rendimiento rendimiento;
    RendimientoDB rendimientodb;
    UsuarioDB usuariodb;
    Producto producto;
    ProductoDB productodb;
    boolean bool;
    List<Producto> lstarr;
    int filaSelect;

    public JFrameAdministracion() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Detalle");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Ganancia");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Impuesto v.");
        modelo.addColumn("Precio");
        initComponents();
        int_copy = 0;
        filaSelect = 0;
        dle_copy = 0.0;
        bool = false;
        str_copy = "";
        datos = new String[8];
        rendimiento = new Rendimiento();
        rendimientodb = new RendimientoDB();
        productodb = new ProductoDB();
        usuariodb = new UsuarioDB();
        lstarr = new ArrayList<Producto>();
    }

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {

            modelo.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jcmbbox_tiempo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtf_ganancia = new javax.swing.JTextField();
        jtxtf_impuesto = new javax.swing.JTextField();
        jtxtf_venta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtxtf_clave = new javax.swing.JTextField();
        jbtn_clave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_inventario = new javax.swing.JTable();
        jcmbbox_inventario = new javax.swing.JComboBox<>();
        jtxtf_inventario = new javax.swing.JTextField();
        jbtn_inventtario = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_calcular = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txtf_codigo = new javax.swing.JTextField();
        txtf_nombre = new javax.swing.JTextField();
        txtf_detalle = new javax.swing.JTextField();
        txtf_ganancia = new javax.swing.JTextField();
        txtf_cantidad = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtf_compra = new javax.swing.JTextField();
        txtf_ganancia_porcentaje = new javax.swing.JTextField();
        txtf_impuesto_porcentaje = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtf_impuesto = new javax.swing.JTextField();
        txtf_venta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema no contable");

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setName(""); // NOI18N

        jcmbbox_tiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "hoy", "ayer", "01", "02", "04", "12", "26", "52", " " }));
        jcmbbox_tiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbbox_tiempoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Filtro");

        jLabel2.setText("Ganancia");

        jLabel3.setText("Impuesto V.");

        jLabel4.setText("Venta Tot.");

        jtxtf_ganancia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtf_impuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtf_venta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setText("filtro: 01 ultima semana, 02 ultimas 2 semanas, etc.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcmbbox_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtf_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtf_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtf_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbbox_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtf_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtf_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtf_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Reporte", jPanel1);

        jbtn_clave.setText("Cambiar clave");
        jbtn_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_claveActionPerformed(evt);
            }
        });

        jLabel6.setText("Cambio de Clave");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtf_clave, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jbtn_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(528, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtf_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuario", jPanel2);

        table_inventario.setModel(modelo);
        table_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_inventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_inventario);

        jcmbbox_inventario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Nombre", "Codigo", "Lista" }));
        jcmbbox_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbbox_inventarioActionPerformed(evt);
            }
        });

        jbtn_inventtario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtn_inventtario.setText("Buscar");
        jbtn_inventtario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_inventtarioActionPerformed(evt);
            }
        });

        jLabel11.setText("Codigo");

        jLabel12.setText("Nombre");

        jLabel13.setText("Detalle");

        jLabel14.setText("Ganancia");

        jLabel15.setText("Cantidad");

        btn_calcular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_calcular.setText("Calcular");
        btn_calcular.setToolTipText("Solo para actualizar el precio");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        txtf_ganancia.setEditable(false);

        jLabel17.setText("Precio Compra");

        jLabel18.setText("Ganancia %");

        jLabel19.setText("Impuesto  %");

        jLabel8.setText("Impuesto V.");

        txtf_impuesto.setEditable(false);

        txtf_venta.setEditable(false);

        jLabel9.setText("Precio Vta. ");

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Seleccionar una fila de la tabla para actualizar");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Cantidad es el numero para sumar al total actual y para restar agregar un \"-\" sin las comillas delante del numero");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jcmbbox_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtxtf_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(jbtn_inventtario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtf_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtf_ganancia_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtf_impuesto_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtf_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtf_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtf_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtf_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcmbbox_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtf_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtn_inventtario))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtf_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtf_ganancia_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtf_impuesto_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtf_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtf_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtf_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtf_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Inventario", jPanel3);
        jPanel3.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_claveActionPerformed
        // TODO add your handling code here:
        bool = false;
        bool = usuariodb.actualizar(jtxtf_clave.getText());
        if (bool) {
            JOptionPane.showMessageDialog(null, "Actualizado!!");
        } else {
            JOptionPane.showMessageDialog(null, "Error no se actualizo");
        }
    }//GEN-LAST:event_jbtn_claveActionPerformed

    private void jcmbbox_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbbox_inventarioActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        lstarr = new ArrayList<Producto>();
        int_copy = 0;
        datos = new String[8];
        str_copy = "";
        str_copy = jcmbbox_inventario.getSelectedItem().toString();
        if (str_copy.equalsIgnoreCase("Lista")) {

            lstarr = productodb.listaCompleta();

            for (Producto p : lstarr) {
                datos[0] = String.valueOf(p.getId());
                datos[1] = p.getNombre();
                datos[2] = p.getDetalle();
                datos[3] = String.format("%.02f",p.getPrecio_compra());
                datos[4] = String.format("%.02f",p.getGanancia());
                datos[5] = String.valueOf(p.getCantidad());
                datos[6] = String.format("%.02f",p.getIva());
                datos[7] = String.format("%.02f",p.getPrecio());
                modelo.addRow(datos);

            }
        }
    }//GEN-LAST:event_jcmbbox_inventarioActionPerformed

    private void jcmbbox_tiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbbox_tiempoActionPerformed
        // TODO add your handling code here:

        rendimiento = new Rendimiento();
        int_copy = 0;
        str_copy = jcmbbox_tiempo.getSelectedItem().toString();
        switch (str_copy) {
            case "hoy":
                int_copy = 0;
                break;
            case "ayer":
                int_copy = 1;
                break;
            case "01":
                int_copy = 6;
                break;
            case "02":
                int_copy = 13;
                break;
            case "04":
                int_copy = 27;
                break;
            case "12":
                int_copy = 83;
                break;
            case "26":
                int_copy = 181;
                break;
            case "52":
                int_copy = 364;
                break;
            default:
                break;
        }
        rendimiento = rendimientodb.consultar(int_copy);
        dle_copy = rendimiento.getIngreso();
        str_copy = String.format("%.02f", dle_copy);
        jtxtf_ganancia.setText(str_copy);
        dle_copy = rendimiento.getImpuesto();
        str_copy = String.format("%.02f", dle_copy);
        jtxtf_impuesto.setText(str_copy);
        dle_copy = rendimiento.getVenta();
        str_copy = String.format("%.02f", dle_copy);
        jtxtf_venta.setText(str_copy);
    }//GEN-LAST:event_jcmbbox_tiempoActionPerformed

    private void jbtn_inventtarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_inventtarioActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        lstarr = new ArrayList<Producto>();
        datos = new String[8];
        str_copy = "";
        str_copy = jcmbbox_inventario.getSelectedItem().toString();
        if (str_copy.equalsIgnoreCase("Nombre")) {

            lstarr = productodb.listaNombre(jtxtf_inventario.getText());

            for (Producto p : lstarr) {
                datos[0] = String.valueOf(p.getId());
                datos[1] = p.getNombre();
                datos[2] = p.getDetalle();
                datos[3] = String.format("%.02f", p.getPrecio_compra());
                datos[4] = String.format("%.02f",p.getGanancia());
                datos[5] = String.valueOf(p.getCantidad());
                datos[6] = String.format("%.02f",p.getIva());
                datos[7] = String.format("%.02f",p.getPrecio());
                modelo.addRow(datos);

            }
        }

        if (str_copy.equalsIgnoreCase("Codigo")) {

            lstarr = productodb.listaCodigo(jtxtf_inventario.getText());

            for (Producto p : lstarr) {
                datos[0] = String.valueOf(p.getId());
                datos[1] = p.getNombre();
                datos[2] = p.getDetalle();
                datos[3] = String.format("%.02f",p.getPrecio_compra());
                datos[4] = String.format("%.02f",p.getGanancia());
                datos[5] = String.valueOf(p.getCantidad());
                datos[6] = String.format("%.02f",p.getIva());
                datos[7] = String.format("%.02f",p.getPrecio());
                modelo.addRow(datos);

            }
        }

    }//GEN-LAST:event_jbtn_inventtarioActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        producto = new Producto();
        dle_copy = 0.0;
        try {
            str_copy = txtf_compra.getText();
            dle_copy = Double.valueOf(str_copy);
            producto.setPrecio_compra(dle_copy);
            str_copy = txtf_ganancia_porcentaje.getText();
            dle_copy = Double.valueOf(str_copy);
            dle_copy = (dle_copy / 100) * producto.getPrecio_compra();
            //int_copy = (int) Math.round(dle_copy);
            producto.setGanancia(dle_copy);
            str_copy = txtf_impuesto_porcentaje.getText();
            dle_copy = Double.valueOf(str_copy);
            dle_copy = (producto.getGanancia() + producto.getPrecio_compra()) * (dle_copy / 100);
            //int_copy = (int) Math.round(dle_copy);
            producto.setIva(dle_copy);
            producto.setPrecio(producto.getGanancia() + producto.getPrecio_compra() + producto.getIva());
            //str_copy = String.format("%.02f",producto.getGanancia());
            str_copy = String.valueOf(producto.getGanancia());
            txtf_ganancia.setText(str_copy);
            //str_copy = String.format("%.02f",producto.getIva());
            str_copy = String.valueOf(producto.getIva());
            txtf_impuesto.setText(str_copy);
            //str_copy = String.format("%.02f",producto.getPrecio());
            str_copy = String.valueOf(producto.getPrecio());
            txtf_venta.setText(str_copy);

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Campos no pueden estar vacios " + ex.getMessage());

        }


    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        datos = new String[8];
        Producto producto = new Producto();
        try {
            str_copy = txtf_compra.getText();
            dle_copy = Double.valueOf(str_copy);
            producto.setPrecio_compra(dle_copy);
            str_copy = txtf_cantidad.getText();
            int_copy = Integer.valueOf(str_copy);
            producto.setCantidad(int_copy);
            producto.setId(txtf_codigo.getText());
            producto.setNombre(txtf_nombre.getText());
            producto.setDetalle(txtf_detalle.getText());
            str_copy = txtf_ganancia.getText();
            dle_copy = Double.valueOf(str_copy);
            producto.setGanancia(dle_copy);
            str_copy = txtf_impuesto.getText();
            dle_copy = Double.valueOf(str_copy);
            producto.setIva(dle_copy);
            str_copy = txtf_venta.getText();
            dle_copy = Double.valueOf(str_copy);
            producto.setPrecio(dle_copy);

            if (productodb.consultarRapido(producto.getId())) {
                productodb.actualizar(producto);
                int_copy = 0;

                javax.swing.JOptionPane.showMessageDialog(null, "Actualizado!! ");

                filaSelect = table_inventario.getSelectedRow();
                if (filaSelect >= 0) {
                    datos[0] = txtf_codigo.getText();
                    modelo.setValueAt(datos[0], filaSelect, 0);
                    datos[1] = txtf_nombre.getText();
                    modelo.setValueAt(datos[1], filaSelect, 1);
                    datos[2] = txtf_detalle.getText();
                    modelo.setValueAt(datos[2], filaSelect, 2);
                    datos[3] = txtf_compra.getText();
                    modelo.setValueAt(datos[3], filaSelect, 3);
                    datos[4] = txtf_ganancia.getText();
                    modelo.setValueAt(datos[4], filaSelect, 4);

                    int_copy = Integer.valueOf(modelo.getValueAt(filaSelect, 5).toString());
                    int_copy += producto.getCantidad();
                    datos[5] = String.valueOf(int_copy);
                    modelo.setValueAt(datos[5], filaSelect, 5);
                    datos[6] = txtf_impuesto.getText();
                    modelo.setValueAt(datos[6], filaSelect, 6);
                    datos[7] = txtf_venta.getText();
                    modelo.setValueAt(datos[7], filaSelect, 7);

                }
            } else {
                productodb.agregar(producto);
                javax.swing.JOptionPane.showMessageDialog(null, "Agregado nuevo producto!!");
                datos[0] = txtf_codigo.getText();
                datos[1] = txtf_nombre.getText();
                datos[2] = txtf_detalle.getText();
                datos[3] = txtf_compra.getText();
                datos[4] = txtf_ganancia.getText();
                datos[5] = txtf_cantidad.getText();
                datos[6] = txtf_impuesto.getText();
                datos[7] = txtf_venta.getText();
                modelo.addRow(datos);
            }

        }

    
    catch (Exception ex

    
        ) {
            javax.swing.JOptionPane.showMessageDialog(null, "Algunos campos no pueden contener decimales o estar vacios " + ex.getMessage());
    }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void table_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventarioMouseClicked
        // TODO add your handling code here:
        filaSelect = table_inventario.getSelectedRow();
        if (filaSelect >= 0) {
            txtf_codigo.setText(modelo.getValueAt(filaSelect, 0).toString());
            txtf_nombre.setText(modelo.getValueAt(filaSelect, 1).toString());
            txtf_detalle.setText(modelo.getValueAt(filaSelect, 2).toString());
            txtf_compra.setText(modelo.getValueAt(filaSelect, 3).toString());
            txtf_ganancia.setText(modelo.getValueAt(filaSelect, 4).toString());
//            txtf_cantidad.setText(modelo.getValueAt(filaSelect, 5).toString());
            txtf_impuesto.setText(modelo.getValueAt(filaSelect, 6).toString());
            txtf_venta.setText(modelo.getValueAt(filaSelect, 7).toString());

        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }//GEN-LAST:event_table_inventarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtn_clave;
    private javax.swing.JButton jbtn_inventtario;
    private javax.swing.JComboBox<String> jcmbbox_inventario;
    private javax.swing.JComboBox<String> jcmbbox_tiempo;
    private javax.swing.JTextField jtxtf_clave;
    private javax.swing.JTextField jtxtf_ganancia;
    private javax.swing.JTextField jtxtf_impuesto;
    private javax.swing.JTextField jtxtf_inventario;
    private javax.swing.JTextField jtxtf_venta;
    private javax.swing.JTable table_inventario;
    private javax.swing.JTextField txtf_cantidad;
    private javax.swing.JTextField txtf_codigo;
    private javax.swing.JTextField txtf_compra;
    private javax.swing.JTextField txtf_detalle;
    private javax.swing.JTextField txtf_ganancia;
    private javax.swing.JTextField txtf_ganancia_porcentaje;
    private javax.swing.JTextField txtf_impuesto;
    private javax.swing.JTextField txtf_impuesto_porcentaje;
    private javax.swing.JTextField txtf_nombre;
    private javax.swing.JTextField txtf_venta;
    // End of variables declaration//GEN-END:variables
}