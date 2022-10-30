/*
 * 
 */
package main;


public class Sensor {
    
    //Declaracion e inicializacion de atributos
    
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
    
    //Metodo que prepara y devuelve en un string toda la informacion del sensor 
    @Override
    public String toString(){
        
        
        String aux = "\n";
                
        aux = aux  + "Tipo: " + this.getTipo() + "\n"
                   + "Valor: " + this.getValor() + "\n";
        
        
        
        return aux;
    }
    
    
}//Fin Sensor
