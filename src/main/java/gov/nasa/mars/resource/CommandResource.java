package gov.nasa.mars.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.mars.usecase.CalculatorUseCase;

@RestController
public class CommandResource {
	
	@Autowired
	private CalculatorUseCase calculatorUseCase;

	@RequestMapping(path="/mars/{command}", method = RequestMethod.GET)
	public String sendCommand(@PathVariable("command") String command){ 
		return calculatorUseCase.calculatePosition(command);
	}
	
}
