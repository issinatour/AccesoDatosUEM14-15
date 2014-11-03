package ut01.act04;

	/* Crear dos ficheros “PALMAYUS.TXT” y “PALMINUS.TXT”, 
 * con todas las palabras que empiezan por letra mayúscula y minúscula, 
 * respectivamente (cada palabra en una línea).
 * 
 * */
	
	import java.io.File;
	import java.io.FileReader;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.StringReader;
	import java.io.PrintWriter;
	import java.io.BufferedWriter;
	import java.io.FileWriter;
	 
	public class Ejercicio04 {
	 
		//declaramos las variables
		private String texto="\n";
		private String txt="";
		public final int TAM_BUFFER = 1024;
		int numPentas = 0;
	
		//constructor con los dos metodos
		
	    public Ejercicio04() {
	    	leerArchivo();
	    	guardarArchivo();
	    }
	 
	    //metodo que lee el archivo para realizar la seleccion mayusculas y minusculas
	    private void leerArchivo()
	   {
	      File nombre = new File("Quijote.txt");
	 
	         try{
	               BufferedReader entrada = new BufferedReader(new FileReader(nombre));
	               StringBuffer bufer = new StringBuffer();
	               while (( texto = entrada.readLine() ) != null) 
	                  bufer.append(texto + "\n");
	 
	               
	               //metodo que coje el caracter primero como mayuscula o minuscula, falta por implementar
	               
	               /*  if(Character.isUpperCase(letra)) 
          letra = Character.toLowerCase(letra);
     else 
          letra = Character.toUpperCase(letra); 

     System.out.println(letra); 
}  */
	               texto = bufer.toString();
	               System.out.println(texto);
	 
	               texto = texto.toUpperCase();
	               System.out.println("\n" +texto);
	           }
	           catch(IOException e)
	           {
	               System.out.println(e);
	           }
	   }
	 
	    //metodo para guardar la modificacion en el fichero
	   private void guardarArchivo()
	   {
		   	try { 
			    BufferedReader leer = new BufferedReader(
		                             new StringReader(texto));
			    PrintWriter escribir = new PrintWriter(new BufferedWriter(new FileWriter("PALMAYUS.txt")));
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

	public void findPentavocalica(String path)   {

		String sLinea;
		String sPalabra;

		// Cargamos el buffer con el contenido del archivo
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(
					"./resources/Quijote.txt"));
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
					
					if(isPentavocalica(sPalabra)){
						numPentas++;
						System.out.println("palabra ventavocalica: "+ sPalabra +", numero: "+numPentas);

					}
					

				}
			} while ((sLinea = br.readLine()) != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 
	}
