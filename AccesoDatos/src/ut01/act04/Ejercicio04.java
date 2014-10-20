package ut01.act04;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ejercicio04 {

	/* Obtener y mostrar la palabra más larga, su número de letras y su posición 
	 * (número de orden en la secuencia de palabras). Si hay más de una se toma la primera.
	 * Nota: El número de orden o posición de la palabra en el texto es el lugar que ocupa,
	 * una vez contadas todas.
	 */
	
	String ruta = "./resources/Quijote.txt";
	
	public String getPalabraMasLarga (String ruta) {
		
		File fichero = new File(ruta);		
		String LineaLeida = "";	
		String PalabraMayorEncontrada = "";
		String CandidataAMayor, Resultado = null;		
		StringTokenizer TextoTokenizado;		
		int NumPalabrasDeLinea; 
		int TamañoMayorEncontrado = 0;
		
		
		if(fichero.isFile()){
			FileReader fr = null;
			int caracter;
			try{
				fr = new FileReader(fichero);
				while((caracter = fr.read())!=-1){
					char CaracterLeido = (char) caracter;
					// Si no es fin de linea sigo concatenando los caracteres en LineaLeida
					if (CaracterLeido != '\n'){
						LineaLeida += CaracterLeido;
						// cuando doy con \n se que he llegado al fin de la linea
					} else {
						// asi que paso toda la linea a StringTokenizer para contar las palabras
						TextoTokenizado = new StringTokenizer(LineaLeida);
						// Las cuento
						NumPalabrasDeLinea = TextoTokenizado.countTokens();
						// Y por cada una de ellas la guardo en CandidataAMayor
						for (int x=0;x<NumPalabrasDeLinea;x++){
							CandidataAMayor = TextoTokenizado.nextToken();
							// Y miro si su longitud es la mayor encontrada hasta el momento
						  	if (CandidataAMayor.length() > TamañoMayorEncontrado){
						  		// En caso de serlo la guardo como la mayor que hay
						  		PalabraMayorEncontrada = CandidataAMayor;
						  		// Y me quedo con la longitud que tiene
						  		TamañoMayorEncontrado = CandidataAMayor.length();
						  	}
						}
					} 
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
		return Resultado;
	}
}
