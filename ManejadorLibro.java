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

	public void modificarLibro(Libro libroAnt,String nombreLibro) {
		Libro libro = new Libro();
		boolean existenciaLibro = false;
		for (Libro aaTemp: listaLibros) {
			if (aaTemp.getNombreLibro().equals(nombreLibro)) {
				System.out.println("Este libro ya existe");
				System.out.println("Imposible de modificar");
				System.out.println("");
				existenciaLibro = true;
				break;
			} else {
				existenciaLibro = false;
			}
		}
		if (existenciaLibro == false) {
			libro.setId(libroAnt.getId());
			libro.setNombreLibro(nombreLibro);
			System.out.println("Libro: " + libroAnt.getId() + " modificado exitosamente");
			listaLibros.remove(libroAnt);
			listaLibros.add(libro);
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