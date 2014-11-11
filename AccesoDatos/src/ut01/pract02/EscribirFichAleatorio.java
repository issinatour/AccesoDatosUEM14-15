package ut01.pract02;

import java.io.*;

public class EscribirFichAleatorio {

	final static int NAME_LENGTH = 10;
	// arrays con los datos

	String nombre[] = { "Alejandro", "Patricia", "Nicolas", "Roberto",
			"Vladimir", "David", "Owen", "Carlos", "Miguel", " Javier",
			" David", " Issam", " Andrés", " Matías", " Daniel", " Guillermo" };
	// nombres

	int dep[] = { 10, 20, 10, 10, 30, 30, 10, 20, 10, 10, 30, 30, 10, 20, 10,
			10 }; // departamentos
	Double salario[] = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87,
			1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 2200.0, 1435.87,
			1000.45, 2400.60, 3000.0, }; // salarios

	public void writeEmployee(String path) {

		RandomAccessFile streamOut = null;

		try {
			streamOut = new RandomAccessFile(new File(path), "rw");

			StringBuffer buffer = null;// buffer para almacenar apellido
			int n = nombre.length;// numero de elementos del array
			for (int i = 0; i < n; i++) { // recorremos los arrays
				streamOut.writeInt(i + 1); // uso i+1 para identificar a los empleados
				buffer = new StringBuffer(nombre[i]);
				buffer.setLength(NAME_LENGTH); // 10 caracteres para los nombres
				streamOut.writeChars(buffer.toString());// insertar apellido
				streamOut.writeInt(dep[i]); // insertar departamento
				streamOut.writeDouble(salario[i]);// insertar salario
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			if(streamOut!=null)
				try {
					streamOut.close(); // cerramos el flujo
				} catch (IOException e) {					
				} 
		}
	}
}
