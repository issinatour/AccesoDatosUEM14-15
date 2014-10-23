package ut01.act04;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Ejercicio04 e = new Ejercicio04();
		String ruta = "./resources/Quijote.txt";
		
		e.readTextFile(ruta);
	}

}
