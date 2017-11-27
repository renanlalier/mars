package gov.nasa.mars.domain;

import java.math.BigDecimal;

import gov.nasa.mars.enums.Coordinate;

/**
 * 
 * Classe responsável pelos dados de dominio do robô
 * @author Renan Lalier <relalier@gmail.com>
 * @since 26/11/2017
 *
 */
public class CoordinateRobot {

	private BigDecimal positionX;

	private BigDecimal positionY;

	private Coordinate coordinate;

	public CoordinateRobot(BigDecimal positionX, BigDecimal positionY, Coordinate coordinate) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.coordinate = coordinate;
	}

	public BigDecimal getPositionX() {
		return positionX;
	}

	public void setPositionX(BigDecimal positionX) {
		this.positionX = positionX;
	}

	public BigDecimal getPositionY() {
		return positionY;
	}

	public void setPositionY(BigDecimal positionY) {
		this.positionY = positionY;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "(" + positionX + "," + positionY + "," + coordinate + ")";
	}

}
