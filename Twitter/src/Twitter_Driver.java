//Created by: Miss Galanos
//version 12.8.2015

//Modified for BHS environment by Mr. Schultz
//version 2.9.2016

import twitter4j.*; //set the classpath to lib\twitter4j-core-4.0.2.jar
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Twitter_Driver {
	private static PrintStream consolePrint;

	public static void main(String[] args) throws TwitterException, IOException {
		consolePrint = System.out;
		TJTwitter bigBird = new TJTwitter(consolePrint);

		////////////
		// PART 1 //
		////////////

		// set up classpath and properties file
		// create message to tweet, then call the tweetOut method

		// !! DO NOT CHANGE THIS MESSAGE! //

		// String message = "I just tweeted from my Java program! #APCSRocks @bellbrook_high @RobSchultzMath -- Thanks @cscheerleader!";
		// bigBird.tweetOut(message);

		////////////
		// PART 2 //
		////////////

		// Choose a public Twitter user's handle

		Scanner scan = new Scanner(System.in);
		consolePrint.print("Please enter a Twitter handle, do not include the @symbol --> ");
		String twitter_handle = scan.next();

		while (!twitter_handle.equals("done")) { // Print the most popular word they tweet
			bigBird.makeSortedListOfWordsFromTweets(twitter_handle);
			consolePrint.println("The most common word from @" + twitter_handle + " is: " + bigBird.mostPopularWord());
			bigBird.investigate();
			consolePrint.println();
			consolePrint.print("Please enter a Twitter handle, do not include the @ symbol --> ");
			twitter_handle = scan.next();
		}

		scan.close();
	}// end main

}// end driver

class TJTwitter {
	private Twitter twitter;
	private PrintStream consolePrint;
	private List<Status> statuses;
	private List<String> sortedTerms;

	public TJTwitter(PrintStream console) {
		// Makes an instance of Twitter - this is re-useable and thread safe.
		twitter = TwitterFactory.getSingleton(); // connects to Twitter and performs authorizations
		consolePrint = console;
		statuses = new ArrayList<Status>();
		sortedTerms = new ArrayList<String>();
	}

	/****************** Part 1 *******************/
	public void tweetOut(String message) throws TwitterException, IOException {
		twitter.updateStatus(message);
	}

	@SuppressWarnings("unchecked")
	/****************** Part 2 *******************/
	public void makeSortedListOfWordsFromTweets(String handle) throws TwitterException, IOException {
		statuses.clear();
		sortedTerms.clear();
		PrintStream fileout = new PrintStream(new FileOutputStream("tweets.txt"));
		Paging page = new Paging(1, 200);
		int p = 1;
		while (p <= 10) {
			page.setPage(p);
			statuses.addAll(twitter.getUserTimeline(handle, page));
			p++;
		}
		int numberTweets = statuses.size();
		fileout.println("Number of tweets = " + numberTweets);

		fileout = new PrintStream(new FileOutputStream("garbageOutput.txt"));

		int count = 1;
		for (Status j : statuses) {
			fileout.println(count + ".  " + j.getText());
			count++;
		}

		// Makes a list of words from user timeline
		for (Status status : statuses) {
			String[] array = status.getText().split(" ");
			for (String word : array)
				sortedTerms.add(removePunctuation(word).toLowerCase());
		}

		// Remove common English words, which are stored in commonWords.txt
		sortedTerms = removeCommonEnglishWords(sortedTerms);
		sortAndRemoveEmpties();
		fileout.close();
	}

	// Sort words in alpha order. You should use your old code from the
	// Sort/Search unit.
	// Remove all empty strings ""
	private void sortAndRemoveEmpties() {
		for (String i : sortedTerms) {
			if ("".equals(i)) {
				sortedTerms.remove(i);
			}
		}
		sortedTerms = insertionSort(sortedTerms);
	}

	public static List<String> insertionSort(List<String> a) {
		for (int i = 1; i < a.size(); i++) {
			String tmp = a.get(i);
			int j = i;
			while (j > 0 && a.get(j - 1).compareTo(tmp) > 0) {
				a.set(j, a.get(j - 1));
				j--;
			}
			a.set(j, tmp);
		}
		return a;
	}

	// Removes common English words from list
	// Remove all words found in commonWords.txt from the argument list.
	// The count will not be given in commonWords.txt. You must count the number
	// of words in this method.
	// This method should NOT throw an exception. Use try/catch.
	@SuppressWarnings("unchecked")
	private List removeCommonEnglishWords(List<String> list) {
		List<String> cleaned = new ArrayList<String>();
		String filePath = new String("/home/rjslater/Documents/EclipseWorkspace/Twitter/TJTClassFolder/commonlyUsedWords");
		Scanner reader = null;
		for (String i : list) {
			try {
				reader = new Scanner(new File(filePath));
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
			boolean common = false;
			while (reader.hasNext()) {
				String word = reader.nextLine();
				if (word.equals(i))
					common = true;
			}
			if (!common)
				cleaned.add(i);
		}
		reader.close();
		return cleaned;
	}

	// Remove punctuation - borrowed from prevoius lab
	// Consider if you want to remove the # or @ from your words. They could be
	// interesting to keep (or remove).
	private String removePunctuation(String s) {
		String anum = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String x = new String();
		for (int i = 0; i < s.length(); i++) {
			if (anum.indexOf(s.charAt(i)) != -1) {
				x += s.charAt(i);
			}
		}
		return x;
	}

	// Should return the most common word from sortedTerms.
	// Consider case. Should it be case sensitive? The choice is yours.
	@SuppressWarnings("unchecked")
	public String mostPopularWord() {
		String mostPopular = new String(sortedTerms.get(0));
		int wordCount = 0;
		int currentCount = 0;
		for (int i = 1; i < sortedTerms.size(); i++) {
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

	/****************** Part 3 *******************/
	public void investigate() {
		boolean valid = false;
		int i = 0;
		String stat = new String();
		while (!valid) {
			stat = statuses.get(i).getText();
			if (!stat.substring(0, 2).equals("RT"))
				valid = true;
			i++;
		}
		stat = stat.toLowerCase();
		String alpha = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		boolean upper = true;
		for (i = 0; i<stat.length(); i++) {
			if(alpha.indexOf(stat.charAt(i)) != -1)
				if (upper) {
					stat = stat.substring(0, i) + Character.toUpperCase(stat.charAt(i)) + stat.substring(i+1);
					upper = false;
				}else {
					upper = true;
				}
		}
		System.out.println(stat);
	}

	// A sample query to determine how many people in Arlington, VA tweet about
	// the Miami Dolphins
	public void sampleInvestigate() {
		Query query = new Query("Miami Dolphins");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(38.8372839, -77.1082443), 5, Query.MILES);
		query.setSince("2015-12-1");
		try {
			QueryResult result = twitter.search(query);
			System.out.println("Count : " + result.getTweets().size());
			for (Status tweet : result.getTweets()) {
				System.out.println("@" + tweet.getUser().getName() + ": " + tweet.getText());
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

}

// Consider adding a sorter class here.