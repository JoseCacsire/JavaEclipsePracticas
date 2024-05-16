package semana_05.clases;

public class Alumno {
	public int codigo, nota1, nota2;
	public String nombre;
	
	public double calcularPromedio() {
		return (nota1 + nota2)/2;
	}
	
	public String obtenerCondicion() {
		double promedio = calcularPromedio();
		if (promedio>=13) {
			return "Aprobado";
		}
		else {
			return "Desaprobado";
		}
	}

}
