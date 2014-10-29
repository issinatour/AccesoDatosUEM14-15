package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	
	
	public boolean isLetter(char letter){
		return Character.isLetter(letter);
	}


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
		String palabra = "jueves";
		File f = new File(ruta);
		System.out.println("introduce un dia del la semana a buscar:");
		int contador = 0;

		if (f.isFile()) {
			FileReader fr = null;
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
		}
		return contador;
	}
}