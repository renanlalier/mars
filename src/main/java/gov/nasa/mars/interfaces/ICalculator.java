package gov.nasa.mars.interfaces;

import java.util.Optional;

import gov.nasa.mars.domain.CoordinateRobot;

public interface ICalculator {
	
	public CoordinateRobot calculatePosition(Optional<String> command);

}
