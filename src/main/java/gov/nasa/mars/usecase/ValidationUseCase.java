package gov.nasa.mars.usecase;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;

import gov.nasa.mars.enums.Command;
import gov.nasa.mars.interfaces.IValidate;

/**
 * @author Renan Lalier <relalier@gmail.com>
 * @since 25/11/2017
 * 
 * Classe responsável por realizar validações
 * 
 */
public class ValidationUseCase implements IValidate {
	 
	@Value("${area.maxX}")
	private BigDecimal maxAreaX;
	
	@Value("${area.maxY}")
	private BigDecimal maxAreaY;

	public Boolean validateCommand(Optional<String> command) {
		return command.isPresent() && command.get().chars().allMatch(c -> getCommands().contains(String.valueOf((char)c)));
	}
	
	public Boolean validateMotion(BigDecimal positionX, BigDecimal positionY){
		return validateMinMotion(positionX, positionY) && validateMaxMotion(positionX, positionY) ? true : false;
	}
	
	private Boolean validateMaxMotion(BigDecimal positionX, BigDecimal positionY){
		return positionX.compareTo(maxAreaX) > 0 || positionY.compareTo(maxAreaY) > 0 ? false : true;
	}
	
	private Boolean validateMinMotion(BigDecimal positionX, BigDecimal positionY){
		return positionX.compareTo(BigDecimal.ZERO) < 0 || positionY.compareTo(BigDecimal.ZERO) < 0 ? false : true;
	}

	private Set<String> getCommands() {
		return Stream.of(Command.values()).map(Command::name).collect(Collectors.toSet());
	}

}
