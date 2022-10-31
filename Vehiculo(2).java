/*
 * 
 */
package main;


public class Vehiculo {
    
    //Declaracion e inicializacion de atributos
    
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    
    //Constructores
    public Vehiculo(){
        
        
    }
    
    public Vehiculo(int mo, String ma, double va){
        this(mo, ma, va, "verde");
        
        
    }
    
    public Vehiculo(int mo, String ma, double va, String co){
        
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        
    }
    
    //Metodos get y set
    
    public void setModelo(int m){
        this.modelo = m;
    }
    
    public int getModelo(){
        return this.modelo;
    }
    
    public void setMarca(String m){
        this.marca = m;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public void setValorComercial(double v){
        this.valorComercial = v;
    }
    
    public double getValorComercial(){
        return this.valorComercial;
    }
    
    public void setColor(String c){
        this.color = c;
    }
    
    public String getColor(){
        return this.color;
    }
    
    
    //Metodo que prepara y devuelve en un string toda la informacion del vehiculo 
    @Override
    public String toString(){
        
        String aux = "\n";
        aux = aux + "Modelo: " + this.getModelo() + "\n"
                  + "Marca: " + this.getMarca() + "\n"
                  + "Valor Comercial: $" + this.getValorComercial() + "\n"
                  + "Color: " + this.getColor() + "\n";
        
        return aux;
    }
    
    
}//Fin Vehiculo
