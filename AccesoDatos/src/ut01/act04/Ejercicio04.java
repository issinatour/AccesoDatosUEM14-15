package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {
	
	
	public boolean isLetter(char letter){
		return Character.isLetter(letter);
	}

	/**
	 * count the nunmber of words of a text file
	 * 
	 * @param path
	 *            of the text file
	 * @param word
	 *            we are counting
	 * @return number of aparitions of the word
	 */
	public int countWords(String path, String word) {
		BufferedReader br = null;
		String buffer;
		char character;
		int numberWords = 0;
		boolean readingWords = false; 
		StringBuffer wordReaden = new StringBuffer();
		try {

			br = new BufferedReader(new FileReader(path));
			while( (buffer = br.readLine())!=null ){
				for(int i=0;i<buffer.length();i++){
					character = buffer.charAt(i);
					if(isLetter(character) && !readingWords) {
						wordReaden.append(character);
						readingWords = true;
					}
					else if(isLetter(character) && readingWords ){
						wordReaden.append(character);
					}
					else if(!isLetter(character) && readingWords ){
						if(wordReaden.toString().toLowerCase().equals(word))
							numberWords++;
						wordReaden = new StringBuffer();
						readingWords = false;
					}
				}
					
			}

		} catch (FileNotFoundException e) {
				System.out.println("fichero no encontrado");
		} catch (IOException e) {
		
		} finally {

			if (br != null)
				try {
					br.close();
				} catch (IOException e) {

				}
		}

		return numberWords;

	}

	String ruta = "./resources/Quijote.txt";

	public int cuentaPalabra(String ruta) {
		Scanner scan = new Scanner(System.in);
		String palabra = "";
		File f = new File(ruta);
		System.out.println("introduce una palabra para buscar:");
		palabra = scan.next();
		int contador = 0;

		if (f.isFile()) {
			FileReader fr = null;//
			int letra;
			try {
				fr = new FileReader(f);
				String pal = "";
				while ((letra = fr.read()) != -1) {
					char caracterleido = (char) letra;
					if (Character.isLetter(caracterleido)) {
						pal += letra;

					} else {
						if (caracterleido == ' ') {
							if (pal.equals(palabra)) {
								contador++;
							}
						}
					}

				}

			} catch (IOException e) {

				System.err.println();
			}
			scan.close();
		}
		return contador;
	}
}