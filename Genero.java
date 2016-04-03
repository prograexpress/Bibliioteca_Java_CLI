package org.biblioteca.bean;

public class Genero {
	private static Genero genero;
	
	private int id = 1;
	private String nombreGenero;
	
	public Genero() {
		
	}
	
	public static Genero getInstancia() {
		if ( genero == null) {
			genero = new Genero();
		}
		return genero;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId () {
		return id;
	}
	
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
	public String getNombreGenero() {
		return nombreGenero;
	}
}