
public class Provincia {
@Override
	public String toString() {
		return nombre;
	}
private String nombre; 
private String domicilioDeposito; 
public Provincia(String _nombre, String _domDeposito)
{
	this.nombre = _nombre; 
	this.domicilioDeposito = _domDeposito;
}
public boolean mismoNombre(String _nombre) {
	return this.nombre.equals(_nombre);
}

}
