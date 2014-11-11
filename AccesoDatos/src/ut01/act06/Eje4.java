package ut01.act06;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Console ;

public class Eje4 {	
	
	static void leerNumeros(String nombrefichero){
		
		try{			
			File fichero = new File(nombrefichero); 		
			DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));		
		
			double n;
			
			try{
				while (true) {
				
					n = dataIS.readDouble(); // recupera el numero
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
		Console console= System.console();
		String ruta = console.readLine("Introduce la ruta el  fichero de los numeros binarios");
		leerNumeros(ruta);
		

	}

}
