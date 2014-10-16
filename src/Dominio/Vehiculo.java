/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Jesus
 */
public class Vehiculo {
    private int nroSerieMotor;
    private String marca;
    private int anio;
    private double precio;
    public Vehiculo(int nroSerieMotor,String marca, int anio,double precio)
    {
        this.nroSerieMotor=nroSerieMotor;
        this.anio=anio;
        this.marca=marca;
        this.precio=precio;
    }

    /**
     * @return the nroSerieMotor
     */
    public int getNroSerieMotor() {
        return nroSerieMotor;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }
    
}
