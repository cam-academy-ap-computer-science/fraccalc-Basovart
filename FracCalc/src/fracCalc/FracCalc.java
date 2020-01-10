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
    	Scanner userInput = new Scanner(System.in); //initializes the scanner
    	System.out.println("What calculation should be performed? (type \"quit\" to stop) ");
    	String input = userInput.nextLine();
    	if (input.equals("quit")) { //function for when to quit the program
    		System.out.println("Good Bye");
    	} 
    	while (!input.toLowerCase().equals("quit")) { //loops until quit
    		System.out.println(produceAnswer(input));
    		System.out.println("What calculation should be performed? (type \"quit\" to stop) ");
    		input = userInput.nextLine();
    	} 
    	if (input.toLowerCase().equals("quit")) {
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
    	int length = input.length(); //finds length of problem
    	int space = input.indexOf(" "); //find index of the first space
    	int secondSpace = input.lastIndexOf(" "); //finds index of the last space
    	String firstOperand = input.substring(0 ,space); //parse the first fraction
    	String operator = input.substring(space, space + 3); //finds the index of the operator
    	String secondOperand = input.substring(secondSpace + 1, length); //parses the second fraction
    	int firstUnder = input.indexOf("_"); //finds index of first underscore
    	int firstDiv = input.indexOf("/"); //finds index of first division sign
        int secondUnder = input.lastIndexOf("_"); //finds index of the last underscore
        int secondDiv = input.lastIndexOf("/"); //finds index of last division sign
        //initializes variables
        int Whole1 = 0;
        int Numerator1 = 0;
        int Denominator1 = 0;
        int Whole2 = 0;
		int Numerator2 = 0;	
		int Denominator2 = 0;
		//parses first fraction into whole, numerator, an denominator
		if (firstOperand.indexOf("_") == -1 && firstOperand.indexOf("/") == -1) { //just the whole number
        	Whole1 = Integer.parseInt(firstOperand);
        	Numerator1 = 0;
        	Denominator1 = 1;
        } else if (firstOperand.indexOf("_") != -1 && firstOperand.indexOf("/") != -1) { //fraction with a whole number
			Whole1 = Integer.parseInt(input.substring(0,firstUnder));	
			Numerator1 = Integer.parseInt(input.substring(firstUnder+1,firstDiv));
			Denominator1 = Integer.parseInt(input.substring(firstDiv+1,space));
  		  } else if (firstOperand.indexOf("_") == -1 && input.lastIndexOf("/") != -1) { //just a fraction with no whole
			Whole1 = 0;
			Numerator1 = Integer.parseInt(input.substring(0,firstDiv));
			Denominator1 = Integer.parseInt(input.substring(firstDiv+1,space));
		    }
		//parses the second fraction 
		if (secondOperand.indexOf("_") == -1 && secondOperand.indexOf("/") == -1) { //just the whole number
        	Whole2 = Integer.parseInt(secondOperand);
        	Numerator2 = 0;
        	Denominator2 = 1;
        } else if (secondOperand.indexOf("_") != -1 && secondOperand.indexOf("/") != -1) { //fraction with a whole number
			Whole2 = Integer.parseInt(input.substring(secondSpace+1,secondUnder));	
			Numerator2 = Integer.parseInt(input.substring(secondUnder+1,secondDiv));
			Denominator2 = Integer.parseInt(input.substring(secondDiv+1,length));
  		  } else if (secondOperand.indexOf("_") == -1 && input.lastIndexOf("/") != -1) { //just a fraction with no whole
			Whole2 = 0;
			Numerator2 = Integer.parseInt(input.substring(secondSpace + 1,secondDiv));
			Denominator2 = Integer.parseInt(input.substring(secondDiv+1,length));
		    }
		
		String answer = "x";
		//looks for the operator and pushes the needed values to the appropriate method
		if (input.indexOf(" + ") != -1) { //addition
			answer = add(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		if (input.indexOf(" - ") != -1) { //subtraction
			answer = sub(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		if (input.indexOf(" * ") != -1) { //multiplication
			answer = mul(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		if (input.indexOf(" / ") != -1) { //division
			answer = div(Whole1, Whole2, Numerator1, Numerator2, Denominator1, Denominator2);
		}
		return answer;
    }
   //addition method
    public static String add(int Whole1, int Whole2, int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	String answer = "x";
    	int numFinal = 0;
    	int denFinal = 0;
    	int finalWhole = 0;
    	//converts to improper fraction
    	if(Whole1 < 0) {
			Numerator1 = (Whole1 * Denominator1) - Numerator1;
		} else {
			Numerator1 = (Whole1 * Denominator1) + Numerator1;
		}
		if(Whole2 < 0) {
			Numerator2 = (Whole2 * Denominator2) - Numerator2;
		} else {
			Numerator2 = (Whole2 * Denominator2) + Numerator2;
		}
		//common denominator
		if(Denominator2 != Denominator1) {
			Numerator2 *= Denominator1;
			Numerator1 *= Denominator2;
			Denominator1 *= Denominator2;
			Denominator2 = Denominator1;
		}
		//runs the operation
		numFinal = Numerator1 + Numerator2;
		denFinal = Denominator1;
		finalWhole = numFinal / denFinal;
		numFinal = numFinal % denFinal;
		//simplifies the fractions
		int simple = gcd(numFinal, denFinal);
    	numFinal = numFinal/simple;
    	denFinal = denFinal/simple;
		//puts the answer together in the appropriate format
		if(finalWhole == 0 && numFinal != 0) { //fraction
			answer = numFinal + "/" + (Math.abs(denFinal));
		} else if(finalWhole != 0 && numFinal != 0) { //mixed number
			answer = finalWhole + "_" + (Math.abs(numFinal)) + "/" + (Math.abs(denFinal));
		} else if(finalWhole != 0 && numFinal == 0) { //whole number
			answer = Integer.toString(finalWhole);
		} else if(finalWhole == 0 && numFinal == 0) {//zero
			answer = Integer.toString(finalWhole);
		}
		return answer;
    }
    
    public static String sub(int Whole1,int Whole2,int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	String answer = "x";
		int finalWhole;
		int numFinal;
		int denFinal;
		//converts to improper fraction
		if (Whole1 < 0) {
    		Numerator1 = (Whole1 * Denominator1) - Numerator1;
    	} else if (Whole1 > 0) {
    		Numerator1 = (Whole1 * Denominator1) + Numerator1;
    	  }
    	if (Whole2 < 0) {
    		Numerator2 = (Whole2 * Denominator2) - Numerator2;
    	} else if (Whole2 > 0) {
    		Numerator2 = (Whole2 * Denominator2) + Numerator2;
    	  }
    	//common denominator
    	if (Denominator1 != Denominator2) {
    		Numerator2 *= Denominator1;
    		Numerator1 *= Denominator2;
    		Denominator1 *= Denominator2;
    		Denominator2 = Denominator1;
    	}
    	//runs the operation
    	numFinal = Numerator1 - Numerator2;
    	denFinal = Denominator1;
    	finalWhole = numFinal / denFinal;
    	numFinal = numFinal % denFinal;
    	//simplify function
    	int simple = gcd(numFinal, denFinal);
    	numFinal = numFinal/simple;
    	denFinal = denFinal/simple;
		//puts the answer together in the appropriate format
		if(finalWhole == 0 && numFinal != 0) { //fraction
			answer = numFinal + "/" + (Math.abs(denFinal));
		} else if(finalWhole != 0 && numFinal != 0) { //mixed number
			answer = finalWhole + "_" + (Math.abs(numFinal)) + "/" + (Math.abs(denFinal));
		} else if(finalWhole != 0 && numFinal == 0) { //whole number
			answer = Integer.toString(finalWhole);
		} else if(finalWhole == 0 && numFinal == 0) {//zero
			answer = Integer.toString(finalWhole);
		}
    	return answer;
    }
    
    public static String mul(int Whole1,int Whole2,int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	String answer = "x";
		int finalWhole;
		int numFinal;
		int denFinal;
		//converts to improper fraction
    	if (Whole1 < 0) {
    		Numerator1 = (Whole1 * Denominator1) - Numerator1;
    	} else if (Whole1 > 0) {
    		Numerator1 = (Whole1 * Denominator1) + Numerator1;
    	  }
    	if (Whole2 < 0) {
    		Numerator2 = (Whole2 * Denominator2) - Numerator2;
    	} else if (Whole2 > 0) {
    		Numerator2 = (Whole2 * Denominator2) + Numerator2;
    	  }
    	//runs the operation
    	numFinal = Numerator1 * Numerator2;
    	denFinal = Denominator1 * Denominator2;
    	finalWhole = numFinal / denFinal;
    	numFinal = numFinal % denFinal;
    	//simplify function
    	int simple = gcd(numFinal, denFinal);
    	numFinal = numFinal/simple;
    	denFinal = denFinal/simple;
    	
		//puts the answer together in the appropriate format
		if (finalWhole == 0 && numFinal != 0) {
			answer = numFinal + "/" + (Math.abs(denFinal));
		} else if (finalWhole != 0 && numFinal != 0) {
			answer = finalWhole + "_" + (Math.abs(numFinal)) + "/" + (Math.abs(denFinal));
		} else if (finalWhole != 0 && numFinal == 0) {
			  answer = Integer.toString(finalWhole);
	    } else if (finalWhole == 0 && numFinal == 0) {
		    	answer = Integer.toString(finalWhole);
		}
    	return answer;
    }
    public static String div(int Whole1,int Whole2,int Numerator1, int Numerator2, int Denominator1, int Denominator2) {
    	String answer = "x";
		int finalWhole;
		int numFinal;
		int denFinal;
		//converts to improper fraction
    	if (Whole1 < 0) {
    		Numerator1 = (Whole1 * Denominator1) - Numerator1;
    	} else if (Whole1 > 0) {
    		Numerator1 = (Whole1 * Denominator1) + Numerator1;
    	  }
    	if (Whole2 < 0) {
    		Numerator2 = (Whole2 * Denominator2) - Numerator2;
    	} else if (Whole2 > 0) {
    		Numerator2 = (Whole2 * Denominator2) + Numerator2;
    	  }
    	//reciprocal of second fraction
    	int rec = Numerator2;
    	Numerator2 = Denominator2;
    	Denominator2 = rec;
    	//runs multiplication
    	numFinal = Numerator1 * Numerator2;
    	denFinal = Denominator1 * Denominator2;
    	finalWhole = numFinal / denFinal;
    	numFinal = numFinal % denFinal;
    	//simplify function
    	int simple = gcd(numFinal, denFinal);
    	numFinal = numFinal/simple;
    	denFinal = denFinal/simple;
    	//puts the answer together in the appropriate format
		if (finalWhole == 0 && numFinal != 0) {
			answer = numFinal + "/" + (Math.abs(denFinal));
		} else if (finalWhole != 0 && numFinal != 0) {
			answer = finalWhole + "_" + (Math.abs(numFinal)) + "/" + (Math.abs(denFinal));
		} else if (finalWhole != 0 && numFinal == 0) {
			  answer = Integer.toString(finalWhole);
	    } else if (finalWhole == 0 && numFinal == 0) {
		    	answer = Integer.toString(finalWhole);
		}
    	return answer;
    }
    public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
    	return (gcd(b, a%b));
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
}
