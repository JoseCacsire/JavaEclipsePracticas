package semana_05.clases;

public class Rectangulo {
	public double base, altura;
	
	public double calcularArea() {
		return base * altura;
	}
	
	public double calcularPerimetro() {
		return (base + altura) * 2;
	}
}
