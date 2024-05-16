package ec_02.clases;

public class Desarrollador {
    public int dni, horasTrabajadas;
    public String Nombre, Herramienta;
    public double tarifa;
    
    public double sueldoDesarrollador(){
        return horasTrabajadas * tarifa;
    }
    
    public double descuentoSeguroSocial(){
        return sueldoDesarrollador() * 0.1175;
    }
    
    public double descuentoFondos(){
        return sueldoDesarrollador() * 0.1025;
    }
    
    public double descuentoFinal(){
        return descuentoSeguroSocial() + descuentoFondos();
    }
    
    public double sueldoFinal(){
        return sueldoDesarrollador() - descuentoFinal();
    }
}
