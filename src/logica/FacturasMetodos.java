/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author adryh
 */
public class FacturasMetodos {
    
   public static ArrayList<Factura> facturas = new ArrayList<>();
   
   public static Factura facturaseleccionada;
   
   public static HashMap<String,Factura> hashMapFacturas = new HashMap<>();
    
   
    public static void cargarFacturas() {
        try {
            //Lectura de los objetos
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            FileInputStream input = new FileInputStream(s + "\\src\\database\\facturas.dat");
            ObjectInputStream ois = new ObjectInputStream(input);
            facturas = (ArrayList<Factura>) ois.readObject();
            input.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Método para guardar los datos del ArrayList tienda en el archivo de texto tienda.dat
    public static void guardarFacturas() {
        try {

            //Serialización
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            FileOutputStream output = new FileOutputStream(s + "\\src\\database\\facturas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(output);
            oos.writeObject(facturas);
            output.close();

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
      public static void crearHashMapFacturas() {
        for (int i = 0; i < facturas.size(); i++) {
            facturas.get(i);
            hashMapFacturas.put(facturas.get(i).getId(),facturas.get(i));

        }

    }
    
    
    
    public static void generarFicheroFactura(Factura f) {
        
        
        Object[] options = {"Guardar factura","Volver"};
        System.out.println(f);
        int input = JOptionPane.showOptionDialog(null, f.toString(), "Factura Producto" + f.getTitulo(), YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (input == 0) {
            JFileChooser guardarFactura = new JFileChooser();
            guardarFactura.setDialogTitle("Selecciona una ruta para guardar la factura:");

            int userSelection = guardarFactura.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                FileWriter factura = null;
                try {
                    File fileToSave = guardarFactura.getSelectedFile();
                    factura = new FileWriter(fileToSave.toString() + ".txt");
                    factura.write(f.toString());
                    factura.close();
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } finally {
                    try {
                        factura.close();
                    } catch (IOException ex) {
                        java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }
}
