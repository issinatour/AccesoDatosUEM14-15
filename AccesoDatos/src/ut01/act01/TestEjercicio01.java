package ut01.act01;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestEjercicio01 {

	@Test
	public void testListarDirectorio01() {
		String rutaPrueba = "5";
		File f = new File(rutaPrueba);
		String[] contenido = f.list();
		Ejercicio01 eje = new Ejercicio01();
		assertArrayEquals("pruebo el contenido del directorio actual",
				contenido,eje.listarDirectorio(rutaPrueba));
		//
	}
	
	@Test
	public void testListarDirectorio02() {
		String[] vacio = new String[0];
		Ejercicio01 eje = new Ejercicio01();
		//assertArrayEquals("pruebo a pasar un directorio que no existe",
		//		vacio, eje.listarDirectorio("ola j ase"));
		assertNotNull("Compruebo que no es nulo si le paso un directorio que no existe",
				eje.listarDirectorio("ola ke ase"));
		//
	}

}
