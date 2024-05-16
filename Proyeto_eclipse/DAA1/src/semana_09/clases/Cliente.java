package semana_09.clases;

public class Cliente {
	private String nombre;
	private double saldo;
	
	public Cliente(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double monto) {
		saldo += monto;
	}
	
	public void retirar(double monto) throws Exception {
		if (monto>saldo) {
			throw new Exception("No se puede realizar el retiro, saldo insuficiente");
		}
		saldo -= monto;
	}
	
}
