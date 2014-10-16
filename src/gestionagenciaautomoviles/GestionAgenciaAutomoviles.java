/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionagenciaautomoviles;
import Dominio.Agencia;
import Dominio.Compacto;
import Dominio.Vehiculo;
import Dominio.VentaVehiculosPorAgencia;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class GestionAgenciaAutomoviles {
    private static final int MAXAGENCIA=2;
    private static final int MAXVENTAVEHICULOS=20;

    private static final Scanner sc = new Scanner(System.in);
    private static final Agencia[] agencias=new Agencia[MAXAGENCIA];
    private static final VentaVehiculosPorAgencia[] ventasVehiculos=new VentaVehiculosPorAgencia[MAXVENTAVEHICULOS];
    private static int tamAgencia, tamVehiculo, tamVentaVehiculo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int opcion, codAgencia=0;
         String nombreAgencia;
        do{
            opcion=MenuPrincipal();
            switch(opcion){
                case 1:
                    if(tamAgencia<MAXAGENCIA){
                        System.out.println("**********************************CREACION DE AGENCIAS*************************************");
                        System.out.println("Código para identificar la agencia : ");
                        codAgencia=sc.nextInt();
                        System.out.println("Nombre de la agencia : ");
                        nombreAgencia=sc.next();
                        agencias[tamAgencia]=new Agencia(codAgencia,nombreAgencia);
                        tamAgencia++;
                        System.out.println("********************************************************************************************");
                    }
                    else{
                        System.out.println("No se pueden crear nuevas agencias");
                    }
                        
                    break;
                case 2:
                    System.out.println("*********************************AGENCIAS CREADAS************************************************");
                    mostrarAgencias();
                    System.out.println("*************************************************************************************************");
                    break;
                case 3:
                    System.out.println("******************************CREACION DE AUTOMOVILES POR AGENCIA*********************************");
                    mostrarAgencias();
                    System.out.println("Digito el codigo de la agencia para la creacion de los vehiculos");
                    int codAgen=sc.nextInt();
                    Agencia agencia=traerAgenciaPorCodigo(codAgen);
                    int totalMaxVeh=agencia.getAutomoviles().length;
                    System.out.println("Numero de autos maximos por agencia : "+totalMaxVeh);
                    if(tamVehiculo<totalMaxVeh){
                        System.out.println("-------------Elija el tipo de vehiculo que desea crear-----");
                        System.out.println("1=>Compacto || 2=>Lujo || 3=>Camioneta || 4=>Vagoneta");
                        int tipoVehiculo=sc.nextInt();
                        //////////////PROPIEDADES COMUNES (HEREDADAS DEL PADRE VEHICULO)
                        System.out.println("Ingrese Nro de serie del motor de vehiculo (es un entero) : ");
                        int nroSerieMotor=sc.nextInt();
                        System.out.println("Ingrese la marca del vehiculo : ");
                        String marca=sc.next();
                        System.out.println("Ingrese el modelo del vehiculo (años es un entero) : ");
                        int anio=sc.nextInt();
                        System.out.println("Ingrese el precio del vehiculo (es un double) : "); 
                        double precio=sc.nextDouble();
                        /////////////////////////////////////////////////////////////////////
                        crearVehiculo(tipoVehiculo, codAgen,nroSerieMotor,marca,anio,precio);
                        mostrarAgencias();
                        tamVehiculo++;
                    }
                    else{
                        System.out.println("SE permiten maximo : "+totalMaxVeh+" Vehiculos por agencia");
                    }
                    break;
                case 4:
                    mostrarAgencias();
                    System.out.println("Seleccione la agencia (por codigo) : ");
                    int agenCode=sc.nextInt();
                    simularVentas(codAgencia);
                    
                    
                    break;
            }
        }while(opcion!=9);   
    }
    private static void simularVentas(int codAgencia){
        System.out.println("Ingrese el codigo del vehiculo(Nro de serie del Vehiculo) : ");
        int nroSerie=sc.nextInt();
        System.out.println("Ingrese la cantidad que piensa comprar : ");
        int cantidadComprada=sc.nextInt();
        if(tamVentaVehiculo<MAXVENTAVEHICULOS){
            VentaVehiculosPorAgencia nuevaVenta=new VentaVehiculosPorAgencia();
            nuevaVenta.setCodigoAgencia(codAgencia);
            nuevaVenta.setVehiculoVendido(obtenerVehiculoVenta(nroSerie, codAgencia));
            nuevaVenta.setCantidadVendida(cantidadComprada);
            tamVentaVehiculo++;
        }
        else{
            System.out.println("Ha excedido la capacidad de venta de vehiculos por agencia ("+MAXVENTAVEHICULOS+")");
        }
    }
    
    private static Vehiculo obtenerVehiculoVenta(int nroSerie,int codAgencia){
        Agencia agencia=traerAgenciaPorCodigo(codAgencia);
        Vehiculo vehiculo=null;
        Vehiculo[] vehiculos=agencia.getAutomoviles();
        for (Vehiculo vehiculo1 : vehiculos) {
            if (vehiculo1.getNroSerieMotor() == nroSerie) {
                vehiculo = vehiculo1;
                break;
            }
        }
        return vehiculo;
    }
    /**
     * 
     * @param tipoVehiculo
     * @param codAgencia
     * @param index
     * @param serieMotor
     * @param marca
     * @param anio
     * @param precio 
     */
    private static void crearVehiculo(int tipoVehiculo,int codAgencia,int serieMotor,String marca,int anio,double precio){
        System.out.println("Ingrese la cantidad de pasajeros (entero) : ");
        int cantPasajeros=sc.nextInt();

        switch (tipoVehiculo) {
            case 1:
                for (int i = 0; i < tamAgencia; i++) {
                    if(agencias[i].getCodigo()==codAgencia){
                        agencias[i].setNuevoAutomovil(new Compacto(serieMotor,marca,anio,precio,cantPasajeros), 1);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < tamAgencia; i++) {
                    if(agencias[i].getCodigo()==codAgencia){
                        agencias[i].setNuevoAutomovil(new Dominio.Lujo(serieMotor,marca,anio,precio,cantPasajeros), 1);
                    }
                }
                break;
            case 3:
                System.out.println("Ingrese la capacidad de carga en Kgs (es un entero) : ");
                int capCargaKgs=sc.nextInt();
                System.out.println("Ingrese la cantidad de ejes (es un entero) : ");
                int ejes=sc.nextInt();
                System.out.println("Ingrese las rodadas (es un entero) : ");
                int rodadas=sc.nextInt();
                for (int i = 0; i < tamAgencia; i++) {
                    if(agencias[i].getCodigo()==codAgencia){
                        agencias[i].setNuevoAutomovil(new Dominio.Camioneta(serieMotor,marca,anio,precio,capCargaKgs,ejes,rodadas), 1);
                    }
                }  
                break;
            case 4:
                for (int i = 0; i < tamAgencia; i++) {
                    if(agencias[i].getCodigo()==codAgencia){
                        agencias[i].setNuevoAutomovil(new Dominio.Vagoneta(serieMotor,marca,anio,precio,cantPasajeros), 1);
                    }
                }
                break;                
            default:
                throw new AssertionError();
        }
    }
    private static void cantidadVehiculosVagonetasVendidas(){
        int totalvendido=0;
        System.out.println("*************************Vehiculos del tipo vagonetas vendidas en cada agencia******************************");
        for (Agencia agencia : agencias) {
            System.out.println("Agencia : "+agencia.getNombre());
             for (VentaVehiculosPorAgencia ventavehiculos : ventasVehiculos) {
                if(ventavehiculos.getCodigoAgencia()==agencia.getCodigo()){
                    if(ventavehiculos.getVehiculoVendido() instanceof Dominio.Vagoneta){
                    }
                        totalvendido+=ventavehiculos.getCantidadVendida();
                    }
            }
            System.out.println("Total vendidas : "+totalvendido);
            totalvendido=0;
        }
        System.out.println("************************************************************************************************************");
    }
    private static Agencia traerAgenciaPorCodigo(int codAgen){
        Agencia agenc=null;
        for (Agencia agencia : agencias) {
            if(agencia instanceof Agencia){
                if(agencia.getCodigo()==codAgen){
                    agenc=agencia;
                    break;
                }
            }
        }
        return agenc;
    }
    private static void mostrarAgencias(){
        System.out.println("----------------------Agencias Creadas----------------------------");
        for (Agencia ag : agencias) {
            if(ag instanceof Agencia){
                System.out.println("Codigo : "+ag.getCodigo()+" Nombre : "+ag.getNombre());
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }
    public static int MenuPrincipal()
    {
        int op;
        System.out.println("1. Crear agencias");
        System.out.println("2. Listar agencias");
        System.out.println("3. Crear automoviles por agencia");
        System.out.println("4. Simular la venta de vehiculos por agencia");
        
        System.out.println("5. Cantidad de vehiculos del tipo vagonetas que se ha vendido en cada una de las agencias");
        System.out.println("6. Ventas de vehiculos por agencia");
        System.out.println("7. El vehiculo que mas se ha vendido");
        System.out.println("8. El total recaudo por ventas");
        
        System.out.println("9. Salir");
        System.out.println("**************************************************");
        System.out.println("Digite una opción");
        op=sc.nextInt();
        return op;
    }
    
}
