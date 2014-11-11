package ut01.act06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Eje1 {

	static final int MAX = 100;

	static void escribeNumeros(String nombrefichero) {
		try {

			File fichero = new File(nombrefichero);
			DataOutputStream dataOS = new DataOutputStream(
					new FileOutputStream(fichero));

			for (int i = 0; i < MAX; i++) {
				dataOS.writeDouble(i);
			}

			dataOS.close(); // cerramos el stream
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
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

		System.out.println(":"+(int)'A');
		
		//escribeNumeros("./resources/NUMEROS.BIN");
		//leerNumeros("./resources/NUMEROS.BIN");

	}

}
