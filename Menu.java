package org.biblioteca.menu;

import org.biblioteca.lector.ObtenerDatos;
import org.biblioteca.manejadores.ManejadorArchivo;
import org.biblioteca.sistema.CLI;

public class Menu {
	private static int decision = 0;
	private static String ubicación = "";
	
	public static void menuPrincipal() {
		ObtenerDatos leer = new ObtenerDatos();
		ManejadorArchivo manejadorArchivo = null;
		
		System.out.println("");
		System.out.println("Bienvenidos a la biblioteca");
		System.out.println("");
		manejadorArchivo = new ManejadorArchivo("bitacora.log");
		
		do {
			System.out.println("");
			System.out.println("Como desea ingresar los datos");
			System.out.println("1. Ingresar por linea de comandos (CLI)");
			System.out.println("2. Ingresar por Archivo txt");
			System.out.println("3. Salir");
			System.out.print("-> ");
			
			try { 
				decision = Integer.parseInt(leer.obtenerDato());
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Debe ingresar un caracter numerico!");
			}

			switch (decision) {
				case 1:
					CLI.ingresarComandos();
					break;
				case 2:
					System.out.println("Ingrese la ubicacion del archivo");      
					System.out.print("-> ");
					ManejadorArchivo.leerArchivo(leer.obtenerDato());
				break;
				case 3:
					System.out.println("Feliz día");
					System.exit(0);
				break;
				default:
					System.out.println("No ingreso ninguna opcion Válida");
					System.out.println("Intente de nuevo");
				break;
			}
		} while (decision != 3);
	}
}