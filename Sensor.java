/*
 * 
 */
package main;


public class Sensor {
    
    //Declaracion e inicializacion de atributos
    private final int TAMAÑO = 8;
    private Sensor[] sensores = new Sensor[this.TAMAÑO];
    private int posAñadir = 0;
    
    private String tipo;
    private double valor;
    
    //Constructores
    public Sensor(){
        
    }
    
    public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
    }
    
    
    //Metodos get y set
    
    public void setTipo(String t){
        this.tipo = t;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setValor(double v){
        this.valor = v;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    //Metodo que prepara y devuelve en un string toda la informacion de los sensores 
    @Override
    public String toString(){
        
        String aux = "";
        
        for(int i = 0; i<this.TAMAÑO; i++){
            aux = aux + "Sensor #" + (i+1) + "\n"
                      + "Tipo: " + this.getTipo() + "\n"
                      + "Valor: " + this.getValor() + "\n";
        }
        
        return aux;
    }
    
    
   
    
    
}//Fin Sensor
