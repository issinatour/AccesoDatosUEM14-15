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

public class Eje6 {
	
	static void escribeNumeros(ArrayList<Integer> l,String ficheroPrimos, String ficheroResto) {
		try {

			File ficheroP = new File(ficheroPrimos);
			File ficheroR = new File(ficheroResto);

			BufferedWriter bfP = new BufferedWriter(new FileWriter(ficheroP));
			BufferedWriter bfR = new BufferedWriter(new FileWriter(ficheroR));


			for(Integer n: l){
				
				if (esPrimo(n)) bfP.write(String.valueOf(n)+" ");
				else bfR.write(String.valueOf(n)+" ");
			}				
			

			bfP.close(); // cerramos el stream
			bfR.close(); // cerramos el stream
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}
	
	/**
	 * n�meros que contiene cu�ntos positivos,negativos y nulos, y cu�ntos primos entre los positivos.
	 */
	
	private static boolean esPrimo(int n) {
	    if (n<1) return false; 
	    //comprobamos si  es multiplo de 2
	    else if (n%2==0) return false;
	    //si no comprobamos los impares
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
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

			while ((n = bf.readLine()) != null){	
				
				tokens = new StringTokenizer(n);
				while(tokens.hasMoreElements())
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
		escribeNumeros(l,"./resources/ENTEROS1.TXT","./resources/ENTEROS2.TXT");
		/*
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		test.add(0);
		test.add(-1);
		test.add(-2);
		test.add(2);
		test.add(3);
		test.add(5);
		escribeNumeros(test,"./resources/ENTEROS1.TXT","./resources/ENTEROS2.TXT");
		*/

	}

}
