package org.biblioteca.manejadores;

import java.util.ArrayList;
import org.biblioteca.bean.Usuario;

public class ManejadorUsuario {
	private static ManejadorUsuario manejadorUsuario;
	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	
	private ManejadorUsuario() {
	
	}
	
	public static ManejadorUsuario getInstancia() {
		if (manejadorUsuario == null) {
			manejadorUsuario = new ManejadorUsuario();
		}
		return manejadorUsuario;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}
	
	public void modificarUsuario(Usuario oldUser, String nombreUsuario, String contraseniaUsuario) {
		Usuario usuario = new Usuario();
		boolean usuario_existe = false;
		for (Usuario userTemp: listaUsuarios) {
			if (userTemp.getNombreUsuario().equals(nombreUsuario)) {
				System.out.println("El nombre de usuario ingresado ya existe!");
				usuario_existe = true;
				break;
			} else {
				usuario_existe = false;
			}
		}
		if (usuario_existe == false) {
			usuario.setId(oldUser.getId());
				usuario.setNombreUsuario(nombreUsuario);
				usuario.setContrasenia(contraseniaUsuario);
				System.out.println("Usuario " + oldUser.getId() + " modificado exitosamente");
				listaUsuarios.remove(oldUser);
				listaUsuarios.add(usuario);
		}
	}	

	public void eliminarUsuario(Usuario usuario) {
		listaUsuarios.remove(usuario);
		System.out.println("Usuario " + usuario.getNombreUsuario() + " eliminado exitosamente!");
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

}