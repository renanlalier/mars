package gov.nasa.mars.interfaces;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.usecase.ValidationUseCase;

public interface ICommand {
	
	public CoordinateRobot executeCommand(CoordinateRobot coordinate, ValidationUseCase validation);

}
