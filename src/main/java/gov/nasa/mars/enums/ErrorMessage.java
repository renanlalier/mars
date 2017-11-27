package gov.nasa.mars.enums;

/**
 * 
 * Enum responsável por manter todas as constantes referente as mensagens de 
 * erros das classes de exceções customizadas
 * @author Renan Lalier <relalier@gmail.com>
 * @since 26/11/2017
 *
 */
public enum ErrorMessage {
	
	BAD_REQUEST("400 Bad Request");
	
	private ErrorMessage(String message) {
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}	

}
