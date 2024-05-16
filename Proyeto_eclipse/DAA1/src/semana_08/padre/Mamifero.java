package semana_08.padre;

public abstract class Mamifero {
	protected String nombre;

	public Mamifero(String nombre) {
		this.nombre = nombre;
	}
	
	public String mostrarMensaje() {
		return "Soy mamífero mi nombre es: " + nombre;
	}
	
	public abstract String hacerRuido();

}
