package gov.nasa.mars.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.mars.usecase.CalculatorUseCase;

/**
 * 
 * Classe responsável por manter todos os recursos relacionados a execução de comandos do robô
 * @author Renan Lalier <relalier@gmail.com>
 * @since 26/11/2017
 *
 */
@RestController
public class CommandResource {
	
	@Autowired
	private CalculatorUseCase calculatorUseCase;

	/**
	 * Método responsável por receber o comando para movimentar o robô
	 * @param command paramêtro reacebido referente ao comando a ser executado
	 * @return retorna posição atual do robô após executação do robô
	 */
	@RequestMapping(path="/mars/{command}", method = RequestMethod.GET)
	public String sendCommand(@PathVariable("command") String command){ 
		return calculatorUseCase.calculatePosition(command);
	}
	
}
