package semana_06.clases;

public class Celular {
	private String numero,usuario;
	private int segundosConsumidos;
	private double precioPorSegundo;
	public Celular(String numero, String usuario, int segundosConsumidos, double precioPorSegundo) {
		this.numero = numero;
		this.usuario = usuario;
		this.segundosConsumidos = segundosConsumidos;
		this.precioPorSegundo = precioPorSegundo;
		
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getSegundosConsumidos() {
		return segundosConsumidos;
	}
	public void setSegundosConsumidos(int segundosConsumidos) {
		this.segundosConsumidos = segundosConsumidos;
	}
	public double getPrecioPorSegundo() {
		return precioPorSegundo;
	}
	public void setPrecioPorSegundo(double precioPorSegundo) {
		this.precioPorSegundo = precioPorSegundo;
	}
	public double calcularCostoConsumo() {
		return segundosConsumidos*precioPorSegundo;
	}
	public double calcularIgv() {
		return calcularCostoConsumo()*18/100;
	}
	public double calcularTotalPagar() {
		return calcularCostoConsumo()+calcularIgv();
	}
}
