/**
	Credit Card Validator

	Utilizes the 'Luhn Check' to Determine if a Credit Card is a valid
	credit card number. The 'Luhn Check' looks to see if the sum of the odd
	numbers plus the sum of the even numbers (doubled) is divisible by 10.

	@author  S.Craig
	@date    10-22-2018
	
*/
import java.util.Scanner;
public class CreditCardValidatorCraigSamuel {
	/**
	Main Method
	*/
	public static void main (String[] args) {
		//String card = "4847352989263094";

		// When you are finished writing the methods below,
		// uncomment the three lines below to test.
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Credit Card Number: ");
		String card = input.nextLine();

		// Should say "Visa"
		System.out.println("getCompany: " + getCompany(card));
		// Should say "5"
		System.out.println("getDigit: " + getDigit(5)); 
		// Should say "7"
		System.out.println("getDigit: " + getDigit(16)); 
		// Should say "52"
		System.out.println("sumOfDoubleEvenPlace: " + sumOfDoubleEvenPlace(card)); 
		// Should say "48"
		System.out.println("sumOfOddPlace: " + sumOfOddPlace(card)); 
		// Should say "true"
		System.out.println("isValid: " + isValid(card)); 

		if ( isValid(card) ) {
			// If True, display the company and state it is valid
		} else {
			// If False, state the card number is invalid
		}
	}

	// Problem 1 ==================================================================
	/** 
		Return the company of the card by looking at the character
		at the zero (0) index of number.

		@param number: A 13 to 16 digit String of numbers

		@returns a String that is either 
		"Visa", "Master Card", "American Express", or "Discover Card"
	*/
	public static String getCompany(String number){
		int company = Character.getNumericValue(number.charAt(0));
		int company2 = Character.getNumericValue(number.charAt(1));
		String companyName = "";
		
		if (company != 3) {
			switch (company) {
				case 4: companyName = "Visa"; break;
				case 5: companyName = "Master Card"; break;
				case 6: companyName = "Discover Card"; break;
				default: companyName = "Invalid Company";
			}
		} else {
			if ((company == 3) && (company2 == 7)) {
				companyName = "American Express";
			} else {
		   companyName = "Invalid Company";
         }
		}

		return companyName;
	}
	
	// Problem 2 ==================================================================
	/** 
		Return this number if it is a single digit, otherwise, return the sum 
		of the two digits. For example, 18 will return 9 (because 1 + 8).

		@param number: a digit that will be between 0 and 18

		@returns an integer
	*/
	public static int getDigit(int number){

		if (number < 10) {
			return number;
		} else {
			return (number - 9);
		}
		
	}
	
	// Problem 3 ==================================================================
	/** 
		Double every second digit from *right to left*. 

		If doubling of a digit results in a two-digit number, add the two digits
		together to get a single digit number using the getDigit(...) method.

		Use a *loop* to cycle through all the numbers of the String.
		Note: You will need to *convert a char to an int*

		@param number: A 13 to 16 digit String of numbers

		@returns an integer
	*/
	public static int sumOfDoubleEvenPlace(String number){
		int sum = 0;
		int i = number.length() - 2;
		
		while ( i >= 0) {
			char digitChar = number.charAt(i);
			int digitInt = Character.getNumericValue(digitChar);
			sum += getDigit(2 * digitInt);
			i -= 2;
		}

		
		return sum; 
	}
	
	// Problem 4 ==================================================================
	/** 
		Return sum of odd-place digits in number

		Use a *loop* to cycle through all the numbers of the String.
		Note: You will need to *convert a char to an int*

		@param number: A 13 to 16 digit String of numbers

		@returns an integer
	*/
	public static int sumOfOddPlace(String number){
		int sum = 0;
		int i = number.length() - 1;
		
		while ( i > 0) {
			char digitChar = number.charAt(i);
			int digitInt = Character.getNumericValue(digitChar);
			sum += getDigit(digitInt);
			i -= 2;
		}
		
		return sum; 
	}
	
	// Problem 5 ==================================================================
	/** 
		Returns true if the card number is valid 

		To determine if a card is valid, the sum of the Double Even Place
		Numbers and the Sum of the Odd Place Numbers must be divisible by
		ten (10) (use modulus to determine if the number is divisible), 
		the String must be 13 to 16 digits, *and* the String must start
		with "4", "5", "37", or "6".

		@param number: A 13 to 16 digit String of numbers

		@returns true if the String is a valid card, False otherwise
	*/
	public static boolean isValid(String number){
		
		
		int tenDivisible = (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number))%10;
		boolean numberValid = tenDivisible == 0;
		boolean companyValid = getCompany(number) != "Invalid Company";
		boolean numberLengthValid = number.length() > 14 && number.length() < 17;
		
		if (numberValid && companyValid && numberLengthValid) {
			return true;
		} else {
			return false;
		}
	}
}
