package semana_05.clases;

public class Coordinador {
	public int codigo;
	public String nombre, categoria, celular;
	
	public double calcularSueldo() {
		double sueldo;
		switch(categoria) {
			case "Junior":
				sueldo=3500;
				break;
			case "Senior":
				sueldo=5500;
				break;
			default:
				sueldo=7500;
		}
		return sueldo;
	}
}
