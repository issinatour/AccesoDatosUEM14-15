package ut01.act10;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Ejercicio04Test {
	private String ruta = "resources/Quijote.txt";
	@Test
	public void contarPalabrasCionTest() throws IOException {
		Ejercicio04 obj = new Ejercicio04(ruta);
		assertNotNull("El dato es nulo", obj.getWordsTRIP());
		obj = new Ejercicio04(ruta);
		assertEquals("El dato es erroneo", 5, obj.getWordsTRIP());
	}

}
