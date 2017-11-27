package gov.nasa.mars.enums;

import java.math.BigDecimal;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.interfaces.ICommand;
import gov.nasa.mars.usecase.ValidationUseCase;

/**
 * 
 * Enum responsável por manter todas as constantes referente aos comandos que podem ser enviados para o robô
 * @author Renan Lalier <relalier@gmail.com>
 * @since 26/11/2017
 *
 */
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
