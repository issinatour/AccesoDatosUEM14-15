package ut01.act04;

/* Crear dos ficheros â€œPALMAYUS.TXTâ€� y â€œPALMINUS.TXTâ€�, 
 * con todas las palabras que empiezan por letra mayÃºscula y minÃºscula, 
 * respectivamente (cada palabra en una lÃ­nea).
 * 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ejercicio04 {

	// declaramos las variables
	private String texto = "\n";
	private String txt = "";
	public final int TAM_BUFFER = 1024;
	int numPentas = 0;

	// metodo que lee el archivo para realizar la seleccion mayusculas y
	// minusculas
	private void leerArchivo() {
		File nombre = new File("Quijote.txt");

		try {
			BufferedReader entrada = new BufferedReader(new FileReader(nombre));
			StringBuffer bufer = new StringBuffer();
			while ((texto = entrada.readLine()) != null)
				bufer.append(texto + "\n");

			// metodo que coje el caracter primero como mayuscula o minuscula,
			// falta por implementar

			/*
			 * if(Character.isUpperCase(letra)) letra =
			 * Character.toLowerCase(letra); else letra =
			 * Character.toUpperCase(letra);
			 * 
			 * System.out.println(letra); }
			 */
			texto = bufer.toString();
			System.out.println(texto);

			texto = texto.toUpperCase();
			System.out.println("\n" + texto);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// metodo para guardar la modificacion en el fichero
	private void guardarArchivo() {
		try {
			BufferedReader leer = new BufferedReader(new StringReader(texto));
			PrintWriter escribir = new PrintWriter(new BufferedWriter(
					new FileWriter("PALMAYUS.txt")));
			while ((txt = leer.readLine()) != null)
				escribir.println(txt);
			escribir.close();
		} catch (Exception e) {
			System.out.println("Final");
		}
	}

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

	public void findPentavocalica(String path) {

		String sLinea;
		String sPalabra;

		// Cargamos el buffer con el contenido del archivo
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./resources/Quijote.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			do {
				// Leemos la primera linea
				sLinea = br.readLine();
				StringTokenizer st = new StringTokenizer(sLinea);
				// bucle por todas las palabras
				while (st.hasMoreTokens()) {
					sPalabra = st.nextToken();

					if (isPentavocalica(sPalabra)) {
						numPentas++;
						System.out.println("palabra ventavocalica: " + sPalabra
								+ ", numero: " + numPentas);

					}

				}
			} while ((sLinea = br.readLine()) != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Elimina los acentos de una línea
	 * 
	 * @param line
	 * @return
	 */
	private String replaceAllAccents(String line) {
		return line.replaceAll("Á", "A").replaceAll("É", "E")
				.replaceAll("Í", "I").replaceAll("Ó", "O").replaceAll("Ú", "U")
				.replaceAll("Ü", "U");

	}

	/**
	 * Guarda el fichero en mayúsuculas y sin acéntos
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	public void lowercaseFiletoUppercaseFile(String pathIn, String pathOut) {

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

	/**
	 * return words starts with uppercase option 0 all words option 1 starts
	 * with uppercase option 2 starts with lowercase
	 * 
	 * @param line
	 * @return
	 */
	public ArrayList<String> listsWordsLine(String line, int option) {
		char letter;
		boolean readingWord = false;
		ArrayList<String> listWords = new ArrayList<String>();
		StringBuffer bufferWord = new StringBuffer();
		String word;
		for (int i = 0; i < line.length(); i++) {
			letter = line.charAt(i);
			if (!readingWord && Character.isLetter(letter)) {
				readingWord = true;
				bufferWord.append(letter);

			} else if (readingWord && Character.isLetter(letter)) {
				bufferWord.append(letter);
			} else if (readingWord && !Character.isLetter(letter)) {
				readingWord = false;
				word = bufferWord.toString();
				bufferWord.delete(0, word.length());
				if (option == 0)
					listWords.add(word);
				else if ((option == 1)
						&& (Character.isUpperCase(word.charAt(0))))
					listWords.add(word);
				else if ((option == 2)
						&& (Character.isLowerCase(word.charAt(0))))
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
	public void WordStartLowercaseFile(String pathIn, String pathOut, int option) {

		BufferedReader streamIn = null;
		BufferedWriter streamOut = null;
		String line;
		ArrayList<String> listWords;
		try {
			streamIn = new BufferedReader(new FileReader(pathIn));
			streamOut = new BufferedWriter(new FileWriter(pathOut));

			while ((line = streamIn.readLine()) != null) {
				// System.out.println(line);
				listWords = listsWordsLine(line, option);
				for (String word : listWords) {
					// System.out.println(word);
					streamOut.write(word);
					streamOut.newLine();
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
			if (streamOut != null) {
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error I/O");
				}
			}
		}
	}
}
