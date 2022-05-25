package nttdata.javat1.game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.javat1.game.components.Ball;
import nttdata.javat1.game.components.Board;
import nttdata.javat1.game.components.Player;

/**
 * 
 * @author nandi
 *
 */
public class Game {

	// Atributos del juego
	private Set<Player> players;
	private Board board;
	private static final Integer WRONGHOLE = 0;
	private static final Integer GHOLE = 1;
	private static final Integer BOUNCE = 2;
	private static final Integer BONUS = 3;
	
	// Logger para la trazas
	private static final Logger GAMELOG = LoggerFactory.getLogger(Game.class);

	/**
	 * Constructor para el juego
	 */
	public Game() {
		super();
		GAMELOG.info("Se ha generado un juego");
		board = new Board();
		players = new HashSet<>();
	}

	/**
	 * Añade los jugadores al conjunto de players
	 * 
	 * @param playersNum
	 * @param scAdd
	 */
	public void addPlayers(int playersNum, Scanner scAdd) {

		GAMELOG.info("Añadiendo jugadores...");
		// Realiza un bucle que sus vueltas es el numero de jugadores que se pasa por
		// parametro
		for (int i = 1; i <= playersNum; i++) {

			// Pregunta el nombre del jugador al usuario y lo introduce por consola
			System.out.println("Introduzca su nombre jugador " + i);
			String name = scAdd.next();

			// Añade el nuevo jugador y muestra por consola un saludo
			players.add(new Player(name));
			System.out.println("Bienvenido " + name);
			
		}

		GAMELOG.info("Jugadores añadidos");
		
	}

	/**
	 * Este metodo lanza y empieza el juego
	 * 
	 * @param scLaunch
	 */
	public void launchAndStart(Scanner scLaunch) {

		GAMELOG.info("Se ha iniciado el juego");
		// Carga el tablero
		board.loadBoard();
		
		// Variable para el numero de jugadores
		int playersNum;

		// Pide al usuario el numero de jugadores y se guarda en la variable
		System.out.println("Introduzca el numero de jugadores: ");
		playersNum = scLaunch.nextInt();

		System.out.println("Ahora se le pediran los nombres a los jugadores");
		
		// Llama al metodo addPlayers para añadir a los jugadores
		addPlayers(playersNum, scLaunch);

		// Recorre el conjunto de jugadores para sus turnos
		for (Player p : players) {
			
			System.out.println("\n");
			System.out.println("Es el turno de " + p.getNombre());
			// Realiza un bucle de 3 vueltas que es el numero de tiradas por jugador
			for (int i = 1; i <= 3; i++) {

				// Muestra un menu que muestra el numero de tirada, la puntuacion y las opciones
				// que puede realizar el jugador
				System.out.println("Numero de tirada: " + i);
				System.out.println("Su puntuacion es de: " + p.getPoints());
				System.out.println("¿Que desea realizar?\n" + "1.Lanzar la bola\n" + "2.Pasar el tiro\n"
						+ "Escoga el numero de la opción");

				// Guarda la opcion en una variable
				int option = scLaunch.nextInt();

				// Depende la opcion del usuario realizara un caso u otro
				switch (option) {

				case 1:

					// Este caso llama al metodo lauchBall para lanzar la bola
					this.launchBall(p);
					break;

				case 2:

					// Este caso llama al metodo setScore 0 que suma la cantida pasada por parametro
					// al jugador
					p.setScore(0);
					break;

				default:

					// Este caso es por si mete una opcion erronea
					System.out.println("La opcion escogida no esta en el menu inserte 1 o 2");

					break;
				}
				System.out.println("\n");
			}
			// Cuando termina el turno muestra el nombre y los puntos del jugador
			System.out
					.println("Turno terminado la puntuacion del jugador " + p.getNombre() + " es de: " + p.getPoints());

		}

		this.showPoints(players);
		GAMELOG.info("Se ha termiando el juego");
	}

