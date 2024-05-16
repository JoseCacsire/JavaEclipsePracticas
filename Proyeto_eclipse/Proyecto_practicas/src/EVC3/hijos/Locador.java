package EVC3.hijos;

import EVC3.clases.Trabajador;

public class Locador extends Trabajador{
	private int horasTrabajadas;
    private double tarifaHoraria;

    public Locador(String nombre, String apellido,int dni, int telefono,int horasTrabajadas, double tarifaHoraria) {
        super(dni, telefono, nombre, apellido);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHoraria = tarifaHoraria;
    }
    
    public double calcularSueldoBruto(){
        return horasTrabajadas * tarifaHoraria;
    }
    @Override
	public String mostrarDatos() {
		String cadena = super.mostrarDatos();
		cadena += "\nHoras: "+ horasTrabajadas;
		cadena += "\nTarifa: "+ tarifaHoraria;
		cadena += "\nSueldo: "+ calcularSueldoBruto();
		return cadena;
	}  
	public String identificacion() {
		return  "<<< LOCADOR >>>";
	}
}	
