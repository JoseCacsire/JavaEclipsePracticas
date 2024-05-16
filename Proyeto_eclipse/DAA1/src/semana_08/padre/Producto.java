package semana_08.padre;

public class Producto {
	protected String codigo, detalle;

	public Producto(String codigo, String detalle) {
		this.codigo = codigo;
		this.detalle = detalle;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}
