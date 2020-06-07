/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author adryh
 */
public class Tester {

    public static void main(String[] args) {
        Usuarios.cargarClientes();
//        Tienda.cargarTienda();
//        Scanner sc = new Scanner(System.in);
        Cliente a = new Cliente( "03215677" , "Adrian", "adrian@gmail.com", "1234567890", "Guadalajara ", "19208","5647-3829-3234-2345",false,null,null,null,null);
        Cliente b = new Cliente( "12345678" , "Manuel", "manuel@gmail.com", "12345678", "Madrid", "21000", "1234-4565-6486-4463", true, "hola soy manuel", "11 a 12", "949 999 999", "www.google.com");
//          Producto p1 = new Producto("0", Usuarios.clientes.get(0) , "plancha", "plancha de planchar", "Hogar", "Nuevo", 0, 20, "20 de mayo", "Madrid", null);
//          Tienda.tienda.add(p1);
//          Tienda.guardarTienda();
//          System.out.println(Tienda.tienda);
        Usuarios.clientes.add(b);

        System.out.println(Usuarios.clientes);

        Usuarios.guardarClientes();

//      System.out.println("Introduce tu direccion de correo electronico");
//      String email = sc.nextLine();
//        System.out.println(a); 
//        System.out.println(b);
//        System.out.println(p1);
//        
//       if (manuel.isPremium() == true){
//            System.out.println("Este usuario es premium");  
//            System.out.println(manuel);  
//        }else{
//            System.out.println("Este usuario no es premium");
//        }
    }

}
