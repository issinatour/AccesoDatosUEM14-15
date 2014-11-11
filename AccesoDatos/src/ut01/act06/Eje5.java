package ut01.act06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Eje5 {
	
	/**
	 * n�meros que contiene cuantos positivos,negativos y nulos, y cuantos primos entre los positivos.
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
	
	static void numeros (ArrayList<Integer> l){
		int positivo = 0;
		int negativo = 0;
		int nulo = 0;
		int primo = 0;
		for(Integer n: l){
			if (n>0) positivo++;
			else if (n<0) negativo++;
			if (n==0) nulo++;
			if (esPrimo(n)) primo++;
		}
		
		System.out.println(positivo +" numeros positivos");
		System.out.println(negativo +" numeros negativos");
		System.out.println(nulo +" numeros nulos");
		System.out.println(primo +" numeros primos");

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
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		test.add(0);
		test.add(-1);
		test.add(-2);
		test.add(2);
		test.add(3);
		test.add(5);
		
		l = leeNumeros("./resources/ENTEROS.TXT");
		numeros(test);
		numeros(l);
		

	}

}
