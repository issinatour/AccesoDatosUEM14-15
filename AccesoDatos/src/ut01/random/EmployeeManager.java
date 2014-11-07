package ut01.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class EmployeeManager {

	final static int TAM_NAME = 10;

	public boolean readCSVfile(String csvFile, String randomFile) {

		BufferedReader streamIn = null;
		RandomAccessFile streamOut = null;
		String line;
		StringTokenizer st;
		StringBuilder sb;

		try {
			streamOut = new RandomAccessFile(randomFile, "rw");
			streamIn = new BufferedReader(new FileReader(csvFile));
			while ((line = streamIn.readLine()) != null) {
				// Leo el fichero csv y saco los datos
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {

					int id = Integer.parseInt(st.nextToken());
					streamOut.writeInt(id);// id
					String name;
					sb = new StringBuilder(st.nextToken());
					sb.setLength(TAM_NAME); // relleno los huecos
					name = sb.toString();
					streamOut.writeChars(name); // nom bre
					int dep = Integer.parseInt(st.nextToken());
					streamOut.writeInt(dep);// departamento
					double salary = Double.parseDouble(st.nextToken());
					streamOut.writeDouble(salary);// salario

				}
			}

		} catch (FileNotFoundException e) {
				return false;
		} catch (IOException e) {
			return false;

		} finally {
			if (streamIn != null)
				try {
					streamIn.close();

				} catch (IOException e) {
					return false;

				}
			if (streamOut != null)
				try {
					streamOut.close();

				} catch (IOException e) {
					return false;

				}
		}

		return true;

	}

	public void printEmployee(String path) {

		// declara el fichero de acceso aleatorio
		RandomAccessFile streamIn = null;

		try {
			streamIn = new RandomAccessFile(new File(path), "r");

			// variables para leer los datos
			int id, dep, posicion;
			Double salario;
			char nombre[] = new char[TAM_NAME], aux;

			do { // recorremos los arrays
				id = streamIn.readInt(); // leemos el id de empleado
				for (int i = 0; i < TAM_NAME; i++) {
					aux = streamIn.readChar();// recorremos uno a uno los
												// caracteres del apellido
					if ((int) aux != 0)
						nombre[i] = aux;
					else
						nombre[i] = ' '; // los vamos guardando en el array
					// System.out.println((int)aux);
				}
				String nombreS = new String(nombre); // convertimos a String el
														// array
				dep = streamIn.readInt();// obtenemos el dep
				salario = streamIn.readDouble(); // obtenemos el salario

				System.out.println("ID: " + id + ", Apellido: " + nombreS + ","
						+ " Departamento: " + dep + ", Salario: " + salario);
				// posicion = posicion + 36; // nos situamos en el siguiente
				// registro del empleado
				// Cada empleado ocupa 36 bytes (4+20+4+8)
				// Si he recorrido todos los bytes salimos del while

			} while (streamIn.getFilePointer() <= streamIn.length());
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			if (streamIn != null)
				try {
					streamIn.close();// cerramos el flujo
				} catch (IOException e) {
				}
		}
	}

}
