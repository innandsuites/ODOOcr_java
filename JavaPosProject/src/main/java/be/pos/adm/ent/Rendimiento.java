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
public class Rendimiento {

    int id;
    int anyo;
    double ingreso;
    double venta;
    double impuesto;

     public Rendimiento() {

        this.id = 0;
        this.ingreso = 0.0;
        this.venta = 0.0;
        this.impuesto = 0.0;
    }
     
    public Rendimiento(int id, int anyo, double ingreso, double venta, double impuesto) {
        this.id = id;
        this.anyo = anyo;
        this.ingreso = ingreso;
        this.venta = venta;
        this.impuesto = impuesto;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

}
