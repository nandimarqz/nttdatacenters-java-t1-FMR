package nttdata.javat1.game.components;

/**
 * Clase Score
 * @author nandi
 *
 */
public class Score {

	// Atributo de la puntuacion
	/** Puntos */
	private Integer points;

	/**
	 * Constructor de los puntos
	 * 
	 */
	public Score() {
		super();

		points = 0;

	}

	/**
	 * Retorna los punnos
	 * 
	 * @return Integer
	 */
	public Integer getPoints() {

		return points;
	}

	/**
	 * Actualiza los puntos
	 * 
	 * @param score
	 */
	public void setPoints(Integer score) {

		this.points = score;

	}

	/**
	 * Devuelve el valor de los puntos en un String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {

		return points.toString();

	}

}
