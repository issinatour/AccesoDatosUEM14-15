package ut01.act01;

import java.io.File;

public class Ejercicio01 {
	
	/**
	 * Devuelve un array con el contenido del directorio
	 * @param directorio String con la ruta del directorio
	 * @return array con el contenido del directorio
	 */
	public String[] listarDirectorio(String directorio){
		File fichero = new File(directorio);
		String[] cadVacia = new String[0]; // devuelvo si no es directorio
		
		String[] contenidoDirectorio = fichero.list();
		// si es un directorio devuelvo contenidoDirectorio
		if(fichero.isDirectory())
			return contenidoDirectorio;
		else // si no es un directorio
			return cadVacia;
					
		
	}

}
