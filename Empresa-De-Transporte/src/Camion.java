import java.util.ArrayList;

public class Camion {
private String patente; 
private Provincia provinciaAsignada; 
private double pesoMax; 
private double pesoActual; 
 ArrayList<Paquete> paquetesEnCamion;
public Camion(String _patente, Provincia p, double pesoMax)
{
	setPatente(_patente); 
	setProvinciaAsignada(p); 
	setPesoMax(pesoMax);
	setPesoActual(0); 
	paquetesEnCamion = new ArrayList<>(); 
}
@Override
public String toString() {
	return "Camion [patente=" + patente + ", provinciaAsignada=" + provinciaAsignada + ", pesoMax=" + pesoMax + "]";
}
public String getPatente() {
	return patente;
}
private void setPatente(String patente) {
	this.patente = patente;
}
public Provincia getProvinciaAsignada() {
	return provinciaAsignada;
}
private void setProvinciaAsignada(Provincia provinciaAsignada) {
	this.provinciaAsignada = provinciaAsignada;
}
public double getPesoMax() {
	return pesoMax;
}
private void setPesoMax(double pesoMax) {
	this.pesoMax = pesoMax;
}
public double getPesoActual() {
	return pesoActual;
}
private void setPesoActual(double pesoActual) {
	this.pesoActual = pesoActual;
}
public boolean hayCapacidad(double _peso) {
    return (this.pesoActual + _peso) <= this.pesoMax;
}
public boolean coincidePesoYProv(double peso, Provincia p) {
	return hayCapacidad(peso) && this.provinciaAsignada.equals(p);
}
public void cargar(Paquete p) {
	this.paquetesEnCamion.add(p);
	this.pesoActual+= p.getPeso();
}
}
