package ut01.act06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Eje2 {

	static final int MAX = 100;

	static void escribeNumeros(String nombrefichero) {
		try {

			File fichero = new File(nombrefichero);

			BufferedWriter bf = new BufferedWriter(new FileWriter(fichero));
			Scanner scanner = new Scanner(System.in);

			System.out
					.println("Escribe un numero entero, pulsa ctrl + Z para terminar ");

			while (scanner.hasNext()) {
				// body of nested loop goes here

				if (scanner.hasNextInt())
					bf.write(scanner.next() + " ");
			}
			scanner.close();
			bf.close(); // cerramos el stream
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}

	static void leerNumeros(String nombrefichero) {

		try {
			File fichero = new File(nombrefichero);
			BufferedReader bf = new BufferedReader(new FileReader(fichero));

			String n;

			System.out.println("Numeros:");

			while ((n = bf.readLine()) != null)
				System.out.println(n);

			bf.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		escribeNumeros("./resources/ENTEROS.TXT");
		leerNumeros("./resources/ENTEROS.TXT");

	}

}
