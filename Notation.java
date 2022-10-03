/**
 * Class: CMSC204
 *  Program: Assignment #2
 *  Instructor: Dr. Kuijt
 * Description: An application that convert between infix and postpix, and evaluate the postfix
 * Due: 10/02/2022 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Shengquan Yang
*/




import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;


public class Notation {



	/**
	 * This methods converts infix to postfix
	 * @param infix the infix format of a formula
	 * @return the postfix format of a string
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {

		MyStack<Character> operator = new MyStack<Character>(100);
		String str = "";
		int leftParenthesisNumber=0;
		int rightParenthesisNumber=0;
		
		
	
		char[] charArray=infix.toCharArray();
		for(int i=0;i<charArray.length;i++) {
			char  c=charArray[i];
			
			if(c == '(') {
				leftParenthesisNumber++;
			}
			
			if(c == ')') {
				rightParenthesisNumber++;
			}
		
		}
		if(leftParenthesisNumber!=rightParenthesisNumber) {
			throw new InvalidNotationFormatException("The number of left parenthesis does not match the number of right parenthesis");
		}
		
		
		char[] ch = infix.toCharArray();

		for(int i=0; i<ch.length; i++){
			char c = ch[i];
			System.out.println(c);
			switch(c)
			{
			case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
				str+=c;
				break;

			case '+': case '-':
				operation(operator, str, c,1);
				break;

			case '*': case '/':
				operation(operator, str, c,2);
				break;

			case '^':
				operator.push(c);
				break;

			case '(':
				operator.push(c);
				leftParenthesisNumber++;
				break;

			case ')':
				Character topOperator = operator.pop();

				while(topOperator != '(') {
					str+=topOperator;
					topOperator = operator.pop();
				}
				rightParenthesisNumber++;
				break;

			default:
				break;
			}
		}

		
		
		while (!operator.isEmpty()) {
			str+=operator.pop();
		}
		
		

		return str;
	}

	/**
	 * This methods compare the level of the operators
	 * @param operatorStack MyStack<Character>
	 * @param str the string of the formula
	 * @param ch the single character
	 * @param level the level of the operators
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	private static void operation(MyStack<Character> operatorStack, String str, char ch, int level) throws StackOverflowException, StackUnderflowException {

		while(!operatorStack.isEmpty()){
			char c = (char)operatorStack.pop();

			if(c=='('){
				operatorStack.push(c);
				break;
			}else {
				int topLevel = 0;
				if(c == '+' || c == '-'){
					topLevel = 1;
				}else {
					topLevel = 2;
				}

				if(topLevel >= level) {
					str+=c;
					break;
				}else {
					operatorStack.push(c);
					break;
				}
			}
		}
		operatorStack.push(ch);
	}



	/**
	 * This methods converts postfix to infix
	 * @param complexPostfix the postfix format of a formula
	 * @return the formula in postfix format
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String complexPostfix) throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {


		MyStack<String> operator = new MyStack<>(100);

		 for (int i = 0; i < complexPostfix.length(); i++)
		  {
		    char ch = complexPostfix.charAt(i);

		    if (ch>='0' && ch<='9'){
		    	operator.push(ch + "");
		    	
		    	System.out.println(operator.toString());
		    	
		    }else{
		    	String op1;
				String op2;
				try {
					op1 = operator.pop();
					op2 = operator.pop();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					throw  new InvalidNotationFormatException("####Invalid PostFix formula");
				}

		    	operator.push("(" + op2 + ch + op1 + ")");
		    }
		  }

		  return operator.pop();
		}


	/**
	 * This method evaluates the value of the formula in postfix format
	 * @param complexPostfix
	 * @return
	 * @throws InvalidNotationFormatException
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	public static double evaluatePostfixExpression(String complexPostfix) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException {

		MyStack<Integer> value = new MyStack<Integer>(100);
		char[] ch = complexPostfix.toCharArray();

		for(int i=0; i<ch.length; i++){

			char c = ch[i];

			if(c>='0' && c<='9'){
				value.push((int)(c-'0'));
			}else {
				int num2;
				int num1;
				try {
					num2 = value.pop();
					num1 = value.pop();
				} catch (StackUnderflowException e) {
					throw  new InvalidNotationFormatException("Invalid PostFix formula");
				}
				int temp = 0;

				if(c=='+') {
					temp = num1+num2;
				}else if (c=='-') {
					temp = num1 - num2;
				}else if (c=='*') {
					temp = num1 * num2;
				}else if (c=='/') {
					temp = num1 / num2;
				}
				value.push(temp);
			}
		}

		return value.top();
	}

}