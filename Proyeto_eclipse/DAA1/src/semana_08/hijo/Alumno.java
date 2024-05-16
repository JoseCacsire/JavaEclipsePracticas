package semana_08.hijo;

import semana_08.padre.Persona;

//Clase Alumno que hereda de Persona
public class Alumno extends Persona {
	private int nota1, nota2, nota3;

	//Constructor
	public Alumno(String nombre, String apellido, int edad, int nota1, int nota2, int nota3) {
		super(nombre, apellido, edad);
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	//Getters y Setters
	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	
	//Método calcularPromedio
	public double calcularPromedio() {
		return (nota1 + nota2 + nota3)/3.0;
	}
	
	//Método mostrarDatos que sobre escribe al método de la clase Persona
	@Override
	public String mostrarDatos() {
		String cadena = super.mostrarDatos();
		cadena += "\nNota1: " + nota1;
		cadena += "\nNota2: " + nota2;
		cadena += "\nNota3: " + nota3;
		cadena += " \nPromedio: " + calcularPromedio();
		return cadena;
	}

	@Override
	public String identificacion() {
		return "<<< ALUMNO >>>";
	}
}
