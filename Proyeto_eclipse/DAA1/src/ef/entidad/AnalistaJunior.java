package ef.entidad;

public class AnalistaJunior extends Analista {
	private int horas;
	private double tarifa;
	public AnalistaJunior(String nombre, String apellido, int dni, int telefono, int horas, double tarifa) {
		super(nombre, apellido, dni, telefono);
		this.horas = horas;
		this.tarifa = tarifa;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public double calcularSueldoBruto(){
        return horas * tarifa;
    }
	@Override
	public String mostrarDatos() {
		String cadena = super.mostrarDatos();
		cadena += "\nHoras: "+ horas;
		cadena += "\nTarifa: "+ tarifa;
		cadena += "\nSueldo: "+ calcularSueldoBruto();
		return cadena;
	}  
	
}
