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

public class Usuarios {

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public static void cargarClientes() {
        try {
            //Lectura de los objetos
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            FileInputStream input = new FileInputStream(s + "\\src\\database\\users.dat");
            ObjectInputStream ois = new ObjectInputStream(input);
            clientes = (ArrayList<Cliente>) ois.readObject();
            input.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void guardarClientes() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        try {
            //Si hay datos los guardamos...
            if (!clientes.isEmpty()) {
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización
                //System.out.println(s + "\\src\\database\\users.dat");
                FileOutputStream output = new FileOutputStream(s + "\\src\\database\\users.dat");
                ObjectOutputStream oos = new ObjectOutputStream(output);
                oos.writeObject(clientes);
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
