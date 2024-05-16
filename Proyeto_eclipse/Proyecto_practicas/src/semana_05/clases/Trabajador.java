package semana_05.clases;

public class Trabajador {
	public int codigo;
	public String nombre;
	public int horasTrabajadas;
	public double tarifaHoraria;
	
	public double calcularSueldoBruto() {
		return horasTrabajadas*tarifaHoraria;
	}
	
	public double calcularDsctoEsSalud() { 
		double sueldoBruto = calcularSueldoBruto();
		return sueldoBruto*9/100;
	}

	public double calcularDsctoAfp() { 
		double sueldoBruto = calcularSueldoBruto();
		return sueldoBruto*12.5/100;
	}
	
	public double calcularDsctoTotal() {
		double esSalud = calcularDsctoEsSalud();
		double afp = calcularDsctoAfp();
		return esSalud + afp;
	}
	
	public double calcularSueldoNeto() {
		double sueldoBruto = calcularSueldoBruto();
		double dsctoTotal = calcularDsctoTotal();
		return sueldoBruto - dsctoTotal;
	}

}
