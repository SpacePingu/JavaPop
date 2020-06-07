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
public class Cliente implements Serializable {

    private String dni;
    private String nombre;
    private String correo;
    private String clave;
    private String ciudad;
    private String codigo_postal;
    private String tarjeta_credito;
    private boolean premium;
    private String descripcion;
    private String horario;
    private String telefono;
    private String web;

    public Cliente(String dni, String nombre, String correo, String clave, String ciudad, String codigo_postal, String tarjeta_credito, boolean premium, String descripcion, String horario, String telefono, String web) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.tarjeta_credito = tarjeta_credito;
        this.premium = premium;
        this.descripcion = descripcion;
        this.horario = horario;
        this.telefono = telefono;
        this.web = web;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTarjeta_credito() {
        return tarjeta_credito;
    }

    public void setTarjeta_credito(String tarjeta_credito) {
        this.tarjeta_credito = tarjeta_credito;
    }


    

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", ciudad=" + ciudad + ", codigo_postal=" + codigo_postal + ", tarjeta_credito=" + tarjeta_credito + ", premium=" + premium + ", descripcion=" + descripcion + ", horario=" + horario + ", telefono=" + telefono + ", web=" + web + '}';
    }

  

}
