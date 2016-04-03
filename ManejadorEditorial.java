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
	
	public void modificarEditorial(Editorial editorialAnt,String nombreEditorial) {
		Editorial editorial = new Editorial();
		boolean existenciaEditorial = false;
		for (Editorial edTemp: listaEditoriales) {
			if (edTemp.getNombreEditorial().equals(nombreEditorial)) {
				System.out.println("Esta editorial ya existe");
				System.out.println("Imposible de modificar");
				System.out.println("");
				existenciaEditorial = true;
				break;
			} else {
				existenciaEditorial = false;
			}
		}
		if (existenciaEditorial == false) {
			editorial.setId(editorialAnt.getId());
			editorial.setNombreEditorial(nombreEditorial);
			System.out.println("Editorial: " + editorialAnt.getId() + " modificado exitosamente");
			listaEditoriales.remove(editorialAnt);
			listaEditoriales.add(editorial);
		}
	}
	
	public void eliminarEditorial(Editorial editorial) {
		listaEditoriales.remove(editorial);
		System.out.println("Editorial " + editorial.getNombreEditorial() + " eliminado exitosamente!");
	}
	
	public ArrayList<Editorial> getListaEditoriales() {
		return listaEditoriales;
	}
}
