package semana_09.clases;

public class PersonaAdulta {
	private String nombre;
	private int edad;

	public PersonaAdulta(String nombre, int edad) throws Exception{
		//con el trows indico q el constructor va a lanzar una excepción o error
		this.nombre = nombre;
		this.edad = edad;
		if (edad<18) {
			throw new Exception(nombre+" no es una persona adulta");
		}
	}
	public String mostrarDatos() {
		String cadena = "Nombre: "+nombre;
		cadena += "\nEdad: "+edad;
		return cadena;
	}
}
