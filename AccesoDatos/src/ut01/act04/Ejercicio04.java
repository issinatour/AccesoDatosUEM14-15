package ut01.act04;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {
	String ruta="./resources/Quijote.txt";
	public int cuentaPalabra(String ruta){
		Scanner scan=new Scanner(System.in);
		String palabra="";
		File f=new File(ruta);
		System.out.println("introduce una palabra para buscar:");
		palabra=scan.next();
		int contador=0;
		
		if(f.isFile()){
			FileReader fr=null;//
			int letra;
			try{
				fr= new FileReader(f);
				String pal="";
				while((letra=fr.read())!=-1){
					char caracterleido= (char) letra;
					if(Character.isLetter(caracterleido)){
						pal+=letra;
					         
					}else{
						if(caracterleido==' '){
							if(pal.equals(palabra)){
							contador++;	
							}
						}
					}
					
			   }
				
			}catch(IOException e){
				
				System.err.println();
			}
		scan.close();
		}
	return contador;
	}
}