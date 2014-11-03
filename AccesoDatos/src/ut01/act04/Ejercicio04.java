package ut01.act04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio04 {


	/**
	 * Elimina los acentos de una línea
	 * @param line
	 * @return
	 */
	private String replaceAllAccents(String line) {
		return line.replaceAll("Á", "A").replaceAll("É", "E").replaceAll("Í", "I").replaceAll("Ó", "O").replaceAll("Ú", "U").replaceAll("Ü", "U");

	}

	/**
	 * Guarda el fichero en mayúsuculas y sin acéntos
	 * @param pathIn
	 * @param pathOut
	 */
	public void lowercaseFiletoUppercaseFile(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		BufferedReader streamIn = null;
		BufferedWriter streamOut = null;
		String line;
		try {
			streamIn = new BufferedReader(new FileReader(pathIn));
			streamOut = new BufferedWriter(new FileWriter(pathOut));

			while ((line = streamIn.readLine()) != null) {
				line = line.toUpperCase();
				line = replaceAllAccents(line);
				System.out.println(line);
				streamOut.write(line);
			}

		} catch (IOException e) {
			System.err.println("Error I/O");
		} finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
				}
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
				}
		}
	}

}
