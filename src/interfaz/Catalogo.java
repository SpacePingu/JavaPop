/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import logica.FacturasMetodos;
import logica.Tienda;
import static logica.Tienda.misproductos;
import static logica.Tienda.tienda;
import logica.Usuarios;

/**
 *
 * @author adryh
 */
public class Catalogo extends javax.swing.JFrame {

    JLabel icono = new JLabel();

    /**
     * Creates new form Catalogo
     */
    public Catalogo() {
        initComponents();
        this.setLocationRelativeTo(null);

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        ImageIcon img = new ImageIcon(s + "\\src\\logos\\logo32px.png");
        this.setIconImage(img.getImage());

        Tienda.ordenarBurbujaArray(Tienda.tienda);
        rellenarCatalogo();
        rellenarMisProductos();
        rellenarReservados();
        rellenarVendidos();

        //resize para que entren los iconos bien
        jTableCatalogo.setRowHeight(150);
        jTableCatalogo.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableCatalogo.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTableMisProd.setRowHeight(150);
        jTableMisProd.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableMisProd.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTableReservados.setRowHeight(150);
        jTableReservados.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableReservados.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTableVendidos.setRowHeight(150);
        jTableVendidos.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableVendidos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public final void rellenarCatalogo() {
        DefaultTableModel model = (DefaultTableModel) jTableCatalogo.getModel();
        Object rowData[] = new Object[8];
        Object rowData2[] = new Object[8];
        String carpetaPath = ".\\src\\IconosProductos\\";

        for (int i = 0; i < tienda.size(); i++) {

            if (tienda.get(i).isUrgente()) {

                rowData[0] = tienda.get(i).getId();

                ImageIcon imageicon = new ImageIcon(carpetaPath + tienda.get(i).getId() + ".jpg");
                ImageIcon imgRedim = new ImageIcon(imageicon.getImage().getScaledInstance(150, 150, 1));
                rowData[1] = imgRedim;

                rowData[2] = tienda.get(i).getTitulo();
                rowData[3] = tienda.get(i).getCategoria();
                rowData[4] = tienda.get(i).getCondicion();

                //para resaltar la localización y la distancia a la que el usuario se encuentra de ella.
                if (Tienda.calcularDistancia(tienda.get(i)) == 0) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " En tu zona";
                } else if ((Tienda.calcularDistancia(tienda.get(i)) <= 99) && (Tienda.calcularDistancia(tienda.get(i)) > 0)) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Muy Cercano)";

                } else if ((Tienda.calcularDistancia(tienda.get(i)) <= 999) && (Tienda.calcularDistancia(tienda.get(i)) > 100)) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Cercano)";

                } else {
                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Lejano)";
                }

                //texto para expresar el estado del producto (en venta, reservado,vendido)
                switch (tienda.get(i).getEstado()) {
                    case 0:
                        rowData[6] = "En venta, Urgente";
                        break;
                    case 1:
                        rowData[6] = "Reservado";
                        break;
                    case 2:
                        rowData[6] = "En proceso de compra";
                        break;
                    case 3:
                        rowData[6] = "Vendido";
                        continue;

                }
                rowData[7] = tienda.get(i).getPrecio();

                model.addRow(rowData);
            }
        }
        for (int e = 0; e < tienda.size(); e++) {

            if (!tienda.get(e).isUrgente()) {
                rowData2[0] = tienda.get(e).getId();

                ImageIcon imageicon = new ImageIcon(carpetaPath + tienda.get(e).getId() + ".jpg");
                ImageIcon imgRedim = new ImageIcon(imageicon.getImage().getScaledInstance(150, 150, 1));
                rowData2[1] = imgRedim;

                rowData2[2] = tienda.get(e).getTitulo();
                rowData2[3] = tienda.get(e).getCategoria();
                rowData2[4] = tienda.get(e).getCondicion();

                if (Tienda.calcularDistancia(tienda.get(e)) == 0) {

                    rowData2[5] = "Tu zona";

                } else if ((Tienda.calcularDistancia(tienda.get(e)) <= 99) && (Tienda.calcularDistancia(tienda.get(e)) > 0)) {

                    rowData2[5] = tienda.get(e).getUbicacionCiudad() + " (Muy Cercano)";

                } else if ((Tienda.calcularDistancia(tienda.get(e)) <= 999) && (Tienda.calcularDistancia(tienda.get(e)) > 110)) {

                    rowData2[5] = tienda.get(e).getUbicacionCiudad() + " (Cercano)";

                } else {
                    rowData2[5] = tienda.get(e).getUbicacionCiudad() + " (Lejano)";
                }
                switch (tienda.get(e).getEstado()) {
                    case 0:
                        rowData2[6] = "En venta";
                        break;
                    case 1:
                        rowData2[6] = "Reservado";
                        break;
                    case 2:
                        rowData[6] = "En proceso de compra";
                        break;
                    case 3:
                        rowData2[6] = "Vendido";
                        break;
                }
                rowData2[7] = tienda.get(e).getPrecio();

                model.addRow(rowData2);

            }
        }

    }

    public final void rellenarMisProductos() {
        DefaultTableModel model = (DefaultTableModel) jTableMisProd.getModel();
        Object rowData[] = new Object[8];
        String carpetaPath = ".\\src\\IconosProductos\\";

        for (int i = 0; i < misproductos.size(); i++) {

            rowData[0] = misproductos.get(i).getId();

            ImageIcon imageicon = new ImageIcon(carpetaPath + misproductos.get(i).getId() + ".jpg");
            ImageIcon imgRedim = new ImageIcon(imageicon.getImage().getScaledInstance(150, 150, 1));
            rowData[1] = imgRedim;

            rowData[2] = misproductos.get(i).getTitulo();
            rowData[3] = misproductos.get(i).getCategoria();
            rowData[4] = misproductos.get(i).getCondicion();
            rowData[5] = misproductos.get(i).getUbicacionCiudad();
            switch (misproductos.get(i).getEstado()) {
                case 0:
                    rowData[6] = "En venta";
                    break;
                case 1:
                    rowData[6] = "Reservado";
                    break;
                case 2:
                    rowData[6] = "En proceso de compra";
                    break;
                default:
                    rowData[6] = "Vendido";
                    break;
            }
            rowData[7] = misproductos.get(i).getPrecio();

            model.addRow(rowData);
        }
    }

    public final void rellenarReservados() {
        DefaultTableModel model = (DefaultTableModel) jTableReservados.getModel();
        Object rowData[] = new Object[8];
        String carpetaPath = ".\\src\\IconosProductos\\";

        for (int i = 0; i < tienda.size(); i++) {

            //Si y solo si, el producto está reservado y coinciden el email del usuario actual con el email del comprador que ha reservado el producto.
            if ((tienda.get(i).getEstado() == 1) && (tienda.get(i).getComprador().getCorreo().equals(Usuarios.clienteActual.getCorreo()))) {

                rowData[0] = tienda.get(i).getId();
                ImageIcon imageicon = new ImageIcon(carpetaPath + tienda.get(i).getId() + ".jpg");
                ImageIcon imgRedim = new ImageIcon(imageicon.getImage().getScaledInstance(150, 150, 1));
                rowData[1] = imgRedim;

                rowData[2] = tienda.get(i).getTitulo();
                rowData[3] = tienda.get(i).getCategoria();
                rowData[4] = tienda.get(i).getCondicion();

                //para resaltar la localización y la distancia a la que el usuario se encuentra de ella.
                if (Tienda.calcularDistancia(tienda.get(i)) == 0) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " En tu zona";
                } else if ((Tienda.calcularDistancia(tienda.get(i)) <= 99) && (Tienda.calcularDistancia(tienda.get(i)) > 0)) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Muy Cercano)";

                } else if ((Tienda.calcularDistancia(tienda.get(i)) <= 999) && (Tienda.calcularDistancia(tienda.get(i)) > 100)) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Cercano)";

                } else {
                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Lejano)";
                }

                rowData[6] = "Reservado";

                rowData[7] = tienda.get(i).getPrecio();
                model.addRow(rowData);
            }

        }
    }

    public final void rellenarVendidos() {
        DefaultTableModel model = (DefaultTableModel) jTableVendidos.getModel();
        Object rowData[] = new Object[8];
        String carpetaPath = ".\\src\\IconosProductos\\";

        for (int i = 0; i < tienda.size(); i++) {

            //Si y solo si, el producto está vendido y coinciden el email del usuario actual con el email del comprador/vendedor del producto.
            if ((tienda.get(i).getEstado() == 3) && ((tienda.get(i).getComprador().getCorreo().equals(Usuarios.clienteActual.getCorreo())
                    || (tienda.get(i).getVendedor().getCorreo().equals(Usuarios.clienteActual.getCorreo()))))) {

                rowData[0] = tienda.get(i).getId();
                ImageIcon imageicon = new ImageIcon(carpetaPath + tienda.get(i).getId() + ".jpg");
                ImageIcon imgRedim = new ImageIcon(imageicon.getImage().getScaledInstance(150, 150, 1));
                rowData[1] = imgRedim;

                rowData[2] = tienda.get(i).getTitulo();
                rowData[3] = tienda.get(i).getCategoria();
                rowData[4] = tienda.get(i).getCondicion();

                //para resaltar la localización y la distancia a la que el usuario se encuentra de ella.
                if (Tienda.calcularDistancia(tienda.get(i)) == 0) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + "( En tu zona )";
                } else if ((Tienda.calcularDistancia(tienda.get(i)) <= 99) && (Tienda.calcularDistancia(tienda.get(i)) > 0)) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Muy Cercano)";

                } else if ((Tienda.calcularDistancia(tienda.get(i)) <= 999) && (Tienda.calcularDistancia(tienda.get(i)) > 100)) {

                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Cercano)";

                } else {
                    rowData[5] = tienda.get(i).getUbicacionCiudad() + " (Lejano)";
                }

                rowData[6] = "Vendido";

                rowData[7] = tienda.get(i).getPrecio();
                model.addRow(rowData);
            }

        }
    }
