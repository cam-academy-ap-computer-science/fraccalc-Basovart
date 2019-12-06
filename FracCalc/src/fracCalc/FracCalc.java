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
    public static void main(String[] args) 
    {
    	Scanner userInput = new Scanner(System.in);
    	String input1 = "";

    	do {String input = userInput.nextLine();
    	produceAnswer(input);
    	System.out.println();
    	} while (input1 != "quit"); 
    	if (input1 == "quit") {
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
    	int x = space + 3;
    	String firstOperand = input.substring(0 ,space);
    	String operator = input.substring(space, space + 2);
    	String secondOperand = input.substring(x, length);
        
        String Whole = "";
		String Numerator = "";	
		String Denominator = "";
		
		if (secondOperand.indexOf("_") == -1 && secondOperand.indexOf("/") == -1) {
        	Whole = secondOperand;
        	Numerator = "0";
        	Denominator = "1";
        }
		System.out.print("whole:" + Whole + " numerator:" + Numerator + " denominator:" + Denominator);
       
		return secondOperand;
    }
    
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
