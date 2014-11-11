package ut01.act06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Eje7 {
	
	static private int primerDigito(int x) {
	    while (x > 9) {
	        x /= 10;
	    }
	    return x;
	}

	static void escribeNumeros(ArrayList<Integer> l) {
		try {

			File ficheros[] = new File[10];
			BufferedWriter bf[] = new BufferedWriter[10];

			for (int i = 0; i < 10; i++) {
				ficheros[i] = new File("D:\\" + i + ".TXT");
				bf[i] = new BufferedWriter(new FileWriter(ficheros[i]));

			}

			for (Integer n : l) {			
				bf[primerDigito(Math.abs(n))].write(String.valueOf(n)+" ");

			}

			for (int i = 0; i < 10; i++)
				bf[i].close(); // cerramos el stream

		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}

	/**
	 * 
	 * @param nombrefichero
	 * @return
	 */
	static ArrayList<Integer> leeNumeros(String nombrefichero) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			File fichero = new File(nombrefichero);
			BufferedReader bf = new BufferedReader(new FileReader(fichero));

			String n;
			StringTokenizer tokens;

			while ((n = bf.readLine()) != null) {

				tokens = new StringTokenizer(n);
				while (tokens.hasMoreElements())
					lista.add(Integer.valueOf(tokens.nextToken()));

			}
			bf.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}

		return lista;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l;
		l = leeNumeros("./resources/ENTEROS.TXT");
		escribeNumeros(l);
		/*
		ArrayList<Integer> test = new ArrayList<Integer>();

		test.add(0);
		test.add(-10);
		test.add(-20);
		test.add(2);
		test.add(30);
		test.add(500);

		
		escribeNumeros(test);
		 */
	}

}
