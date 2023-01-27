/*
 * Title: Text Analysis
 * Author: Ryan Slater
 * Date: 9/9/2017
 * Purpose: determine the number of words, sentences, and occurrences of a given keyword in a string of text
 */
public class TextAnalysis{
	
	public void analyzeIt(String text, String keyword){
		
		text = text.toLowerCase();
		String lowerKeyword = keyword.toLowerCase();
		String notWords = " .,?!";
		int words = 0, sentences = 0, keywords = 0;
		
		for(int i=0; i<text.length(); i++){
			if ((text.charAt(i) == '.') || (text.charAt(i) == '!') || (text.charAt(i) == '?')){
				sentences++;
			}		
		}
		
		for(int i=1; i<text.length(); i++){
			boolean alphaChar = true, lastAlphaChar = true;
			if (notWords.contains(String.valueOf(text.charAt(i)))){
				alphaChar = false;
			}else{
				alphaChar = true;
			}
			if (notWords.contains(String.valueOf(text.charAt(i-1)))){
				lastAlphaChar = false;
			}else{
				lastAlphaChar = true;
			}
			
			if((lastAlphaChar == true) && (alphaChar == false)){
				words++;
			}
		}
		
		for(int i=0; i<text.length()-keyword.length(); i++){
			String substring = text.substring(i, i+keyword.length());
			if(substring.contains(lowerKeyword)){
				keywords++;
			}
		}
		
		System.out.println("Number of words: " + words);
		System.out.println("Number of sentences: " + sentences);
		System.out.println("Number of occurrences of \"" + keyword + "\": " + keywords);
		
	}
}