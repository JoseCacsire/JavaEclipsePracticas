package semana_05.clases;

public class Persona {
	public String nombre;
	public String apellido;
	public int edad;
	public double estatura;
	public double peso;
	
	public String obtenerEstado() {
		if (edad>=18) {
			return "Mayor de edad";
		}
		else {
			return "Menor de edad";
		}
	}
	
	public double calcularImc() {
		return peso/(estatura*estatura);
	}

}
