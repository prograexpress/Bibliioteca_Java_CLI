package org.biblioteca.bean;

public class Usuario {
	private static Usuario usuario;
	
	private int id;
	private String nombreUsuario;
	private String contrasenia;
	
	public Usuario() {
		
	}
	
	public static Usuario getInstancia() {
		if (usuario == null) {
			usuario = new Usuario();			
		}
		return usuario;
	}
	
	public void setId (int id) {
		this.id = id;		
	}
	
	public int getId(){
		return id;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setContrasenia (String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
}