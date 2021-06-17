/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;

/**
 *
 * @author adryh
 */
public class Producto implements Serializable {
    private String id;      //ID aleatoria que se convertirá en el identificador del producto
    private Cliente vendedor;       //El objeto SIEMPRE guardará el cliente creador del producto.
    private Cliente comprador;      //El producto guardará los datos del cliente que desea comprarlo. Iniciado a null.
    private String compradorMensaje;    //El comprador podrá escribir un mensaje para el vendedor en el momento de la compra ( en el estado de reserva).
    private String titulo;
    private String descripcion;
    private String categoria; //
    private String condicion; //nuevo; poco usado; muy usado; estropeado.
    private int estado; //0 = en venta; 1= Reservado/en proceso de venta/solicitado; 2 = vendido
    private double precio;
    private String fecha;   //fecha de la publicacion del producto. será un date convertido a String. No será necesario tocarlo una vez creado.
    private String ubicacionCiudad; 
    private String ubicacionCP; // Ciudad y CP desde la que se crea el producto.
    boolean Urgente;


    public Producto(String id, Cliente vendedor, Cliente comprador, String compradorMensaje, String titulo, String descripcion, String categoria, String condicion, int estado, double precio, String fecha, String ubicacionCiudad, String ubicacionCP, boolean Urgente) {
        this.id = id;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.compradorMensaje = compradorMensaje;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.condicion = condicion;
        this.estado = estado;
        this.precio = precio;
        this.fecha = fecha;
        this.ubicacionCiudad = ubicacionCiudad;
        this.ubicacionCP = ubicacionCP;
        this.Urgente = Urgente;
    }

    public boolean isUrgente() {
        return Urgente;
    }

    public void setUrgente(boolean Urgente) {
        this.Urgente = Urgente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public String getCompradorMensaje() {
        return compradorMensaje;
    }

    public void setCompradorMensaje(String compradorMensaje) {
        this.compradorMensaje = compradorMensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacionCiudad() {
        return ubicacionCiudad;
    }

    public void setUbicacionCiudad(String ubicacionCiudad) {
        this.ubicacionCiudad = ubicacionCiudad;
    }

    public String getUbicacionCP() {
        return ubicacionCP;
    }

    public void setUbicacionCP(String ubicacionCP) {
        this.ubicacionCP = ubicacionCP;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", vendedor=" + vendedor.getNombre() + ", comprador=" + comprador + ", compradorMensaje=" + compradorMensaje + ", titulo=" + titulo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", condicion=" + condicion + ", estado=" + estado + ", precio=" + precio + ", fecha=" + fecha + ", ubicacionCiudad=" + ubicacionCiudad + ", ubicacionCP=" + ubicacionCP + '}';
    }

    /**
     *
     * @param id
     * @param vendedor
     * @param comprador
     * @param compradorMensaje
     * @param titulo
     * @param descripcion
     * @param categoria
     * @param condicion
     * @param estado
     * @param precio
     * @param fecha
     * @param ubicacion
     */
 
      
 
    
 

    

}
