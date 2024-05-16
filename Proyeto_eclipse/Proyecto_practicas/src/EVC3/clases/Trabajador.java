package EVC3.clases;

public class Trabajador {
	protected int dni;
	protected int telefono;
    protected String nombre;
    protected String apellido;
	public Trabajador(int dni, int telefono, String nombre, String apellido) {
		this.dni = dni;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String generarCodigo() {
		return dni + "-" + nombre + apellido;
	}
	public String mostrarDatos() {
		String cadena = "Nombre: "+nombre;
		cadena += "\nApellido: "+apellido;
		cadena += "\nDni: "+dni; 
		cadena += "\nNúmero: "+telefono; 
		cadena += "\nCorreo: "+generarCodigo();
		return cadena;
	}
	
}
