package org.biblioteca.manejadores;

import java.util.ArrayList;
import org.biblioteca.bean.Genero;

public class ManejadorGenero {
	private static ManejadorGenero manejadorGenero;
	private ArrayList<Genero> listaGeneros = new ArrayList<>();
	
	private ManejadorGenero() {
	
	}
	
	public static ManejadorGenero getInstancia() {
		if (manejadorGenero == null) {
			manejadorGenero = new ManejadorGenero();
		}
		return manejadorGenero;
	}
	
	public void agregarGenero(Genero genero) {
		this.listaGeneros.add(genero);
	}

	public void modificarGenero(Genero generoAnt,String nombreGenero) {
		Genero genero = new Genero();
		boolean existenciaGenero = false;
		for (Genero aaTemp: listaGeneros) {
			if (aaTemp.getNombreGenero().equals(nombreGenero)) {
				System.out.println("Este genero ya existe");
				System.out.println("Imposible de modificar");
				System.out.println("");
				existenciaGenero = true;
				break;
			} else {
				existenciaGenero = false;
			}
		}
		if (existenciaGenero == false) {
			genero.setId(generoAnt.getId());
			genero.setNombreGenero(nombreGenero);
			System.out.println("Genero: " + generoAnt.getId() + " modificado exitosamente");
			listaGeneros.remove(generoAnt);
			listaGeneros.add(genero);
		}
	}
	
	public void eliminarGenero(Genero genero) {
		listaGeneros.remove(genero);
		System.out.println("Genero " + genero.getNombreGenero() + " eliminado exitosamente!");
	}
	
	public ArrayList<Genero> getListaGeneros() {
		return listaGeneros;
	}
}