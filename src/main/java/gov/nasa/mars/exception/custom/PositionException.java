package gov.nasa.mars.exception.custom;

import gov.nasa.mars.enums.ErrorMessage;

public class PositionException extends BaseException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionException() {
		super(ErrorMessage.BAD_REQUEST.getMessage());
	}

}
