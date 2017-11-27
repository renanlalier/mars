package gov.nasa.mars.usecase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nasa.mars.Aplicattion;
import gov.nasa.mars.domain.CoordinateRobot;
import gov.nasa.mars.enums.Command;
import gov.nasa.mars.enums.Coordinate;
import gov.nasa.mars.exception.custom.PositionException;
import gov.nasa.mars.usecase.ValidationUseCase;

import java.math.BigDecimal;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Aplicattion.class)
public class ValidationUSeCaseTest {

	@Autowired
	private ValidationUseCase validationUseCase;

	@Test
	public void executeTestCommandInvalid() {
		Assert.assertFalse(validationUseCase.validateCommand("AAA"));
	}

	@Test(expected = PositionException.class)
	public void executeTestMotionInvalidOne() {

		final String command = "MLMM";
		getCoordinateRobot(command);

	}
	
	@Test(expected = PositionException.class)
	public void executeTestMotionInvalidTwo(){
		
		final String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
		getCoordinateRobot(command);
		
	}

	@Test
	public void executeTestMotionLeft() {

		final String command = "MML";
		Assert.assertEquals("(0,2,W)", getCoordinateRobot(command));
	}

	@Test
	public void executeTestMotionRight() {

		final String command = "MMRMMRMM";
		Assert.assertEquals("(2,0,S)", getCoordinateRobot(command));

	}

	private String getCoordinateRobot(String command) {

		CoordinateRobot coordinate = new CoordinateRobot(new BigDecimal(0), new BigDecimal(0), Coordinate.N);
		command.chars().forEach(c -> {
			Command com = Command.valueOf(String.valueOf((char) c));
			com.executeCommand(coordinate, validationUseCase);
		});

		return coordinate.toString();
	}

}
