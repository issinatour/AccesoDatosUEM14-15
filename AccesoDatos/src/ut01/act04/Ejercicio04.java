package ut01.act04;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {

	/**
	 * Count the number of lowercase letters 
	 * @param path
	 * @return the number of lowercase letters
	 */
	public String countLowercase(String path) {
		File archivo = null;
		FileReader fr = null;
		int suma = 0;

		try {
			archivo = new File(path);

			fr = new FileReader(archivo);

			int caracter;

			while ((caracter = fr.read()) != -1) {
				if (isLowercase((char) caracter)) {
					suma++;
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return Integer.toString(suma);

	}

	/*
	 * Verifies that the letters are lowercase
	 */
	private boolean isLowercase(char letra) {

		return (letra >= 'a' && letra <= 'z' || letra == '–');
		
	}
}
