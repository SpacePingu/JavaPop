/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Tienda;
import logica.Usuarios;

/**
 *
 * @author adryh
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);

        //Icono para la ventana
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ImageIcon img = new ImageIcon(s + "\\src\\logos\\logo32px.png");
        this.setIconImage(img.getImage());

        System.out.println("\nUsuario actual:\n");
        System.out.println(Usuarios.clienteActual.getNombre() + "----" + Usuarios.clienteActual.getCorreo());

        //Bienvenida personalizada
        jLabelNombreUsuarioActual.setText(Usuarios.clienteActual.getNombre());
        
        //cargamos las publicaciones que ha creado del cliente:
        Tienda.crearMisproductos();
        
        //Sacamos alertas por pantalla en caso de que exista algun producto del usuario con notificaciones:
        JOptionPane.showMessageDialog(VentanaPrincipal.this, "Bienvenido a Javapop "+Usuarios.clienteActual.getNombre()
                +"\n" +Tienda.alertasReservas()+"\n"+Tienda.alertasCompras());
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCatalogo = new javax.swing.JButton();
        jButtonAlta = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jButtonMejoraProfesional = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNombreUsuarioActual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonCatalogo.setText("VER TODO EL CATÁLOGO");
        jButtonCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatalogoActionPerformed(evt);
            }
        });

        jButtonAlta.setText("DAR DE ALTA UN PRODUCTO");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        jButtonCerrarSesion.setText("CERRAR SESIÓN");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jButtonMejoraProfesional.setText("MEJORA PROFESIONAL");
        jButtonMejoraProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMejoraProfesionalActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logo128px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel2.setText("Bienvenid@ ");

        jLabelNombreUsuarioActual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelNombreUsuarioActual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombreUsuarioActual.setText("( ͡° ͜ʖ ͡°)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jButtonMejoraProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCatalogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNombreUsuarioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNombreUsuarioActual))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMejoraProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCatalogoActionPerformed
        Catalogo c = new Catalogo();
        c.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonCatalogoActionPerformed

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed
        AltaProducto ap = new AltaProducto();
        ap.setVisible(true);

    }//GEN-LAST:event_jButtonAltaActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        Log log = null;
        try {
            log = new Log();
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jButtonMejoraProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMejoraProfesionalActionPerformed
        if (Usuarios.clienteActual.isPremium()) {
            JOptionPane.showMessageDialog(rootPane, "Ya estás dado de alta como usuario profesional.");
        } else {
            MejoraUsuarioProf mup = new MejoraUsuarioProf();
            mup.setVisible(true);
        }
    }//GEN-LAST:event_jButtonMejoraProfesionalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonCatalogo;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonMejoraProfesional;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNombreUsuarioActual;
    // End of variables declaration//GEN-END:variables
}
