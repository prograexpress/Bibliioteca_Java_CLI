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
	
	public ArrayList<Genero> getListaGeneros() {
		return listaGeneros;
	}
}