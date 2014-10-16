package ut01.act04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ejercicio04 {
	BufferedReader archivo;
	
	
 public	Ejercicio04(String ruta){
	try {
		archivo = new BufferedReader(new FileReader(ruta));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
 }
	
	public int contarPalabras() {
		int numPalabras =0;
		StringTokenizer stk;
		try {
			while(archivo.ready()){
				stk = new StringTokenizer(archivo.readLine(), " \t\n\r\f¡,.:;-()\"0123456789?¿!");
				numPalabras += stk.countTokens();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return numPalabras;
	}

}
