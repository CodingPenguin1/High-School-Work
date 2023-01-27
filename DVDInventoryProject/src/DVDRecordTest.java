/* Title: DVD Inventory Tester
 * Author: Ryan Slater
 * Date: 11/30/2017
 */

public class DVDRecordTest {

	public static void main(String args[]) {
		
		DVDRecord d = new DVDRecord("Title", "Director", "Genre", "Star");
		System.out.println("Title: " + d.getTitle());
		System.out.println("Director: " + d.getDirector());
		System.out.println("Genre: " + d.getGenre());
		System.out.println("Star: " + d.getStar());
		
		d.setTitle("Wow a new title");
		d.setDirector("Noice its a director");
		d.setGenre("Some random genre");
		d.setStar("The amazing Ryan Slater");
		System.out.println(d.toString());
		
	}
}