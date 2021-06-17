/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.Factura;
import logica.FacturasMetodos;
import logica.Tienda;
import logica.Usuarios;

/**
 *
 * @author adryh
 */
public class Articulo extends javax.swing.JFrame {

    BufferedImage bImage = null;
    File cambiarImagen = new File("");

    /**
     * Creates new form Articulo
     */
    public Articulo() {
        initComponents();
        this.setLocationRelativeTo(null);

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ImageIcon img = new ImageIcon(s + "\\src\\logos\\logo32px.png");
        this.setIconImage(img.getImage());

        //Introducimos el icono correspondiente al producto
        ImageIcon imagenRuta = new ImageIcon(s + ".\\src\\IconosProductos\\" + Tienda.productoseleccionado.getId() + ".jpg");
        ImageIcon imagenProducto = new ImageIcon(imagenRuta.getImage().getScaledInstance(jLabelIcono.getWidth(), jLabelIcono.getHeight(), 1));
        jLabelIcono.setIcon(imagenProducto);

        //estos botones son invisibles para todos aquellos usuarios que vean el producto y no sean los creadores del mismo.
        jButtonBaja.setVisible(false);
        jButtonEditar.setVisible(false);
        jButtonCambiarImagen.setVisible(false);
        jToggleButtonUrgente.setVisible(false);
        jButtonResponderComprador.setVisible(false);
        jButtonRespuestaVendedor.setVisible(false);

        //Si es el usuario creador, se activan los botones de Dar de baja y Editar producto y se desactiva el botón de comprar.
        if (Usuarios.clienteActual.getCorreo().equals(Tienda.productoseleccionado.getVendedor().getCorreo())) {
            jFormattedPrecio.setEditable(true);
            jButtonBaja.setVisible(true);
            jButtonEditar.setVisible(true);
            jButtonCambiarImagen.setVisible(true);
            jTextTitulo.setEditable(true);
            jTextDescripcion.setEditable(true);
            jButtonComprar.setVisible(false);
            jToggleButtonUrgente.setVisible(true);

            if (Tienda.productoseleccionado.getEstado() == 1) {
                jButtonResponderComprador.setVisible(true);

            } else if (Tienda.productoseleccionado.getEstado() == 2) {
                jButtonEditar.setVisible(false);
                jToggleButtonUrgente.setVisible(false);
                jButtonBaja.setVisible(false);

            }
        }

        //Se copia toda la informacion del producto en los campos de textos para su visualización. 
        jFormattedPrecio.setValue(Tienda.productoseleccionado.getPrecio());
        jTextTitulo.setText(Tienda.productoseleccionado.getTitulo());
        jTextDescripcion.setText(Tienda.productoseleccionado.getDescripcion());
        jLabelCondicion.setText(Tienda.productoseleccionado.getCondicion());
        if (Tienda.productoseleccionado.isUrgente()) {
            jToggleButtonUrgente.setVisible(false);

        }

        switch (Tienda.productoseleccionado.getEstado()) {
            case 0:
                jLabelEstado.setText("En venta");
                break;
            case 1:
                jLabelEstado.setText("Reservado");
                jButtonComprar.setVisible(false);
                jButtonEditar.setVisible(false);
                if ((!Usuarios.clienteActual.getCorreo().equals(Tienda.productoseleccionado.getVendedor().getCorreo()))
                        && (!Usuarios.clienteActual.getCorreo().equals(Tienda.productoseleccionado.getComprador().getCorreo()))) {
                    JOptionPane.showMessageDialog(rootPane, "!!!\nEste producto está reservado para otra persona.\nPuede que el vendedor decida no venderlo...");
                }

                break;
            case 2:
                jLabelEstado.setText("En proceso de compra");
                jButtonComprar.setVisible(false);
                jButtonResponderComprador.setVisible(false);
                if ((!Usuarios.clienteActual.getCorreo().equals(Tienda.productoseleccionado.getVendedor().getCorreo()))
                        && (!Usuarios.clienteActual.getCorreo().equals(Tienda.productoseleccionado.getComprador().getCorreo()))) {
                    JOptionPane.showMessageDialog(rootPane, "Se está tramitando la venta de este artículo");
                }

                break;
        }

        jLabelFecha.setText(Tienda.productoseleccionado.getFecha());
        jLabelVendedor.setText(Tienda.productoseleccionado.getVendedor().getNombre());
        jLabelUbicacion.setText(Tienda.productoseleccionado.getVendedor().getCiudad());

        if (Tienda.productoseleccionado.isUrgente()) {
            jLabelUrgente.setText("Venta urgente.");
        } else {
            jLabelUrgente.setText("No.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelIcono = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDescripcion = new javax.swing.JTextArea();
        jButtonAtras = new javax.swing.JButton();
        jButtonBaja = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonComprar = new javax.swing.JButton();
        jButtonCambiarImagen = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelUbicacion = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelVendedor = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelCondicion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedPrecio = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jToggleButtonUrgente = new javax.swing.JToggleButton();
        jLabelUrgente = new javax.swing.JLabel();
        jButtonResponderComprador = new javax.swing.JButton();
        jButtonRespuestaVendedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Título del producto:");

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextTitulo.setEditable(false);
        jTextTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        jTextDescripcion.setEditable(false);
        jTextDescripcion.setColumns(20);
        jTextDescripcion.setLineWrap(true);
        jTextDescripcion.setRows(5);
        jTextDescripcion.setWrapStyleWord(true);
        jTextDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextDescripcion);

        jButtonAtras.setText("Volver al catálogo");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonBaja.setText("Dar de baja el producto");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Actualizar el Producto");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonComprar.setText("Comprar");
        jButtonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprarActionPerformed(evt);
            }
        });

        jButtonCambiarImagen.setText("Cambiar Imagen");
        jButtonCambiarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarImagenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Fecha de creación:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Condición del producto:");

        jLabelFecha.setText("//FECHA//");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ubicacion del producto:");

        jLabelUbicacion.setText("//CLIENTE.UBICACION+CLIENTE.CP");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Estado de la publicación:");

        jLabelEstado.setText("//En venta//reservado//Vendido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Venta Urgente:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Vendedor:");

        jLabelVendedor.setText("//Vendedor.nombre");

        jLabelCondicion.setText("//Condicion");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Precio:");

        jFormattedPrecio.setEditable(false);
        jFormattedPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedPrecioActionPerformed(evt);
            }
        });

        jLabel11.setText("€");

        jToggleButtonUrgente.setText("Marcar como urgente");
        jToggleButtonUrgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonUrgenteActionPerformed(evt);
            }
        });

        jLabelUrgente.setText("//urgente");

        jButtonResponderComprador.setText("Ver y responder mensaje comprador");
        jButtonResponderComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResponderCompradorActionPerformed(evt);
            }
        });

        jButtonRespuestaVendedor.setText("Ver respuesta vendedor");
        jButtonRespuestaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRespuestaVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonResponderComprador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelUbicacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jButtonCambiarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jLabelFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jButtonAtras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabelUrgente))
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel1)
                                                .addComponent(jTextTitulo)
                                                .addComponent(jLabel2)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                                .addComponent(jLabelCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jFormattedPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel11)))
                                            .addComponent(jToggleButtonUrgente))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonComprar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRespuestaVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCambiarImagen)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUbicacion)
                    .addComponent(jLabelCondicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha)
                    .addComponent(jLabelEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabelUrgente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelVendedor)
                    .addComponent(jToggleButtonUrgente))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonResponderComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRespuestaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed

        Catalogo c = new Catalogo();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaActionPerformed

        File f = new File(".\\src\\IconosProductos\\" + Tienda.productoseleccionado.getId() + ".jpg");

        int a = JOptionPane.showConfirmDialog(this, "Esto eliminará para siempre la publicación."
                + "\n¿Seguro que deseas continuar?",
                "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {

            try {
                f.delete();

            } catch (Exception e) {
                e.printStackTrace();
            }
        

        Tienda.hashProdutos.remove(Tienda.productoseleccionado.getId());
        Tienda.volcarHashMapProductos();
        Tienda.guardarTienda();
        Tienda.crearMisproductos();

        JOptionPane.showMessageDialog(rootPane, "Producto eliminado satisfactoriamente.\nRegresando al catálogo....");
        Catalogo c = new Catalogo();
        c.setVisible(true);
        this.dispose();

    }

    }//GEN-LAST:event_jButtonBajaActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

        String errores = "Los siguientes campos son incorrectos:";
        boolean valido = true;
        String msgUrgente = "";

        String precio = jFormattedPrecio.getText().replace(".", "");
        precio = precio.replace(",", ".");
        Double precioAc = Double.parseDouble(precio);

        String titAc = jTextTitulo.getText();
        String desAc = jTextDescripcion.getText();
