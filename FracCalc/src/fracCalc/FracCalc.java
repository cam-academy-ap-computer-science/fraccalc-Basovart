/*
 * Create scanner 
 * have the input be passed to produceAnswer
 * break up produceAnswer into three strings
 * 	first operand
 *  operator
 *  second operand
 * store these in produceAnswer
 * produceAnswer return the second operand
 * main prints the return value
 */
package fracCalc;
import java.util.Scanner;
public class FracCalc {
    public static void main(String[] args) 
    {
    	Scanner userInput = new Scanner(System.in);
    	String input = userInput.next();
    	System.out.println("");
    	

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	String firstOperand;
    	String operator;
    	String secondOperand = "";
        return secondOperand;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
