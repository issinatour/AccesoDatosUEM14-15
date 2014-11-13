package ut01.xml;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.util.Date;

public class CrearXMLconDOM {

	// Inserción de los datos del empleado
	static void CrearElemento(String datoEmple, String valor, Element raiz,
			Document document) {
		// Para crear el nodo hijo (<id>, <nombre>, <dep> y <salario>),se escribe
		Element elem = document.createElement(datoEmple); 
		
		//Para añadir su valor se usa el método createTextNode(String)
		Text text = document.createTextNode(valor); 
		
		//A continuación se añade el nodo hijo a la raíz(empleado)
		// y su texto o valor al nodo hijo
		raiz.appendChild(elem); // pegamos el elemento hijo a la raíz
		elem.appendChild(text); // pegamos el valor
	}

	public static void main(String[] args) throws IOException {
		File fichero = new File("./resources/employee.bin");
		// declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		// variables para leer los datos
		int id, dep;
		Double salario;
		char nombre[] = new char[10], aux;

		// crearemos una instancia de DocumentBuilderFactory para construir el
		// parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			// Necesita encerrarse entre try-catch porque puede producirse una
			// excepción ParserConfigurationException
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			// Creamos un documento vacío de nombre document con el nodo raíz
			// de nombre Empleados
			Document document = implementation.createDocument(null,
					"Empleados", null);

			// asignamos la versión de nuestro XML
			document.setXmlVersion("1.0");

			do { // recorremos el fichero aleatorio secuencialmente
					// leemos la información del empleado del registro

				id = file.readInt(); // leemos el id de empleado
				for (int i = 0; i < nombre.length; i++) {
					aux = file.readChar();// recorremos uno a uno los caracteres
											// del apellido
					if ((int) aux != 0)
						nombre[i] = aux;
					else
						nombre[i] = ' '; // los vamos guardando en el array
					// System.out.println((int)aux);
				}
				String nombreS = new String(nombre); // convertimos a String el
														// array
				dep = file.readInt();// obtenemos el dep
				salario = file.readDouble(); // obtenemos el salario

				if (id > 0) { // validamos a partir de 1

					// Creamos el nodo <empleado> al documento
					Element raiz = document.createElement("empleado");
					// lo "pegamos" a la raíz del documento
					document.getDocumentElement().appendChild(raiz);

					// Después añadiremos los hijos de ese nodo (raíz), mediante
					// la función CrearElemento()
					CrearElemento("emp_no", Integer.toString(id), raiz,
							document);// Añadir ID
					CrearElemento("nombre", nombreS.trim(), raiz, document);// Añadir
																			// apellido
					CrearElemento("apellido", nombreS.trim(), raiz, document);// Añadir
																				// apellido
					CrearElemento("job", Integer.toString(dep), raiz, document); // Añadir
																					// departamento
					CrearElemento("fecha", nombreS.trim(), raiz, document);// Añadir
																			// apellido
					CrearElemento("salario", Double.toString(salario), raiz,
							document); // Añadir salario
					CrearElemento("comision", Double.toString(salario), raiz,
							document); // Añadir salario
					CrearElemento("dep", Integer.toString(dep), raiz, document); // Añadir
																					// departamento
				}

				// Si he recorrido todos los bytes salimos del while
			} while (file.getFilePointer() != file.length());

			// Creamos la fuente XML a partir del documento
			Source source = new DOMSource(document);

			// Creamos el resultado en el fichero Empleados.xml
			Result result = new StreamResult(new java.io.File(
					"./resources/xml/Empleados.xml"));

			// Obtenemos un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			// Le damos formato y realizamos la transformación del documento a
			// fichero
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);

			// Mostramos el documento por pantalla especificando
			// el canal de salida el System.out
			Result console = new StreamResult(System.out);
			transformer.transform(source, console);

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		finally{
			if(file!=null)
				file.close(); // cerramos el fichero
		}
	}

}
