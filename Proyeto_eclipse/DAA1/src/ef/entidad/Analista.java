package ef.entidad;

public class Analista {
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected int telefono;
	public Analista(String nombre, String apellido, int dni, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String mostrarDatos() {
		String cadena = "Nombre: "+nombre;
		cadena += "\nApellido: "+apellido;
		cadena += "\nDni: "+dni; 
		cadena += "\nTeléfono: "+telefono; 
		return cadena;
	}
}
