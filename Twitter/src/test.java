import java.util.*;

public class test {
	
	
	
	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("wow");
		s.add("hello");
		s.add("goodbye");
		s.add("wow");
		s.add("wow");

		s = sortAndRemoveEmpties(s);
		System.out.println(s);
		System.out.println("Most popular word: " + mostPopularWord(s));
	}
	
	public static String mostPopularWord(List<String> sortedTerms) {
		String mostPopular = new String(sortedTerms.get(0));
		int wordCount = 0;
		int currentCount = 0;
		for (int i = 1; i < sortedTerms.size(); i++) {
			System.out.println(mostPopular + ": " + wordCount + " / " + sortedTerms.get(i) + ", " + sortedTerms.get(i-1) + " : " + currentCount);
			if (sortedTerms.get(i).equals(sortedTerms.get(i - 1))) {
				currentCount++;
			} else {
				currentCount = 0;
			}
			if (currentCount > wordCount) {
				mostPopular = sortedTerms.get(i);
				wordCount = currentCount;
			}
		}

		return mostPopular;
	}
	
	public static List<String> sortAndRemoveEmpties(List<String> sortedTerms) {
		List<String> s = new ArrayList<String>();
		for (String i : sortedTerms) {
			if ("".equals(i)) {
				sortedTerms.remove(i);
			}
		}
		// TODO: actually use my sort alg
		Collections.sort(sortedTerms);
		return sortedTerms;
	}
}