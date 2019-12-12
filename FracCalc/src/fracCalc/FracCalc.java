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
    	int answer;
		//System.out.println(add(answer));
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
        int Whole1 = 0;
        int Numerator1 = 0;
        int Denominator1 = 0;
        int Whole2 = 0;
		int Numerator2 = 0;	
		int Denominator2 = 0;
		
		if (firstOperand.indexOf("_") == -1 && firstOperand.indexOf("/") == -1) {
        	Whole1 = Integer.parseInt(firstOperand);
        	Numerator1 = 0;
        	Denominator1 = 1;
        } else if (firstOperand.indexOf("_") != -1 && firstOperand.indexOf("/") != -1) {
			Whole1 = Integer.parseInt(input.substring(0,firstUnder));	
			Numerator1 = Integer.parseInt(input.substring(firstUnder+1,firstDiv));
			Denominator1 = Integer.parseInt(input.substring(firstDiv+1,space));
  		  } else if (firstOperand.indexOf("_") == -1 && input.lastIndexOf("/") != -1) {
			Whole1 = 0;
			Numerator1 = Integer.parseInt(input.substring(0,firstDiv));
			Denominator1 = Integer.parseInt(input.substring(firstDiv+1,space));
		    }
		System.out.println("whole:" + Whole1 + " numerator:" + Numerator1 + " denominator:" + Denominator1);
	
		if (secondOperand.indexOf("_") == -1 && secondOperand.indexOf("/") == -1) {
        	Whole2 = Integer.parseInt(secondOperand);
        	Numerator2 = 0;
        	Denominator2 = 1;
        } else if (secondOperand.indexOf("_") != -1 && secondOperand.indexOf("/") != -1) {
			Whole2 = Integer.parseInt(input.substring(secondSpace+1,secondUnder));	
			Numerator2 = Integer.parseInt(input.substring(secondUnder+1,secondDiv));
			Denominator2 = Integer.parseInt(input.substring(secondDiv+1,length));
  		  } else if (secondOperand.indexOf("_") == -1 && input.lastIndexOf("/") != -1) {
			Whole2 = 0;
			Numerator2 = Integer.parseInt(input.substring(secondSpace + 1,secondDiv));
			Denominator2 = Integer.parseInt(input.substring(secondDiv+1,length));
		    }
		secondOperand = ("whole:" + Whole2 + " numerator:" + Numerator2 + " denominator:" + Denominator2);
		/*
		if (input.indexOf(" + ") != -1) {
			add(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		if (input.indexOf(" - ") != -1) {
			sub(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		if (input.indexOf(" * ") != -1) {
			mul(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		if (input.indexOf(" / ") != -1) {
			div(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		*/
		return secondOperand;
    }
    /*
    public static String add(int Whole1) {
    	int finalWhole = Whole1 + Whole2;
    	int finalNumerator = Numerator1 + Numerator2;
    	int finalDenominator = Denominator1 + Denominator2;
    	String answer = (finalWhole + "_" + finalNumerator + "/" + finalDenominator);
    	return answer;
    }
    
    public static String sub(int Whole1,int Whole2,int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	
    	return answer;
    }
    public static String mul(int Whole1,int Whole2,int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	
    	return answer;
    }
    public static String div(int Whole1,int Whole2,int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	
    	return answer;
    }
    */
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
