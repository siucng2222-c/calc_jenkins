package com.siucng.calcjenkins;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private Calculator calculator = new Calculator();

	@Test
	public void testSum() {
		assertEquals(4, calculator.sum(2, 3));
	}
}