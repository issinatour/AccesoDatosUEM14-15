package ut01.act04;

public class Ejercicio04 {
	
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
		
		public Ejercicio04(String ruta) throws FileNotFoundException{
			if(ruta.substring(ruta.length()-4).equals(".txt"))
				f = new File(ruta);
				fr = new FileReader(f);
				br = new BufferedReader(fr);
		}
		
		public int getWordsDIPT() throws IOException{
			contador = 0;
			// creamos un StringBuffer donde almacenar las palabras
			StringBuffer aux = new StringBuffer();
			// mientras que el BufferedReader este listo seguira con la lectura
			while(br.ready()){
				// leemos la primera linea
				String s = br.readLine();
				s = s.toLowerCase();
				// recorremos todo el string
				for(int i=0; i<s.length(); i++){
					// en caso de que el caracter en el que nos encontramos sea una letra la introducimos al StringBuffer
					if(Character.isLetter(s.charAt(i)))
						aux.append(s.charAt(i));
					// si nos encontramos con un final de linea o un espacio en blanco significa final de palabra
					if(s.charAt(i)==' ' || i==(s.length()-1)){	
						if(aux.toString().indexOf("ui") || aux.toString().indexOf("au") || aux.toString().indexOf("eu")){
							contador++;
						}
						// reseteamos el StringBuffer para coger la siguiente palabra
						aux = new StringBuffer();
					}
				}
			}
			br.close();
			return contador;
		}
}
