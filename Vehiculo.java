/*
 * 
 */
package main;


public class Vehiculo {
    
    
    //Declaracion e inicializacion de atributos
    private final int TAMAÑO = 10;
    private Vehiculo[] vehiculos = new Vehiculo[this.TAMAÑO];
    private int posAñadir = 0;
    
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
    public int getTamaño(){
        return this.TAMAÑO;
    }
    
    public void setPosAñadir(int p){
        this.posAñadir = p;
    }
    
    public int getPosAñadir(){
        return this.posAñadir;
    }
    
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
    
    //Metodo que prepara y devuelve en un string toda la informacion de los vehiculos 
    @Override
    public String toString(){
        
        String aux = "";
        
        for(int i = 0; i<this.TAMAÑO; i++){
            aux = aux + "Vehiculo #" + (i+1) + "\n"
                      + "Modelo: " + this.vehiculos[i].getModelo() + "\n"
                      + "Marca: " + this.vehiculos[i].getMarca() + "\n"
                      + "Valor Comercial: $" + this.vehiculos[i].getValorComercial() + "\n"
                      + "Color: " + this.vehiculos[i].getColor() + "\n";
        }
        
        return aux;
    }
    
}//Fin Vehiculo