//Método para filtro avanzado, con doble búsqueda: por categoría del producto y por palabra.

    private void filtrarCategoria(String categoria, String nombre) {

        DefaultTableModel model = (DefaultTableModel) jTableCatalogo.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);

        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
        filters.add(RowFilter.regexFilter(categoria, 3));
        filters.add(RowFilter.regexFilter("(?i)" + nombre, 2));
        RowFilter<Object, Object> filtro2 = RowFilter.andFilter(filters);

        jTableCatalogo.setRowSorter(trs);
        trs.setRowFilter(filtro2);
    }

    //método para filtrar artículos según lo escrito en el jTextField (la tabla se actualiza en directo)
    private void filtrar(String query) {

        DefaultTableModel model = (DefaultTableModel) jTableCatalogo.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        jTableCatalogo.setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter("(?i)" + query, 2));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCatalogo = new javax.swing.JTable();
        jButtonVerProducto = new javax.swing.JButton();
        jButtonOrdenar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxOrdenar = new javax.swing.JComboBox<>();
        jButtonatras = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jTextFieldBuscarAv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMisProd = new javax.swing.JTable();
        jButtonVerMiProducto = new javax.swing.JButton();
        jButtonatras1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableReservados = new javax.swing.JTable();
        jButtonVerReservado = new javax.swing.JButton();
        jButtonatras2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableVendidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonatras3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.textHighlight);
        setResizable(false);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(java.awt.SystemColor.textHighlight);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTableCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Icono", "Título", "Categoría", "Condición", "Localización", "Estado", "Precio ( € )"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {

                switch(columnIndex) {
                    case 0: return String.class;
                    case 1: return ImageIcon.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return String.class;
                    case 5: return String.class;
                    case 6: return String.class;
                    case 7: return String.class;
                    default: return Object.class;
                }
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCatalogo.setRowHeight(50);
        jTableCatalogo.getTableHeader().setReorderingAllowed(false);
        jTableCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCatalogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCatalogo);

        jButtonVerProducto.setText("Ver producto");
        jButtonVerProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerProductoActionPerformed(evt);
            }
        });

        jButtonOrdenar.setText("Buscar");
        jButtonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar producto");

        jComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----Todo el catálogo-----", "Moda y accesorios ", "TV, audio y fotografía", "Móviles y telefonía", "Informática y electrónica ", "Consolas y videojuegos ", "Deporte y ocio", "Hogar y decoración", "Cine, libros y música" }));
        jComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenarActionPerformed(evt);
            }
        });

        jButtonatras.setText("Volver a menu");
        jButtonatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonatrasActionPerformed(evt);
            }
        });

        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarActionPerformed(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Busqueda avanzada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonatras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVerProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxOrdenar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOrdenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldBuscarAv)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldBuscarAv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButtonatras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("CATÁLOGO", jPanel1);

        jTableMisProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Icono", "Título", "Categoría", "Condición", "Localización", "Estado", "Precio ( € )"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0: return String.class;
                    case 1: return ImageIcon.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return String.class;
                    case 5: return String.class;
                    case 6: return String.class;
                    case 7: return Double.class;
                    default: return Object.class;
                }
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMisProd.setRowHeight(50);
        jTableMisProd.getTableHeader().setReorderingAllowed(false);
        jTableMisProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMisProdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMisProd);

        jButtonVerMiProducto.setText("Ver producto");
        jButtonVerMiProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerMiProductoActionPerformed(evt);
            }
        });

        jButtonatras1.setText("Volver a menu");
        jButtonatras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonatras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVerMiProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonatras1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonVerMiProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRODUCTOS DE "+Usuarios.clienteActual.getNombre().toUpperCase(), jPanel2);

        jTableReservados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Icono", "Título", "Categoría", "Condición", "Localización", "Estado de venta", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0: return String.class;
                    case 1: return ImageIcon.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return String.class;
                    case 5: return String.class;
                    case 6: return String.class;
                    case 7: return Double.class;
                    default: return Object.class;
                }
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableReservados.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableReservados);
        if (jTableReservados.getColumnModel().getColumnCount() > 0) {
            jTableReservados.getColumnModel().getColumn(0).setResizable(false);
            jTableReservados.getColumnModel().getColumn(1).setResizable(false);
            jTableReservados.getColumnModel().getColumn(2).setResizable(false);
            jTableReservados.getColumnModel().getColumn(3).setResizable(false);
            jTableReservados.getColumnModel().getColumn(4).setResizable(false);
            jTableReservados.getColumnModel().getColumn(5).setResizable(false);
            jTableReservados.getColumnModel().getColumn(6).setResizable(false);
            jTableReservados.getColumnModel().getColumn(7).setResizable(false);
        }

        jButtonVerReservado.setText("Ver producto");
        jButtonVerReservado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerReservadoActionPerformed(evt);
            }
        });

        jButtonatras2.setText("Volver a menu");
        jButtonatras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonatras2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVerReservado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonatras2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonVerReservado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonatras2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRODUCTOS RESERVADOS", jPanel3);

        jTableVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Icono", "Título", "Categoría", "Condición", "Localización", "Estado de venta", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0: return String.class;
                    case 1: return ImageIcon.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return String.class;
                    case 5: return String.class;
                    case 6: return String.class;
                    case 7: return Double.class;
                    default: return Object.class;
                }
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVendidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableVendidos);
        if (jTableVendidos.getColumnModel().getColumnCount() > 0) {
            jTableVendidos.getColumnModel().getColumn(0).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(1).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(2).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(3).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(4).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(5).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(6).setResizable(false);
            jTableVendidos.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton1.setText("Ver factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonatras3.setText("Volver a menu");
        jButtonatras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonatras3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonatras3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonatras3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRODUCTOS VENDIDOS/COMPRADOS", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonatrasActionPerformed

        VentanaPrincipal n = new VentanaPrincipal();
        n.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonatrasActionPerformed

    private void jButtonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarActionPerformed

        String categoria = jComboBoxOrdenar.getSelectedItem().toString();
        String nombre = jTextFieldBuscarAv.getText();
        if (jComboBoxOrdenar.getSelectedIndex() == 0) {
            categoria = "";
        }
        filtrarCategoria(categoria, nombre);


    }//GEN-LAST:event_jButtonOrdenarActionPerformed

    private void jButtonVerProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerProductoActionPerformed

        //Comprueba que algun item esté seleccionado y después copia la información del producto en otro Objeto de su mismo tipo.
        //Se usará para cargar dicha información en la ventana Articulo.
        int selected = jTableCatalogo.getSelectedRow();

        if (selected != -1) {
            String selectedID = (String) jTableCatalogo.getValueAt(jTableCatalogo.getSelectedRow(), 0);
            Tienda.productoseleccionado = Tienda.hashProdutos.get(selectedID);
            System.out.print("\n" + Tienda.productoseleccionado);
            Articulo a = new Articulo();
            a.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(rootPane, "No has seleccionado ningún artículo");

        }

    }//GEN-LAST:event_jButtonVerProductoActionPerformed

    private void jTableCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCatalogoMouseClicked

    }//GEN-LAST:event_jTableCatalogoMouseClicked

    private void jTableMisProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMisProdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMisProdMouseClicked

    private void jButtonVerMiProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerMiProductoActionPerformed

        int selected = jTableMisProd.getSelectedRow();
        System.out.print(selected);

        if (selected != -1) {
            String selectedID = (String) jTableMisProd.getValueAt(jTableMisProd.getSelectedRow(), 0);
            Tienda.productoseleccionado = Tienda.hashProdutos.get(selectedID);
            System.out.print("\n" + Tienda.productoseleccionado);
            Articulo a = new Articulo();
            a.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(rootPane, "No has seleccionado ningún artículo");

        }
    }//GEN-LAST:event_jButtonVerMiProductoActionPerformed

    private void jButtonatras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonatras1ActionPerformed
        VentanaPrincipal n = new VentanaPrincipal();
        n.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonatras1ActionPerformed

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed


    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void jComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrdenarActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
        String query = jTextFieldBuscar.getText();
        filtrar(query);

    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void jButtonVerReservadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerReservadoActionPerformed
        int selected = jTableReservados.getSelectedRow();
        System.out.print(selected);

        if (selected != -1) {
            String selectedID = (String) jTableReservados.getValueAt(jTableReservados.getSelectedRow(), 0);
            Tienda.productoseleccionado = Tienda.hashProdutos.get(selectedID);
            System.out.print("\n" + Tienda.productoseleccionado);
            Articulo a = new Articulo();
            a.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(rootPane, "No has seleccionado ningún artículo");

        }
    }//GEN-LAST:event_jButtonVerReservadoActionPerformed

    private void jButtonatras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonatras2ActionPerformed
        VentanaPrincipal n = new VentanaPrincipal();
        n.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonatras2ActionPerformed

    private void jButtonatras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonatras3ActionPerformed
        VentanaPrincipal n = new VentanaPrincipal();
        n.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonatras3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selected = jTableVendidos.getSelectedRow();

        if (selected != -1) {
            String selectedID = (String) jTableVendidos.getValueAt(jTableVendidos.getSelectedRow(), 0);
            FacturasMetodos.facturaseleccionada = FacturasMetodos.hashMapFacturas.get(selectedID);

            FacturasMetodos.generarFicheroFactura(FacturasMetodos.facturaseleccionada);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No has seleccionado ningún artículo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOrdenar;
    private javax.swing.JButton jButtonVerMiProducto;
    private javax.swing.JButton jButtonVerProducto;
    private javax.swing.JButton jButtonVerReservado;
    private javax.swing.JButton jButtonatras;
    private javax.swing.JButton jButtonatras1;
    private javax.swing.JButton jButtonatras2;
    private javax.swing.JButton jButtonatras3;
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCatalogo;
    private javax.swing.JTable jTableMisProd;
    private javax.swing.JTable jTableReservados;
    private javax.swing.JTable jTableVendidos;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldBuscarAv;
    // End of variables declaration//GEN-END:variables

}
