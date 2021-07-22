
public class Asiento {
	private Pasajero pasajero;
	private Clase clase;
	private double precio;
	private String fila;
	private int numAsiento;
	private final int PRECIO_TURISTA, PRECIO_BUSINESS, PRECIO_PRIMERA;

	public Asiento(int _dni, int _telefono, Clase c, String _fila, int _numero) {
		PRECIO_TURISTA = 50000;
		PRECIO_BUSINESS = 100000;
		PRECIO_PRIMERA = 150000;
		setPasajero(_dni, _telefono);
		setClase(c);
		setFila(_fila);
		setNumero(_numero);
		setPrecioSegunClase(c);
	}

	public boolean mismaClase(Clase c) {
		return this.clase.equals(c);
	}

	public double getPrecio() {
		return this.precio;
	}

	@Override
	public String toString() {
		return "Asiento [pasajero=" + pasajero.toString() + ", clase=" + clase.toString() + ", precio=" + precio
				+ ", fila=" + fila + ", numAsiento=" + numAsiento + "]";
	}

	private void setPasajero(int _dni, int _telefono) {
		if (_dni > 0 && _telefono > 0) {
			this.pasajero = new Pasajero(_dni, _telefono);
		}
	}

	private void setNumero(int _numero) {
		this.numAsiento = _numero;

	}

	private void setFila(String _fila) {
		this.fila = _fila;

	}

	private void setClase(Clase c) {
		this.clase = c;

	}

	public boolean mismaFilaYnum(String _fila, int _asiento) {
		return this.fila.equals(_fila) && (this.numAsiento == _asiento);
	}

	public boolean pasajeroYaExiste(int dni) {
		return this.pasajero.getDni() == dni;
	}

	private void setPrecioSegunClase(Clase c) {
		if (c == Clase.TURISTA) {
			this.precio = PRECIO_TURISTA;
		} else if (c == Clase.BUSINESS) {
			this.precio = PRECIO_BUSINESS;
		} else {
			this.precio = PRECIO_PRIMERA;
		}
	}
}
