/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Dominio.Inmueble;

/**
 *
 * @author Jesus
 */
public class DataBaseInmuebles {
    public DataBaseInmuebles(int max) {
        this.inmuebles = new Inmueble[max];
    }
    private final Inmueble[] inmuebles;
    public Inmueble[] ObtenerInmueblesCreados(){
        return this.inmuebles;
    }
    public void CrearInmuebles(Dominio.Inmueble inmueble,int index){
        inmuebles[index]=inmueble;
    }
}

