package org.biblioteca.sistema;

import java.util.ArrayList;

import org.biblioteca.bean.Usuario;
import org.biblioteca.bean.Autor;
import org.biblioteca.bean.Editorial;
import org.biblioteca.manejadores.ManejadorUsuario;
import org.biblioteca.manejadores.ManejadorAutor;
import org.biblioteca.manejadores.ManejadorEditorial;
import org.biblioteca.manejadores.ManejadorArchivo;

public class Comandos {
	private ArrayList<String> listaPalabrasLinea = new ArrayList<>();
	
	private boolean aprobacion = false;
	private String palabra = "";
	private String linea;
	private int numeroUsuarios = 0;
	private int numeroAutores = 0;
	private int numeroEditoriales = 0;
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
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2){
					System.out.println("El comando contiene menos parametros de los aceptados");
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
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 5){
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 5) {
					try {
						modificarUsuario();
					} catch (Exception ex) {
						
					}	
				}
			break;

			case "ELIMINAR_USUARIO":
				if (listaPalabrasLinea.size () > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					try {
						eliminarUsuario();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			break;
				
			case "AGREGAR_AUTOR":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					try {
						agregarAutor();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			break;
				
			case "MOSTRAR_AUTORES":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					try {
						mostrarAutores();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			break;

			case "MOSTRAR_AUTOR":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					try {
						mostrarAutor();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			break;

			case "MODIFICAR_AUTOR":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					try {
						modificarAutor();
					} catch (Exception ex) {

					}
				}
			break;

			case "ELIMINAR_AUTOR":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarAutor();
				}
			break;

			case "AGREGAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2){
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2){
					agregarEditorial();
				}
			break;

			case "MOSTRAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarEditorial();
				}
			break;
				
			case "MOSTRAR_EDITORIALES":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarEditoriales();
				}
			break;
				
			case "MODIFICAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					try {
						modificarEditorial();
					} catch (Exception ex) {
					}
				}
				break;
				
			case "ELIMINAR_EDITORIAL":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2){
					eliminarEditorial();
				}
			break;
