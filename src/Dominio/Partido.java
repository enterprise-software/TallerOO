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
public class Partido {
    private boolean _jugado;
    private static final short MAXARR=2;
    private static final int MIN=0;
    private static final int MAX=7;
    private final Equipo[] _juego;
    public Partido(){
        _juego=new Equipo[MAXARR];
    }
    
    /**
     * @return the _jugado
     */
    public boolean isJugado() {
        return _jugado;
    }
    /**
     * @param _jugado the _jugado to set
     */
    public void setJugado(boolean _jugado) {
        this._jugado = _jugado;
    }
    public void crearEncuentro(Equipo equipo1, Equipo equipo2)
    {
        this._juego[0]=equipo1;
        this._juego[1]=equipo2;
    }
    public void jugarEncuentro(){
        this.getJuego()[0].setGol(generarGolesAleatorios());
        this.getJuego()[1].setGol(generarGolesAleatorios());
        this.asignarPuntos();
    }
    private void asignarPuntos(){
        if(this.getJuego()[0].getGol()==this.getJuego()[1].getGol()){
            this.getJuego()[0].setPuntos(1);
            this.getJuego()[1].setPuntos(1);
            this.getJuego()[0].setPartidosEmpatados(1);
            this.getJuego()[1].setPartidosEmpatados(1);
            
        }
        else if(this.getJuego()[0].getGol()>this.getJuego()[1].getGol()) {
            this.getJuego()[0].setPuntos(3);
            this.getJuego()[0].setPartidosGanados(1);
            this.getJuego()[1].setPartidosPerdidos(1);
        }
        else if(this.getJuego()[0].getGol()<this.getJuego()[1].getGol()){
            this.getJuego()[1].setPuntos(3);
            this.getJuego()[1].setPartidosGanados(1);            
            this.getJuego()[0].setPartidosPerdidos(1);
        }
    }
    private int generarGolesAleatorios(){
        return  MIN + (int)(Math.random() * (MAX - MIN));
    }
    /**
     * @return the _juego
     */
    public Equipo[] getJuego() {
        return _juego;
    }
    
}
