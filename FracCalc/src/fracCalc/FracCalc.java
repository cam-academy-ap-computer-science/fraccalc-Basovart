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
    	String operator = input.substring(space, space + 3);
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
		System.out.println(operator);
	
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
		
		return secondOperand;
    }
    
    public static String add(int Whole1, int Whole2, int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	int Num1;
    	int Num2;
    	int Den1;
    	int Den2;
    	int numFinal = 0;
    	int denFinal = 0;
    	int finalWhole;
    	if (Denominator1 != Denominator2) {
    		Num1 = Numerator1 * Denominator2;
    		Num2 = Numerator2 * Denominator1;
    		Den1 = Denominator1 * Denominator2;
    		Den2 = Denominator2 * Denominator1;
    		numFinal = Num1 + Num2;
    		denFinal = Den1 + Den2;
    	}
    	if (Denominator1 == Denominator2) {
    		numFinal = Numerator1 + Numerator2;
    		denFinal = Denominator1 + Denominator2;
    	}
    //Whole
    	if (Whole1 == -1 && Whole2 == -1) {
    		finalWhole = 0;
    	} else {
    		finalWhole = Whole1 + Whole2;
    	  }
    	if (Whole1 != -1 && Whole2 == -1) {
    		finalWhole = Whole1;
    	} else {
    		finalWhole = Whole2;
    	  }
    	
    	
    	String answer = (finalWhole + numFinal + "/" + denFinal);
    	System.out.println(answer);
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
    
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
