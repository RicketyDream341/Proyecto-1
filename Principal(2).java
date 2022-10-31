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
                        inputOk = false;
                    }
                    else{
                        System.out.println("ERROR. YA NO SE PUEDE AÑADIR MAS VEHICULOS, SE HA LLEGADO AL LIMITE " + TAMAÑO_V);
                    }
                    break;
                    
                case "2":
                    System.out.println();
                    System.out.println(arrayToString(vehiculos, posAñadirV));
                    break;
                    
                case "3":
                    System.out.println();
                    System.out.println("Vehiculos registrados: " + cantidadVehiculos());
                    break;
                    
                case "4":
                    System.out.println();
                    //Se podria mejorar solicitando al usuario el color, asi valdria para cualquiera
                    System.out.println(vehiculosPorColor("verde"));
                    break;
                    
                case "5":
                    System.out.println();
                    //Se podria mejorar solicitando al usuario el rango de años, asi valdria para cualquiera.
                    System.out.println(vehiculosPorModelo(2000,2021));
                    break;
                    
                case "6":
                    //Se verifica si hay espacio en el array de sensores
                    if(hayEspacioS()){
                        Sensor aux = new Sensor();
                        //Se valida que el usuario no introduzca un caracter cuando se espera un valor numerico, se captura Exception y se repite la peticion de datos en caso de que no 
                        //esten correctos
                        while(!inputOk){
                            try{
                                System.out.print("Indique el tipo: ");
                                aux.setTipo(input.nextLine());
                                System.out.print("Indique el valor: ");
                                aux.setValor(Double.parseDouble(input.nextLine()));
                                inputOk = true;
                            }
                            catch(NumberFormatException e){
                                System.out.println("ERROR. ALGUNO DE LOS VALORES INTRODUCIDOS NO ES CORRECTO");
                            }
                        }
                        //Si todo fue bien, se añade el vehiculo al array en la siguiente posicion libre y se incrementa la posicion
                        inputOk = false;
                        sensores[posAñadirS] = aux;
                        posAñadirS++;
                    }
                    else{
                        System.out.println("ERROR. YA NO SE PUEDE AÑADIR MAS SENSORES, SE HA LLEGADO AL LIMITE DE " + TAMAÑO_S);
                    }
                    break;
                    
                case "7":
                    System.out.println();
                    System.out.println(arrayToString(sensores,posAñadirS));
                    break;
                    
                case "8":
                    System.out.println();
                    System.out.println("Sensores registrados: " + cantidadSensores());
                    break;
                    
                case "9":
                    //Se podria mejorar solicitando al usuario el tipo de sensor
                    System.out.println("Sensores tipo temperatura: " + cantidadSensoresPorTipo("temperatura"));
                    System.out.println(arrayToString(sensoresPorTipo("temperatura"),cantidadSensoresPorTipo("temperatura")));
                    break;    
                    
                case "666":
                    //Se podria mejorar solicitando al usuario el tipo de sensor
                    System.out.println(arrayToString(ordenarSensores("temperatura"),cantidadSensoresPorTipo("temperatura")));
                    break;    
                    
                default:
                    System.out.println();
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
    
    //Igual que el anterior pero verificando posAñadirS segun el limite establecido para el array de sensores
    private static boolean hayEspacioS(){
        if(posAñadirS<TAMAÑO_S){
            return true;
        }
        return false;
    }
    
    //Devuelve la cantidad de vehiculos almacenados en el array que es equivalente a la posAñadirV.
    private static int cantidadVehiculos(){
        return posAñadirV;
    }
    
    //Metodo que recorre un array dado, concatena y devuelve toda la informacion de los elementos del mismo. Recibe como parametros el array y la cantidad de elementos que hay en el
    private static String arrayToString(Object[] array, int limite){
        String aux = "";
        for(int i = 0; i<limite; i++){
            aux = aux + array[i].toString();
        }
        return aux;
    }
    
    //Devuelve la cantidad de sensores almacenados en el array que es equivalente a la posAñadirS.
    private static int cantidadSensores(){
        return posAñadirS;
    }
    
    
    //Metodo que devuelve un string con la informacion de los vehiculos que coinciden con un color recibido como parametro
    private static String vehiculosPorColor(String c){
        String aux = "";
        for(int i = 0; i<cantidadVehiculos(); i++){
            if(vehiculos[i].getColor().equalsIgnoreCase(c)){
                aux = aux + vehiculos[i].toString();
            }
        }
        return aux;
    }
    
    //Metodo que devuelve un string con la informacion de los vehiculos cuyo modelo esta entre 2 años recibidos como parametro.
    private static String vehiculosPorModelo(int m1, int m2){
        String aux = "";
        for(int i=0; i<cantidadVehiculos();i++){
            if(vehiculos[i].getModelo()>=m1 && vehiculos[i].getModelo()<=m2){
                aux = aux + vehiculos[i].toString();
            }
        }
        return aux;
    }
    
    //Metodo que devuelve un array con los sensores que coinciden con un determinado tipo recibido como parametro
    private static Sensor[] sensoresPorTipo(String t){
        int tam = cantidadSensoresPorTipo(t);
        Sensor[] aux = new Sensor[tam];
        int j = 0;
        for(int i = 0; i<cantidadSensores(); i++){
            if(sensores[i].getTipo().equalsIgnoreCase(t)){
                aux[j] = sensores[i];
                j++;
            }
        }
        return aux;
    }
    
    //Metodo que devuelve cuantos sensores hay de un determinado tipo
    private static int cantidadSensoresPorTipo(String t){
        int aux = 0;
        for(int i = 0; i<cantidadSensores(); i++){
            if(sensores[i].getTipo().equalsIgnoreCase(t)){
                aux++;
            }
        }
        return aux;
    }
    
    //Ordenamiento de los sensores de un tipo recibido como parametro, por valor, de forma ascendente (metodo burbuja). Genera y devuelve un nuevo array.
    private static Sensor[] ordenarSensores(String t){
        int tam = cantidadSensoresPorTipo(t);
        Sensor[] array = new Sensor[tam];
        array = sensoresPorTipo(t);
        Sensor aux;
        for(int i = 0; i<tam; i++){
            for(int j = 0; j<tam-1; j++){
                    if(array[j].getValor()>array[j+1].getValor()){
                        aux = array[j];
                        array[j] = array[j+1];
                        array[j+1] = aux;
                    }
            }
        }
        return array;
    }
    
}//Fin de Principal
