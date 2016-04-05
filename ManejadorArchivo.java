package org.biblioteca.manejadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.biblioteca.menu.Menu;

import java.util.Calendar;

import org.biblioteca.sistema.Comandos;

public class ManejadorArchivo {
	private static BufferedReader lector = null;
	private static Comandos comandos = new Comandos();
	private static PrintWriter escritor = null;
	private static Menu menu = new Menu();
	
	public ManejadorArchivo(String archivo) {
		FileWriter escritorArchivo = null;
		try {
			escritorArchivo = new FileWriter(archivo, true);
		} catch (IOException ioe) {
			System.out.println("Ocurrio un error");
		}
		escritor = new PrintWriter(escritorArchivo, true);
	}
	
	public static void leerArchivo(String ruta) {
		String linea = null;
		
		try {
			lector = new BufferedReader(new FileReader(new File(ruta)));
		} catch (Exception ex) {
			System.out.println("No se encontro el archivo.");
			menu.menuPrincipal();	
		}
		
		try {
			System.out.println("");
			while ((linea = lector.readLine()) != null) {
				if (linea.equals("")) {
					System.out.println("*** Linea vacia***");
					System.out.println("");
				} else {
					System.out.println("-> " + linea);
					comandos.leerLinea(linea);
				}
			}
			lector.close();
		} catch (IOException ioe) {
			System.out.println("Ocurrio un error. :(");
		}
	}
	
	public static void escribirArchivo(String linea) {
		Calendar tiempo = Calendar.getInstance();
		escritor.println(linea + " -> Realizado el " + tiempo.get(Calendar.DATE) + "-" + tiempo.get(Calendar.MONTH) + "-" + tiempo.get(Calendar.YEAR) 
		  + " a las " + tiempo.get(Calendar.HOUR) + ":" + tiempo.get(Calendar.MINUTE) + ":" + tiempo.get(Calendar.SECOND));
	}
}
