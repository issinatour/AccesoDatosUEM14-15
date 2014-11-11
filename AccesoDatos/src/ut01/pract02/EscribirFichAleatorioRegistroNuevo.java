package ut01.pract02;

import java.io.*;

public class EscribirFichAleatorioRegistroNuevo {

	final static int RECORD_SIZE = 36;
	final static int NAME_SIZE = 10;

	public void addEmployee(String path, String nombre, int dep, int id,
			double salario) {
		// declara el fichero de acceso aleatorio
		RandomAccessFile sourceOut = null;

		try {
			sourceOut = new RandomAccessFile(new File(path), "rw");
			// arrays con los datos

			StringBuffer buffer = null;// buffer para almacenar apellido

			long posicion = (id - 1) * RECORD_SIZE; // calculamos la posición
			sourceOut.seek(posicion); // nos posicionamos

			sourceOut.writeInt(id); // identificar del empleado
			buffer = new StringBuffer(nombre);
			buffer.setLength(NAME_SIZE); // 10 caracteres para los nombres
			sourceOut.writeChars(buffer.toString());// insertar apellido
			sourceOut.writeInt(dep); // insertar departamento
			sourceOut.writeDouble(salario);// insertar salario
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			try {
				sourceOut.close();
			} catch (IOException e) {
			} // cerramos el fichero
		}
	}
}
