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

	public void modificarAutor(Autor autorAnt,String nombreAutor) {
		Autor autor = new Autor();
		boolean existenciaAutor = false;
		for (Autor aaTemp: listaAutores) {
			if (aaTemp.getNombreAutor().equals(nombreAutor)) {
				System.out.println("Este autor ya existe");
				System.out.println("Imposible de modificar");
				System.out.println("");
				existenciaAutor = true;
				break;
			} else {
				existenciaAutor = false;
			}
		}
		if (existenciaAutor == false) {
			autor.setId(autorAnt.getId());
			autor.setNombreAutor(nombreAutor);
			System.out.println("Autor: " + autorAnt.getId() + " modificado exitosamente");
			listaAutores.remove(autorAnt);
			listaAutores.add(autor);
		}
	}
	
	public void eliminarAutor(Autor autor) {
		listaAutores.remove(autor);
		System.out.println("Autor " + autor.getNombreAutor() + " eliminado exitosamente!");
	}

	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}
}
