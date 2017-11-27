package gov.nasa.mars.usecase;

import java.math.BigDecimal;
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
 * Classe responsável por manter as validações de execução do comando enviado ao robô
 * 
 */
public class ValidationUseCase implements IValidate {
	 
	@Value("${area.maxX}")
	private BigDecimal maxAreaX;
	
	@Value("${area.maxY}")
	private BigDecimal maxAreaY;

	/**
	 * Método responsável por validar o comando enviado ao robô
	 * 
	 * @param command paramêtro referente ao comando a ser executado
	 * @return retorna booleano informando se o comando é válido
	 */
	public Boolean validateCommand(String command) {
		return command != null && command.chars().allMatch(c -> getCommands().contains(String.valueOf((char)c)));
	}
	
	/**
	 * Método responsável por validar se o movimento do robô esta sendo realizado dentro da área permitida
	 * 
	 * @param positionX posição requerida para o robô no eixo X
	 * @param positionY posição requerida para o robô no eixo Y
	 * @return valor booleano indicando se o movimento que o robô 
	 */
	public Boolean validateMotion(BigDecimal positionX, BigDecimal positionY){
		return validateMinMotion(positionX, positionY) && validateMaxMotion(positionX, positionY) ? true : false;
	}
	
	/**
	 * Método responsável por validar se o movimento do robô esta dentro do máximo permitido para a área
	 * 
	 * @param positionX requerida para o robô no eixo X
	 * @param positionY requerida para o robô no eixo Y
	 * @return valor booleano indicando se esta dentro do máximo permitido
	 */
	private Boolean validateMaxMotion(BigDecimal positionX, BigDecimal positionY){
		return positionX.compareTo(maxAreaX) > 0 || positionY.compareTo(maxAreaY) > 0 ? false : true;
	}
	
	/**
	 * Método responsável por validar se o movimento do robô esta dentro do minimo permitido para a área
	 * 
	 * @param positionX requerida para o robô no eixo X
	 * @param positionY requerida para o robô no eixo Y
	 * @return valor booleano indicando se esta dentro do minimo permitido
	 */
	private Boolean validateMinMotion(BigDecimal positionX, BigDecimal positionY){
		return positionX.compareTo(BigDecimal.ZERO) < 0 || positionY.compareTo(BigDecimal.ZERO) < 0 ? false : true;
	}

	/**
	 * Método responsável por obter todos os comandos existentes
	 * @return comandos existentes
	 */
	private Set<String> getCommands() {
		return Stream.of(Command.values()).map(Command::name).collect(Collectors.toSet());
	}

}
