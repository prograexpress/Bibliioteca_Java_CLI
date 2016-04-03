package org.biblioteca.bean;

public class Editorial {
	private static Editorial editorial;
	
	private int id;
	private String nombreEditorial;
	
	public Editorial() {
	
	}
	
	public static Editorial getInstancia() {
		if (editorial == null) {
			editorial = new Editorial();
		}
		return editorial;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}
	
	public String getNombreEditorial() {
		return nombreEditorial;
	}
	
}