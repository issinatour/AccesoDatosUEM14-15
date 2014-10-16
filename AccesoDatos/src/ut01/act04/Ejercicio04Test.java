package ut01.act04;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ejercicio04Test {

	@Test
	public void contarPalabrasTest() {
		Ejercicio04 prueba = new Ejercicio04("resources/prueba4_05.txt");
	    assertEquals("error contando el numero de palabras", 16,prueba.contarPalabras() );
	}

}