	/**
	 * Metodo para lanzar la bola. Se generan dos numeros aleatorios para las
	 * posiciones del array bidimensional que es el tablero y segun la posicion que
	 * caiga y el valor que tenga esa posicion ocurrira una accion u otra
	 * 
	 * @param player
	 */
	public void launchBall(Player p) {

		GAMELOG.info("Se ha lanzado una bola");
		
		// Genera dos numeros aleatorios
		Integer num1 = (int) Math.floor(Math.random() * 6);
		Integer num2 = (int) Math.floor(Math.random() * 9);
		boolean eOLaunch = Boolean.FALSE;

		// Crea una bola
		Ball ball = new Ball();

		// Mientras que eOLauch sea falso que entre en el bucle
		while (!eOLaunch) {

			// Si el valor que devuelven los dos numeros alatorios en el tablero es igual a
			// algunas de las constantes ocurre una accion u otra
			if (board.getBoard()[num1][num2].equals(WRONGHOLE)) {

				// Decrementa en 1 el valor de la bola
				ball.decreaseScore(1);

				// Actualiza los puntos del jugador con el valor de la bola
				p.setScore(ball.getValue());

				// Muestra por consola lo ocurrido
				System.out.println(
						"La bola ha caido en un mal agujero se decrementa en 1 el valor de la bola, a continuacion se sumara su valor a tu puntuacion "
								+ "\nEl valor de la bola es de: " + ball.getValue());
				// Fin del lanzamiento igual a true
				eOLaunch = true;

			} else if (board.getBoard()[num1][num2].equals(GHOLE)) {

				// Incrementa el valor de la bola a 1
				ball.increaseScore(1);
				// Actualiza los puntos del jugador con el valor de la bola
				p.setScore(ball.getValue());
				// Muestra por consola lo ocurrido
				System.out.println(
						"La bola ha caido en un buen agujero el valor de la bola incremento en 1, a continuacion se sumara su valor a tu puntuacion"
								+ "\nEl valor de la bola es de: " + ball.getValue());
				// Fin del lanzamiento igual a true
				eOLaunch = true;

			} else if (board.getBoard()[num1][num2].equals(BOUNCE)) {

				// Se vuelve a generar dos numero aleatorios
				num1 = (int) Math.floor(Math.random() * 6);
				num2 = (int) Math.floor(Math.random() * 9);
				// Muestra por consola que la bola ha caido en un rebote
				System.out.println("La bola ha rebotado" + "\nEl valor de la bola es de: " + ball.getValue());

			} else if (board.getBoard()[num1][num2].equals(BONUS)) {

				// Incrementa el valor de la bola a 1
				ball.increaseScore(1);
				// Genera dos numeros aleatorios nuevos
				num1 = (int) Math.floor(Math.random() * 6);
				num2 = (int) Math.floor(Math.random() * 9);
				// Muestra por pantalla que ha caido en un bonus y se suma a 1 el valor de la
				// bola
				System.out.println("La bola ha rebotado en un bonus se incrementa en 1 el valor de la bola"
						+ "\nEl valor de la bola es de: " + ball.getValue());

			}
		}
	}

	/**
	 * Muestra los jugadores en orden de sus puntos de mayor a menor que es el
	 * criterio de ordenacion que tenemos en el compareTo de la clase Player
	 * 
	 * @param players
	 */
	public void showPoints(Set<Player> players) {

		GAMELOG.info("Se muestran los puntos de los jugadores");
		
		// Crea una lista con los datos del conjunto de jugadores pasado por parametro
		List<Player> podium = new LinkedList<>(players);

		// Ordena esa lista con el criterio de ordenacion que indica el comparaTo de la
		// clase Player
		podium.sort(null);
		int i = 0;

		// Recorre la lista podium y muestra los jugadores ordenados
		for (Player p : podium) {
			i++;
			System.out.println("En " + i + "º posicion " + p.getNombre() + " con: " + p.getPoints());

		}

	}
}
