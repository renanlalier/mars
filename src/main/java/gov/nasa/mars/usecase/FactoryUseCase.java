package gov.nasa.mars.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe responsável por manter factory para criação dos beans usecase
 * @author Renan Lalier <relalier@gmail.com>
 * @since 25/11/2017
 *
 */
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
