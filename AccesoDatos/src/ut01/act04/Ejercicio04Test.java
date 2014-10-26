import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;


public class Ejercicio04Test {

	Ejercicio04 Ejercicio04= new Ejercicio04();
	String ruta = "./resources/Quijote.txt";
	
	@Test
	public void getPalabraMasLargaTEST() {
		try {
			Ejercicio04.getPalabraMasLarga(ruta);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
