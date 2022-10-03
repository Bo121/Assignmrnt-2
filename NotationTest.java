 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationTest {
	public String complexInfix = "(3+(((5*7)-(((8/2)-1)*4))*6))";
	public String complexPostfix =  "357*82/1-4*-6*+";
	public String easyInfix = "(5+4)";
	public String easyPostfix = "54+";
	public String intermediateInfix = "((3*(5+4))+2)";
	public String intermediatePostfix = "354+*2+";

	public String invalidPostfixExpression = "354+*-";
	public String invalidInfixExpression = "(3+5)*4)-2";
	
	public double evalComplexPostfix = 141.0;
	public double evalIntermediatePostfix = 29.0;
	public double evalEasyPostfix = 9.0;

	@Before	
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexConvertInfixToPostfix() throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(complexInfix);
		assertEquals(complexPostfix, postfixResult);
	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(intermediateInfix);
		assertEquals(intermediatePostfix, postfixResult);
	}
	
	@Test
	public void testEasyConvertInfixToPostfix() throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(easyInfix);
		assertEquals(easyPostfix, postfixResult);
	}
	
	@Test
	public void testInvalidInfixExpression() throws StackOverflowException, StackUnderflowException {
		try{
			Notation.convertInfixToPostfix(invalidInfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexConvertPostfixToInfix() throws StackOverflowException, StackUnderflowException {
		String infixResult = null;
		try {
			infixResult = Notation.convertPostfixToInfix(complexPostfix);
		} catch (InvalidNotationFormatException e) {
			
		}
		assertEquals(complexInfix, infixResult);
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() throws StackOverflowException, StackUnderflowException {
		String infixResult = null;
		try {
			infixResult = Notation.convertPostfixToInfix(complexPostfix);
		} catch (InvalidNotationFormatException e) {
			
		}
		assertEquals(complexInfix, infixResult);
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() throws StackOverflowException, StackUnderflowException {
		String infixResult = null;
		try {
			infixResult = Notation.convertPostfixToInfix(complexPostfix);
		} catch (InvalidNotationFormatException e) {
			
		}
		assertEquals(complexInfix, infixResult);
	}

	@Test
	public void testInvalidPostfixExpressionB() throws StackOverflowException, StackUnderflowException {
		try{
			Notation.convertPostfixToInfix(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression()  throws StackOverflowException, StackUnderflowException{
		double result = 0;
		try {
			result = Notation.evaluatePostfixExpression(complexPostfix);
		} catch (InvalidNotationFormatException e) {
			
		} 
		assertEquals(evalComplexPostfix, result, .001);
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression()  throws StackOverflowException, StackUnderflowException{
		double result = 0;
		try {
			result = Notation.evaluatePostfixExpression(intermediatePostfix);
		} catch (InvalidNotationFormatException e) {

		}
		assertEquals(evalIntermediatePostfix, result, .001);
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression()  throws StackOverflowException, StackUnderflowException{
		double result = 0;
		try {
			result = Notation.evaluatePostfixExpression(easyPostfix);
		} catch (InvalidNotationFormatException e) {
			
		}
		
		assertEquals(evalEasyPostfix, result, .001);
	}
	
	@Test
	public void testInvalidPostfixExpressionA() throws StackOverflowException, StackUnderflowException{
		try{
			Notation.evaluatePostfixExpression(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
}
