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
public class Camioneta extends Vehiculo {
private final int capacidadCargaKgs;
private final int ejes;
private final int rodadas;
    public Camioneta(int nroSerieMotor, String marca, int anio, double precio,int capCargaKgs,int ejes,int rodadas) {
        super(nroSerieMotor, marca, anio, precio);
        this.capacidadCargaKgs=capCargaKgs;
        this.ejes=ejes;
        this.rodadas=rodadas;
    }
}
