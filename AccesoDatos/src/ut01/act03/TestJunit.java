package ut01.act03;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestJunit {
	String ruta = "./resources/prueba03.txt";
	@Test
	public void testreadTextFile() {
		Ejercicio03 e = new Ejercicio03();
		String prueba = "ola ke ase!";
		String vacio = new String();
		assertEquals("prueba03.txt", prueba,e.readTextFile(ruta));
		
		assertEquals("fichero que no existe", vacio,e.readTextFile("prueba"));

	}
	
	@Test
	public void testreadTextFile02() {
		Ejercicio03 e = new Ejercicio03();
		String prueba = new String();
		
		assertEquals("fichero que no existe", prueba,e.readTextFile("prueba"));

	}

}
