package semana_08.padre;

public abstract class Persona {
	//Atributos protegidos de clase
	protected String nombre, apellido;
	protected int edad;
	
	//Constructor
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	//Getters y Setters
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//Método generarCorreo
	public String generarCorreo() {
		return nombre + "." + apellido + "@idat.edu.pe";
	}
	
	//Método mostrarDatos
	public String mostrarDatos() {
		String cadena = "Nombre: " + nombre;
		cadena += "\nApellido: " + apellido;
		cadena += "\nEdad: " + edad;
		cadena += "\nCorreo: " + generarCorreo();
		return cadena;
	}
	
	//Método abstracto
	public abstract String identificacion();
	

}

