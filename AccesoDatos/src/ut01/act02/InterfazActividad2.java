package ut01.act02;

public interface InterfazActividad2 {
	

		/**
		 * indica si existe el fichero dado
		 * 
		 * @param ruta
		 * @return
		 */
		public boolean existeFichero(String ruta);

		/**
		 * devuelve en un array el nombre del fichero, la ruta absoluta, si tiene
		 * permisos de lectura, si tiene permisos de escritura, el tama�o en bytes y
		 * su directorio padre
		 * 
		 * @param ruta
		 * @return
		 */
		public String[] datosFicheros(String ruta);

		/**
		 * Devuelve la ruta absoluta de un fichero
		 * 
		 * @param rutaRelativa
		 * @return
		 */
		public String ruta(String rutaRelativa);

		/**
		 * Devuelve un array de Strings con los contenidos de un directorio, si no
		 * es un directorio devolver� un array con una cadena vac�a ""
		 * 
		 * @param ruta
		 * @return
		 */
		public String[] contenidoDirectorio(String ruta);

		/**
		 * Devuelve un array de Strings con los contenidos de un directorio con la
		 * extension dada de la ruta dada, si no es un directorio o no encuentra
		 * ning�n fichero con esa extensi�n devolver� un array con una cadena vac�a
		 * ""
		 * 
		 * @param ruta
		 * @param extension
		 * @return
		 */
		public String[] contenidoDirectorio(String ruta, String extension);

		/**
		 * Crea un directorio en la ruta dada, si se realiza correctamente devuelve
		 * true en caso contrario devuelve false
		 * 
		 * @param ruta
		 * @return
		 */
		public boolean creaDirectorio(String ruta);

		/**
		 * renombra un fichero en la ruta dada, si se realiza correctamente devuelve
		 * true en caso contrario devuelve false
		 * 
		 * @param ruta
		 * @param nombre
		 * @return
		 */
		public boolean renombraFichero(String ruta,String nombre); //

		/**
		 * crea un archivo vacio en la ruta actual, si se realiza correctamente
		 * devuelve true en caso contrario devuelve false
		 * 
		 * @param nombre
		 * @return
		 */
		public boolean touch(String nombre);

		/**
		 * crea un archivo vacio en la ruta indicada, si se realiza correctamente
		 * devuelve true en caso contrario devuelve false
		 * 
		 * @param ruta
		 * @param nombre
		 * @return
		 */
		public boolean touch(String ruta, String nombre);

		/**
		 * Lee una linea introducida por teclado usando la clase Scanner.
		 * 
		 * @return
		 */
		public String leerLinea();

		/**
		 * devuelve un array de Strings con los datos de un fichero con la clase
		 * Scanner que estan separados por separacion
		 * 
		 * @param Fichero
		 * @param separacion
		 * @return
		 */
		public String[] leerFichero(String Fichero, String separacion); //

		/**
		 * Hacer un programa que permita leer una linea de caracteres introducidos
		 * por teclado. Para aumentar el rendimiento utilizaremos un buffer.
		 * 
		 * @return
		 */
		public String leerLineaBuffer();
	}


