/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pos.adm.ent;

/**
 *
 * @author daniel
 */
public class Producto {

    String id;
    String nombre;
    String detalle;
    double precio_compra;
    double ganancia;
    int cantidad;
    double iva;
    double precio;

    public Producto() {
        this.id = "";
        this.nombre = "";
        this.detalle = "";
        this.precio_compra = 0.0;
        this.ganancia = 0.0;
        this.cantidad = 0;
        this.iva = 0.0;
        this.precio = 0.0;
    }

    public Producto(String id, String nombre, String detalle, double precio_compra, double ganancia, int cantidad, double iva, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio_compra = precio_compra;
        this.ganancia = ganancia;
        this.cantidad = cantidad;
        this.iva = iva;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
