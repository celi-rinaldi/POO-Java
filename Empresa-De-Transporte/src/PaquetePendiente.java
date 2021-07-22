
public class PaquetePendiente {
private Paquete elPaquete; 
private Resultado motivo;
public PaquetePendiente( Paquete p, Resultado m)
{
	this.elPaquete = p; 
	this.motivo = m;
}
public Resultado getMotivo()
{
	return this.motivo;
}
public Paquete getPaquete()
{
	return this.elPaquete;
}
}
