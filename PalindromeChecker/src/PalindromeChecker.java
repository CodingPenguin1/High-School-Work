/*
 * Title: Palindrome Checker
 * Author: Ryan Slater
 * Date: 9/9/2017
 * Purpose: Check if a string is a palindrome
 */
public class PalindromeChecker{
	
	public void analyzeIt(String text){
		
		String originalText = new String(text);
		boolean isPalindrome = true;
		text = text.replace(" ", "");
		text = text.replace("~", "");
		text = text.replace("`", "");
		text = text.replace("!", "");
		text = text.replace("@", "");
		text = text.replace("#", "");
		text = text.replace("$", "");
		text = text.replace("%", "");
		text = text.replace("^", "");
		text = text.replace("&", "");
		text = text.replace("*", "");
		text = text.replace("(", "");
		text = text.replace(")", "");
		text = text.replace("-", "");
		text = text.replace("_", "");
		text = text.replace("=", "");
		text = text.replace("+", "");
		text = text.replace("[", "");
		text = text.replace("]", "");
		text = text.replace("{", "");
		text = text.replace("}", "");
		text = text.replace("\\", "");
		text = text.replace("|", "");
		text = text.replace(";", "");
		text = text.replace(":", "");
		text = text.replace("\"", "");
		text = text.replace("\'", "");
		text = text.replace(",", "");
		text = text.replace(".", "");
		text = text.replace("<", "");
		text = text.replace(">", "");
		text = text.replace("/", "");
		text = text.replace("?", "");
		
		text = text.toLowerCase();
		text = text.trim();
		
		for(int i=0; i<text.length()/2; i++){
			if(text.charAt(i) != text.charAt(text.length()-1-i)){
					isPalindrome = false;
			}
			
		}
		
		if(isPalindrome == true){
			System.out.println("\"" + originalText + "\" is a palindrome.");
		}else{
			System.out.println("\"" + originalText + "\" is NOT a palindrome.");
		}
		
	}
}