package ut01.act04;

public class Main {

	final static String path = "./resources/Quijote.txt";
	
	public static void main(String[] args) {
		Ejercicio04 e = new Ejercicio04();
		
		System.out.println(e.countWords(path, "jueves"));

	}

}
