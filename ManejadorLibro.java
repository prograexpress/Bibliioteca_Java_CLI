package org.biblioteca.manejadores;

import java.util.ArrayList;
import org.biblioteca.bean.Libro;

public class ManejadorLibro {
	private static ManejadorLibro manejadorLibro;
	private ArrayList<Libro> listaLibros = new ArrayList<>();
	
	private ManejadorLibro() {
	
	}
	public static ManejadorLibro getInstancia() {
		if (manejadorLibro == null) {
			manejadorLibro = new ManejadorLibro();
		}
		return manejadorLibro;
	}
	
	public void agregarLibro(Libro libro) {
		this.listaLibros.add(libro);
	}
	
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
}