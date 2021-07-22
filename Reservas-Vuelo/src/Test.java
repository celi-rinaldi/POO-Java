
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PARA CREAR UN VUELO, SE INGRESA POR PARAMETRO EL NUMERO DE VUELO Y LA CANTIDAD MAXIMA DE ASIENTOS QUE ESTE ADMITE. 
     Vuelo vuelo = new Vuelo("AA3313", 180);
     //PARA RESERVAR UN ASIENTO, SE INGRESA POR PARAMETRO DNI DEL PASAJERO, TELEFONO, CLASE DEL VUELO Y LETRA Y NUMERO DEL ASIENTO (1-6). 
    System.out.println( vuelo.reservarAsiento(11111111, 1234567890, Clase.PRIMERA, "A", 1));
    System.out.println( vuelo.reservarAsiento(22222222, 1234567891, Clase.TURISTA, "F", 6));
    System.out.println( vuelo.reservarAsiento(33333333, 1234567892, Clase.PRIMERA, "A", 2));
    System.out.println( vuelo.reservarAsiento(44444444, 1234567894, Clase.TURISTA, "F", 5));
    System.out.println( vuelo.reservarAsiento(55555555, 1234567895, Clase.PRIMERA, "A", 1));
    vuelo.mostrarMontoRecaudadoDeClase(Clase.PRIMERA); 
    vuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS); 
    vuelo.mostrarMontoRecaudadoDeClase(Clase.TURISTA); 
    
     
     
     
     
     
	}

}
