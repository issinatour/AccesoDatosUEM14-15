package ut01.act04;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	private static String ruta = "resources/Quijote.txt";
			
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Ejercicio04 obj = new Ejercicio04(ruta);
		try {
			System.out.println(obj.getWordsCION());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
