package ut01.act06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Eje8 {
	
	/*
	static private int primerDigito(int x) {
	    while (x > 9) {
	        x /= 10;
	    }
	    return x;
	}*/

	static void fusionar(String n1, String n2, String n3) {
		try {

			File fichero1 = new File(n1);
			File fichero2 = new File(n2);
			File fichero3 = new File(n3);

			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero3));
			BufferedReader br1 = new BufferedReader(new FileReader(fichero1));
			BufferedReader br2 = new BufferedReader(new FileReader(fichero2));

			
			StringTokenizer tokens;
			String n;
			
			while ((n = br1.readLine()) != null){	
				
				tokens = new StringTokenizer(n);
				while(tokens.hasMoreElements())
					bw.write(tokens.nextToken()+" ");
				
			}
			
			br1.close();
			
			while ((n = br2.readLine()) != null){	
				
				tokens = new StringTokenizer(n);
				while(tokens.hasMoreElements())
					bw.write(tokens.nextToken()+" ");
				
			}
			
			
			br2.close();
			bw.close();


		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fusionar("./resources/ENTEROS1.TXT","./resources/ENTEROS2.TXT","./resources/ENTEROS3.TXT");

	}

}
