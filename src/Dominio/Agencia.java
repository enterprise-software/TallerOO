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
public class Agencia {
    private final static int MAXAUTOMOVIL=10;
    private final int codigo;
    private final String nombre;
    private final Vehiculo[] vehiculos;
    private int indexvehiculo;
    public Agencia(int codigo, String nombre){
        vehiculos=new Vehiculo[MAXAUTOMOVIL];
        this.codigo=codigo;
        this.nombre=nombre;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the automoviles
     */
    public Vehiculo[] getAutomoviles() {
        return vehiculos;
    }
            
    public void setNuevoAutomovil(Vehiculo vehiculo,int index){
        if(this.indexvehiculo<MAXAUTOMOVIL){
            this.vehiculos[indexvehiculo]=vehiculo;
            this.indexvehiculo+=index;
        }
        else{
            System.out.println("Ha sobrepasado la cantidad maxima de vehiculos por agencia");
        }
    }
}
