package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {

	private File f;
	private FileReader fr;
	private BufferedReader br;
	private int contador;
	private int posicion;

	public boolean isVowel(char letter) {
		return (" aeiouáéíóúüyh".indexOf(Character.toLowerCase(letter)) > 0);
	}

	public boolean haveThreeVocals(String word) {

		word = word.toLowerCase();
		String triptongo = "";
		int numberVowels = 0;
		// System.out.println(word);

		for (int i = 0; i < word.length(); i++) {

			if (isVowel(word.charAt(i)) && numberVowels == 0) {

				triptongo += word.charAt(i);

				if (word.charAt(i) != 'h') {
					++numberVowels;
				}

			} else if (isVowel(word.charAt(i)) && numberVowels < 3) {

				triptongo += word.charAt(i);

				if (word.charAt(i) != 'h') {
					++numberVowels;
				}

			}

			// if (triptongo.length() > 2)
			if ((numberVowels == 3 && !word.toLowerCase().contains(
					"q" + triptongo))) {
				
				if( triptongo.contains("y") && (triptongo.charAt(triptongo.length()-1)!='y')){
					triptongo = "";
					numberVowels = 0;
				}
				else	
				return true;
				
			} else if (!isVowel(word.charAt(i)) && numberVowels != 0) {

				triptongo = "";
				numberVowels = 0;

			}
		}

		return false;
	}

	public ArrayList<String> listsWordsThreeVocals(String line) {
		char letter;
		boolean readingWord = false;
		ArrayList<String> listWords = new ArrayList<String>();
		StringBuffer bufferWord = new StringBuffer();
		String word;
		// System.out.println(line);
		for (int i = 0; i < line.length(); i++) {
			letter = line.charAt(i);
			// System.out.println(bufferWord.toString());
			// System.out.println(i+" "+line.length());
			if (!readingWord && Character.isLetter(letter)) {

				readingWord = true;
				bufferWord.append(letter);

			} else if (readingWord && Character.isLetter(letter)) {

				bufferWord.append(letter);

			}

			if (readingWord && !Character.isLetter(letter)
					|| (i == line.length() - 1)) {

				readingWord = false;
				word = bufferWord.toString();
				// System.out.println(word);
				bufferWord = new StringBuffer();

				if (haveThreeVocals(word))
					listWords.add(word);

			} // end (readingWord && !Character.isLetter(letter))
		} // end for

		return listWords;
	}

	/**
	 * Guarda el fichero en mayúsuculas y sin acéntos
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	public void WordStartLowercaseFile(String pathIn) {

		BufferedReader streamIn = null;

		String line;
		ArrayList<String> listWords;
		try {
			streamIn = new BufferedReader(new FileReader(pathIn));

			while ((line = streamIn.readLine()) != null) {

				listWords = listsWordsThreeVocals(line);
				for (String word : listWords) {
					System.out.println(word);
				}
			}

		} catch (IOException e) {
			System.err.println("Error I/O");
		} finally {
			if (streamIn != null) {
				try {
					streamIn.close();
				} catch (IOException e) {
				}
			}

		}
	}

	public int getWordsTRIP() throws IOException {
		contador = 0;
		posicion = 0;
		// creamos un StringBuffer donde almacenar las palabras
		StringBuffer aux = new StringBuffer();
		// mientras que el BufferedReader este listo seguira con la lectura
		while (br.ready()) {
			// leemos la primera linea
			String s = br.readLine();
			s = s.toLowerCase();

			// recorremos todo el string

			for (int i = 0; i < s.length(); i++) {
				// en caso de que el caracter en el que nos encontramos sea una
				// letra la introducimos al StringBuffer
				if (Character.isLetter(s.charAt(i)))
					aux.append(s.charAt(i));
				// si nos encontramos con un final de linea o un espacio en
				// blanco significa final de palabra

				if (s.charAt(i) == ' ' || i == (s.length() - 1)) {
					posicion++;
					if (aux.toString().indexOf("iái") != -1
							|| aux.toString().indexOf("uái") != -1
							|| aux.toString().indexOf("iéi") != -1
							|| aux.toString().indexOf("uau") != -1
							|| aux.toString().indexOf("uái") != -1
							|| aux.toString().indexOf("iau") != -1
							|| aux.toString().indexOf("uey") != -1
							|| aux.toString().indexOf("ioi") != -1
							|| aux.toString().indexOf("iei") != -1
							|| aux.toString().indexOf("uay") != -1) {
						contador++;

						System.out.println("El primer triptongo es:\n"
								+ aux.toString() + "\nSu posición: ");
						return posicion;
					}

					// reseteamos el StringBuffer para coger la siguiente
					// palabra

					aux = new StringBuffer();

				}
			}

		}
		br.close();

		return contador;

	}

}
