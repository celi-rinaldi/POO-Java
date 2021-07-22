
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     TindOrt tinder = new TindOrt("TindOrt"); 
     tinder.registrarUsuario("Juan", "juan@mail.com", Genero.MASCULINO, 30, Genero.FEMENINO, 25, 35);
     tinder.registrarUsuario("Carlos", "carlos@mail.com", Genero.MASCULINO, 35, Genero.FEMENINO, 30, 50);
     tinder.registrarUsuario("Carlos", "carlos@mail.com", Genero.MASCULINO, 45, Genero.FEMENINO, 25, 35);
     tinder.registrarUsuario("Maria", "maria@mail.com", Genero.FEMENINO, 28, Genero.MASCULINO, 30, 40);
     tinder.registrarUsuario("Ana", "ana@mail.com", Genero.FEMENINO, 32, Genero.MASCULINO, 28, 42);
     tinder.registrarUsuario("Eva", "eva@mail.com", Genero.FEMENINO, 32, Genero.MASCULINO, 40, 50);
     tinder.mostrarListado("juan@mail.com");
     tinder.mostrarListado("carlos@mail.com");
	}

}
