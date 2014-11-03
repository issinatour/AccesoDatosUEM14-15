package ut01.act04;

public class Main {

	public static void main(String[] args) {
		String pathIn = "./resources/Quijote.txt";
		String pathOut = "./resources/PalabrasEmpiezanMayuscula.txt";
		Ejercicio04 e = new Ejercicio04();
		e.WordStartLowercaseFile(pathIn, pathOut,2);
	}

}
