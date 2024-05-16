package semana_09.clases;

public class Operaciones {
	private int numero1,numero2;

	public Operaciones(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	public int suma() {
		return numero1+numero2;
	}
	public int resta() {
		return numero1-numero2;
	}
	public int producto() {
		return numero1*numero2;
	}
	public Resultado division() {
		Resultado objRes = new Resultado();
		try {
			objRes.setValor(numero1/numero2);
			objRes.setMensaje("");
		}
		catch(ArithmeticException e) {
			objRes.setMensaje("No se puede dividir entre cero");
		}
		return objRes;
	}

}
