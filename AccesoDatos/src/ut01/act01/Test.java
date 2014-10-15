package ut01.act01;

import java.util.Scanner;

public class Test {

	static Scanner sc;

	public static void main(String[] args) {

		// declaro un objeto de la clase Ejercicio01
		Ejercicio01 objectoEje01 = new Ejercicio01();

		// Declaro un Scanner
		sc = new Scanner(System.in);
		String ruta = "";
		// bucle
		do {
			System.out.println("Introduzca una ruta");
			ruta = sc.next();
			
			// guardo en contenido los ficheros que contiene la ruta
			String[] contenido = objectoEje01.listarDirectorio(ruta);
			// recorre el array contenido para mostrar por pantalla los ficheros
			for (String fichero : contenido)
				System.out.println(fichero);
			
		} while (!ruta.equals("-1")); // finaliza cuando ruta es igual a -1
	}

}
