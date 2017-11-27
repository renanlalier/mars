package gov.nasa.mars.exception.custom;

/**
 * Classe para tratamento de exceções em tempo de execução
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 25/11/2017
 *
 */
public class BaseException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(String message) {
		super(message);
	}

}
