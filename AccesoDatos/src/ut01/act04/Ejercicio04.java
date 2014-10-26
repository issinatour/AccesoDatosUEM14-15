import java.io.*;
import java.util.*;

public class Ejercicio04 {

	/* Obtener y mostrar la palabra más larga, su número de letras y su posición
	* (número de orden en la secuencia de palabras). Si hay más de una se toma la primera.
	* Nota: El número de orden o posición de la palabra en el texto es el lugar que ocupa,
	* una vez contadas todas.
	*/	
	
	public String getPalabraMasLarga (String ruta) throws FileNotFoundException, IOException {
		String LineaLeida, Token, Resultado = "";
		int LongitudDelTokenMasLargo = 0;
		String TokenMasLargo = "";		
		FileInputStream Fis = null;
		BufferedReader Br = null;
		try {
			Fis = new FileInputStream(ruta);
			Br = new BufferedReader(new InputStreamReader(Fis));
			LineaLeida = Br.readLine();
			int NumDeToken = 1, PosicionToken = 1;
			// Mientras siga teniendo mas lineas
			while (LineaLeida != null) {
				// Parto la linea en tokens
				StringTokenizer LineaTokenizada = new StringTokenizer(LineaLeida);
				// Y recorro dichos tokens
				while (LineaTokenizada.hasMoreTokens()) {
					Token = LineaTokenizada.nextToken();
					// En caso de ser el token mas largo encontrado hasta el momento
					// Me quedo con su posicion, su longitud y con el token					
					if (Token.length() > LongitudDelTokenMasLargo) {
						// Si no acaba en , entonces es valido el token
						// ya que suma 1 caracter mas de longitud a la palabra
						// y la longitud no seria real
						if ((Token.charAt(Token.length()-1)!=',')) {     
							PosicionToken = NumDeToken;
							LongitudDelTokenMasLargo = Token.length();
							TokenMasLargo = Token;
						}
					}
					// Aqui voy sumando 1 al numero de token para saber en todo momento
					// la posicion del que estoy mirando
					NumDeToken++;
					Resultado = " Palabra: "+ TokenMasLargo + 
							    "  | Longitud: "+ LongitudDelTokenMasLargo + 
							    "  | Posicion: "+ PosicionToken + ".";					
				}
				// Y ahora sigo con la siguiente linea
				LineaLeida = Br.readLine();
			}
		}
		finally {
			try {
				Br.close();
				Fis.close();
			} 
			catch (IOException ex) {
			}
		}
		System.out.println(Resultado);
		return Resultado;
	}	
}
