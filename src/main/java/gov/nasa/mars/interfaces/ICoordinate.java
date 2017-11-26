package gov.nasa.mars.interfaces;

import java.math.BigDecimal;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.enums.Command;
import gov.nasa.mars.enums.Coordinate;
import gov.nasa.mars.usecase.ValidationUseCase;

public interface ICoordinate {
	
	public CoordinateRobot changePosition(CoordinateRobot coordinate, BigDecimal totalPosition, ValidationUseCase validation);
	
	public Coordinate changeCoordinate(Command command);

}
