package ut01.act10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {

	private File f;
	private FileReader fr;
	private BufferedReader br;
	private int contador;
	private int posicion;

	public Ejercicio04(String ruta) throws FileNotFoundException {
		if (ruta.substring(ruta.length() - 4).equals(".txt"))
			f = new File(ruta);
		fr = new FileReader(f);
		br = new BufferedReader(fr);
	}

	public int getWordsTRIP() throws IOException {
		contador = 0;
		posicion = 0;
		// creamos un StringBuffer donde almacenar las palabras
		StringBuffer aux = new StringBuffer();
		// mientras que el BufferedReader este listo seguira con la lectura
		while (br.ready()) {
			// leemos la primera linea
			String s = br.readLine();
			s = s.toLowerCase();
			
			// recorremos todo el string
			
			for (int i = 0; i < s.length(); i++) {
				// en caso de que el caracter en el que nos encontramos sea una
				// letra la introducimos al StringBuffer
				if (Character.isLetter(s.charAt(i)))
					aux.append(s.charAt(i));
				// si nos encontramos con un final de linea o un espacio en
				// blanco significa final de palabra
				
				if (s.charAt(i) == ' ' || i == (s.length() - 1)) {
					posicion++;
					if (aux.toString().indexOf("iái")!=-1|| aux.toString().indexOf("uái")!=-1|| aux.toString().indexOf("iéi")!=-1
							|| aux.toString().indexOf("uau")!=-1|| aux.toString().indexOf("uái")!=-1|| aux.toString().indexOf("iau")!=-1
							|| aux.toString().indexOf("uey")!=-1|| aux.toString().indexOf("ioi")!=-1|| aux.toString().indexOf("iei")!=-1
							|| aux.toString().indexOf("uay")!=-1) {
						contador++;
						
						System.out.println("El primer triptongo es:\n"+aux.toString()+"\nSu posición: ");
						return posicion;
					}
					
					// reseteamos el StringBuffer para coger la siguiente
					// palabra
					
			aux = new StringBuffer();
			
				}
			}
			
		}
		br.close();
		
		
		return contador;
		
	}

}
