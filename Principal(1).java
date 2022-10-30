/*
 * 
 */
package main;

import java.util.Scanner;


public class Principal {
    
    //Declaracion e inicializacion de variables
    private static final int TAMAÑO_V = 10;
    private static final int TAMAÑO_S = 8;
    
    private static Vehiculo[] vehiculos = new Vehiculo[TAMAÑO_V];
    private static Sensor[] sensores = new Sensor[TAMAÑO_S];
    
    private static int posAñadirV = 0;
    private static int posAñadirS = 0;
    
    public static void main(String[] args) {
        
        mostrarMenu();
        
    }//Fin de main

    //Metodo que muestra en pantalla el menu de opciones y solicita al usuario que elija una, realizando las acciones correspondientes. El menu se muestra continuamente hasta que
    //el usuario seleccione la opcion de salir (0)
    private static void mostrarMenu(){
        Scanner input = new Scanner(System.in);
        String opcion;
        boolean seguir = true;
        boolean inputOk = false;
        
        while(seguir){
            System.out.println();
            System.out.println("-------------------------------");
            System.out.println("     SELECCIONE UNA OPCION     ");
            System.out.println("-------------------------------");
            System.out.println();
            System.out.println("0.- Salir");
            System.out.println("1.- Nuevo vehiculo");
            System.out.println("2.- Mostrar todos los vehiculos");
            System.out.println("3.- Cantidad de vehiculos registrados");
            System.out.println("4.- Mostrar vehiculos color 'verde'");
            System.out.println("5.- Mostrar vehiculos modelo 2000/2021");
            System.out.println("6.- Nuevo sensor");
            System.out.println("7.- Mostrar todos los sensores");
            System.out.println("8.- Cantidad de sensores registrados");
            System.out.println("9.- Mostrar sensores tipo 'temperatura'");
            System.out.println("666.- Mostrar sensores tipo 'temperatura' ordenados (ASC)");
            System.out.println();
            
            opcion = input.nextLine();
            switch(opcion){
                
                case "0":
                    System.out.println("EJECUCION FINALIZADA.");
                    seguir = false;
                    break;
                
                case "1":
                    //Se verifica si hay espacio disponible en el array de vehiculos
                    if(hayEspacioV()){
                        Vehiculo aux = new Vehiculo();
                        //Se valida que el usuario no introduzca un caracter cuando se espera un valor numerico, se captura Exception y se repite la peticion de datos en caso de que no 
                        //esten correctos
                        while(!inputOk){
                            try{
                                System.out.print("Indique el modelo: ");
                                aux.setModelo(Integer.parseInt(input.nextLine()));
                                System.out.print("Indique la marca: ");
                                aux.setMarca(input.nextLine());
                                System.out.print("Indique el valor comercial: $");
                                aux.setValorComercial(Double.parseDouble(input.nextLine()));
                                System.out.print("Indique el color: ");
                                aux.setColor(input.nextLine());
                                
                                inputOk = true;
                            }catch(NumberFormatException ex){
                                System.out.println("ERROR. ALGUNO DE LOS VALORES INTRODUCIDOS NO ES EL ESPERADO.");
                            }    
                        }
                        //Si todo fue bien, se añade el vehiculo al array en la siguiente posicion libre y se incrementa la posicion
                        vehiculos[posAñadirV] = aux;
                        posAñadirV++;
                    }
                    else{
                        System.out.println("ERROR. YA NO SE PUEDE AÑADIR MAS VEHICULOS, SE HA LLEGADO AL LIMITE DE 10");
                    }
                    break;
                    
                case "2":
                    vehiculosToString();
                    break;
                    
                case "3":
                    break;
                    
                case "4":
                    break;
                    
                case "5":
                    break;
                    
                case "6":
                    break;
                    
                case "7":
                    break;
                    
                case "8":
                    break;
                    
                case "9":
                    break;    
                    
                case "666":
                    break;    
                    
                default:
                    System.out.println("ERROR. OPCION NO VALIDA");
                    break;
            }
        }
    }
    
    //Metodo que verifica si la posAñadirV es menor al limite, es decir, si hay espacio para vehiculos. Devuelve true o false
    private static boolean hayEspacioV(){
        
        if(posAñadirV<TAMAÑO_V){
            return true;
        }
        return false;
    }
    
    //Devuelve la cantidad de vehiculos almacenados en el array que es equivalente a la posAñadirV.
    private static int cantidadVehiculos(){
        return posAñadirV;
    }
    
    //Metodo que recorre el array de vehiculos, concatena y devuelve en un String toda la informacion de los mismos.
    private static String vehiculosToString(){
        String aux = "";
        for(int i = 0; i<cantidadVehiculos(); i++){
            aux = aux + vehiculos[i].toString();
        }
        return aux;
    }
}//Fin de Principal
