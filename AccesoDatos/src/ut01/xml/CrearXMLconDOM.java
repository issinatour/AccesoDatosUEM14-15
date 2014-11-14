package ut01.xml;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.util.Date;

public class CrearXMLconDOM {

	// Inserci�n de los datos del empleado
	static void CrearElemento(String datoEmple, String valor, Element raiz,
			Document document) {
		// Para crear el nodo hijo (<id>, <nombre>, <dep> y <salario>),se escribe
		Element elem = document.createElement(datoEmple); 
		
		//Para a�adir su valor se usa el m�todo createTextNode(String)
		Text text = document.createTextNode(valor); 
		
		//A continuaci�n se a�ade el nodo hijo a la ra�z(empleado)
		// y su texto o valor al nodo hijo
		raiz.appendChild(elem); // pegamos el elemento hijo a la ra�z
		elem.appendChild(text); // pegamos el valor
	}

	public static void main(String[] args) throws IOException {
		File fichero = new File("./resources/employee.bin");
		// declara el fichero de acceso aleatorio
		RandomAccessFile streamIn = new RandomAccessFile(fichero, "r");
		// variables para leer los datos
		int id, dep;
		Double salario;
		char nombre[] = new char[10], aux;

		// crearemos una instancia de DocumentBuilderFactory para construir el
		// parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			// Necesita encerrarse entre try-catch porque puede producirse una
			// excepci�n ParserConfigurationException
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			// Creamos un documento vac�o de nombre document con el nodo ra�z
			// de nombre Empleados
			Document document = implementation.createDocument(null,
					"Empleados", null);

			// asignamos la versi�n de nuestro XML
			document.setXmlVersion("1.0");

			do { // recorremos el fichero aleatorio secuencialmente
					// leemos la informaci�n del empleado del registro

				id = streamIn.readInt(); // leemos el id de empleado
				for (int i = 0; i < nombre.length; i++) {
					aux = streamIn.readChar();// recorremos uno a uno los caracteres
											// del apellido
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

				if (id > 0) { // validamos a partir de 1

					// Creamos el nodo <empleado> al documento
					Element raiz = document.createElement("empleado");
					// lo "pegamos" a la ra�z del documento
					document.getDocumentElement().appendChild(raiz);

					// Despu�s a�adiremos los hijos de ese nodo (ra�z), mediante
					// la funci�n CrearElemento()
					CrearElemento("emp_no", Integer.toString(id), raiz,
							document);// A�adir ID
					CrearElemento("nombre", nombreS.trim(), raiz, document);// A�adir
																			// apellido
					CrearElemento("apellido", nombreS.trim(), raiz, document);// A�adir
																				// apellido
					CrearElemento("job", Integer.toString(dep), raiz, document); // A�adir
																					// departamento
					CrearElemento("fecha", nombreS.trim(), raiz, document);// A�adir
																			// apellido
					CrearElemento("salario", Double.toString(salario), raiz,
							document); // A�adir salario
					CrearElemento("comision", Double.toString(salario), raiz,
							document); // A�adir salario
					CrearElemento("dep", Integer.toString(dep), raiz, document); // A�adir
																					// departamento
				}

				// Si he recorrido todos los bytes salimos del while
			} while (streamIn.getFilePointer() < streamIn.length());

			// Creamos la fuente XML a partir del documento
			Source source = new DOMSource(document);

			// Creamos el resultado en el fichero Empleados.xml
			Result result = new StreamResult(new java.io.File(
					"./resources/xml/Empleados.xml"));

			// Obtenemos un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			// Le damos formato y realizamos la transformaci�n del documento a
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

		
		} catch (ParserConfigurationException e) {
			
		} catch (TransformerException e) {
		
		}
		finally{
			if(streamIn!=null)
				streamIn.close(); // cerramos el fichero
		}
	}

}
