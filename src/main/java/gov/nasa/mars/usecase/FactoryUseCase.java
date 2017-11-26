package gov.nasa.mars.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryUseCase {

	@Bean
	public CalculatorUseCase createCalculatorUseCase(){
		return new CalculatorUseCase();
	}
	
	@Bean
	public ValidationUseCase createValidationUseCase(){
		return new ValidationUseCase();
	}
	
}
