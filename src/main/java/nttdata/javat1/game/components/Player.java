package nttdata.javat1.game.components;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author nandi
 *
 */
public class Player implements Comparable<Player> {

	// Atributos del jugador
	private String nombre;
	private Score points;

	// Logger para las trazas
	private static final Logger PLAYERLOG = LoggerFactory.getLogger(Player.class);

	/**
	 * Constructor del jugador solamente recibe el nombre, ya que los puntos es 0 al
	 * comenzar
	 * 
	 * @param nombre
	 */
	public Player(String nombre) {
		super();
		this.nombre = nombre;
		this.points = new Score();
		PLAYERLOG.info("Se ha generado un jugador");
	}

	/**
	 * Retorna el nombre del jugador
	 * 
	 * @return String
	 */
	public String getNombre() {

		return nombre;

	}

	/**
	 * Actualiza el nombre del jugador
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	/**
	 * Retorna los puntos del jugador
	 * 
	 * @return Integer
	 */
	public Integer getPoints() {

		PLAYERLOG.info("Se han obtenido los puntos del jugador {}", this.nombre);
		return points.getPoints();

	}

	/**
	 * Actualiza los puntos del jugador, si se le va a restar puntos(es decir el
	 * numero pasado por parametro es negativo) se comprueba de que la puntuacion no
	 * baje de 0, si es así se mantienen los puntos a 0
	 * 
	 * @param points
	 */
	public void setScore(Integer points) {

		if ((this.getPoints() + points) >= 0) {

			this.points.setPoints(this.getPoints() + points);
			PLAYERLOG.info("Se han actualizado los puntos al jugador: {}", this.nombre);

		} else {
			this.points.setPoints(0);
			System.out.println("Su puntuacion se mantiene a 0");
		}

	}

	/**
	 * Retorna el hashCode apartir del nombre
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {

		return Objects.hash(nombre);
	}

	/**
	 * Devuelve un boolean indicando si los dos jugadores son iguales (Si los nombre
	 * son iguales)
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(nombre, other.nombre);

	}

	/**
	 * Devuelve un int un numero mayor a 0 si los puntos del invocante es mayor a
	 * los puntos del jugador que se pasa por paramentro, un 0 si los puntos son
	 * iguales y un valor menor a 0 si los puntos del jugador pasado por parametro
	 * es mayor a los puntos del invocante
	 * 
	 * @return int
	 */
	@Override
	public int compareTo(Player o) {

		return o.points.getPoints() - this.points.getPoints();

	}

}
