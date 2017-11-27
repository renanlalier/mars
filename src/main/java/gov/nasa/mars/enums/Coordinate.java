package gov.nasa.mars.enums;

import java.math.BigDecimal;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.exception.custom.PositionException;
import gov.nasa.mars.interfaces.ICoordinate;
import gov.nasa.mars.usecase.ValidationUseCase;

/**
 * 
 * Enum responsável por manter todas as constantes referente as coordenadas para as quais o robô pode se deslocar
 * @author Renan Lalier <relalier@gmail.com>
 * @since 26/11/2017
 *
 */
public enum Coordinate implements ICoordinate {

	N {
		@Override
		public CoordinateRobot changePosition(CoordinateRobot coordinate, BigDecimal totalPosition,
				ValidationUseCase validation) {

			BigDecimal newPosition = coordinate.getPositionY().add(totalPosition);
			if (validation.validateMotion(coordinate.getPositionX(), newPosition)) {
				coordinate.setPositionY(newPosition);
				return coordinate;
			}
			throw new PositionException();
		}

		@Override
		public Coordinate changeCoordinate(Command command) {
			if (Command.L.equals(command)) {
				return W;
			} else {
				return E;
			}
		}
	},
	S {
		@Override
		public CoordinateRobot changePosition(CoordinateRobot coordinate, BigDecimal totalPosition,
				ValidationUseCase validation) {

			BigDecimal newPosition = coordinate.getPositionY().subtract(totalPosition);
			if (validation.validateMotion(coordinate.getPositionX(), newPosition)) {
				coordinate.setPositionY(newPosition);
				return coordinate;
			}
			throw new PositionException();
		}

		@Override
		public Coordinate changeCoordinate(Command command) {
			if (Command.L.equals(command)) {
				return E;
			} else {
				return W;
			}
		}
	},
	E {
		@Override
		public CoordinateRobot changePosition(CoordinateRobot coordinate, BigDecimal totalPosition,
				ValidationUseCase validation) {

			BigDecimal newPosition = coordinate.getPositionX().add(totalPosition);
			if (validation.validateMotion(newPosition, coordinate.getPositionY())) {
				coordinate.setPositionX(newPosition);
				return coordinate;
			}
			throw new PositionException();
		}

		@Override
		public Coordinate changeCoordinate(Command command) {
			if (Command.L.equals(command)) {
				return N;
			} else {
				return S;
			}
		}
	},
	W {
		@Override
		public CoordinateRobot changePosition(CoordinateRobot coordinate, BigDecimal totalPosition,
				ValidationUseCase validation) {
			
			BigDecimal newPosition = coordinate.getPositionX().subtract(totalPosition);
			if(validation.validateMotion(newPosition, coordinate.getPositionY())){
				coordinate.setPositionX(newPosition);
				return coordinate;
			}
			throw new PositionException();
		}

		@Override
		public Coordinate changeCoordinate(Command command) {
			if (Command.L.equals(command)) {
				return S;
			} else {
				return N;
			}
		}
	};

}
