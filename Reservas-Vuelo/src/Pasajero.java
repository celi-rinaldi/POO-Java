
public class Pasajero {
@Override
	public String toString() {
		return "Pasajero [dni=" + dni + ", telefono=" + telefono + "]";
	}
private int dni; 
private int telefono;
public Pasajero(int _dni, int _telefono)
{
	setDni(_dni); 
	setTelefono(_telefono);
}
private void setTelefono(int _telefono) {
	this.telefono = _telefono;
	
}
private void setDni(int _dni) {
	this.dni = _dni;
	
}
public int getDni()
{
	return this.dni;
}
public boolean mismoDni(int dni)
{
	return this.dni == dni;
}
}
