package nttdata.javat1.game.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Board
 * @author nandi
 *
 */
public class Board {

	// Atributos tablero
	/** Estructura tablero */
	private Integer[][] board;
	/** Logger para las trazas */
	private static final Logger BOARDLOG = LoggerFactory.getLogger(Board.class);

	/**
	 * Constructor del tablero
	 */
	public Board() {
		super();

		this.board = new Integer[6][9];

	}

	/**
	 * Devuelve el tablero
	 * 
	 * @return Integer[][]
	 */
	public Integer[][] getBoard() {

		return board;

	}

	/**
	 * Actualiza el tablero
	 * 
	 * @param board
	 */
	public void setBoard(Integer[][] board) {

		this.board = board;

	}

	/**
	 * Carga el tablero con numeros aleatorios del 0 al 3 que son lso valores de lso
	 * huecos, rebotes y bonus
	 */
	public void loadBoard() {

		BOARDLOG.info("Generando el tablero...");

		// Recorre las posiciones del array y en cada posicion pone un numero aleatorio
		// comprendido entre el 0 y 3.
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				Integer randomNum = (int) Math.floor(Math.random() * 4);

				board[i][j] = randomNum;

			}
		}

		BOARDLOG.info("Tablero generado con éxito");

	}

}
