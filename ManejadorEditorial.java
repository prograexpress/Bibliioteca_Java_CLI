package org.biblioteca.manejadores;

import java.util.ArrayList;
import org.biblioteca.bean.Editorial;

public class ManejadorEditorial {
	private static ManejadorEditorial manejadorEditorial;
	private ArrayList<Editorial> listaEditoriales = new ArrayList<>();
	
	private ManejadorEditorial() {
	
	}

	public static ManejadorEditorial getInstancia() {
		if (manejadorEditorial == null) {
			manejadorEditorial = new ManejadorEditorial();
		}
		return manejadorEditorial;
	}
	
	public void agregarEditorial(Editorial editorial) {
		this.listaEditoriales.add(editorial);
	}
	
	public ArrayList<Editorial> getListaEditoriales() {
		return listaEditoriales;
	}
	
}