import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

//********************************************************************
//
//Author:        Madeline Weber
//
//Program:       Multiplication Quiz
//
//File Name:     MultiplicationQuiz.java
//
//Description:   This program helps elementary school children learn
//				 multiplication by generating random numbers to quiz the user with. 
//				 Originally completed as part of a homework assignment.
//
//********************************************************************
public class MultiplicationQuiz {

	public static void main(String[] args){
		// Create object
			MultiplicationQuiz myObject = new MultiplicationQuiz();
			
			myObject.startQuiz();
		}
	  //
	   //  Method:       startQuiz
	   // 
	   //  Description:  This method begins the quiz and counts to five
	   // 				 using a boolean expression. After five questions are 
	   // 				 correctly answers, it asks the user if they want to continue with the quiz.
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      None
	   //
	   //************************************************************** 
	
	public void startQuiz(){
		boolean allCorrect = true;
		for(int x = 0; x < 5; x++){
			int[] randomNumbers = get_Random();
			while(!get_Questions(randomNumbers)){ //get_Questions(randomNumbers) == false
				allCorrect = false;
			}
		}
		if(allCorrect){ //allCorrect == true
			extra_Questions();
		}
	}

	// ***************************************************************
	   //
	   //  Method:       get_Random
	   // 
	   //  Description:  This method generates random numbers for the quiz
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      a random array
	   //
	   //************************************************************** 
	public int[] get_Random(){
		
		//Scanner scanner = new Scanner(System.in);
		SecureRandom random = new SecureRandom();
		
		int numberOne = random.nextInt(9) + 1;
		int numberTwo = random.nextInt(9) + 1; 
		
		int [] generateRandom = new int[2]; 
		generateRandom[0] = numberOne;
		generateRandom[1] = numberTwo;
		
		//RandNumbers.add(generateRandom);  
    return generateRandom;
	}
	
	// ***************************************************************
	   //
	   //  Method:       get_Questions
	   // 
	   //  Description:  This method uses the two random ints to create the multiplication question
	   //
	   //  Parameters:   int[] randomNumbers
	   //
	   //  Returns:      boolean expression true or false
	   //
	   //************************************************************** 
	public boolean get_Questions(int[] randomNumbers){
		
		Scanner scannertwo = new Scanner (System.in);
				
		System.out.printf("How much is %d%s%d%s%n", randomNumbers[0], " times ",  randomNumbers[1],  "?");
		// Declare variables 
		int answer = scannertwo.nextInt(); // get response
 		
		if (answer == (randomNumbers[0] * randomNumbers[1])) {
				CorrectResponse();
				return true;
 			}
		else {
				IncorrectResponse();
 			//System.out.printf("How much is %d%s%d%s%n", generateRandom[0], " times ",  generateRandom[1],  "?");
 			return false;
 				}	
	}
	// ***************************************************************
	   //
	   //  Method:       CorrectResponse
	   // 
	   //  Description:  Array list of correct response outcomes
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      N/A 
	   //
	   //************************************************************** 
	public void CorrectResponse(){
		
		// Create array of possible correct responses
		String [] CorrectResponse = {"Excellent!", "Very good!", "Nice Work!", "Way to go!", "Keep up the good work!"};
		SecureRandom rand = new SecureRandom();
		
		int i = rand.nextInt(CorrectResponse.length); 
		System.out.println(CorrectResponse[i]);
		
	}
	
	// ***************************************************************
	   //
	   //  Method:       IncorrectResponse
	   // 
	   //  Description:  Array list of incorrect response outcomes
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      N/A 
	   //
	   //************************************************************** 
	public void IncorrectResponse(){
		
		// Create array of possible incorrect responses
		String [] IncorrectResponse = {"That is incorrect!", "No, please try again!", "Wrong, try once more!", "No. Don't give up!", "Incorrect. Keep trying!"};
		SecureRandom random = new SecureRandom();
		
		int i = random.nextInt(IncorrectResponse.length);
		System.out.println(IncorrectResponse[i]);
	}
	
	// ***************************************************************
	   //
	   //  Method:       extra_Questions
	   // 
	   //  Description:  This method offers extra questions to the user after they 
	   //  				 complete five correct questions. 
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      N/A 
	   //
	   //************************************************************** 
	public void extra_Questions(){
		
		System.out.println("Would you like to continue? Enter 'Y' to continue or 'N' to quit: ");
		Scanner scannerExtra = new Scanner(System.in);
		String extraresponse = scannerExtra.next();
		
		while ( extraresponse == "Y" ){
			SecureRandom random = new SecureRandom();
			
			int number1 = random.nextInt(9) + 1;
			int number2 = random.nextInt(9) + 1; 
			
			System.out.println("How much is " + number1 + " times " + number2 + "?");
			int response = scannerExtra.nextInt();
			if (response == ( number1 * number2)){
				CorrectResponse();
				System.out.println("Would you like to continue? Enter n 'Y' to continue or 'N' to quit: ");
				extraresponse = scannerExtra.next();
			}
			else{
				IncorrectResponse();
				response = scannerExtra.nextInt();
			}
			if (extraresponse == "N"){
				System.out.println("Thank you! Goodbye.");
			}
		}
		if ( extraresponse == "N"){
			System.out.println("Thank you! Goodbye.");
		}
		
	} // End Program
}
