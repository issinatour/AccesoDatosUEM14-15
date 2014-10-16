package ut01.act04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ejercicio04 {
	
	public String contarMin (String path){
		File  archivo = null;
		FileReader fr = null;
		try {
			 archivo = new File(path);
			 fr = new FileReader(archivo);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}
