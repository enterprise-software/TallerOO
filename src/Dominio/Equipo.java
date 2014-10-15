/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
/**
 *
 * @author Programador
 */
public class Equipo {
    private final int _codigo;
    private final String _nombre;
    private int _gol;
    private int _puntos;
    private int _partidosJugados;
    private int _partidosGanados;
    private int _partidosPerdidos;
    private int _partidosEmpatados;
    public Equipo(int codigo,String nombre){
        this._codigo=codigo;
        this._nombre=nombre;
    }
    /**
     * @return the _gol
     */
    public int getGol() {
        return _gol;
    }
    /**
     * @param _gol the _gol to set
     */
    public void setGol(int _gol) {
        this._gol = _gol;
    }

    /**
     * @return the _codigo
     */
    public int getCodigo() {
        return _codigo;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @return the _puntos
     */
    public int getPuntos() {
        return _puntos;
    }

    /**
     * @param _puntos the _puntos to set
     */
    public void setPuntos(int _puntos) {
        this._puntos += _puntos;
    }

    /**
     * @return the _partidosJugados
     */
    public int getPartidosJugados() {
        return _partidosJugados;
    }

    /**
     * @param _partidosJugados the _partidosJugados to set
     */
    public void setPartidosJugados(int _partidosJugados) {
        this._partidosJugados += _partidosJugados;
    }

    /**
     * @return the _partidosGanados
     */
    public int getPartidosGanados() {
        return _partidosGanados;
    }

    /**
     * @param _partidosGanados the _partidosGanados to set
     */
    public void setPartidosGanados(int _partidosGanados) {
        this._partidosGanados += _partidosGanados;
    }
    /**
     * @return the _partidosPerdidos
     */
    public int getPartidosPerdidos() {
        return _partidosPerdidos;
    }

    /**
     * @param _partidosPerdidos the _partidosPerdidos to set
     */
    public void setPartidosPerdidos(int _partidosPerdidos) {
        this._partidosPerdidos += _partidosPerdidos;
    }
    /**
     * @return the _partidosEmpatados
     */
    public int getPartidosEmpatados() {
        return _partidosEmpatados;
    }
    /**
     * @param _partidosEmpatados the _partidosEmpatados to set
     */
    public void setPartidosEmpatados(int _partidosEmpatados) {
        this._partidosEmpatados += _partidosEmpatados;
    }
}
