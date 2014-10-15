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
public class Inmueble {
    private int _codigo;
    private String _descripcion;
    private String _propietario;
    private TipoInmueble _tipoInm;
    private double _area;
    public int getCodigo(){
        return _codigo;
    }
    public void setCodigo(int codigo){
        _codigo=codigo;
    }
    public TipoInmueble getTipoInmueble(){
        return _tipoInm;
    }
    public void setTipoInmueble(TipoInmueble tipoInm){
        _tipoInm=tipoInm;
    }
    /**
     * @return the _propietario
     */
    public String getPropietario() {
        return _propietario;
    }
    /**
     * @param _propietario the _propietario to set
     */
    public void setPropietario(String _propietario) {
        this._propietario = _propietario;
    }
    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    /**
     * @return the _area
     */
    public double getArea() {
        return _area;
    }

    /**
     * @param _area the _area to set
     */
    public void setArea(double _area) {
        this._area = _area;
    }
}

