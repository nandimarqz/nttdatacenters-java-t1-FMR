package nttdata.javat1;

import java.util.Scanner;

import nttdata.javat1.game.Game;

public class T1MainFMR {
	public static void main(String[] args) {
		try (Scanner scMain = new Scanner(System.in)) {

			// Muestra una bienvenida y pregunta al usuario si esta preparado
			System.out.println("Bienvenido al Pinball de NTTDATA\n"
					+ "Ahora mismo el numero de punto de los jugardores es 0.\n"
					+ "Cada uno de vosotros tendrá 3 tiradas.\n"
					+ "El ganador será el que obtenga al mayor cantidad de puntos\n" + "¿Estaís preparados? S / N ");
			// Se guarda la opcion
			String option = String.valueOf(scMain.next().charAt(0));
			
			// Mientras que la opcion sea dieferente a N entra en el bucle
			while (!option.toUpperCase().equals("N")) {
				
				// Cambiamos la variable a mayusculas y depende el valor cae en un caso u en
				// otro
				switch (option.toUpperCase()) {

				case "S":
					
					// En este caso se crea el juego y se llama al metodo launchAndStart para
					// empezar el juego
					Game game = new Game();
					game.launchAndStart(scMain);
					
					//Vuelve a preguntar una vez termina si quiere jugar otra vez o no
					System.out.println("Desea jugar otra vez de nuevo? S / N");
					option = String.valueOf(scMain.next().charAt(0));

					break;

				case "N":
					
					// En este caso muestra una despedida y termina
					System.out.println("Muchas gracias por jugar, hasta otra!");
					break;

				default:
					
					//En este caso se muestra que la opcion es invalida y vuelve a mostrar el menu
					System.out.println("La opción escogida es invalida." + "Opciones validas S o N");
					System.out.println("Bienvenido al Pinball de NTTDATA\n"
							+ "Ahora mismo el numero de punto de los jugardores es 0.\n"
							+ "Cada uno de vosotros tendrá 3 tiradas.\n"
							+ "El ganador será el que obtenga al mayor cantidad de puntos\n"
							+ "¿Estaís preparados? S / N ");
					option = String.valueOf(scMain.next().charAt(0));
					break;

				}

			}

		}

	}
}
