package ut01.act04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Quijote {

	/*
	 * private static boolean esCaracter(char c){ return ((char)c>='a' &&
	 * (char)c<='z' || (char)c>='A' && (char)c<='Z' || (char)c>='ï¿½' &&
	 * (char)c<='ï¿½' || (char)c>='ï¿½' && (char)c<='ï¿½'); }
	 */
	/*
	 * todas incluidas minï¿½sculas, mayï¿½sculas, acentuadas, etc., pero no los
	 * signos de puntuaciï¿½n, cifras y otros caracteres
	 */

	private static int esVocal(char c) {
		
		return "áéíóú".indexOf(Character.toLowerCase(c));
	}

	private static boolean esPentaVocalica(String p) {
		int[] vocal = new int[5];
		int pos;
		

		for (int i = 0; i < p.length(); i++) {

			pos = esVocal(p.charAt(i));
			if (pos!=-1)
				vocal[pos]++;
			
		}
		for (int i = 0; i < 5; i++) {
			if(vocal[i]<1) return false;
		}
			return true;
	
	}

		
	private static boolean esAcentuada(char c) {
	
		

	/*	switch (Character.toUpperCase(c)) {

		case 'ï¿½':
			;
		case 'ï¿½':
			;
		case 'ï¿½':
			;
		case 'ï¿½':
			;
		case 'ï¿½':
			;
		case 'ï¿½':
			;
		case 'ï¿½':
			;
			return true;
		default:
			return false;
		}
*/
		
		return true;
	}

	private static boolean esCaracterMayus(char c) {
		
		return Character.isUpperCase(c);
	}



	private static boolean esCaracter(char c) {

		//return (esCaracterMayus(c) || esCaracterMinus(c) || esAcentuada(c));
		return Character.isLetter(c);

	}

	public static String[] diptongos(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;

		boolean esVocal = false;
		boolean esPalabra = false;
		boolean esDiptongo = false;

		String[] mDiptongos = new String[ejercicio14(nombrefichero)];
		String diptongo = "";
		String palabra = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;
			int j = 0;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {

					// Nueva palabra
					if (!esPalabra) {
						esPalabra = true;
						palabra += (char) i;
						// Posible diptongo
						if (esVocal((char) i) != -1) {
							esVocal = true;
							diptongo += (char) i;
						}

					}
					// continua palabra
					else {
						palabra += (char) i;

						if (esVocal((char) i) != -1) {
							// Posible diptongo
							if (!esVocal) {
								esVocal = true;
								diptongo += (char) i;
							}
							// Diptongo
							else {
								diptongo += (char) i;
								if (!palabra.toUpperCase().contains(
										"Q" + diptongo.toUpperCase())) {
									esDiptongo = true;
								}
								esVocal = false;
								diptongo = "";
							}

						}
						// descarta diptongo
						else if (esVocal) {
							esVocal = false;
							diptongo = "";
						}
					}

					// System.out.print((char) i);
				}
				// Termina palabra
				else if (esPalabra) {
					// if (esDiptongo) System.out.println(palabra);
					if (esDiptongo) {
						// System.out.println(palabra);
						mDiptongos[j] = palabra;
						j++;
						esDiptongo = false;
					}

					esPalabra = false;
					esVocal = false;
					diptongo = "";
					palabra = "";
				}

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return mDiptongos;
	}

	/*
	 * Se tiene en el directorio de trabajo el fichero de texto ï¿½QUIJOTE.TXTï¿½
	 * que contiene letras mayï¿½sculas y minï¿½sculas, con o sin acento o diï¿½resis,
	 * cifras y demï¿½s caracteres imprimibles posibles, ademï¿½s de fines de lï¿½nea
	 * y fin de fichero. Contar y mostrar en pantalla el nï¿½mero de caracteres
	 */

	public static int ejercicio8(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		int i;

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			while ((i = fr.read()) != -1)
				if ((char) i != ' ')
					++contar;

			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/* Contar el nï¿½mero de letras minï¿½sculas puras (sin acentuar ni diï¿½resis). */
	public static int ejercicio9(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char)i) && !esCaracterMayus((char)i)) {
					++contar;
				}
				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/*
	 * Contar el nï¿½mero de letras (todas incluidas minï¿½sculas, mayï¿½sculas,
	 * acentuadas, etc., pero no los signos de puntuaciï¿½n, cifras y otros
	 * caracteres)
	 */

	public static int ejercicio10(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i))
					++contar;

				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	// contar nï¿½mero de lï¿½neas
	/*
	 * public static int ejercicio11(String nombrefichero) {
	 * 
	 * File fichero = new File(nombrefichero); FileReader fr = null; int contar
	 * = 0;
	 * 
	 * 
	 * // Declaramos el fichero try { fr = new FileReader(fichero); // Creamos
	 * el flujo de entrada int i;
	 * 
	 * while ((i = fr.read()) != -1){ // se va leyendo un carï¿½cter if
	 * ((char)i=='\n') { //System.out.print((char) i); ++contar; }
	 * //System.out.print((char) i);
	 * 
	 * } fr.close(); // cerramos el fichero } catch (FileNotFoundException fnfe)
	 * { System.out.println("El fichero " + nombrefichero + " no se encuentra");
	 * } catch (IOException ioe) { System.out
	 * .println("El disco estï¿½ lleno o protegido contra escritura "); } return
	 * contar; }
	 */

	public static int ejercicio11(String nombrefichero) {
		int contador = 0;
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(nombrefichero));

			while (br.readLine() != null) {
				contador++;
			}
		} catch (IOException ioe) {

		}

		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contador;

	}

	public static boolean contieneCion(String p) {

		final String CION = "CION";
		final String CION2 = "CIï¿½N";

		if (p.length() < 4)
			return false;

		String ult3pal = "";

		for (int i = -4; i < 0; i++)
			ult3pal += p.charAt(p.length() + i);

		ult3pal = ult3pal.toUpperCase();
		// ult3pal+=p.charAt(p.length()-4)+p.charAt(p.length()-3)+p.charAt(p.length()-2)+p.charAt(p.length()-1);

		for (int i = 0; i < 4; i++) {
			if (CION.charAt(i) != ult3pal.charAt(i)
					&& CION2.charAt(i) != ult3pal.charAt(i))
				return false;
		}

		return true;

	}

	// contar nï¿½mero de palabras
	public static int ejercicio12(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		boolean palabra = false;
		String pal = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {
					
					if (!palabra) {
						palabra = true;
						pal = pal + (char) i;
						// ++contar;
					} else
						pal += (char) i;
				} else if (palabra) {
					//if (contieneCion(pal))
					contar++;
					palabra = false;
					System.out.print("pal");
					pal = "";
				}
				 //System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/*
	 * ï¿½dem. Contar el nï¿½mero de palabras terminadas en ï¿½cionï¿½ (con o sin
	 * acentos, en minï¿½sculas o mayï¿½sculas).
	 */
	public static int ejercicio13(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		boolean EsPalabra = false;
		String palabra = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {

					if (!EsPalabra) {
						EsPalabra = true;
						palabra += (char) i;
					} else
						palabra += (char) i;

				} else if (EsPalabra) {
					// System.out.println(palabra);
					palabra += " ";
					if (palabra.toUpperCase().contains("CION ")
							|| palabra.toUpperCase().contains("CIï¿½N ")) {
						// System.out.println(palabra);
						++contar;
					}
					EsPalabra = false;
					palabra = "";
				}
				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/*
	 * 14. ï¿½dem. Contar el nï¿½mero de diptongos (ojo con los acentos que deshacen
	 * diptongos).
	 */

	public static int ejercicio14(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		boolean leeVocal = false;
		boolean esPalabra = false;
		boolean esDiptongo = false;

		String diptongo = "";
		String palabra = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {

					// Nueva palabra
					if (!esPalabra) {
						esPalabra = true;
						palabra += (char) i;
						// Posible diptongo
						if (esVocal((char) i) != -1) {
							leeVocal = true;
							diptongo += (char) i;
						}

					}
					// continua palabra
					else {
						palabra += (char) i;

						if (esVocal((char) i) != -1) {
							// Posible diptongo
							if (!leeVocal) {
								leeVocal = true;
								diptongo += (char) i;
							}
							// Diptongo
							else {
								diptongo += (char) i;
								// los diptongos de la q no cuentan
								if (!palabra.toUpperCase().contains(
										"Q" + diptongo.toUpperCase())) {
									esDiptongo = true;
									++contar;
								}
								leeVocal = false;
								diptongo = "";
							}

						}
						// descarta diptongo
						else {
							leeVocal = false;
							diptongo = "";
						}
					}

					// System.out.print((char) i);
				}
				// Termina palabra
				else if (esPalabra) {
					if (esDiptongo) { // System.out.println(palabra);
						esDiptongo = false;
					}
					esPalabra = false;
					leeVocal = false;
					diptongo = "";
					palabra = "";
				}

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/*
	 * 15. ï¿½dem. Obtener y mostrar la palabra mï¿½s larga, su nï¿½mero de letras y
	 * su posiciï¿½n (nï¿½mero de orden en la secuencia de palabras). Si hay mï¿½s de
	 * una se toma la primera. Nota: El nï¿½mero de orden o posiciï¿½n de la palabra
	 * en el texto es el lugar que ocupa, una vez contadas todas. El Quijote
	 * tiene unas 380.000 palabras, como sabremos por ejerc. 12.
	 */
	public static void ejercicio15(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0, posicion = 0;

		boolean esPalabra = false;
		String palabra = "";
		String palabraMasLarga = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {
					if (!esPalabra) {
						esPalabra = true;
						palabra += (char) i;
						++contar;
					} else
						palabra += (char) i;

				} else if (esPalabra) {
					if (palabra.length() > palabraMasLarga.length()) {
						posicion = contar;
						palabraMasLarga = palabra;
					}
					palabra = "";
					esPalabra = false;
				}
				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		System.out.println("la palabra mï¿½s larga es \"" + palabraMasLarga
				+ "\" de " + palabraMasLarga.length()
				+ " letras, y estï¿½ en la palabra nï¿½mero " + posicion);
	}

	/*
	 * 16. ï¿½dem. Encontrar la primera palabra que tiene un triptongo. Decir quï¿½
	 * numero tiene en la secuencia de palabras.
	 */

	public static int ejercicio16(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		boolean leePrimeraVocal = false;
		boolean leeSegundaVocal = false;
		boolean esPalabra = false;
		boolean esTriptongo = false;

		String triptongo = "";
		String palabra = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {

					// Nueva palabra
					if (!esPalabra) {
						esPalabra = true;
						palabra += (char) i;
						// Posible diptongo
						if (esVocal((char) i) != -1) {
							leePrimeraVocal = true;
							triptongo += (char) i;
						}

					}
					// continua palabra
					else {
						palabra += (char) i;

						if (esVocal((char) i) != -1) {
							// Posible diptongo
							if (!leePrimeraVocal) {
								leePrimeraVocal = true;
								triptongo += (char) i;
							} else if (!leeSegundaVocal) {
								leeSegundaVocal = true;
								triptongo += (char) i;
							}
							// Triptongo
							else {
								triptongo += (char) i;
								// los diptongos de la q no cuentan
								if (!palabra.toUpperCase().contains(
										"Q" + triptongo.toUpperCase())) {
									esTriptongo = true;
									++contar;
								}
								leePrimeraVocal = false;
								leeSegundaVocal = false;
								triptongo = "";
							}

						}
						// descarta diptongo
						else {
							leePrimeraVocal = false;
							leeSegundaVocal = false;
							triptongo = "";
						}
					}

					// System.out.print((char) i);
				}
				// Termina palabra
				else if (esPalabra) {
					if (esTriptongo) {
						// System.out.println(palabra);
						esTriptongo = false;
					}
					esPalabra = false;
					leePrimeraVocal = false;
					leeSegundaVocal = false;
					triptongo = "";
					palabra = "";
				}

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/*
	 * 17. ï¿½dem. Encontrar la primera palabra pentavocï¿½lica. Decir quï¿½ nï¿½mero
	 * tiene en la secuencia.
	 */

	public static void ejercicio17(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		boolean EsPalabra = false;
		String palabra = "";
		int posicion = 0;

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {
					if (!EsPalabra) {
						++posicion;
						EsPalabra = true;
						palabra += (char) i;
					} else
						palabra += (char) i;

				} else if (EsPalabra) {
					if (esPentaVocalica(palabra))
						break;
					palabra = "";
					EsPalabra = false;
				}
				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		System.out.println("la primera palabra pentavocï¿½lica es \"" + palabra
				+ "\" y es la palabra nï¿½mero " + posicion);
	}

	/*
	 * 18. ï¿½dem. Contar y mostrar el nï¿½mero total de palabras pentavocï¿½licas.
	 */

	public static int ejercicio18(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		boolean EsPalabra = false;
		String palabra = "";

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {
					if (!EsPalabra) {
						EsPalabra = true;
						palabra += (char) i;
					} else
						palabra += (char) i;

				} else if (EsPalabra) {
					if (esPentaVocalica(palabra)) {
						System.out.println(palabra);
						contar++;
					}
					palabra = "";

					EsPalabra = false;
				}
				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return contar;
	}

	/*
	 * 19. ï¿½dem. Colocar en un array todas las palabras pentavocï¿½licas, sin
	 * repetirlas, mostrar la lista ordenada de todas ellas. Nota: Se supone
	 * suficiente con un array para 300 palabras.
	 */

	public static String[] ejercicio19(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;
		boolean EsPalabra = false;
		String palabra = "";
		String[] palabras = new String[300];

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un carï¿½cter
				if (esCaracter((char) i)) {
					if (!EsPalabra) {
						EsPalabra = true;
						palabra += (char) i;
					} else
						palabra += (char) i;

				} else if (EsPalabra) {
					if (esPentaVocalica(palabra)) {
						palabras[contar] = palabra;
						contar++;
					}
					palabra = "";

					EsPalabra = false;
				}
				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}
		return palabras;
	}

	/*
	 * 20. ï¿½dem. Contar el nï¿½mero de veces que estï¿½ la palabra que previamente
	 * se introduce por teclado. Nota: Hacer recorridos sucesivos con diferentes
	 * palabras mediante un bucle y no olvidarse que hay que ï¿½rebobinarï¿½ el
	 * fichero cada vez.
	 */

	public static void ejercicio20(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		BufferedReader br = null;
		int contar = 0;
		int i = 0;
		boolean EsPalabra = false;
		String palabra = "";
		String busqueda = "";
		Scanner sc = new Scanner(System.in);

		// Declaramos el fichero
		try {

			while (true) {
				fr = new FileReader(fichero); // Creamos el flujo de entrada
				br = new BufferedReader(fr);

				System.out.println("Introduce una palabra (q/Q para salir)");
				busqueda = sc.next();

				if (busqueda.toUpperCase().equals("Q"))
					break;
				while ((i = br.read()) != -1) {
					if (esCaracter((char) i)) {
						if (!EsPalabra) {
							EsPalabra = true;
							palabra += (char) i;
						} else
							palabra += (char) i;

					} else if (EsPalabra) {
						if (busqueda.equals(palabra)) {
							contar++;
						}
						palabra = "";
						EsPalabra = false;
					}
					// System.out.print((char) i);
				}

				System.out.println("La pabara " + busqueda + " aparece "
						+ contar + " veces.");
				contar = 0;

			}
			br.close(); // cerramos el fichero

		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}

	}

	/*
	 * 21. ï¿½dem. Obtener la frecuencia de las 5 vocales (nï¿½mero de veces que se
	 * repite cada vocal).
	 */

	public static void ejercicio21(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		BufferedReader br = null;
		int[] vocales = { 0, 0, 0, 0, 0 };
		int i = 0;

		// Declaramos el fichero
		try {

			fr = new FileReader(fichero); // Creamos el flujo de entrada
			br = new BufferedReader(fr);

			while ((i = br.read()) != -1) {
				if (esVocal((char) i) >= 0)
					vocales[esVocal((char) i)]++;
				// System.out.print((char) i);
			}

			br.close(); // cerramos el fichero

		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}

		for (i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				System.out.println(vocales[i] + " aes,");
				break;
			case 1:
				System.out.println(vocales[i] + " es,");
				break;

			case 2:
				System.out.println(vocales[i] + " ies,");
				break;

			case 3:
				System.out.println(vocales[i] + " os,");
				break;

			case 4:
				System.out.println(vocales[i] + " ues,");
				break;

			}
		}

	}

	/*
	 * 22. ï¿½dem. Obtener la frecuencia de las 27 letras del alfabeto y mostrar
	 * el resultado en orden descendente de frecuencia.
	 */

	static class Letra implements Comparable<Letra> {
		private char letra;
		private int num;

		public Letra(char l, int n) {
			this.letra = l;
			this.num = n;
		}

		public String toString() {
			return letra + " " + num;
		}

		@Override
		public int compareTo(Letra l) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			if (this.num < l.num)
				return AFTER;
			else
				return BEFORE;

		}
	}

	public static void ejercicio22(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		BufferedReader br = null;
		char letra;
		Set<Letra> listaAlfabeto = new TreeSet<Letra>();
		// a b c d e f g h i j k l m n ï¿½ o p q r s t u v w x y z

		int[]ascii = new int[500];
		int i = 0;
		
		// Declaramos el fichero
		try {

			fr = new FileReader(fichero); // Creamos el flujo de entrada
			br = new BufferedReader(fr);

			while ((i = br.read()) != -1) {
				letra = Character.toLowerCase((char) i);
				if (esCaracter(letra)) {
					ascii[Character.valueOf(letra)]++;
				}
				// System.out.print((char) i);
			}

			br.close(); // cerramos el fichero

		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco estï¿½ lleno o protegido contra escritura ");
		}

		// Burbuja.ordenar(ascii);

		for (i = 0; i < ascii.length; i++) {
			if (ascii[i] != 0){
				//System.out.println((char) i + " " + ascii[i]);
			    listaAlfabeto.add(new Letra( (char)i, ascii[i]) ) ;
			}
		}
		
		for(Letra l:listaAlfabeto)
			System.out.println(l.letra+" "+l.num);
			
			

	}

	/*
	 * 23. ï¿½dem. Obtener la frecuencia de los nombres de los dï¿½as de la semana
	 * (cuï¿½ntas veces se repite ï¿½lunesï¿½, etcï¿½tera) y mostrar el resultado en su
	 * orden natural.
	 */
	/*
	 * 24. ï¿½dem. Crear un nuevo fichero ï¿½DIPTONGO.TXTï¿½ con todas las palabras
	 * que contengan al menos un diptongo.
	 */
	public static void ejercicio24(String FicheroOrigen, String FicheroDestino) {

		String nombrefichero = FicheroDestino;
		String[] cadDiptongos = diptongos(FicheroOrigen);

		try {
			/*
			 * PrintWriter f = new PrintWriter ( new FileWriter(nombrefichero));
			 */
			PrintWriter f = new PrintWriter(FicheroDestino);

			for (int i = 0; i < cadDiptongos.length; i++)
				if (cadDiptongos[i] != null)
					f.println(cadDiptongos[i]);

			f.close();
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}
	}

	/*
	 * 
	 * 25. ï¿½dem. Crear un nuevo fichero ï¿½QUIMAYUS.TXTï¿½ con el mismo texto
	 * completo, pero con todas las letras en mayï¿½sculas, quitando los posibles
	 * acentos o diï¿½resis que pueda haber.
	 */

	/*
	 * 26. ï¿½dem. Crear dos ficheros ï¿½PALMAYUS.TXTï¿½ y ï¿½PALMINUS.TXTï¿½, con todas
	 * las palabras que empiezan por letra mayï¿½scula y minï¿½scula,
	 * respectivamente (cada palabra en una lï¿½nea). Mostrar en pantalla el
	 * nï¿½mero de letras y palabras de ambos ficheros.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fichero = "./resources/Quijote.txt";
		String ficheroDiptongos = "D:\\DIPTONGO.txt";
		String[] palabras;
	
/*
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio8(fichero) + " caracteres");
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio9(fichero) + " minusculas puras");
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio10(fichero) + " carï¿½cteres min. may. y acentuadas");
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio11(fichero) + " lineas");
				
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio12(fichero) + " palabras");
		
		
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio13(fichero) + " palabras terminadas en cion");
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio14(fichero) + " diptongos");
		ejercicio15(fichero);
		System.out.println("Leyendo diptongos de " + fichero
				+ " y guardï¿½ndolos en " + ficheroDiptongos);
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio16(fichero) + " triptongos");
		ejercicio17(fichero);
		*/
		System.out.println("El fichero " + fichero + " tiene "
				+ ejercicio18(fichero) + " pentavocï¿½licas.");
/*
		palabras = ejercicio19(fichero);
		Burbuja.ordenarStr(palabras);

		
		 ejercicio22(fichero);
		 ejercicio24(fichero, ficheroDiptongos);
*/
	}

}
