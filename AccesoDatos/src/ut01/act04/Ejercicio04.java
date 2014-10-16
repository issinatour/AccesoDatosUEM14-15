package ut01.act04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	/*
	 * Cuenta el número de letras minúsculas puras (sin acentuar ni diéresis).
	 */
	public String contarMin(String path) {
		File archivo = null;
		FileReader fr = null;
		StringBuffer contenido = new StringBuffer();
		int suma = 0;

		try {
			archivo = new File(path);

			fr = new FileReader(archivo);

			int caracter;

			while ((caracter = fr.read()) != -1) {
				contenido.append((char) caracter);

			}

			for (int i = 0; i < contenido.length(); i++) {
				if (contenido.toString().charAt(i) >= 'a'
						&& contenido.toString().charAt(i) <= 'z') {
					suma +=  +1   ;
				}
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(suma);
		return null;

	}
}
