package ut01.xml;
import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;	
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeerXMLconSAX {

	public static void main(String[] args) 
					throws FileNotFoundException, IOException  {
		try{
			// Instanciamos el parser SAX
			XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
			
			// Objeto manejador de eventos
			GestionContenido gestor = new GestionContenido();
			// añadimos el manejador al parser
			procesadorXML.setContentHandler(gestor);
			
			// fichero xml para leer
			InputSource fileXML = new InputSource("./resources/xml/Discografica.xml");
			
			// analizamos el fichero
			procesadorXML.parse(fileXML);
			
		} catch (SAXException saxe) {}
	}
}// fin PruebaSax1

/**
 * Manejador de eventos SAX
 * 
 */
class GestionContenido extends DefaultHandler {
	public GestionContenido(){
		super();
	}
	
	@Override
	public void startDocument(){
		System.out.println("Comienzo del documento XML");
	}
	@Override
	public void endDocument(){
		System.out.println("Final del documento XML");
	}
	
	@Override
	public void startElement(String uri, String nombre,
			String nomobreC, Attributes atts){
		System.out.println("\tPrincipio Elemento:" + nombre);
	}
	
	public void endElement(String uri, String nombre,
			String nomobreC, Attributes atts) {
		System.out.println("\tFin Elemento:" + nombre);
	}
	
	@Override
	public void characters(char[] ch, int inicio, int longitud)	
			throws SAXException{
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]",""); // quitar saltos de l�nea
		System.out.println("\tCaracteres : "+car);
	}
} // fin GestionContenido

