package org.biblioteca.sistema;

import java.util.ArrayList;

import org.biblioteca.bean.Usuario;
import org.biblioteca.manejadores.ManejadorUsuario;
import org.biblioteca.manejadores.ManejadorArchivo;

public class Comandos {
	private ArrayList<String> listaPalabrasLinea = new ArrayList<>();
	
	private boolean aprobacion = false;
	private String palabra = "";
	private String linea;
	private int numeroUsuarios = 0;
	private int error = 0;
	
	
	public void leerLinea(String linea) {
		listaPalabrasLinea.clear();
		this.linea = linea;
		int y = linea.length() -1;
		
		for (int x = 0; x < linea.length(); x++) {
			if (x == y) {
				if (linea.substring(x, x + 1).equals(" ")) {
					listaPalabrasLinea.add(palabra);
					palabra = "";
				} else {
					palabra = palabra + linea.substring(x);
					listaPalabrasLinea.add(palabra);
					palabra = "";
				}
			} else {
				if (linea.substring(x, x + 1).equals(" ")) {
					listaPalabrasLinea.add(palabra);
					palabra = "";
				} else {
					palabra = palabra + linea.substring(x, x + 1);
				}
			}
		}
		
		switch (listaPalabrasLinea.get(0)) {
			case "AGREGAR_USUARIO":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("El comando AGREGAR_USUARIO contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("El comando AGREGAR_USUARIO contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					try {
						agregarUsuario();
					} catch (Exception ex) {
						System.out.println("Error" + ex.getMessage());
					}
				}
			break;

			case "MOSTRAR_USUARIOS":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					try {
						mostrarUsuarios();
					} catch (Exception ex) {
						System.out.println("Error" + ex.getMessage());
					}
				}
			break;

			case "MOSTRAR_USUARIO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2){
					System.out.println("Faltaron paranetros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					try {
						mUser();
					} catch (Exception ex){
						System.out.println(ex.getMessage());
					}
				}
			break;

			case "MODIFICAR_USUARIO":
				if (listaPalabrasLinea.size() > 5) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 5){
					System.out.println("Faltaron Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 5) {
					try {
					modificarUsuario();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}	
				}
			break;

			case "ELIMINAR_USUARIO":
				if (listaPalabrasLinea.size () > 2) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltaron Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarUsuario();
				}
			break;
