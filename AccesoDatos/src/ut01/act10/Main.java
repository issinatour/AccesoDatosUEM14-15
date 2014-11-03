package ut01.act10;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	private static String ruta = "./resources/Quijote.txt";
	private static String ruta2 = "./resources/prueba.txt";
	public static void main(String[] args) throws FileNotFoundException {
		/*
		// TODO Auto-generated method stub
		Ejercicio04 obj = new Ejercicio04(ruta);
		try {
			System.out.println(obj.getWordsTRIP());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		Ejercicio04 obj = new Ejercicio04();
		obj.WordStartLowercaseFile(ruta);
	}
	
}
