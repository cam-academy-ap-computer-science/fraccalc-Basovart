/*PSEUDOCODE
 * CHECKPOINT 1:
 * Create scanner 
 * have the input be passed to produceAnswer
 * break up produceAnswer into three strings
 * 	first operand
 *  operator
 *  second operand
 * store these in produceAnswer
 * produceAnswer return the second operand
 * main prints the return value
 * CHECKPOINT 2:
 * accept multiple inputs until user types 'quit'
 * parse operand into Whole, Numerator, and Denominator
 * 
 */
package fracCalc;
import java.util.Scanner;
public class FracCalc {
    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("What calculation should be performed? (type \"quit\" to stop) ");
    	String input = userInput.nextLine();
    	if (input.equals("quit")) {
    		System.out.println("Good Bye");
    	} 
    	while (!input.equals("quit")) {
    		System.out.println(produceAnswer(input));
    		System.out.println("What calculation should be performed? (type \"quit\" to stop) ");
    		input = userInput.nextLine();
    	} 
    	if (input.equals("quit")) {
    		System.out.println("Good Bye");
    	} 
    }
        
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) { 
    	
    	int length = input.length();
    	int space = input.indexOf(" ");
    	int secondSpace = input.lastIndexOf(" ");
    	String firstOperand = input.substring(0 ,space);
    	char operator = input.charAt(space + 1);
    	String secondOperand = input.substring(secondSpace + 1, length);
    	int firstUnder = input.indexOf("_");
    	int firstDiv = input.indexOf("/");
        int secondUnder = input.lastIndexOf("_");
        int secondDiv = input.lastIndexOf("/");
        String Whole1 = "";
        String Numerator1 = "";
        String Denominator1 = "";
        String Whole2 = "";
		String Numerator2 = "";	
		String Denominator2 = "";
		/*
		if (firstOperand.indexOf("_") == -1 && firstOperand.indexOf("/") == -1) {
        	Whole1 = firstOperand;
        	Numerator1 = "0";
        	Denominator1 = "1";
        } else if (firstOperand.indexOf("_") != -1 && firstOperand.indexOf("/") != -1) {
			Whole1 = input.substring(0,firstUnder);	
			Numerator1 = input.substring(firstUnder+1,firstDiv);
			Denominator1 = input.substring(firstDiv+1,space);
  		  } else if (firstOperand.indexOf("_") == -1 && input.lastIndexOf("/") != -1) {
			Whole1 = "0";
			Numerator1 = input.substring(0,firstDiv);
			Denominator1 = input.substring(firstDiv+1,space);
		    }
		System.out.println("whole:" + Whole1 + " numerator:" + Numerator1 + " denominator:" + Denominator1);
		*/
		if (secondOperand.indexOf("_") == -1 && secondOperand.indexOf("/") == -1) {
        	Whole2 = secondOperand;
        	Numerator2 = "0";
        	Denominator2 = "1";
        } else if (secondOperand.indexOf("_") != -1 && secondOperand.indexOf("/") != -1) {
			Whole2 = input.substring(secondSpace+1,secondUnder);	
			Numerator2 = input.substring(secondUnder+1,secondDiv);
			Denominator2 = input.substring(secondDiv+1,length);
  		  } else if (secondOperand.indexOf("_") == -1 && input.lastIndexOf("/") != -1) {
			Whole2 = "0";
			Numerator2 = input.substring(secondSpace + 1,secondDiv);
			Denominator2 = input.substring(secondDiv+1,length);
		    }
		System.out.println("whole:" + Whole2 + " numerator:" + Numerator2 + " denominator:" + Denominator2);
		
		return secondOperand;
    }
    
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
