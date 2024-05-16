package EVC3.clases;

public class Auto {
	//Implemente la clase Auto con los atributos privados: código, color, marca, modelo y precio;
	//un constructor que inicialice los atributos privados y los métodos de acceso público set/get.
	private int codigo;
	private int precio;
	private String color;
	private String marca;
	private String modelo;
	public Auto(int codigo, int precio, String color, String marca, String modelo) {
		this.codigo = codigo;
		this.precio = precio;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
