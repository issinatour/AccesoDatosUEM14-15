package ut01.act04;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	/*
	 * Cuenta el nœmero de letras minœsculas puras (sin acentuar ni diresis).
	 */
	public String contarMin(String path) {
		File archivo = null;
		FileReader fr = null;
		int suma = 0;

		try {
			archivo = new File(path);

			fr = new FileReader(archivo);

			int caracter;

			while ((caracter = fr.read()) != -1) {
				if (esLetraMinuscula((char) caracter)) {
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
	 * Comprueba que la letra sea una letra minuscula
	 */
	private boolean esLetraMinuscula(char letra) {

		return (letra >= 'a' && letra <= 'z' || letra == '–');
	}
}
