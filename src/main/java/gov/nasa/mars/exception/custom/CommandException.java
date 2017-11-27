package gov.nasa.mars.exception.custom;

import gov.nasa.mars.enums.ErrorMessage;

/**
 * Classe para tratamento de exceção relacionadas a comandos inválidos 
 * @author Renan Lalier
 * @since 25/11/2017
 *
 */
public class CommandException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public CommandException() {
		super(ErrorMessage.BAD_REQUEST.getMessage());
	}

}
