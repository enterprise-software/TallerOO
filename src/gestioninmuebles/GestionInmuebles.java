/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninmuebles;

import Dominio.Inmueble;
import Dominio.TipoInmueble;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class GestionInmuebles {
static final Scanner sc = new Scanner(System.in);
static final int MAXINMUEBLES=2;
//static final DataBaseInmuebles nuevoDataBase=new DataBaseInmuebles(MAXINMUEBLES);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion, tipoInmueble, codigo,tam=0;
        String descripcion,propietario;
        double area;
        Inmueble[] inmuebles=new Inmueble[MAXINMUEBLES];
        do{
            opcion=MenuPrincipal();
            switch(opcion){
                case 1:
                    if(tam<MAXINMUEBLES){
                        System.out.println("Codigo para identificar el inmueble:");
                        codigo=sc.nextInt();
                        System.out.println("Descripcion del inmueble:");
                        descripcion=sc.next();
                        System.out.println("Propietario del apartamento (Si aun no tiene propietario ingres NA):");
                        propietario=sc.next();
                        System.out.println("Tipo del inmueble: 1=> APARTAMENTO. 2 => PARQUEADERO. 3 => CUARTO UTIL");
                        tipoInmueble=sc.nextInt();
                        System.out.println("Area del inmueble:");
                        area=sc.nextDouble();
                        //Creando el nuevo inmueble para la DataBase
                        Inmueble nuevoInmueble=new Inmueble();
                        nuevoInmueble.setCodigo(codigo);
                        nuevoInmueble.setDescripcion(descripcion);
                        nuevoInmueble.setPropietario(propietario);
                        nuevoInmueble.setArea(area);
                        switch(tipoInmueble){
                            case 1:
                                nuevoInmueble.setTipoInmueble(TipoInmueble.APARTAMENTO);
                                break;
                            case 2:
                                nuevoInmueble.setTipoInmueble(TipoInmueble.PARQUEADERO);
                                break;
                            default:
                                nuevoInmueble.setTipoInmueble(TipoInmueble.CUARTOUTIL);
                        }
                        inmuebles[tam]=nuevoInmueble;
                        //nuevoDataBase.CrearInmuebles(nuevoInmueble,tam);
                        tam++;
                    }
                    else{
                        System.out.println("No se puede crear nuevos inmuebles. Maximo => "+MAXINMUEBLES);
                    }
                    break;
                case 2:
                    for (int i = 0; i < tam; i++) {
                        System.out.println("Codigo : "+inmuebles[i].getCodigo()+" Descripcion : "+inmuebles[i].getDescripcion()+" Propietario : "+inmuebles[i].getPropietario()+" Tipo Inmueble : "+inmuebles[i].getTipoInmueble()+" Area : "+inmuebles[i].getArea());
                    }
                    //System.out.println("Inmuebles creados => "+nuevoDataBase.ObtenerInmueblesCreados().size());
                    break;
                case 3:
                    int inmConPropietarios=0;
                    for (int i = 0; i < tam; i++) {
                        if(!"NA".equals(inmuebles[i].getPropietario())){
                            inmConPropietarios++;
                            System.out.println("Codigo : "+inmuebles[i].getCodigo()+" Descripcion : "+inmuebles[i].getDescripcion()+" Propietario : "+inmuebles[i].getPropietario()+" Tipo Inmueble : "+inmuebles[i].getTipoInmueble()+" Area : "+inmuebles[i].getArea());
                        }
                    }
                    System.out.println("Cantidad de inmuebles con propietarios => "+inmConPropietarios);
                    break;
                case 4:
                    int NroTipoApart=0,NroTipoParq=0,NroTipoCuartUt=0;
                    for (int i = 0; i < tam; i++) {
                        if(inmuebles[i].getTipoInmueble()==TipoInmueble.APARTAMENTO)
                            NroTipoApart++;
                        else if(inmuebles[i].getTipoInmueble()==TipoInmueble.PARQUEADERO)
                            NroTipoCuartUt++;
                        else
                            NroTipoParq++;
                    }
                    System.out.println("Nro de Inmuebles del tipo APARTAMENTO : "+NroTipoApart);
                    System.out.println("Nro de Inmuebles del tipo PARQUEADERO : "+NroTipoParq);                    
                    System.out.println("Nro de Inmuebles del tipo CUARTO UTIL : "+NroTipoCuartUt);                    
                    break;
                case 5:
                    double sumaTodosInmEdificio=0.0;
                    for (int i = 0; i < tam; i++) {
                        sumaTodosInmEdificio+=inmuebles[i].getArea();
                    }
                    for (int i = 0; i < tam; i++) {
                        System.out.println(" INDICE DE COPROPIEDAD => "+inmuebles[i].getArea()/sumaTodosInmEdificio+" del inmueble : "+inmuebles[i].getCodigo()+"-"+inmuebles[i].getDescripcion());
                    }
                    break;
            }
        }while(opcion!=6);        
    }
    
    public static int MenuPrincipal()
    {
        int op;
        System.out.println("1. Crear inmuebles");
        System.out.println("2. Listar inmuebles creados");
        System.out.println("3. Mostrar inmuebles con propietarios");
        System.out.println("4. Cantidad de inmuebles por tipo");
        System.out.println("5. Mostrar indice de copropiedad por inmuebles");
        System.out.println("6. Salir");
        System.out.println("**************************************************");
        System.out.println("Digite una opción");
        op=sc.nextInt();
        return op;
    }
}
