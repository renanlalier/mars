package gov.nasa.mars.usecase;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.enums.Command;
import gov.nasa.mars.enums.Coordinate;
import gov.nasa.mars.exception.custom.CommandException;
import gov.nasa.mars.interfaces.ICalculator;

public class CalculatorUseCase implements ICalculator {

	@Value("${robot.position.initialX}")
	private BigDecimal posInitialX;

	@Value("${robot.position.initialY}")
	private BigDecimal posInitialY;

	@Value("${robot.coordinate.initial}")
	private Coordinate coordInitial;

	@Autowired
	private ValidationUseCase validationUseCase;

	@Override
	public String calculatePosition(String command) {

		if (validationUseCase.validateCommand(command)) {
			
			CoordinateRobot coordinate = new CoordinateRobot(posInitialX, posInitialY, coordInitial);
			command.chars().forEach(c -> {
				Command com = Command.valueOf(String.valueOf((char) c));
				com.executeCommand(coordinate, validationUseCase);
			});

			return coordinate.toString();
		}
		
		throw new CommandException();

	}

}
