package EVC3.hijos;

import EVC3.clases.Trabajador;

public class Colaborador extends Trabajador{
	private int sueldoBasico;
    private double porcentajeDescuento;

    public Colaborador(String nombre, String apellido,int dni, int telefono,int sueldoBasico, double porcentajeDescuento) {
        super(dni, telefono, nombre, apellido);
        this.sueldoBasico = sueldoBasico;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    public double calcularDescuento(){
        return sueldoBasico * ( porcentajeDescuento / 100 );
    }
    
    public double calcularSueldoNeto(){
        return sueldoBasico - calcularDescuento();
    }
    @Override
    public String mostrarDatos() {
		String cadena = super.mostrarDatos();
		cadena += "\nTelefono: "+telefono;
		cadena += "\nSueldo Basico: "+sueldoBasico;
		cadena += "\nDescuento: "+calcularDescuento();
		cadena += "\nSueldo Neto: "+calcularSueldoNeto();
		return cadena;
    }
    public String identificacion() {
		return  "<<< COLABORADOR >>>";
	}
}
