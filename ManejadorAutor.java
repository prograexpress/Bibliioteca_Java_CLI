package org.biblioteca.manejadores;

import java.util.ArrayList;
import org.biblioteca.bean.Autor;

public class ManejadorAutor {
	private static ManejadorAutor manejadorAutor;
	private ArrayList<Autor> listaAutores = new ArrayList<>();
	
	private ManejadorAutor() {
	
	}
	
	public static ManejadorAutor getInstancia() {
		if (manejadorAutor == null) {
			manejadorAutor = new ManejadorAutor();
		}
		return manejadorAutor;
	}
	
	public void agregarAutor(Autor autor) {
		this.listaAutores.add(autor);
	}
	
	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}
}