/*
			case "AGREGAR_GENERO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					agregarGenero();
				}
			break;
			case "MOSTRAR_GENERO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarGenero();
				}
			break;
			case "MOSTRAR_GENEROS":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarGeneros();
				}
			break;
			case "MODIFICAR_GENERO":
				if (listaPalabrasLinea.size() > 3) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 3) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 3) {
					modificarGenero();
				}
			break;
			case "ELIMINAR_GENERO":
				if (listaPalabrasLinea.size() > 2 ) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarGenero();
				}
			break;
			case "AGREGAR_LIBRO":
				if (listaPalabrasLinea.size() > 7 ) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 7) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 7) {
					agregarLibro();
				}
			break;
			case "MOSTRAR_LIBRO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					mostrarLibro();
				}
			break;
			case "MOSTRAR_LIBROS":
				if (listaPalabrasLinea.size() > 1) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 1) {
					mostrarLibros();
				}
			break;
			case "MODIFICAR_LIBRO":
				if (listaPalabrasLinea.size() > 8) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 8) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 8){
					modificarLibro();
				}
			break;
			case "ELIMINAR_LIBRO":
				if (listaPalabrasLinea.size() > 2) {
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 2) {
					System.out.println("El comando contiene menos parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() == 2) {
					eliminarLibro();
				}
			break;
*/
			case "SALIR":
				if (listaPalabrasLinea.size() > 1){ 
					System.out.println("El comando contiene más parametros de los aceptados");
					System.out.println("");
				} else if (listaPalabrasLinea.size() < 1) {
					System.out.println("El comando contiene menos parametros de los aceptados");
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
	
	//CRUD USUARIO
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
	
	public void mostrarAutor() {
		boolean existenciaAutor = false;
		for (Autor aa:ManejadorAutor.getInstancia().getListaAutores()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(aa.getId())) || listaPalabrasLinea.get(1).equals(aa.getNombreAutor())) {
				System.out.println("");
				System.out.println("ID: " + aa.getId() + " Nombre_Autor: " + aa.getNombreAutor());
				System.out.println("");
				ManejadorArchivo.escribirArchivo(linea);
				existenciaAutor = true;
				break;
			} else {
				existenciaAutor = false;
			}
		}
		if (existenciaAutor == false) {
			System.out.println("El Autor no existe");
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

	//CRUD AUTOR
	public void agregarAutor() {
		Autor autor = new Autor();
		error = 0;
		if (numeroAutores == 0) {
			try {
				autor.setId(numeroAutores);
				autor.setNombreAutor(listaPalabrasLinea.get(1));
				ManejadorAutor.getInstancia().agregarAutor(autor);
				ManejadorArchivo.escribirArchivo(linea);
				numeroAutores++;
				System.out.println("Autor agregado con éxito");
			} catch (Exception ex) {
				System.out.println("Ha ocurrido un error por favor intente de nuevo");
			}
		} else {
			for (Autor aa:ManejadorAutor.getInstancia().getListaAutores()) {
				if (listaPalabrasLinea.get(1).equals(String.valueOf(aa.getId())) || listaPalabrasLinea.get(1).equals(aa.getNombreAutor())) {
					System.out.println("El autor ingresado ya existe");
					System.out.println("");
					error++;
					break;
				}
			}
	
			if(error == 0) {
				try {
					autor.setId(numeroAutores);
					autor.setNombreAutor(listaPalabrasLinea.get(1));
					ManejadorAutor.getInstancia().agregarAutor(autor);
					ManejadorArchivo.escribirArchivo(linea);
					numeroAutores++;
					System.out.println("Autor agregado con éxito");
				} catch (Exception ex) {
					System.out.println("Ha ocurrido un error por favor intente de nuevo");
				}
			}		
		}
	}
	
	public void mostrarAutores() {
		error = 0;
		for (Autor aa:ManejadorAutor.getInstancia().getListaAutores()) {
			System.out.println("ID: " + aa.getId() +  " Nombre_Autor: " + aa.getNombreAutor());
		}
		ManejadorArchivo.escribirArchivo(linea);
	}
	
	public void modificarAutor() {
		int contador = 0;
		for (Autor aa:ManejadorAutor.getInstancia().getListaAutores()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(aa.getId())) || listaPalabrasLinea.get(1).equals(aa.getNombreAutor())){
				ManejadorAutor.getInstancia().modificarAutor(aa,listaPalabrasLinea.get(2));
			}
			contador = contador + 1;
		}
	}
	
	public void eliminarAutor() {
		Autor autor = new Autor();
		boolean existenciaAutor = false;
		for (Autor aa: ManejadorAutor.getInstancia().getListaAutores()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(aa.getId())) || listaPalabrasLinea.get(1).equals(aa.getNombreAutor())) {
				existenciaAutor = true;
				autor = aa;
				break;
			}
		}
		if (existenciaAutor == true) {
			ManejadorAutor.getInstancia().eliminarAutor(autor);
		} else {
			System.out.println("El Autor ingresado no existe! ");
		}
	}
	
	//CRUD Editorial
	public void agregarEditorial() {
		Editorial editorial = new Editorial();
		error = 0;
		if (numeroEditoriales == 0) {
			try {
				editorial.setId(numeroEditoriales);
				editorial.setNombreEditorial(listaPalabrasLinea.get(1));
				ManejadorEditorial.getInstancia().agregarEditorial(editorial);
				numeroEditoriales++;
				System.out.println("Editorial agregada con éxito");
			} catch (Exception ex) {
				System.out.println("Ha ocurrido un error por favor intente de nuevo");
			}
		} else {
			for (Editorial ed:ManejadorEditorial.getInstancia().getListaEditoriales()) {
				if (listaPalabrasLinea.get(1).equals(String.valueOf(ed.getId())) || listaPalabrasLinea.get(1).equals(ed.getNombreEditorial())) {
					System.out.println("La editorial ingresada ya existe");
					System.out.println("");
					error++;
					break;
				}
			}
			
			if (error == 0) {
				try {
					editorial.setId(numeroEditoriales);
					editorial.setNombreEditorial(listaPalabrasLinea.get(1));
					ManejadorEditorial.getInstancia().agregarEditorial(editorial);
					ManejadorArchivo.escribirArchivo(linea);
					numeroEditoriales++;
					System.out.println("Editorial agregada exitosamente");
				} catch (Exception ex) {
					System.out.println("Ha ocurrido un error por favor intente de nuevo");
				}
			}
		}
	}
	
	public void mostrarEditoriales() {
		error = 0;
		for (Editorial ed:ManejadorEditorial.getInstancia().getListaEditoriales()) {
			System.out.println("ID: " + ed.getId() +  " Nombre_Editorial: " + ed.getNombreEditorial());
		}
		ManejadorArchivo.escribirArchivo(linea);
	}
	
	public void mostrarEditorial() {
		boolean existenciaEditorial = false;
		for (Editorial ed:ManejadorEditorial.getInstancia().getListaEditoriales()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(ed.getId())) || listaPalabrasLinea.get(1).equals(ed.getNombreEditorial())) {
				System.out.println("");
				System.out.println("ID: " + ed.getId() + " Nombre_Editorial: " + ed.getNombreEditorial());
				System.out.println("");
				ManejadorArchivo.escribirArchivo(linea);
				existenciaEditorial = true;
				break;
			} else {
				existenciaEditorial = false;
			}
		}
		if (existenciaEditorial == false) {
			System.out.println("Esta editorial no existe");
		}
	}
	
	public void modificarEditorial() {
		int contador = 0;
		for (Editorial ed:ManejadorEditorial.getInstancia().getListaEditoriales()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(ed.getId())) || listaPalabrasLinea.get(1).equals(ed.getNombreEditorial())) {
				ManejadorEditorial.getInstancia().modificarEditorial(ed,listaPalabrasLinea.get(2));
			}
			contador = contador +1;
		}
	}
	
	public void eliminarEditorial() {
		Editorial editorial = new Editorial();
		boolean existenciaEditorial = false;
		for (Editorial ed: ManejadorEditorial.getInstancia().getListaEditoriales()) {
			if (listaPalabrasLinea.get(1).equals(String.valueOf(ed.getId())) || listaPalabrasLinea.get(1).equals(ed.getNombreEditorial())) {
				existenciaEditorial = true;
				editorial = ed;
				break;
			}
		}
		if (existenciaEditorial == true) {
			ManejadorEditorial.getInstancia().eliminarEditorial(editorial);
		} else {
			System.out.println("La editorial ingresada no existe! ");
			System.out.println("Intente de nuevo");
			System.out.println("");
		}	
	}
	
	
	
	public boolean getAprobacion() {
		return aprobacion;
	}
}
