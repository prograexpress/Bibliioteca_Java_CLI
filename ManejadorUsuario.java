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
	
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
}