package programa;

// ? Importamos la clase Scanner y Locale
import java.util.Scanner;
import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		// ^ Definimos una instancia de la clase Oca
		Funciones game = new Funciones();

		// ^ Definimos una instancia de la clase Scanner y cambiamos su formato a US
		Scanner read = new Scanner(System.in).useLocale(Locale.US);

		// ^ Definimos las variables tirada1 y tirada2 que almacenaran el resultado de
		// las dos tiradas
		int tirada1, tirada2;

		// ^ Definimos las variables nomJ1 y nomJ2 para almacenar el nombre de los
		// jugadores
		String nomJ1, nomJ2;

		// ! Presentamos a los Usuarios el Juego
		System.out.println("Bienvenidos a el Juego 'La Oca de los numeros Primos!!!'");
		System.out.println("Para jugar debereis introducir vuestros nombres y el valor mínimo y máximo del dado.");
		System.out.println("Vuestros nombres no podrán ser iguales.");
		System.out.println("Dicho esto empezemos.");

		// ? Salto de Línea Triple
		System.out.println("\n-------------------------\n");

		// ! Pedimos el valor mínimo y máximo del dado
		System.out.print("Introducid el valor mínimo del dado > ");
		Funciones.minDado = read.nextInt(); // * Leemos el valor mínimo del dado
		System.out.print("Introducid el valor máximo del dado > ");
		Funciones.maxDado = read.nextInt(); // * Leemos el valor máximo del dado

		// ? Salto de Línea Triple
		System.out.println("\n---------------------\n");

		read.nextLine(); // ? Limpiamos el Búfer del Scanner tras leer un número para poder leer un
							// String

		// ! Pedimos los nombres a los Usuarios
		System.out.print("Como te llamas, Jugador 1? > ");
		nomJ1 = read.nextLine(); // * Leemos el nombre de J1
		do { // ! Pediremos el nombre del Jugador 2 hasta que sea diferente al del jugador 1
			System.out.print("Como te llamas, Jugador 2? > ");
			nomJ2 = read.nextLine(); // * Leemos el nombre de J2
			if (nomJ2.equals(nomJ1)) {
				System.out.println("Lo siento Jugador 2, tu nombre no puede ser igual que el de tu compañero\n");
			}
		} while (nomJ2.equals(nomJ1));

		// ! Pintamos la pista por primera vez
		Funciones.pintaPista();

		do {
			// ? Salto de Línea
			System.out.println("\n");

			// ! Pediremos que pulsen una tecla para la siguiente ronda
			System.out.print("Pulsa 'enter' para continuar");
			read.nextLine();

			// ! Imprimiremos las tiradas de J1
			System.out.println("\nTurno para " + nomJ1);
			tirada1 = Funciones.tiraDados(); // * Generamos la primera tirada
			System.out.println("En la primera tirada ha sacado un " + tirada1);
			tirada2 = Funciones.tiraDados(); // * Generamos la segunda tirada
			System.out.println("En la segunda tirada ha sacado un " + tirada2);

			// ! Si la suma de las tiradas es primo avanzará
			if (Funciones.sumaDeNumerosEsPrimo(tirada1, tirada2)) { // * Si es Primo
				System.out.println("TIRADA VÁLIDA");
				Funciones.fichaJ1 += (tirada1 + tirada2);
			} else { // * Si no es Primo
				System.out.println("TIRADA NO VÁLIDA\nNo suma puntos ya que la el total NO ES PRIMO");
			}

			// ! Pintamos el Tablero tras la jugada
			Funciones.pintaPista();

			// ? Cambiamos de Línea
			System.out.println("\n");

			// ! Indicamos quien va ganando
			game.imprimeComoVaLaCarrera(nomJ1, nomJ2);

			// ! Si el Jugador 1 ha llegado antes que el Jugador 2 nos saldremos del Bucle
			if (Funciones.fichaJ1 >= Funciones.TAMCIRCUITO) {
				break;
			}

			// ! Pediremos que pulsen una tecla para la siguiente ronda
			System.out.print("Pulsa 'enter' para continuar");
			read.nextLine();

			// ! Imprimiremos las tiradas de J2
			System.out.println("\nTurno para " + nomJ2);
			tirada1 = Funciones.tiraDados(); // * Generamos la primera tirada
			System.out.println("En la primera tirada ha sacado un " + tirada1);
			tirada2 = Funciones.tiraDados(); // * Generamos la segunda tirada
			System.out.println("En la segunda tirada ha sacado un " + tirada2);

			// ! Si la suma de las tiradas es primo avanzará
			if (Funciones.sumaDeNumerosEsPrimo(tirada1, tirada2)) {
				System.out.println("TIRADA VÁLIDA");
				Funciones.fichaJ2 += (tirada1 + tirada2);
			} else {
				System.out.println("TIRADA NO VÁLIDA\nNo suma puntos ya que la el total NO ES PRIMO");
			}

			// ! Pintamos el Tablero tras la jugada
			Funciones.pintaPista();

			// ? Cambiamos de Línea
			System.out.println("\n");

			// ! Indicamos quien va ganando
			game.imprimeComoVaLaCarrera(nomJ1, nomJ2);
		} while (game.esGanador(nomJ1, nomJ2).equals(""));

		// ^ Cerramos el Scanner tras su uso
		read.close();

		// ! Imprimimos el Ganador de la Partida
		System.out.println("\n-------------------------------");
		System.out.println("El/La ganador/a es " + game.esGanador(nomJ1, nomJ2));
		System.out.println("-------------------------------");
	}
}