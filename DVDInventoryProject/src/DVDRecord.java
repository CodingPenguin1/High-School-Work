/* Title: DVD Record
 * Author: Ryan Slater
 * Date: 11/30/2017
 */

public class DVDRecord {
	
	String title = "N/A", director = "N/A", genre = "N/A", star = "N/A";
	
	public DVDRecord(String Title, String Director, String Genre, String Star) {
		title = Title;
		director = Director;
		genre = Genre;
		star = Star;
	}
	
	public void setTitle(String Title) {
		title = Title;
	}
	
	public void setDirector(String Director) {
		director = Director;
	}
	
	public void setGenre(String Genre) {
		genre = Genre;
	}

	public void setStar(String Star) {
		star = Star;
	}

	public String getTitle() {
		return title;
	}
	
	public String getDirector() {
		return director;
	}
	
	public String getGenre() {
		return genre;
	}

	public String getStar() {
		return star;
	}

	public String toString() {
		return("Title: " + title + "\nDirector: " + director + "\nGenre: " + genre + "\nStar: " + star + "\n");
	}
	
}