package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	public final int TAM_BUFFER=1024;
	
	public boolean isLetter(char letter){
		return Character.isLetter(letter);
	}
	
	/**
	 * find the first word pentavolica and return the position in the sequence.
	 * @param path
	 * @throws IOException 
	 * 
	 */

	public void findPentavolica(String path){
		BufferedReader br = null;
		String buffer;
		int numPalabras;
		char character;
		boolean readingWord=false;
		StringBuffer wordReaden = new StringBuffer();
		try {
			br=new BufferedReader(new FileReader(new File(path)),TAM_BUFFER);
			while((buffer=br.readLine()) != null){
				for(int i=0;i<buffer.length();i++){
					character = buffer.charAt(i);
					if(isLetter(character) && !readingWord){
						wordReaden.append(character);
						readingWord=true;
					}if(isLetter(character)&&readingWord){
						
					}
				}
			}
		} catch (FileNotFoundException e) {
			
		}catch(IOException ex){
			
		}
		finally{
			try {
				if(br!=null)
					br.close();
			} catch (IOException e) {
				
			}
		}
	}
}
