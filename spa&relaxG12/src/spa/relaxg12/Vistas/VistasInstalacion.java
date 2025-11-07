package spa.relaxg12.Vistas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import spa.relaxg12.Modelo.Instalacion;
import spa.relaxg12.Persistencia.*;

/**
 *
 * @author franco-desktop
 */

public class VistasInstalacion extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private InstalacionData instalacionData;
    
    
    public VistasInstalacion() {
        initComponents();
       
       
        instalacionData = new InstalacionData();
        
        modelo = new DefaultTableModel();
            
        jSPrecio.setModel(new SpinnerNumberModel(0.0, 0.0, 100000.0, 0.5));
        jTId.setEditable(false);

        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
        jBEliminar.setEnabled(false);

        armarCabecera();
        cargarTabla();
    }
    
    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Detalle");
        modelo.addColumn("Precio 30min");
        modelo.addColumn("Estado");
        jTabla.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTId = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTDetalle = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTNombre = new javax.swing.JTextArea();
        jSPrecio = new javax.swing.JSpinner();
        jCEstado = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(45, 45, 45));
        setForeground(new java.awt.Color(45, 45, 45));
        setMinimumSize(new java.awt.Dimension(880, 530));
        setPreferredSize(new java.awt.Dimension(880, 530));

        jDesktopPane1.setBackground(new java.awt.Color(45, 45, 45));
        jDesktopPane1.setForeground(new java.awt.Color(234, 247, 246));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(850, 480));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));

        jTId.setBackground(new java.awt.Color(230, 230, 230));
        jTId.setColumns(20);
        jTId.setForeground(new java.awt.Color(0, 0, 0));
        jTId.setRows(5);
        jScrollPane3.setViewportView(jTId);

        jTDetalle.setBackground(new java.awt.Color(230, 230, 230));
        jTDetalle.setColumns(20);
        jTDetalle.setForeground(new java.awt.Color(0, 0, 0));
        jTDetalle.setRows(5);
        jScrollPane4.setViewportView(jTDetalle);

        jTNombre.setBackground(new java.awt.Color(230, 230, 230));
        jTNombre.setColumns(20);
        jTNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTNombre.setRows(5);
        jScrollPane5.setViewportView(jTNombre);

        jCEstado.setBackground(new java.awt.Color(230, 230, 230));
        jCEstado.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCEstado.setForeground(new java.awt.Color(0, 0, 0));
        jCEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No Disponible" }));
        jCEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("ID:");

        label2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 0));
        label2.setText("Nombre:");

        label3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 0, 0));
        label3.setText("Detalle de uso:");

        label4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 0, 0));
        label4.setText("Precio por 30min:");

        label5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label5.setForeground(new java.awt.Color(0, 0, 0));
        label5.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jSPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(60, 63, 65));

        jTabla.setBackground(new java.awt.Color(60, 63, 65));
        jTabla.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTabla.setForeground(new java.awt.Color(230, 230, 230));
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Detalle", "Precio30min", "Estado"
            }
        ));
        jTabla.setGridColor(new java.awt.Color(80, 80, 80));
        jTabla.setSelectionBackground(new java.awt.Color(75, 110, 175));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jBActualizar.setBackground(new java.awt.Color(240, 240, 240));
        jBActualizar.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jBActualizar.setForeground(new java.awt.Color(40, 40, 40));
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(194, 76, 76));
        jBEliminar.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBLimpiar.setBackground(new java.awt.Color(240, 240, 240));
        jBLimpiar.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(40, 40, 40));
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBGuardar.setBackground(new java.awt.Color(76, 154, 155));
        jBGuardar.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jBGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBNuevo.setBackground(new java.awt.Color(240, 240, 240));
        jBNuevo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jBNuevo.setForeground(new java.awt.Color(40, 40, 40));
        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBLimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jBLimpiar)
                        .addGap(33, 33, 33)
                        .addComponent(jBEliminar)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBNuevo)
                            .addComponent(jBGuardar)
                            .addComponent(jBActualizar)
                            .addComponent(jBLimpiar)
                            .addComponent(jBEliminar)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        limpiarCampos();
        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
        jBEliminar.setEnabled(false);
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        try {
            String nombre = jTNombre.getText();
            String detalle = jTDetalle.getText();
            double precio = (Double) jSPrecio.getValue();
            String estadoSeleccionado = (String) jCEstado.getSelectedItem();
            boolean estado = estadoSeleccionado.equals("Disponible"); 

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
                return;
            }

            Instalacion nuevaInst = new Instalacion(nombre, detalle, precio, estado);
            
            boolean guardadOk = instalacionData.guardarInstalacion(nuevaInst);
            
            if(guardadOk) {
                JOptionPane.showMessageDialog(this, "Instalacion guardada con exito!");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar la instalacion.");
            }
            
            
            
            limpiarCampos();
            cargarTabla(); // Recarga la tabla

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener datos de los campos: " + ex.getMessage());
        }
    
    
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        try {
            int id = 0;
            String idText = jTId.getText().trim();
            if (!idText.isEmpty()) {
                id = Integer.parseInt(idText);
            } else {
                JOptionPane.showMessageDialog(this, "ID inválido. Seleccione una instalación de la tabla.");
                return;
            }

            String nombre = jTNombre.getText().trim();
            String detalle = jTDetalle.getText().trim();
            double precio = ((Number) jSPrecio.getValue()).doubleValue();
            String estadoSeleccionado = (String) jCEstado.getSelectedItem();
            boolean estado = "Disponible".equals(estadoSeleccionado);

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
                return;
            }

            Instalacion instActualizada = new Instalacion(id, nombre, detalle, precio, estado);
            instalacionData.actualizarInstalacion(instActualizada);

            limpiarCampos();
            cargarTabla();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido. Seleccione una instalación de la tabla.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener datos: " + ex.getMessage());
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        try {
            String idText = jTId.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID inválido. Seleccione una instalación de la tabla.");
                return;
            }
            int id = Integer.parseInt(idText);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que desea eliminar esta instalación (se marcará como Inactiva)?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                instalacionData.eliminarInstalacion(id);
                limpiarCampos();
                cargarTabla();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido. Seleccione una instalación de la tabla.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void limpiarCampos() {
        jTId.setText("");
        jTNombre.setText("");
        jTDetalle.setText("");
        jSPrecio.setValue(0.0);
        jCEstado.setSelectedItem("Disponible");
        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
        jBEliminar.setEnabled(false);
    }

    private void cargarTabla() {
        modelo.setRowCount(0);

        List<Instalacion> instalaciones = instalacionData.listarInstalaciones();

        for (Instalacion inst : instalaciones) {
            modelo.addRow(new Object[]{
                inst.getIdInstalacion(),
                inst.getNombre(),
                inst.getDetalleUso(),
                inst.getPrecioPor30min(),
                inst.isEstado() ? "Disponible" : "No Disponible"
            });
        }
    }
    
    private void jTablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMousePressed
        int fila = jTabla.getSelectedRow();
        if (fila != -1) {
            Object idObj = jTabla.getValueAt(fila, 0);
            Object nombreObj = jTabla.getValueAt(fila, 1);
            Object detalleObj = jTabla.getValueAt(fila, 2);
            Object precioObj = jTabla.getValueAt(fila, 3);
            Object estadoObj = jTabla.getValueAt(fila, 4);

            int id = (idObj instanceof Number) ? ((Number) idObj).intValue() : Integer.parseInt(String.valueOf(idObj));
            String nombre = (nombreObj != null) ? String.valueOf(nombreObj) : "";
            String detalle = (detalleObj != null) ? String.valueOf(detalleObj) : "";
            double precio = (precioObj instanceof Number) ? ((Number) precioObj).doubleValue() : Double.parseDouble(String.valueOf(precioObj));
            String estadoStr = (estadoObj != null) ? String.valueOf(estadoObj) : "No Disponible";

            jTId.setText(String.valueOf(id));
            jTNombre.setText(nombre);
            jTDetalle.setText(detalle);
            jSPrecio.setValue(precio);
            jCEstado.setSelectedItem(estadoStr);

            jBGuardar.setEnabled(false);
            jBActualizar.setEnabled(true);
            jBEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_jTablaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCEstado;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSPrecio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTDetalle;
    private javax.swing.JTextArea jTId;
    private javax.swing.JTextArea jTNombre;
    private javax.swing.JTable jTabla;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    // End of variables declaration//GEN-END:variables
}


