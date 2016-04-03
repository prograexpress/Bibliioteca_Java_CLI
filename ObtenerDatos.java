package org.biblioteca.lector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ObtenerDatos {
	public String obtenerDato() {
		String dato = null;
		BufferedReader obtener = new BufferedReader(new InputStreamReader(System.in));
		try {
			dato = obtener.readLine();
		} catch (IOException ioe) {
			System.out.println("Error de I/O");
			System.exit(1);
		}
		return dato;
	}
}