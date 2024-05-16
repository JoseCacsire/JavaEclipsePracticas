package EVC3.clases;

public class Estudiante {
	private String codigo;
	private String nombre;
	private int nota1;
	private int nota2;
	private int nota3;
	public Estudiante(String codigo, String nombre, int nota1, int nota2, int nota3) throws Exception {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		if (nota1 < 0 || nota1 > 20){
            throw new Exception ("NOTA 1 INGRESADA INCORRECTAMENTE");
        }
        
        else if(nota2 < 0 || nota2 > 20){
            throw new Exception ("NOTA 2 INGRESADA INCORRECTAMENTE");
        }
        
        else if (nota3 < 0 || nota3 > 20){
            throw new Exception ("NOTA 3 INGRESADA INCORRECTAMENTE");
        }
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public int getNota3() {
		return nota3;
	}
	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	public double calcularPromedio() {
		return (nota1+nota2+nota3)/3.0;
	}
	 public String mostrarDatos(){
	        String cadena = "Codigo: " + codigo;
	        cadena += "\nNombre: " + nombre;
	        cadena += "\nNota1: " + nota1;
	        cadena += "\nNota2: " + nota2;
	        cadena += "\nNota3: " + nota3;
	        cadena += "\nPromedio: " + calcularPromedio();
	        return cadena;
	    }
}
