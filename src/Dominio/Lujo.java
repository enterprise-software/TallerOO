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
public class Lujo extends Vehiculo {
    private final int cantidadPasajeros;
    public Lujo(int nroSerieMotor, String marca, int anio, double precio,int cantidadPasajeros) {
        super(nroSerieMotor, marca, anio, precio);
        this.cantidadPasajeros=cantidadPasajeros;
    }
}
