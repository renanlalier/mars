package gov.nasa.mars.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.mars.exception.custom.BaseException;

/**
 * Classe responsável pelas configurações de tratamento de exceções da aplicação
 * @author Renan Lalier <relalier@gmail.com>
 * @since 25/11/2017
 *
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Método responsável pela configuração de exceções de tempo de execução customizada
	 * @param e paramêtro referente a classe BaseException para tratamento
	 * @return mensagem de erro
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BaseException.class)
	public String handleBaseException(BaseException e) {
		return e.getMessage();
	}

	/**
	 * Método responsável pela configuração das demais exceções da aplicação
	 * @param e paramêtro referente a classe Exception para tratamento
	 * @return mensagem de erro
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return e.getMessage();
	}

}
