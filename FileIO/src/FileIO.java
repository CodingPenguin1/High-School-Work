
/* Title: File IO
 * Author: Ryan Slater
 * Date: 11/29/2017
 */

import java.util.*;
import java.io.*;

public class FileIO {

	public static void main(String[] args) throws IOException {
		
		Random rand = new Random();
		
		Scanner fileReader = new Scanner(new File("/home/rjslater/Documents/EclipseWorkspace/FileIO/nouns"));
		String[] nouns = new String[100];
		int nounsLogicalSize = -1;
		while (fileReader.hasNext()) {
			nounsLogicalSize++;
			nouns[nounsLogicalSize] = fileReader.nextLine();
		}

		fileReader = new Scanner(new File("/home/rjslater/Documents/EclipseWorkspace/FileIO/verbs"));
		String[] verbs = new String[100];
		int verbsLogicalSize = -1;
		while (fileReader.hasNext()) {
			verbsLogicalSize++;
			verbs[verbsLogicalSize] = fileReader.nextLine();
		}

		fileReader = new Scanner(new File("/home/rjslater/Documents/EclipseWorkspace/FileIO/adverbs"));
		String[] adverbs = new String[100];
		int adverbsLogicalSize = -1;
		while (fileReader.hasNext()) {
			adverbsLogicalSize++;
			adverbs[adverbsLogicalSize] = fileReader.nextLine();
		}

		for (int i = 0; i < 10; i++) {
			int noun = rand.nextInt(nounsLogicalSize);
			int verb = rand.nextInt(verbsLogicalSize);
			int adverb = rand.nextInt(adverbsLogicalSize);
			System.out.println(nouns[noun] + " " + verbs[verb] + " " + adverbs[adverb]);
			
		}

		fileReader.close();

	}
}