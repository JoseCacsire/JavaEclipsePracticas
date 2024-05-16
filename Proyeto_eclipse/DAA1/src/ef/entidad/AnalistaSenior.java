package ef.entidad;

public class AnalistaSenior extends Analista {
	private int sueldoBasico;

	public AnalistaSenior(String nombre, String apellido, int dni, int telefono, int sueldoBasico) {
		super(nombre, apellido, dni, telefono);
		this.sueldoBasico = sueldoBasico;
	}

	public int getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(int sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	public double calcularDescuento(){
        return sueldoBasico * ( 10.5 / 100 );
    }
	public double calcularSueldoNeto(){
        return sueldoBasico - calcularDescuento();
    }
	@Override
    public String mostrarDatos() {
		String cadena = super.mostrarDatos();
		cadena += "\nSueldo Basico: "+sueldoBasico;
		cadena += "\nDescuento: "+calcularDescuento();
		cadena += "\nSueldo Neto: "+calcularSueldoNeto();
		return cadena;
    }
}
