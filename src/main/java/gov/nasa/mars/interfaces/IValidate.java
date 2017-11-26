package gov.nasa.mars.interfaces;

import java.math.BigDecimal;
import java.util.Optional;

public interface IValidate {
	
	public Boolean validateCommand(Optional<String> command);
	
	public Boolean validateMotion(BigDecimal positionX, BigDecimal positionY);

}
