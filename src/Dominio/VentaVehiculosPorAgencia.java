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
public class VentaVehiculosPorAgencia {
    private int codigoAgencia;
    private Vehiculo vehiculoVendido;
    private int cantidadVendida;
    /**
     * @return the codigoAgencia
     */
    public int getCodigoAgencia() {
        return codigoAgencia;
    }

    /**
     * @param codigoAgencia the codigoAgencia to set
     */
    public void setCodigoAgencia(int codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }
    /**
     * @return the cantidaVendida
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * @param cantidaVendida the cantidaVendida to set
     */
    public void setCantidadVendida(int cantidaVendida) {
        this.cantidadVendida = cantidaVendida;
    }

    /**
     * @return the vehiculoVendido
     */
    public Vehiculo getVehiculoVendido() {
        return vehiculoVendido;
    }

    /**
     * @param vehiculoVendido the vehiculoVendido to set
     */
    public void setVehiculoVendido(Vehiculo vehiculoVendido) {
        this.vehiculoVendido = vehiculoVendido;
    }
}
