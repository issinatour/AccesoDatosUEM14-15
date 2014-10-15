package ut01.act03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio03 {

	/**
	 * 
	 * @param path
	 * @return
	 */
	public String readTextFile(String path, int n){
		return null;
	}
	/**
	 * 
	 * @param path
	 * @return
	 */
	public String readTextFile(String path){
		File fichero = new File(path);
		StringBuffer contenidoFichero = new StringBuffer();
		if(fichero.isFile()){
			FileReader fr = null;
			int caracter;
			try{
				fr = new FileReader(fichero); // abrimos el stream
				while((caracter = fr.read())!=-1){
					contenidoFichero.append((char) caracter);
				}
				
			}
			catch (IOException e){
				System.err.println("Error al leer el fichero");
			}
			finally{
				if (fr!=null)
					try {
						fr.close();
					} catch (IOException e) {
						
					}
					
			}
		}
		return contenidoFichero.toString();
	}

}
