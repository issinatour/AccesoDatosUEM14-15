package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {

	public final static int TAM_BUFFER = 1024;

	/**
	 * return all printable characters of a text file
	 * 
	 * @param path
	 *            of the text file
	 * @return number of printable characters
	 */
	public int countCharacters(String path) {

		BufferedReader br = null;
		String buffer;
		int numCharacters = 0;
		try {
			// abrimos flujo de lectura
			br = new BufferedReader(new FileReader(new File(path)), TAM_BUFFER);
			while ((buffer = br.readLine()) != null) {
				numCharacters += buffer.length();

			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {

			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}

		}

		return numCharacters;

	}

}
