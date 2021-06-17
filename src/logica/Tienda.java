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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author adryh
 */
public class Tienda {

    public static ArrayList<Producto> tienda = new ArrayList<Producto>();

    public static Producto productoseleccionado;

    public static HashMap<String, Producto> hashProdutos = new HashMap<>();

    public static ArrayList<Producto> misproductos = new ArrayList<Producto>();

    //Método para crear un Hashmap a partir de los datos del ArrayList "tienda". Servirá para asociar cada artículo con su imagen
    public static void crearHashMapProductos() {
        for (int i = 0; i < tienda.size(); i++) {
            tienda.get(i);
            hashProdutos.put(tienda.get(i).getId(), tienda.get(i));

        }

    }

//Método para cargar todos los datos del fichero tienda.dat en un Arraylist que nos servirá para la creación del hashmap <ID,Producto>
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
    }

    //Método para guardar los datos del ArrayList tienda en el archivo de texto tienda.dat
    public static void guardarTienda() {
        try {

            //Serialización
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            FileOutputStream output = new FileOutputStream(s + "\\src\\database\\tienda.dat");
            ObjectOutputStream oos = new ObjectOutputStream(output);
            oos.writeObject(tienda);
            output.close();

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //método para calcular la fecha actual y convertirlo en String. Servirá para poner la fecha de creacion de items
    //y tambien para la creación de facturas.

    public static String fechaActual() {
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");//dd/MM/yyyy
        Date ahora = new Date();
        String stringFecha = sdfFecha.format(ahora);
        return stringFecha;
    }

    public static void volcarHashMapProductos() {

        Tienda.tienda.clear();
        System.out.println(Usuarios.clientes);
        Tienda.tienda.addAll(Tienda.hashProdutos.values());
    }

   

    public static void crearMisproductos() {

        Tienda.misproductos.clear();
        for (int i = 0; i < Tienda.tienda.size(); i++) {

            if (Tienda.tienda.get(i).getVendedor().getCorreo().equals(Usuarios.clienteActual.getCorreo())) {

                Tienda.misproductos.add(Tienda.tienda.get(i));

            }

        }

    }

    public static String alertasReservas() {

        int contador = 0;
        String mensaje = "Los siguientes artículos tienen una petción de compra:";
        for (int i = 0; i < Tienda.misproductos.size(); i++) {
            if (Tienda.misproductos.get(i).getEstado() == 1) {
                mensaje += "\n--" + Tienda.misproductos.get(i).getTitulo() + "--";
                contador += 1;
            }
        }
        mensaje += "\n\nPara ver los mensajes que los compradores han dejado en sus productos, debe dirigirse al CATÁLOGO."
                + "\nEn la pestaña PRODUCTOS RESERVADOS podrá ver aquellos productos que estén reservados."
                + "\nUna vez allí, seleccione el artículo reservado y presione el botón VER ARTÍCULO";
        if (contador == 0) {
            mensaje = "No tiene nuevas notificaciones de ventas";
        }
        return mensaje;

    }

    public static String alertasCompras() {

        int contador = 0;
        String mensaje = "El vendedor ha aceptado la petición de compra de los siguientes artículos:";
        for (int i = 0; i < Tienda.tienda.size(); i++) {
            if ((Tienda.tienda.get(i).getEstado() == 2) && (Tienda.tienda.get(i).getComprador().getCorreo().equals(Usuarios.clienteActual.getCorreo()))) {
                mensaje += "\n--" + Tienda.tienda.get(i).getTitulo() + "--"
                        + "\nMensaje de "+Tienda.tienda.get(i).getVendedor().getNombre()+":"
                        + "\n"+Tienda.tienda.get(i).getCompradorMensaje();
                Tienda.tienda.get(i).setEstado(3);
                contador += 1;
            }
        }
        Tienda.guardarTienda();
        mensaje += "\nPara ver los mensajes del vendedor, dirigase al CATALOGO y filtre por ARTICULOS RESERVADOS."
                + "\nUna vez allí, seleccione el artículo reservado y presione el botón VER ARTÍCULO para ver el mensaje";
        if (contador == 0) {
            mensaje = "";
        }
        return mensaje;

    }

    public static int calcularDistancia(Producto p) {

        int a = Integer.parseInt(p.getVendedor().getCodigo_postal());
        int b = Integer.parseInt(Usuarios.clienteActual.getCodigo_postal());

        int c = Math.abs(a - b);

        return c;
    } 

 
  public static void ordenarBurbujaArray(ArrayList t) {
        boolean movimiento = true;
        int contRondas = 0;
        Producto aux;
        while (movimiento) {
            movimiento = false;
            for (int i = 1; i < t.size() - contRondas; i++) {
                if (Tienda.calcularDistancia((Producto) t.get(i)) < Tienda.calcularDistancia((Producto) t.get(i - 1))) {
                    movimiento = true;
                    aux = (Producto) t.get(i);
		//Intercambiamos los valores en sendas posiciones
                    t.set(i,t.get(i-1));
                    t.set(i-1, aux);
                }
            }
        }
    }


}
    


