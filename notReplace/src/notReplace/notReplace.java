/* Title: notReplace.java
 * Author: Ryan J. Slater
 * Date: May 4, 2018
 */
package notReplace;

public class notReplace {

	public static void main(String[] args) {
		System.out.println(notReplace("is test"));
	}

	public static String notReplace(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if (i - 1 >= 0 && Character.isLetter(str.charAt(i - 1)) || i + 2 < str.length() && Character.isLetter(str.charAt(i + 2)))
				s += str.charAt(i);
			else if (i + 1 < str.length() && str.substring(i, i + 2).equals("is")) {
				s += "is not";
				i++;
			}
		}

		return s;
	}

}
