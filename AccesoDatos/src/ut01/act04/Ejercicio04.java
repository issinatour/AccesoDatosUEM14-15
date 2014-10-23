package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	public final int TAM_BUFFER = 1024;

	public boolean isLetter(char letter) {
		return Character.isLetter(letter);
	}

	public boolean isPentavocalica(String word) {

		int numa = 0, nume = 0, numi = 0, numo = 0, numu = 0;

		for (int x = 0; x < word.length(); x++) {
			if (word.charAt(x) == 'a') {
				numa++;
			}
			if (word.charAt(x) == 'e') {
				nume++;
			}
			if (word.charAt(x) == 'i') {
				numi++;
			}
			if (word.charAt(x) == 'o') {
				numo++;
			}
			if (word.charAt(x) == 'u') {
				numu++;
			}
		}
		if (numa == 1 && nume == 1 && numi == 1 && numo == 1 && numu == 1) {
			return true;
		} else
			return false;
	}

	/**
	 * find the first word pentavolica and return the position in the sequence.
	 * 
	 * @param path
	 * @throws IOException
	 * 
	 */

	public int findPentavocalica(String path) {
		BufferedReader br = null;
		String buffer;
		int numWords = 0;
		char character;
		boolean readingWord = false;
		StringBuffer wordReaden = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(new File(path)), TAM_BUFFER);
			while ((buffer = br.readLine()) != null) {
				for (int i = 0; i < buffer.length(); i++) {
					character = buffer.charAt(i);
					if (isLetter(character) && !readingWord) {
						wordReaden.append(character);
						readingWord = true;

					}
					if (isLetter(character) && readingWord) {
						wordReaden.append(character);
					} else if (!isLetter(character) && readingWord) {

					} else {
						numWords++;
						if (isPentavocalica(wordReaden.toString().toLowerCase())) {
							// pintamos en pantalla la palabra pentavocalica
							System.out.println(wordReaden);
							return numWords;
						}
						wordReaden = new StringBuffer();
						readingWord = false;
					}
				}
			}
		} catch (FileNotFoundException e) {

			System.out.println("No se encuentra el fichero");

		} catch (IOException ex) {

		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {

			}
		}
		return 0;
	}
}
