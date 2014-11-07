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
	final static int TAM_RECORD = 4 + 20 + 4 + 8; // 36
	final static int TAM_MAX_FILE = TAM_RECORD*1000;

	public void readCSVfile(final String csvFile, final String randomFile) {

		Thread t = new Thread(new Runnable() {

			public void run() {

				BufferedReader streamIn = null;
				RandomAccessFile streamOut = null;
				String line;
				StringTokenizer st;
				StringBuffer sb;

				try {
					streamOut = new RandomAccessFile(randomFile, "rw");
					streamIn = new BufferedReader(new FileReader(csvFile));
					while ((line = streamIn.readLine()) != null) {
						// Leo el fichero csv y saco los datos
						st = new StringTokenizer(line, ";");
						while (st.hasMoreTokens()) {

							int id = Integer.parseInt(st.nextToken());
							streamOut.writeInt(id);// escribo en random id

							sb = new StringBuffer(st.nextToken());
							sb.setLength(TAM_NAME); // fijo a tam max 10
							String name = sb.toString();
							streamOut.writeChars(name); // nom bre
							int dep = Integer.parseInt(st.nextToken());
							streamOut.writeInt(dep);// departamento
							double salary = Double.parseDouble(st.nextToken());
							streamOut.writeDouble(salary);// salario

						}
					}

				} catch (FileNotFoundException e) {

				} catch (IOException e) {

				} finally {
					if (streamIn != null)
						try {
							streamIn.close();

						} catch (IOException e) {

						}
					if (streamOut != null)
						try {
							streamOut.close();

						} catch (IOException e) {

						}
				}

			}
		});
		t.start();

	}
	
	public  void modifyEmployee  (final String path, Employee emp)
			throws Exception {
		

		RandomAccessFile streamOut = null;
		
		StringBuilder sb;

		try {
			streamOut = new RandomAccessFile(path, "rw");
			
			// cojo la posición del registro
			int position = (emp.getId() - 1) * TAM_RECORD;
			
			// me posicion si existe el registro
			if (position < TAM_MAX_FILE)
				streamOut.seek(position);
			else
				throw new Exception("Tamaño de fichero excededido");
			
			streamOut.writeInt(emp.getId()); // escribo el id
			// me aseguro que voy a tener un array de char de 10 caracteres
			sb = new StringBuilder(emp.getName());
			sb.setLength(TAM_NAME);
			streamOut.writeChars(sb.toString());

			streamOut.writeInt(emp.getDep());
			streamOut.writeDouble(emp.getSalary());
			
		
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error E/S");

		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error E/S");
				}
		}


	}

	public Employee getEmployee(final String path, final int clave)
			throws Exception {
		Employee emp = new Employee();

		RandomAccessFile streamIn = null;
		int id, dep;
		double salary;
		String sName;
		char letter;
		char[] aCharName = new char[TAM_NAME];

		try {
			streamIn = new RandomAccessFile(path, "r");
			int position = (clave - 1) * TAM_RECORD;
			if (position < streamIn.length())
				streamIn.seek(position);
			else
				throw new Exception("Clave incorrecta");
			id = streamIn.readInt();
			for (int i = 0; i < TAM_NAME; i++) {
				letter = streamIn.readChar();
				if (letter != 0)
					aCharName[i] = letter;
				else
					aCharName[i] = ' ';
			}
				sName = new String(aCharName);
				dep = streamIn.readInt();
				salary = streamIn.readDouble();
				emp = new Employee(id, sName, dep, salary);
			

		} catch (FileNotFoundException e) {
		} catch (IOException e) {

		} finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
				}
		}

		return emp;
	}

	public void printEmployee(final String path) {

		Thread t = new Thread(new Runnable() {

			public void run() {
				// declara el fichero de acceso aleatorio
				RandomAccessFile streamIn = null;

				try {
					streamIn = new RandomAccessFile(new File(path), "r");

					// variables para leer los datos
					int id, dep;
					Double salario;
					char nombre[] = new char[TAM_NAME], aux;

					do { // recorremos los arrays
						id = streamIn.readInt(); // leemos el id de empleado
						for (int i = 0; i < TAM_NAME; i++) {
							aux = streamIn.readChar();// recorremos uno a uno
														// los
														// caracteres del
														// apellido
							if ((int) aux != 0)
								nombre[i] = aux;
							else
								nombre[i] = ' '; // los vamos guardando en el
													// array
							// System.out.println((int)aux);
						}
						String nombreS = new String(nombre); // convertimos a
																// String el
																// array
						dep = streamIn.readInt();// obtenemos el dep
						salario = streamIn.readDouble(); // obtenemos el salario

						if(id!=0)
						System.out.println("ID: " + id + ", Apellido: "
								+ nombreS + "," + " Departamento: " + dep
								+ ", Salario: " + salario);
						// posicion = posicion + 36; // nos situamos en el
						// siguiente
						// registro del empleado
						// Cada empleado ocupa 36 bytes (4+20+4+8)
						// Si he recorrido todos los bytes salimos del while

					} while (streamIn.getFilePointer() <= streamIn.length()); // leo
																				// hasta
																				// el
																				// final
																				// del
																				// fichero
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
		});
		t.start();

	}

}
