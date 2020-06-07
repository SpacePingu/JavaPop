/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.swing.Icon;

/**
 *
 * @author adryh
 */
public class Producto implements Serializable {
    private String id;
    private Cliente vendedor;
    private Cliente comprador;
    private String compradorMensaje;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String condicion;
    private int estado;
    private double precio;
    private String fecha;
    private String ubicacion;
    private Icon imagen;

    public Producto(String id, Cliente vendedor,Cliente comprador,String compradorMensaje, String titulo, String descripcion, String categoria, String condicion, int estado, double precio, String fecha, String ubicacion, Icon imagen) {
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
        this.ubicacion = ubicacion;
        this.imagen = imagen;
    }

    public String getCompradorMensaje() {
        return compradorMensaje;
    }

    public void setCompradorMensaje(String compradorMensaje) {
        this.compradorMensaje = compradorMensaje;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }

 

    

}
