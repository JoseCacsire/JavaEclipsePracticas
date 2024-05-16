package semana_05.clases;

public class Filmacion {
	public int codigo;
	public String titulo;
	public int minutos;
	public double precioSoles;
	
	public double calcularPrecioDolares() {
		return precioSoles/3.90;
	}
	
	
}
