package gov.nasa.mars.enums;

import java.math.BigDecimal;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.interfaces.ICommand;
import gov.nasa.mars.usecase.ValidationUseCase;

public enum Command implements ICommand {

	L {
		@Override
		public CoordinateRobot executeCommand(CoordinateRobot coordinate, ValidationUseCase validation) {
			coordinate.setCoordinate(coordinate.getCoordinate().changeCoordinate(L));
			return coordinate;
		}
	},
	M {
		@Override
		public CoordinateRobot executeCommand(CoordinateRobot coordinate, ValidationUseCase validation) {
			coordinate.getCoordinate().changePosition(coordinate, new BigDecimal(1), validation);
			return coordinate;
		}
	},
	R {
		@Override
		public CoordinateRobot executeCommand(CoordinateRobot coordinate, ValidationUseCase validation) {
			coordinate.setCoordinate(coordinate.getCoordinate().changeCoordinate(R));
			return coordinate;
		}
	}

}