/*			case "AGREGAR_AUTOR":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea == 2) {
					agregarAutor();
				}
			break;
			case "MOSTRAR_AUTOR":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarAutor();
				}
			break;
			case "MOSTRAR_AUTORES":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("Faltan Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarAutores();
				}
			break;
			case "MODIFICAR_AUTOR":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("Faltan Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					modificarAutor();
				}
			break;
			case "ELIMINAR_AUTOR":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarAutor();
				}
			break;
			case "AGREGAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2){
					System.out.println("Faltan Parametros");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2){
					agregarEditorial();
				}
			break;
			case "MOSTRAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarEditorial();
				}
			break;
			case "MOSTRAR_EDITORIALES":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarEditoriales();
				}
			break;
			case "MODIFICAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					modificarEditorial();
				}
				break;
			case "ELIMINAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2){
					eliminarEditorial();
				}
			break;
			case "AGREGAR_GENERO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					agregarGenero();
				}
			break;
			case "MOSTRAR_GENERO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarGenero();
				}
			break;
			case "MOSTRAR_GENEROS":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarGeneros();
				}
			break;
			case "MODIFICAR_GENERO":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					modificarGenero();
				}
			break;
			case "ELIMINAR_GENERO":
				if (listaPalabrasLinea.size() > 2 ) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarGenero();
				}
			break;
			case "AGREGAR_LIBRO":
				if (listaPalabrasLinea.size() > 7 ) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 7) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 7) {
					agregarLibro();
				}
			break;
			case "MOSTRAR_LIBRO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarLibro();
				}
			break;
			case "MOSTRAR_LIBROS":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarLibros();
				}
			break;
			case "MODIFICAR_LIBRO":
				if (listaPalabrasLinea.size() > 8) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 8) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 8){
					modificarLibro();
				}
			break;
			case "ELIMINAR_LIBRO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("Más Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarLibro();
				}
			break;
*/
			case "SALIR":
				if (listaPalabrasLinea.size() > 1){ 
					System.out.println("Más datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("Faltan Datos");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					ManejadorArchivo.escribirArchivo(linea);
					this.aprobacion = true;					
				}
			break;
			default:
				System.out.println("Ingrese un comando valido");
				System.out.println("Intentelo de nuevo");
				System.out.println("");
			break;
		}
		
	}
	
	//definir metodos
	
	public void agregarUsuario() {
		Usuario usuario = new Usuario();
		error = 0;
		if (numeroUsuarios == 0) {
			try {
				usuario.setId(numeroUsuarios);
				usuario.setNombreUsuario(listaPalabrasLinea.get(1));
				usuario.setContrasenia(listaPalabrasLinea.get(2));
				
				ManejadorUsuario.getInstancia().agregarUsuario(usuario);
				
				ManejadorArchivo.escribirArchivo(linea);
				numeroUsuarios++;
				System.out.println("Usuario Agregado con exito");
			} catch (Exception ex) {
				System.out.println("Ha ocurrido un error por favor intente de nuevo");
			}
		} else {
			for (Usuario usu: ManejadorUsuario.getInstancia().getListaUsuarios()) {
				if (listaPalabrasLinea.get(1).equals(String.valueOf(usu.getId())) || listaPalabrasLinea.get(1).equals(usu.getNombreUsuario())) {
					System.out.println("El usuario ingresado ya existe");
					System.out.println("");
					error++;
					break;
				}
			}
			
			if (error == 0) {
				try {
					usuario.setId(numeroUsuarios);
					usuario.setNombreUsuario(listaPalabrasLinea.get(1));
					usuario.setContrasenia(listaPalabrasLinea.get(2));
					
					ManejadorUsuario.getInstancia().agregarUsuario(usuario);
					
					ManejadorArchivo.escribirArchivo(linea);
					numeroUsuarios++;
					System.out.println("Usuario Agregado con exito");
				} catch (Exception ex) {
					System.out.println("Ha ocurrido un error por favor intente de nuevo");
				}
			}
		}
		System.out.println("");
	}
	
	public void mostrarUsuarios() {
		error = 0;
		for (Usuario usu:ManejadorUsuario.getInstancia().getListaUsuarios()){
			System.out.println("ID: " + usu.getId() + " Nombre: " + usu.getNombreUsuario() + " Contrasenia: " + usu.getContrasenia());
		}
		ManejadorArchivo.escribirArchivo(linea);
	}
	
	public void mUser() {
		boolean usuario_existe = false;
		for (Usuario usu:ManejadorUsuario.getInstancia().getListaUsuarios()){
			if (listaPalabrasLinea.get(1).equals(String.valueOf(usu.getId())) || listaPalabrasLinea.get(1).equals(usu.getNombreUsuario())) {
				System.out.println("");
				System.out.println(" " + " ID: " + usu.getId() + " Nombre: " + usu.getNombreUsuario() + " Contrasenia: " + usu.getContrasenia());
				System.out.println("");
				ManejadorArchivo.escribirArchivo(linea);
				usuario_existe = true;
				break;
			} else {
				usuario_existe = false;
			}			
		}
		if (usuario_existe == false ) {
			System.out.println("Este usuario no existe");
		}
	}
	
	public void modificarUsuario() {
		int contador = 0;
		for (Usuario usu:ManejadorUsuario.getInstancia().getListaUsuarios()){
			if (listaPalabrasLinea.get(1).equals(String.valueOf(usu.getId())) || listaPalabrasLinea.get(1).equals(usu.getNombreUsuario())) {
				if (listaPalabrasLinea.get(2).equals(usu.getContrasenia())) {
					ManejadorUsuario.getInstancia().modificarUsuario(usu, listaPalabrasLinea.get(3), listaPalabrasLinea.get(4)); 
				}
			}
			contador = contador +1;
		}
	}
	
	public void eliminarUsuario() {
		Usuario usuario = new Usuario();
		boolean usuario_existe = false;
		for (Usuario user: ManejadorUsuario.getInstancia().getListaUsuarios()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(user.getId())) || listaPalabrasLinea.get(1).equals(user.getNombreUsuario())) {
				usuario_existe = true;
				usuario = user;
				break;
			}
		}
		if (usuario_existe == true) {
			ManejadorUsuario.getInstancia().eliminarUsuario(usuario);
		} else {
			System.out.println("El usuario ingresado no existe!");
		}
	}

	public boolean getAprobacion() {
		return aprobacion;
	}
}
