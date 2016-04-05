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

	public void modificarLibro(Libro libroAnt, Libro libroNuevo) {
		listaLibros.remove(libroAnt);
		boolean libroExiste = false;
		for (Libro li: listaLibros) {
			if (li.getNombreLibro().equals(libroNuevo.getNombreLibro())) {
				libroExiste = true;
				break;
			} else {
				libroExiste = false;
			}
		}
		if (libroExiste == false) {
			listaLibros.add(libroNuevo);
			System.out.println("Libro modificado con éxito");
		}else {
			System.out.println("Ya existe un libro con ese nombre");
			listaLibros.add(libroAnt);
		}
	}
	
	public void eliminarLibro(Libro libro) {
		listaLibros.remove(libro);
		System.out.println("Libro " + libro.getNombreLibro() + " eliminado exitosamente!");
	}
	
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
}