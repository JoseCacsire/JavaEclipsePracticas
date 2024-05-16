package semana_07.clases;

public class Estudiante {
	//Atributos privados
		private int codigo;
		private String nombre;
		private int nota1, nota2;

		//Variables de clase
		private static int cantidad;
		private static double sumaPromedios;
		
		//Constante
		public static final String INSTITUCION;
		
		//Bloque de inicialización static
		static {
			cantidad=0;
			sumaPromedios=0;
			INSTITUCION = "IDAT";
		}

		//Primer constructor con 4 parámetros
		public Estudiante(int codigo, String nombre, int nota1, int nota2) {
			this.codigo = codigo;
			this.nombre = nombre;
			this.nota1 = nota1;
			this.nota2 = nota2;
			cantidad++;
			sumaPromedios += calcularPromedio();
		}

		//Segundo constructor (recibe 2 parámetros e invoca al 1er constructor)
		public Estudiante(int codigo, String nombre) {
			this(codigo, nombre, 0, 0);
		}

		//Tercer constructor (sin parámetros e invoca al 2do constructor)
		public Estudiante() {
			this(8888,"ninguno");
		}

		//Getters y setters para los atributos privados
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
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

		//Getters para variables de clase 
		public static int getCantidad() {
			return cantidad;
		}

		public static double getSumaPromedios() {
			return sumaPromedios;
		}
		
		//Método para calcular el promedio
		public double calcularPromedio() {
			return (nota1+nota2)/2.0;
		}
}
