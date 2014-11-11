package ut01.act06;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Eje3 {
	
	static void escribeNumerosBinario(ArrayList<Integer> lista,String nombrefichero) {
		try {

			File fichero = new File(nombrefichero);
			DataOutputStream dataOS = new DataOutputStream(
					new FileOutputStream(fichero));

			for (Integer n: lista) {
				dataOS.writeDouble(n);
			}

			dataOS.close(); // cerramos el stream
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}

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
	
	static void leerNumeros(String nombrefichero){
		
		try{			
			File fichero = new File(nombrefichero); 		
			DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));		
		
			double n;
			
			try{
				while (true) {
				
					n = dataIS.readDouble(); // recupera el n�mero
					System.out.println("Numero: "+n);
				}
			}
			catch (EOFException eo) {}
			finally	{
				dataIS.close();}
		
		}	
		catch (FileNotFoundException fnfe) {
			System.out.println("El fichero "+nombrefichero+" no se encuentra");	}
		catch (IOException ioe) {
			System.out.println("Error de E/S");	}
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		escribeNumerosBinario(leeNumeros("./resources/ENTEROS.TXT"), "./resources/ENTEROS.BIN");
		leerNumeros("./resources/ENTEROS.BIN");

	}

}
