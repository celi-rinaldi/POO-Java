import java.util.ArrayList;

public class Vuelo {
	private String numeroDeVuelo;
	private int cantAsientos;
	private ArrayList<Asiento> asientosReservados;
	private double montoTotalRecaudado;
	private final int MIN_NUMERO_ASIENTO, MAX_NUMERO_ASIENTO;

	public Vuelo(String _numVuelo, int _cantAsientos) {
		MIN_NUMERO_ASIENTO = 1;
		MAX_NUMERO_ASIENTO = 6;
		asientosReservados = new ArrayList<>();
		montoTotalRecaudado = 0;
		setCantAsientos(_cantAsientos);
		setNumeroVuelo(_numVuelo);
	}

	private void setCantAsientos(int _cantAsientos) {
		this.cantAsientos = _cantAsientos;
	}

	private void setNumeroVuelo(String _numero) {
		this.numeroDeVuelo = _numero;
	}

	private boolean pasajeroExistente(int dni) {
		boolean existe = false;
		int i = 0;
		while (i < this.asientosReservados.size() && !(asientosReservados.get(i).pasajeroYaExiste(dni))) {
			i++;
		}
		if (i < this.asientosReservados.size()) {
			existe = true;
		}
		return existe;
	}

	private Asiento buscarAsientoReservado(String _fila, int _asiento) {
		int i = 0;
		Asiento buscado = null;
		while (i < this.asientosReservados.size() && !(asientosReservados.get(i).mismaFilaYnum(_fila, _asiento))) {
			i++;
		}
		if (i < this.asientosReservados.size()) {
			buscado = this.asientosReservados.get(i);
		}
		return buscado;
	}

	private boolean verDistanciamiento(String _fila, int _numero) {
		boolean ok = false;
		if (buscarAsientoReservado(_fila, (_numero + 1)) == null || _numero == MAX_NUMERO_ASIENTO) {
			if (buscarAsientoReservado(_fila, (_numero - 1)) == null || _numero == MIN_NUMERO_ASIENTO) {
				ok = true;
			}
		}
		return ok;
	}

	public ResultadoReservaBoletos reservarAsiento(int dni, int telefono, Clase _clase, String fila, int _numero) {
		ResultadoReservaBoletos res = ResultadoReservaBoletos.RESERVA_CONFIRMADA;
		if (this.asientosReservados.size() < this.cantAsientos) {

			if (buscarAsientoReservado(fila, _numero) == null) {
				if (!pasajeroExistente(dni)) {
					if (verDistanciamiento(fila, _numero)) {
						Asiento a = new Asiento(dni, telefono, _clase, fila, _numero);
						this.asientosReservados.add(a);
						this.montoTotalRecaudado += a.getPrecio();

					} else {
						res = ResultadoReservaBoletos.ERROR_EL_ASIENTO_DE_AL_LADO_ESTA_OCUPADO;
					}
				} else {
					res = ResultadoReservaBoletos.ERROR_YA_TIENE_UN_PASAJE;
				}
			} else {
				res = ResultadoReservaBoletos.ERROR_YA_ESTA_VENDIDO;
			}
		} else {
			res = ResultadoReservaBoletos.ERROR_AVION_COMPLETO;
		}
		return res;
	}

	private double obtenerAcumuladoPorClase(Clase c) {
		double monto = 0;
		for (Asiento a : this.asientosReservados) {
			if (a.mismaClase(c)) {
				monto += a.getPrecio();
			}
		}
		return monto;
	}

	public void mostrarMontoRecaudadoDeClase(Clase c) {
		if (!(this.montoTotalRecaudado == 0)) {
			double monto = obtenerAcumuladoPorClase(c);
			if (monto != 0) {
				System.out
						.println("El monto asignado hasta el momento en la clase " + c.toString() + " es de $" + monto);
			} else {
				System.out.println("No hay asientos reservados para la clase " + c.toString());
			}
		} else {
			System.out.println("No hay asientos reservados en ninguna clase.");
		}
	}

	@Override
	public String toString() {
		return "Vuelo [numeroDeVuelo=" + numeroDeVuelo + ", cantAsientos=" + cantAsientos + ", asientosReservados="
				+ asientosReservados.size() + ", montoTotalRecaudado=" + montoTotalRecaudado + "]";
	}
}
