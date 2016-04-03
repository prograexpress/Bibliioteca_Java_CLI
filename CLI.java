package org.biblioteca.sistema;

import org.biblioteca.lector.ObtenerDatos;

public class CLI {
	private static Comandos comandos  = new Comandos();
	private static ObtenerDatos od = new ObtenerDatos();	
	private static boolean aprobacion = false;
	
	public static void ingresarComandos(){
		do {
			System.out.println("");
			System.out.println("Ingrese un comando: ");
			System.out.print("->");
			comandos.leerLinea(od.obtenerDato());
			aprobacion = comandos.getAprobacion();
		} while (aprobacion != true);
	}
}