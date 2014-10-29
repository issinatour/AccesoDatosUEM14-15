package ut01.act04;

public class Main {

	final static String path = "./resources/Quijote.txt";
	
	public static void main(String[] args) {
		Ejercicio04 e = new Ejercicio04();
		
		System.out.println("Lunes aparece " + e.countWords(path, "lunes") + " veces en el texto.");
		System.out.println("Martes aparece " + e.countWords(path, "martes") + " veces en el texto.");
		System.out.println("Miercoles aparece " + e.countWords(path, "miercoles") + " veces en el texto.");
		System.out.println("Jueves aparece " + e.countWords(path, "jueves") + " veces en el texto.");
		System.out.println("Viernes aparece " + e.countWords(path, "viernes") + " veces en el texto.");
		System.out.println("Sabado aparece " + e.countWords(path, "sabado") + " veces en el texto.");
		System.out.println("Domingo aparece " + e.countWords(path, "domingo") + " veces en el texto.");

	}

}
