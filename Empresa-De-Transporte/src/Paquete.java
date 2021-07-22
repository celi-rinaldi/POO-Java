
public class Paquete {
private double peso; 
private double valorAsegurado; 
private Provincia provinciaDestino; 
public Paquete(double _peso, double _valorA, Provincia p)
{
	setPeso(_peso);
	setValorAsegurado(_valorA); 
	setProvinciaDestino(p); 
}
@Override
public String toString() {
	return "[peso=" + peso + ", valorAsegurado=" + valorAsegurado + ", provinciaDestino=" + provinciaDestino.toString()
			+ "]";
}
public double getPeso() {
	return peso;
}
private void setPeso(double peso) {
	this.peso = peso;
}
public double getValorAsegurado() {
	return valorAsegurado;
}
private void setValorAsegurado(double valorAsegurado) {
	this.valorAsegurado = valorAsegurado;
}
public Provincia getProvinciaDestino() {
	return provinciaDestino;
}
private void setProvinciaDestino(Provincia provinciaDestino) {
	this.provinciaDestino = provinciaDestino;
}
}
