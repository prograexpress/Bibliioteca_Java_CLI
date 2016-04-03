package org.biblioteca.bean;

public class Autor {
	private static Autor autor;
	
	private int id;
	private String nombreAutor;
		
	public Autor() {
	
	}
	
	public static Autor getInstancia() {
		if (autor == null) {
			autor = new Autor();
		}
		return autor;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	
	public String getNombreAutor() {
		return nombreAutor;
	}	
}