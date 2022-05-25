package nttdata.javat1.game.components;

/**
 * 
 * @author nandi
 *
 */
public class Ball {
	//Atributos de la bola
	private Score value;
	
	/**
	 * Constructor de la bola
	 */
	public Ball() {
		super();
		
		value = new Score();
	}
	/**
	 * Devuelve el valor de la bola
	 * 
	 * @return Integer
	 */
	public Integer getValue() {
		
		return value.getPoints();
		 
	}

	/**
	 * Incrementa los puntos de la bola por la cantidad pasada por parametro
	 * @param points
	 */
	public void increaseScore(Integer points) {
		
		this.value.setPoints(this.value.getPoints() + points);
			
	}
	
	/**
	 * Decrementa los puntos de la bola por la cantidad pasada por parametro
	 * @param points
	 */
	public void decreaseScore(Integer points) {
		
		this.value.setPoints(this.value.getPoints() - points);
			
	}
	
}
