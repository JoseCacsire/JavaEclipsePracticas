package semana_08.hijo;

import semana_08.padre.Persona;

//Clase Docente hereda de la clase Persona
public class Docente extends Persona {
	private int horas;
	private double tarifa;
	
	//Constructor
	public Docente(String nombre, String apellido, int edad, int horas, double tarifa) {
		super(nombre, apellido, edad);
		this.horas = horas;
		this.tarifa = tarifa;
	}

	//Getters y Setters 
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	//Método calcularSueldo 
	public double calcularSueldo() {
		return horas * tarifa;
	}

	//Método mostrarDatos que sobre escribe al método de la clase Persona
	@Override
	public String mostrarDatos() {
		String cadena = super.mostrarDatos();
		cadena += "\nHoras: " + horas;
		cadena += "\nTarifa: " + tarifa;
		cadena += "\nSueldo: " + calcularSueldo();
		return cadena;
	}

	@Override
	public String identificacion() {
		return "<<< DOCENTE >>>";
	}
}
