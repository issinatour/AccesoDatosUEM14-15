package ut01.random;
import java.io.*;

public class LeerFichAleatorio {
	
	

	public  void printEmployee(String path) {
		
		// declara el fichero de acceso aleatorio
		RandomAccessFile streamIn = null;
		
		try {
			streamIn = new RandomAccessFile(new File (path), "r");
		
		//variables para leer los datos
		int id, dep, posicion;
		Double salario;
		char nombre[] = new char[10], aux;
		
		posicion = 0; //para situarnos al principio
		do{ // recorremos los arrays
			streamIn.seek(posicion); //nos posición 
			id=streamIn.readInt(); //leemos el id de empleado
			for (int i = 0; i < nombre.length; i++){
				aux = streamIn.readChar();//recorremos uno a uno los caracteres del apellido
				if ((int)aux!=0) nombre[i] = aux;
				else nombre[i]=' '; //los vamos guardando en el array
				//System.out.println((int)aux);
			}	
			String nombreS = new String(nombre); // convertimos a String el array
			dep=streamIn.readInt();//obtenemos el dep
			salario=streamIn.readDouble(); //obtenemos el salario
			
			System.out.println("ID: " + id + ", Apellido: "+ nombreS + "," +
					" Departamento: "+dep + ", Salario: " + salario);
			posicion = posicion + 36; // nos situamos en el siguiente registro del empleado
									  // Cada empleado ocupa 36 bytes (4+20+4+8)
			// Si he recorrido todos los bytes salimos del while
		} while (streamIn.getFilePointer()!=streamIn.length());
		} catch (FileNotFoundException e) {		
		} catch (IOException e) {			
		}
		finally{
		if(streamIn!=null)
			try {
				streamIn.close();//cerramos el flujo
			} catch (IOException e) {			
			} 
		}
	}
}

