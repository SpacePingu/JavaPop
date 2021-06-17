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
import java.util.HashMap;

public class Usuarios {

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static HashMap<String, Cliente> hashClientes = new HashMap<>();
    public static Cliente clienteActual = null;

    
    //Método para crear un Hashmap a partir de los datos del ArrayList "clientes". Esto es necesario para el LogIn
    //ya que acelera el proceso de búsqueda del email+password con este tipo de lista.
    public static void crearHashMapClientes() {  
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i);
            hashClientes.put(clientes.get(i).getCorreo(), clientes.get(i));

        }

    }
    
    public static void volcarHashMapClientes(){
    
        Usuarios.clientes.clear();
        System.out.println(Usuarios.clientes);
        Usuarios.clientes.addAll(hashClientes.values());
    
    
    }   
    
    
    
//método para guardar en un ArrayList los datos de clientes guardados en el archivo database.users.dat 
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
//método para serializar y guardar los datos del  ArrayList "clientes"  en el archivo  database.users.dat 
    public static void guardarClientes() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        try {

            FileOutputStream output = new FileOutputStream(s + "\\src\\database\\users.dat");
            ObjectOutputStream oos = new ObjectOutputStream(output);
            oos.writeObject(clientes);
            output.close();

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
