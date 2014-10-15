package ut01.act03;


public class Main {

	public static void main(String[] args) {
		Ejercicio03 e = new Ejercicio03();
		String ruta = "./resources/prueba03.txt";

		
		System.out.println(e.readTextFile(ruta));

	}

}
