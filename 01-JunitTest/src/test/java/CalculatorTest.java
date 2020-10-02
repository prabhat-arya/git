import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.unitTesting.Calculator;

public class CalculatorTest {
	
	@Test
	public void calculatorAddTest01() {
		Calculator cal= new Calculator();
		int actualRes= cal.add(10, 20);
		int expectedRes=30;
		
		assertEquals(expectedRes, actualRes);
	}

}
