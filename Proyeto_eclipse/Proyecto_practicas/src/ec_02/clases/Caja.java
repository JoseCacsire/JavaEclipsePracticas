package ec_02.clases;

public class Caja {
	private double largo,ancho,alto,peso;

	public Caja(double largo, double ancho, double alto, double peso) {
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		this.peso = peso;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}	
	/*• Un método que retorne el volumen de la caja en centímetros cúbicos (largo *
		ancho * alto).
	  • Un método que retorne el peso volumétrico en kilogramos: (volumen en
		centímetros cúbicos / 5000).
	  • Un método que retorne el peso facturable que es el mayor peso entre el peso de
		balanza y el peso volumétrico.*/
	public double calcularVolumen() {
		return largo*ancho*alto;
	}
	public double calcularPesoVolum() {
		return calcularVolumen()/5000;
	}
	public double calcularPesoFactur() {
		if (peso>calcularPesoVolum()){
			return peso;
		}
		else {
			return calcularPesoVolum();
		}
	}	
}
