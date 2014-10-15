/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontorneofutbolcolombiano;

import Dominio.Equipo;
import Dominio.Partido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Programador
 */
public class GestionTorneoFutbolColombiano {
private static final Scanner sc = new Scanner(System.in);
private static final int MAXEQUIPOS=18;
private static final int MAXPARTIDOS=9;
private static int opcion,tamEquipos,tamPartidos,codigoEquipo;

        private static final Partido partidos[]=new Partido[MAXPARTIDOS];
        private static final Equipo equipos[]=new Equipo[MAXEQUIPOS];
        private static String nombreEquipo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        do{
            opcion=MenuPrincipal();
            switch(opcion){
                case 1:
                    if(tamEquipos<MAXEQUIPOS){
                        System.out.println("Ingrese un codigo para el equipo : ");
                        codigoEquipo=sc.nextInt();
                        System.out.println("Ingrese un nombre para el equipo : ");
                        nombreEquipo=sc.next();
                        equipos[tamEquipos]=new Equipo(codigoEquipo,nombreEquipo);
                        tamEquipos++;
                    }
                    else{
                        System.out.println("Se permiten hasta 18 equipos para jugar en el torneo.");
                    }
                    break;
                case 2:
                    System.out.println("******************Listado de los equipos creados**************************");
                    System.out.println("--------------------------------------------------------------------------");
                    for (int i = 0; i < tamEquipos; i++) {
                        System.out.println("Codigo : "+equipos[i].getCodigo()+" Nombre : "+equipos[i].getNombre());
                    }
                    System.out.println("***************************************************************************");
                    break;
                case 3:
                    if(tamEquipos<=1){
                        System.out.println("¡¡¡¡No se han creado equipos o se ha creado un sólo equipo!!!!");
                    }
                    else{
                        if(tamPartidos<MAXPARTIDOS){
                            Partido nuevoPart=new Partido();
                            System.out.println("Ingrese el codigo del equipo que jugará en casa (Ojo!!! el equipo debe existir) : ");
                            int codEq1=sc.nextInt();
                            Equipo equipo1=getEquipoPorCodigo(codEq1);
                            System.out.println("Ingrese el codigo del equipo rival (Ojo!!! el equipo debe existir) : ");
                            int codEq2=sc.nextInt();
                            Equipo equipo2=getEquipoPorCodigo(codEq2);
                            if(equipo1!=null && equipo2!=null){
                                nuevoPart.crearEncuentro(equipo1, equipo2);
                                partidos[tamPartidos]= nuevoPart;
                            }
                            tamPartidos++;
                        }
                        System.out.println("**********************Partidos Pendientes****************************************");
                        for (int i = 0; i < tamPartidos; i++) {
                            Equipo[] partidoPendiente=  partidos[i].getJuego();
                            System.out.println(partidoPendiente[0].getNombre() +" ["+partidoPendiente[0].getGol()+"]" +" VS "+partidoPendiente[1].getNombre()+" ["+partidoPendiente[1].getGol()+"]");
                        }
                        System.out.println("**********************************************************************************");
                    }
                    break;
                case 4:
                    System.out.println("***************************EQUIPOS JUGANDO**********************************************");
                    for (Partido partido : partidos) {
                        if(partido instanceof Partido)
                            partido.jugarEncuentro();
                    }
                    for (Partido partido : partidos) {
                        if(partido instanceof Partido){
                            System.out.println("--------------------------Resultados--------------------------");
                            Equipo[] resultPartido= partido.getJuego();
                            System.out.println(resultPartido[0].getNombre() +" ["+resultPartido[0].getGol()+"]" +" VS "+resultPartido[1].getNombre()+" ["+resultPartido[1].getGol()+"]");
                            System.out.println("---------------------------------------------------------------");
                        }
                    }
                    System.out.println("***************************FINALIZADO EQUIPOS JUGANDO**********************************************");
                    break;
                case 5:
                    break;
            }
        }while(opcion!=6);          
    }
    private static Equipo getEquipoPorCodigo(int codigo){
        Equipo equipo=null;
        for (int i = 0; i < tamEquipos; i++) {
            if(equipos[i].getCodigo()==codigo)
                equipo=equipos[i];
        }
        return equipo;
    }
    public static int MenuPrincipal()
    {
        int op;
        System.out.println("1. Crear Equipos");
        System.out.println("2. Listar equipos creados");
        System.out.println("3. Crear partidos (Eq1 vs Eq2)");
        System.out.println("4. Iniciar juego de los partidos");
        System.out.println("5. --");
        System.out.println("6. Salir");
        System.out.println("**************************************************");
        System.out.println("Digite una opción");
        op=sc.nextInt();
        return op;
    }
}
