/*
 * Title: Palindrome Checker
 * Author: Ryan Slater
 * Date: 9/9/2017
 * Purpose: Check if a string is a palindrome
 */
public class tester{

	public static void main(String[] args){
		
		PalindromeChecker pdc = new PalindromeChecker();
		
		String text = "Hi. My name is Mr. Schultz";
		pdc.analyzeIt(text);
		
		text = "Able was I ere I saw elba";
		pdc.analyzeIt(text);
		
		text = "Race car";
		pdc.analyzeIt(text);
		
		text = "1234.321";
		pdc.analyzeIt(text);
		
		text = "h!@#%^%^&%$#@#@%%$~@`-==|}{{{:><>/.,./]h[][;.";
		pdc.analyzeIt(text);
		
	}
}