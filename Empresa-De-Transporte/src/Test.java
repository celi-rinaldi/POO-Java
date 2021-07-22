
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Empresa e = new Empresa("La Mulita"); 
   e.setProvincia("Jujuy", "Yatay 240");
   e.setProvincia("Salta", "Yatay 240");
   e.setProvincia("Chaco", "Yatay 240");
   e.setProvincia("Cordoba", "Yatay 240");
   e.setProvincia("Formosa", "Yatay 240");
   e.agregarCamion("ABC123", "Chaco", 100);
   e.agregarCamion("YPJ", "Jujuy", 100);
   e.agregarCamion("PLO258", "Formosa", 100);
   e.agregarPaquete(2.5, 102.6, "Jujuy");
   e.agregarPaquete(52, 1000, "Chaco");
   e.agregarPaquete(32, 102.6, "Formosa");
   e.agregarPaquete(120, 102.6, "Formosa");
   e.agregarPaquete(120, 102.6, "Cordoba");
   e.agregarPaquete(120, 102.6, "Cordoba");
   e.cargarPaquetes();
   

	}

}
