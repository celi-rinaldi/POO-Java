
public class Usuario {
	private String nombre;
	private String mail;
	private Genero genero;
	private int edad;
	private Genero generoDeseado;
	private int edadMinDeseada;
	private int edadMaxDeseada;

	public Usuario(String _nombre, String _mail, Genero g, int _edad, Genero deseado, int minDeseado, int maxDeseado) {
		setNombre(_nombre);
		setMail(_mail);
		setGenero(g);
		setEdad(_edad);
		setGeneroDeseado(deseado);
		setEdadMinDeseada(minDeseado);
		setEdadMaxDeseada(maxDeseado);

	}
    public String getNombre()
    {
    	return this.nombre;
    }
	private void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	private void setMail(String _mail) {
		this.mail = _mail;
	}

	private void setGenero(Genero g) {
		this.genero = g;
	}

	private void setEdad(int _edad) {
		this.edad = _edad;
	}

	private void setGeneroDeseado(Genero g) {
		this.generoDeseado = g;
	}

	private void setEdadMinDeseada(int _edad) {
		this.edadMinDeseada = _edad;
	}

	private void setEdadMaxDeseada(int _edad) {
		this.edadMaxDeseada = _edad;
	}

	public boolean mismoNombre(String _nombre) {
		return this.nombre.equals(_nombre);
	}

	public boolean mismoMail(String _mail) {
		return this.mail.equals(_mail);
	}

	public Genero getGenero() {
		return this.genero;
	}

	public Genero getGeneroDeseado() {
		return this.generoDeseado;
	}

	public int getEdad() {
		return this.edad;
	}

	public int getEdadMinDeseada() {
		return this.edadMinDeseada;
	}

	public int getEdadMaxDeseada() {
		return this.edadMaxDeseada;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + "]";
	}
}
