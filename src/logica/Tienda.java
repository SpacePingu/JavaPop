/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author adryh
 */
public class Tienda {

    public static ArrayList<Producto> tienda = new ArrayList<Producto>();

    public static void cargarTienda() {
        try {
            //Lectura de los objetos
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            FileInputStream input = new FileInputStream(s + "\\src\\database\\tienda.dat");
            ObjectInputStream ois = new ObjectInputStream(input);
            tienda = (ArrayList<Producto>) ois.readObject();
            input.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin de carga

    public static void guardarTienda() {
        try {
            //Si hay datos los guardamos...
            if (!tienda.isEmpty()) {
                //Serialización
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                FileOutputStream output = new FileOutputStream(s + "\\src\\database\\tienda.dat");
                ObjectOutputStream oos = new ObjectOutputStream(output);
                oos.writeObject(tienda);
                output.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
}
