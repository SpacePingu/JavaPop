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
public class Factura extends Producto {

    private String fechaVenta;

    public Factura(String fechaVenta, String id, Producto p) {
        super(id, p.getVendedor(), p.getComprador(), p.getCompradorMensaje(), p.getTitulo(), p.getDescripcion(), p.getCategoria(),
                p.getCondicion(), p.getEstado(), p.getPrecio(), p.getFecha(), p.getUbicacionCiudad(), p.getUbicacionCP(), p.isUrgente());
        this.fechaVenta = fechaVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "--------------------------------\n"
                + "Factura\n"
                + "ID:\t" + getId()
                + "\n\n"
                + "Fecha:\t" + getFechaVenta()
                + "\n\n"
                + "Vendedor:\t" + getVendedor().getNombre()
                + "\n\n"
                + "Comprador:\t" + getComprador().getNombre()
                + "\n\n"
                + "\nProducto:\t\t"+getTitulo()
                + "\nCondición del producto:\t"+getCondicion()
                + "\t\t\nImporte:\t\t"+getPrecio() + " €"
                + "\n------------------------------------------"               
                + "\nLo mio pa mí (tasa de la página = 10%):  " + getPrecio() * 0.10 + " €"
                + "\n------------------------------------------"
                + "\nTotal:\t\t" + getPrecio()*1.10 + " €"
                + "\n------------------------------------------";
    }

   
}
