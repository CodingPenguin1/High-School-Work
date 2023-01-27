
import java.util.*;

public class sortTest {

	public static ArrayList<DVDRecord> sort(ArrayList<DVDRecord> dvds, String sortBy) {
		String[] array = new String[dvds.size()];
		if (sortBy.equals("title")) {
			for (int i = 0; i < dvds.size(); i++) {
				array[i] = dvds.get(i).getTitle();
			}
		} else if (sortBy.equals("director")) {
			for (int i = 0; i < dvds.size(); i++) {
				array[i] = dvds.get(i).getDirector();
			}
		} else if (sortBy.equals("genre")) {
			for (int i = 0; i < dvds.size(); i++) {
				array[i] = dvds.get(i).getGenre();
			}
		} else if (sortBy.equals("star")) {
			for (int i = 0; i < dvds.size(); i++) {
				array[i] = dvds.get(i).getStar();
			}
		}
		for (int i = 1; i < array.length; i++) {
			String tmp = array[i];
			DVDRecord tmp1 = dvds.get(i);
			int j = i;

			while (j > 0 && array[j-1].compareTo(tmp) > 0) {
				array[j] = array[j - 1];
				dvds.set(j, dvds.get(j-1));
				j--;
			}
			array[j] = tmp;
			dvds.set(j, tmp1);
		}
		return dvds;
	}

	public static void main(String[] args) {
		ArrayList<DVDRecord> dvds = new ArrayList<DVDRecord>();
		dvds.add(new DVDRecord("movie", "ADirector", "AGenre", "AStar"));
		dvds.add(new DVDRecord("a", "DDirector", "DGenre", "DStar"));
		dvds.add(new DVDRecord("BTitle", "BDirector", "BGenre", "BStar"));
		dvds.add(new DVDRecord("CTitle", "CDirector", "CGenre", "CStar"));

		dvds = sort(dvds, "title");

		for (int i = 0; i < dvds.size(); i++) {
			System.out.println(dvds.get(i).getTitle());
		}

	}

}
