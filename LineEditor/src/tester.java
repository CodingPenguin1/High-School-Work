/*
 * Title: Line Editor Tester
 * Author: Ryan Slater
 * Date: 9/11/2017
 * Purpose: Test the line editor class
 */
public class tester {

	public static void main(String[] args) {
		
		//Make myLine public temporarily for testing
		
		LineEditor le = new LineEditor("Computer Science");
		le.insert("A.P.", 0);
		System.out.println(le.toString() + " should be \"A.P.Computer Science\"");
		LineEditor le2 = new LineEditor("Computer Science");
		le2.insert(" is best", 16);
		System.out.println(le2.toString() + " should be \"Computer Science is best\"");
		LineEditor le3 = new LineEditor("Computer Science");
		le3.insert("Java", 4);
		System.out.println(le3.toString() + " should be \"CompJavauter Science\"");
		
		LineEditor le4 = new LineEditor("Computer Science");
		le4.delete("Com");
		System.out.println(le4.toString() + " should be \"puter Science\"");
		LineEditor le5 = new LineEditor("Computer Science");
		le5.delete("ter Sc");
		System.out.println(le5.toString() + " should be \"Compuience\"");
		LineEditor le6 = new LineEditor("Computer Science");
		le6.delete("c");
		System.out.println(le6.toString() + " should be \"Computer Sience\"");
		LineEditor le7 = new LineEditor("Computer Science");
		le7.delete("Java");
		System.out.println(le7.toString() + " should be \"Computer Science\"");
		
		LineEditor le8 = new LineEditor("string programming");
		le8.deleteAll("ing");
		System.out.println(le8.toString() + " should be \"str programm\"");
		LineEditor le9 = new LineEditor("string programming");
		le9.deleteAll("r");
		System.out.println(le9.toString() + " should be \"sting pogamming\"");
		LineEditor le10 = new LineEditor("abababa");
		le10.deleteAll("aba");
		System.out.println(le10.toString() + " should be \"b\"");
		LineEditor le11 = new LineEditor("ooh-lah-lah");
		le11.deleteAll("oh-la");
		System.out.println(le11.toString() + " should be \"h\"");
		LineEditor le12 = new LineEditor("pizza pie");
		le12.deleteAll("zap");
		System.out.println(le12.toString() + " should be \"pizza pie\"");
		
	}

}