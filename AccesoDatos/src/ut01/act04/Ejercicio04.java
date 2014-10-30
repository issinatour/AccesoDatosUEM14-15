package ut01.act04;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;


public class Act19 {
	String cadena= "/n";
	String txt="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Act19();
	}
		public Act19(){
			leerArchivo();
			guardarArchivo();
		
	}
		
		
		private void leerArchivo() {
			// TODO Auto-generated method stub
			File archivo = new File("QUIMAYUS.txt");
			try{
	               BufferedReader entrada = new BufferedReader(new FileReader(cadena));
	               StringBuffer bufer = new StringBuffer();
	               while (( cadena = entrada.readLine() ) != null) 
	                  bufer.append(cadena + "\n");
	 
	               cadena = bufer.toString();
	               System.out.println(cadena);
	 
	               cadena = cadena.toUpperCase();
	               System.out.println("\n" +cadena);
	           }
	           catch(IOException e)
	           {
	               System.out.println(e);
	           }
		}
		private void guardarArchivo() {
			// TODO Auto-generated method stub
			try { 
			    BufferedReader lectura = new BufferedReader(new StringReader(cadena));
			    PrintWriter escribir = new PrintWriter(new BufferedWriter(new FileWriter("QUIMAYUS.txt")));
			    while ((txt = lectura.readLine()) != null) 
				escribir.println(txt);
			    escribir.close();
			} catch (Exception e) { 
			    System.out.println("Final");
			}
	   }
}



