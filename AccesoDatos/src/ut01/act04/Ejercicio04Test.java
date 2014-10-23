package ut01.act04;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ejercicio04Test {

	final static String path = "./resources/Quijote.txt";

	@Test
	public void testIsLetter() {
		Ejercicio04 e = new Ejercicio04();
	
		for(char letra='a'; letra <'z';letra++)
			assertTrue("Prueba de la a la z",e.isLetter(letra));
		
		assertTrue("Prueba con á",e.isLetter('á'));
		assertTrue("Prueba con Ñ",e.isLetter('Ñ'));
		assertTrue("Prueba con ü",e.isLetter('ü'));
		assertFalse("Prueba con @",e.isLetter('@'));
		assertFalse("Prueba con .",e.isLetter('.'));
		assertFalse("Prueba con $",e.isLetter('$'));
		assertFalse("Prueba con 1",e.isLetter('1'));

		
	}
	
	@Test
	public void testCountWords() {
		Ejercicio04 e = new Ejercicio04();
	
		
		
		assertEquals("Prueba con jueves",1,e.countWords(path, "jueves"));
		assertEquals("Prueba con jarrrr",0,e.countWords(path, "jarrrrr"));
		assertEquals("Prueba con null",0,e.countWords(path, null));
		assertEquals("Prueba con .",0,e.countWords(path, "."));


		
	}

}
