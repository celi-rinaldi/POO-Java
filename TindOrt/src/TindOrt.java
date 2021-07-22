import java.util.ArrayList;

public class TindOrt {
	private ArrayList<Usuario> usuarios;
	private String nombre;

	public TindOrt(String _nombre) {
		setNombre(_nombre);
		usuarios = new ArrayList<>();
	}

	private void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	public void registrarUsuario(String _nombre, String _mail, Genero g, int _edad, Genero deseado, int minDeseado,
			int maxDeseado) {
		if (esNombreValido(_nombre)) {
			if (esMailValido(_mail)) {
				if (esNumeroValido(_edad) && esNumeroValido(minDeseado) && esNumeroValido(maxDeseado)) {
					Usuario u = new Usuario(_nombre, _mail, g, _edad, deseado, minDeseado, maxDeseado);
					this.usuarios.add(u);
					System.out.println("Usuario registrado con éxito.");
				} else {
					System.out.println("ERROR. Por favor ingrese numeros correctos.");
				}
			} else {
				System.out.println("El mail ya existe. Intente con otro.");
			}
		} else {
			System.out.println("El nombre ya existe. Intente con otro.");
		}
	}

	private boolean esMailValido(String _mail) {
		boolean ok = false;
		if (esCadenaValida(_mail) && buscarUsuarioPorMail(_mail) == null) {
			ok = true;
		}
		return ok;
	}

	private boolean esNumeroValido(int numero) {
		return numero > 0 && numero < 110;
	}

	private Usuario buscarUsuarioPorMail(String _mail) {
		int i = 0;
		Usuario buscado = null;
		while (i < this.usuarios.size() && !usuarios.get(i).mismoMail(_mail)) {
			i++;
		}
		if (i < this.usuarios.size()) {
			buscado = usuarios.get(i);
		}
		return buscado;
	}

	private boolean esCadenaValida(String laCadena) {
		return laCadena != null && !laCadena.isEmpty();
	}

	private boolean esNombreValido(String _nombre) {
		boolean ok = false;
		if (esCadenaValida(_nombre) && buscarUsuarioPorNombre(_nombre) == null) {
			ok = true;
		}
		return ok;
	}

	private Usuario buscarUsuarioPorNombre(String _nombre) {
		int i = 0;
		Usuario buscado = null;
		while (i < this.usuarios.size() && !usuarios.get(i).mismoNombre(_nombre)) {
			i++;
		}
		if (i < this.usuarios.size()) {
			buscado = usuarios.get(i);
		}
		return buscado;
	}

	private boolean coincideGenero(Usuario u1, Usuario u2) {
		return u2.getGenero().equals(u1.getGeneroDeseado());
	}

	private boolean coincideEdad(Usuario u1, Usuario u2) {
		return u2.getEdad() >= u1.getEdadMinDeseada() && u2.getEdad() <= u1.getEdadMaxDeseada();
	}

	private boolean verificarCoincidenciaParcial(Usuario u1, Usuario u2) {
		boolean ok = false;
		if (coincideGenero(u1, u2) && coincideEdad(u1, u2)) {
			ok = true;
		}
		return ok;
	}

	private boolean verificarCoincidenciaTotal(Usuario u1, Usuario u2) {
		boolean ok = false;
		if (verificarCoincidenciaParcial(u1, u2) && verificarCoincidenciaParcial(u2, u1)) {
			ok = true;
		}
		return ok;
	}

	public Usuario mostrarListado(String _email) {
		Usuario usuario = buscarUsuarioPorMail(_email);
		ArrayList<Usuario> usuariosCoinciden = new ArrayList<>();
		if (usuario != null) {
			for (Usuario u : usuarios) {
				if (verificarCoincidenciaTotal(usuario, u)) {
					usuariosCoinciden.add(u);
				}
			}
			if (usuariosCoinciden.size() > 0) {
				System.out.println("Listado de usuarios que coinciden con los gustos de " + usuario.getNombre() + ":");
				System.out.println(usuariosCoinciden.toString());
			} else {
				System.out.println("No se encontraron usuarios que coincidan con los gustos de " + usuario.getNombre());
			}
		} else

		{

			System.out.println("No se encontro el usuario.");
		}
        return usuario;
	}
}
