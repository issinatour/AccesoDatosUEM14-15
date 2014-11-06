package ut01.act04;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Ejercicio04Test {
	private String ruta = "resources/Quijote.txt";
	
	/*
	@Test
	public void contarPalabrasCionTest() throws IOException {
		Ejercicio04 obj = new Ejercicio04(ruta);
		assertNotNull("El dato es nulo", obj.getWordsTRIP());
		obj = new Ejercicio04(ruta);
		assertEquals("El dato es erroneo", 5, obj.getWordsTRIP());
	}
	*/
	
	@Test
	public void testIsVowel(){
		Ejercicio04 obj = new Ejercicio04();
		assertTrue(obj.isVowel('a'));
		assertTrue(obj.isVowel('e'));
		assertTrue(obj.isVowel('i'));
		assertTrue(obj.isVowel('o'));
		assertTrue(obj.isVowel('i'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('A'));
		assertTrue(obj.isVowel('E'));
		assertTrue(obj.isVowel('I'));
		assertTrue(obj.isVowel('O'));
		assertTrue(obj.isVowel('U'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertTrue(obj.isVowel('�'));
		assertFalse(obj.isVowel('X'));
		assertFalse(obj.isVowel('�'));
		assertFalse(obj.isVowel('s'));
		assertFalse(obj.isVowel(' '));
	}
	
	@Test
	public void testhaveThreeVocals(){
		Ejercicio04 obj = new Ejercicio04();
		assertTrue(obj.haveThreeVocals("ARRECI�IS"));
		assertTrue(obj.haveThreeVocals("Acahual"));
		assertTrue(obj.haveThreeVocals("Camag�ey"));
		assertTrue(obj.haveThreeVocals("Apremi�is"));
		assertTrue(obj.haveThreeVocals("Semiautom�tico"));
		assertFalse(obj.haveThreeVocals("Hoy"));
		assertFalse(obj.haveThreeVocals("noesuntriiptongo"));
		assertFalse(obj.haveThreeVocals("hola"));
		assertFalse(obj.haveThreeVocals("androide"));
	}

}
