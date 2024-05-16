package semana_08.padre;

public abstract class Poliedro {
	protected double largo, ancho;

	public Poliedro(double largo, double ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public String mostrarDimensiones() {
		String cadena = "Largo:" + largo;
		cadena += "\nAncho: " + ancho;
		return cadena;
	}
	
	public double calcularAreaBase() {
		return largo * ancho;
	}
	
	public abstract String mostrarTipo();
	
	public abstract double calcularVolumen();
	
}