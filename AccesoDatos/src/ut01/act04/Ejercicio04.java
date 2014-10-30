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
	 
	}
