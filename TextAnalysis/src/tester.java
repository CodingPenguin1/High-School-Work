/*
 * Title: Text Analysis
 * Author: Ryan Slater
 * Date: 9/9/2017
 * Purpose: determine the number of words, sentences, and occurrences of a given keyword in a string of text
 */
public class tester {

	public static void main(String[] args) {
		
		TextAnalysis txt = new TextAnalysis();
		
		String text = "Hi. My name is Mr Schultz.";
		String keyword = "NaMe";
		txt.analyzeIt(text, keyword);
		
		text = "This is a test. A test this is. Is this a test? This is a test!";
		keyword = "is";
		txt.analyzeIt(text, keyword);
	
		text = "Kent keeps the pace fast, but smooth. Run within yourself, he recommends. The tough parts are to come. Though at his 2015 record, he shifted strategy. I decided from the gun I was just going to go as hard as I could for as long as I could. It ended up turning out well, he says.";
		keyword = "he";
		txt.analyzeIt(text, keyword);
		
	}
}