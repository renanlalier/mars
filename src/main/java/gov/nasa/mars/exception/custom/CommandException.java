package gov.nasa.mars.exception.custom;

import gov.nasa.mars.enums.ErrorMessage;

public class CommandException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandException() {
		super(ErrorMessage.BAD_REQUEST.getMessage());
	}

}
