import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Camion> camiones;
	private ArrayList<Paquete> paquetesACargar;
	private ArrayList<PaquetePendiente> paquetesPendientes;
	private ArrayList<Provincia> provincias;

	public Empresa(String _nombre) {
		setNombre(_nombre);
		camiones = new ArrayList<>();
		paquetesACargar = new ArrayList<>();
		paquetesPendientes = new ArrayList<>();
		provincias = new ArrayList<>();

	}

	public void agregarCamion(String _patente, String prov, double pesoMax) {
		Provincia p = buscarProvincia(prov);
		this.camiones.add(new Camion(_patente, p, pesoMax));
	}

	private void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	public void setProvincia(String nombreProvincia, String domicilio) {
		this.provincias.add(new Provincia(nombreProvincia, domicilio));
	}

	public boolean agregarPaquete(double _peso, double _valorAsegurado, String nombreProv) {
		Provincia laProvincia = buscarProvincia(nombreProv);
		boolean ok = false;
		if (laProvincia != null && esNumeroValido(_peso) && esNumeroValido(_valorAsegurado)) {
			this.paquetesACargar.add(new Paquete(_peso, _valorAsegurado, laProvincia));
			ok = true;
			System.out.println("Paquete agregado!");
		}
		return ok;
	}

	private boolean esNumeroValido(double _peso) {
		return _peso > 0;
	}

	private Provincia buscarProvincia(String _nombre) {
		int i = 0;
		Provincia laProvincia = null;
		while (i < this.provincias.size() && !provincias.get(i).mismoNombre(_nombre)) {
			i++;
		}
		if (i < this.provincias.size()) {
			laProvincia = provincias.get(i);
		}
		return laProvincia;
	}

	public void cargarPaquetes() {
		int i = 0;
		Paquete p = null;
		while (i < this.paquetesACargar.size()) {
			p = paquetesACargar.get(i);
			Camion elCamion = buscarCamion(p.getPeso(), p.getProvinciaDestino());
			if (elCamion != null) {
				elCamion.cargar(p);
				System.out.println("Paquete " + p.toString() + " cargado en el camion!");
			} else {
				this.paquetesPendientes.add(new PaquetePendiente(p, dameMotivo(p)));
				System.out.println("Paquete a " + p.getProvinciaDestino() + " agregado a los pendientes! Motivo: "
						+ dameMotivo(p));
			}
			this.paquetesACargar.remove(p);
		}
	}

	private Camion buscarCamion(double peso, Provincia p) {
		int i = 0;
		Camion elCamion = null;
		while (i < this.camiones.size() && !camiones.get(i).coincidePesoYProv(peso, p)) {
			i++;
		}
		if (i < this.camiones.size()) {
			elCamion = camiones.get(i);
		}
		return elCamion;
	}

	private Resultado dameMotivo(Paquete p) {
		Resultado elMotivo = Resultado.NO_HAY_CAMION_CON_LUGAR_DISPONIBLE;
		if (!buscarProvinciaEnCamiones(p.getProvinciaDestino())) {
			elMotivo = Resultado.NO_HAY_CAMION_ASIGNADO_A_ESA_PROVINCIA;
		}
		return elMotivo;
	}

	private boolean buscarProvinciaEnCamiones(Provincia provinciaDestino) {
		boolean ok = false;
		for (Camion c : camiones) {
			if (c.getProvinciaAsignada().equals(provinciaDestino)) {
				ok = true;
			}
		}
		return ok;
	}

	public void reincorporarPaquetes() {
		for (PaquetePendiente p : paquetesPendientes) {
			if (p.getMotivo() == Resultado.NO_HAY_CAMION_CON_LUGAR_DISPONIBLE) {
				this.paquetesACargar.add(p.getPaquete());
				this.paquetesPendientes.remove(p);
			}
		}
	}
}
