package gov.nasa.mars.interfaces;

import java.math.BigDecimal;

public interface IValidate {
	
	public Boolean validateCommand(String command);
	
	public Boolean validateMotion(BigDecimal positionX, BigDecimal positionY);

}
