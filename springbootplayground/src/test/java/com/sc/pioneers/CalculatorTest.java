package com.sc.pioneers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest
{

	Calculator underTest=new Calculator();
	
	@Test
	public void canAdd()
	{
		//Given
				
				int numberOne=30;
				int numberTwo=20;
		//When
				int result=underTest.add(numberOne, numberTwo);
		//Then
				int expected=50;
				
				assertThat(result).isEqualTo(expected);
	}

}
