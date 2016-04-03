package org.biblioteca.bean;

public class Libro {
	private static Libro libro;
	
	private int id;
	private int idAutor;
	private int idEditorial;
	private int idGenero;
	private int isbn;
	private String nombreLibro;
	private double precio;
	
	public Libro() {
	
	}
	
	public static Libro getInstancia() {
		if (libro == null) {
			libro = new Libro();
		}
		return libro;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	
	public int getIdAutor(){
		return idAutor;
	}
	
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	
	public int getIdEditorial() {
		return idEditorial;
	}
	
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	
	public int getIdGenero() {
		return idGenero;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	private void setNombreLibro (String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	
	private String getNombreLibro() {
		return nombreLibro;
	}
	
	private void setPrecio(double precio) {
		this.precio = precio;
	}
	
	private double getPrecio(){
		return precio;	
	}
	
		
		
}