//        boolean urgente = jCheckUrgente.isSelected();

        if (titAc.isBlank()) {
            errores += "\nDebe tener un título";
            valido = false;
        }
        if (desAc.isBlank()) {
            errores += "\nDebe tener una descripción";
            valido = false;
        }
//        if (urgente) {
//            msgUrgente = "Se ha realizado un cargo de 5€ pora que este artículo destaque sobre los demás";
//        }
        if (precioAc < 0) {
            errores += "\nEl precio debe ser superior a 0";
            valido = false;
        }

        if (valido) {

            Tienda.productoseleccionado.setPrecio(precioAc);
            Tienda.productoseleccionado.setTitulo(titAc);
            Tienda.productoseleccionado.setDescripcion(desAc);
            if (!Tienda.productoseleccionado.isUrgente()) {
                Tienda.productoseleccionado.setUrgente(jToggleButtonUrgente.isSelected());
            }

            System.out.println(Tienda.productoseleccionado);
            try {

                bImage = ImageIO.read(cambiarImagen);
                ImageIO.write(bImage, "jpg", new File(".\\src\\IconosProductos\\" + Tienda.productoseleccionado.getId() + ".jpg"));

            } catch (IOException e) {
                System.out.println("Exception occured :" + e.getMessage());

            }
            JOptionPane.showMessageDialog(rootPane, "Datos del artículo actualizados correctamente" + msgUrgente);

            Tienda.hashProdutos.replace(Tienda.productoseleccionado.getId(), Tienda.productoseleccionado);
            Tienda.volcarHashMapProductos();
            Tienda.guardarTienda();
            Tienda.crearMisproductos();
            Catalogo c = new Catalogo();
            c.setVisible(true);
            this.dispose();

        } else {

            JOptionPane.showMessageDialog(jPanel1, errores);

        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Catalogo c = new Catalogo();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonCambiarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarImagenActionPerformed
        //crear el objeto jFileChooser
        JFileChooser file = new JFileChooser();

        //Filtro para que solo admita imagenes .jpg o .png
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        file.setCurrentDirectory(new File(s + "\\src\\ImagenesProductos"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.Images", "jpg");
        file.addChoosableFileFilter(filtro);

        //abrir la ventana
        int resultado = file.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {

            cambiarImagen = file.getSelectedFile();

            String rutaAbsImagen = cambiarImagen.getAbsolutePath();
            ImageIcon imagen = new ImageIcon(rutaAbsImagen);

            //redimensión para ajustar:
            ImageIcon imgRedim = new ImageIcon(imagen.getImage().getScaledInstance(jLabelIcono.getWidth(), jLabelIcono.getHeight(), 1));
            jLabelIcono.setIcon(imgRedim);

        } else if (resultado == JFileChooser.CANCEL_OPTION) {

            JOptionPane.showMessageDialog(rootPane, "Ninguna imagen seleccionada");

        }
    }//GEN-LAST:event_jButtonCambiarImagenActionPerformed

    private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprarActionPerformed
        String a = JOptionPane.showInputDialog(rootPane, "Escriba un mensaje para el vendedor"
                + " del producto (no puede estar vacío)", DISPOSE_ON_CLOSE);
        System.out.println("\n" + a);
        if (a.isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "El mensaje de compra no puede estar vacío.");
        } else {
            Tienda.productoseleccionado.setComprador(Usuarios.clienteActual);
            Tienda.productoseleccionado.setCompradorMensaje(a);
            Tienda.productoseleccionado.setEstado(1);

            JOptionPane.showMessageDialog(rootPane, "Solicitud de compra enviada correctamente."
                    + "\nDebe esperar a que el vendedor acepte o rechace la petición.");

            Tienda.hashProdutos.replace(Tienda.productoseleccionado.getId(), Tienda.productoseleccionado);
            Tienda.volcarHashMapProductos();
            Tienda.guardarTienda();
            Articulo c = new Articulo();
            c.setVisible(true);
            this.dispose();

        }

    }//GEN-LAST:event_jButtonComprarActionPerformed

    private void jFormattedPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedPrecioActionPerformed

    private void jToggleButtonUrgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonUrgenteActionPerformed
        if (jToggleButtonUrgente.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Se realizará un cargo de 5,00€ en su"
                    + " tarjeta de crédito para que este producto destaque sobre los demás durante 7 días");
        }
    }//GEN-LAST:event_jToggleButtonUrgenteActionPerformed

    private void jButtonResponderCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResponderCompradorActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "El usuario: " + Tienda.productoseleccionado.getComprador().getNombre()
                + ", quiere comprar su producto y le ha enviado el siguiente mensaje:"
                + "\n" + Tienda.productoseleccionado.getCompradorMensaje()
                + "\n\n¿Confirma la venta?", "Confirmación de venta", YES_NO_OPTION, QUESTION_MESSAGE);

        if (respuesta == 0) {
            Tienda.productoseleccionado.setEstado(2);

            String t = JOptionPane.showInputDialog("Escriba un texto de respuesta para el comprador. "
                    + "\n(no puede estar vacío)."
                    + "\n\nA continuación se generará una factura del producto que podrá guardar."
                    + "\nEsta factura será accesible también desde CATALOGO -> PRODUCTOS VENDIDOS -> VER FACTURA");

            Object[] options = {"Guardar factura", "Volver"};
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String fechaVenta = formatter.format(date);

            Factura f = new Factura(fechaVenta, Tienda.productoseleccionado.getId(), Tienda.productoseleccionado);
            
            FacturasMetodos.facturas.add(f);
            FacturasMetodos.guardarFacturas();

            System.out.println(f);
            FacturasMetodos.generarFicheroFactura(f);

            Tienda.productoseleccionado.setCompradorMensaje(t);

            Tienda.hashProdutos.replace(Tienda.productoseleccionado.getId(), Tienda.productoseleccionado);
            Tienda.volcarHashMapProductos();
            Tienda.guardarTienda();
            Articulo a = new Articulo();
            a.setVisible(true);
            this.dispose();

        } else if (respuesta == 1) {
            Tienda.productoseleccionado.setComprador(null);
            Tienda.productoseleccionado.setCompradorMensaje(null);
            Tienda.productoseleccionado.setEstado(0);

            Tienda.hashProdutos.replace(Tienda.productoseleccionado.getId(), Tienda.productoseleccionado);
            Tienda.volcarHashMapProductos();
            Tienda.guardarTienda();

            Catalogo c = new Catalogo();
            c.setVisible(true);
            this.dispose();

        }


    }//GEN-LAST:event_jButtonResponderCompradorActionPerformed

    private void jButtonRespuestaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRespuestaVendedorActionPerformed
        JOptionPane.showMessageDialog(rootPane, "El vendedor ha aceptado la compra."
                + "\nEste es el mensaje que ha dejado:\n\n"
                + Tienda.productoseleccionado.getCompradorMensaje());
    }//GEN-LAST:event_jButtonRespuestaVendedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonCambiarImagen;
    private javax.swing.JButton jButtonComprar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonResponderComprador;
    private javax.swing.JButton jButtonRespuestaVendedor;
    private javax.swing.JFormattedTextField jFormattedPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCondicion;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelUbicacion;
    private javax.swing.JLabel jLabelUrgente;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextDescripcion;
    private javax.swing.JTextField jTextTitulo;
    private javax.swing.JToggleButton jToggleButtonUrgente;
    // End of variables declaration//GEN-END:variables
}
