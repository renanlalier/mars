package gov.nasa.mars.usecase;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.enums.Command;
import gov.nasa.mars.enums.Coordinate;
import gov.nasa.mars.exception.custom.CommandException;
import gov.nasa.mars.interfaces.ICalculator;

/**
 * 
 * Classe responsável por manter os métodos de entrada para calculo dos comandos
 * @author Renan Lalier <relalier@gmail.com>
 * @since 26/11/2017
 *
 */
public class CalculatorUseCase implements ICalculator {

	@Value("${robot.position.initialX}")
	private BigDecimal posInitialX;

	@Value("${robot.position.initialY}")
	private BigDecimal posInitialY;

	@Value("${robot.coordinate.initial}")
	private Coordinate coordInitial;

	@Autowired
	private ValidationUseCase validationUseCase;

	/**
	 * Método responsável por receber o comando e calcular a posição do robô
	 * @param command parametro referente ao comando a ser executado
	 * @return retorna a posição atual do robô após a execução do comando
	 */
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
