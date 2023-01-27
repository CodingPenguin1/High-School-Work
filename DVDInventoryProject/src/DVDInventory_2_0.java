
/* Title: DVD Inventory
 * Author: Ryan Slater
 * Date: 1/4/2018
 */

import java.util.*;
import java.io.*;

public class DVDInventory_2_0 {

	public static void printOptions(String inventory) {
		if (inventory.equals("")) {
			inventory = "None";
		}
		System.out.println("\nCurrent Inventory: " + inventory);
		System.out.println("◦ Open an inventory");
		System.out.println("◦ Save an inventory");
		System.out.println("◦ Display an inventory");
		System.out.println("◦ Add a DVD");
		System.out.println("◦ Remove a DVD");
		System.out.println("◦ Quit");
	}

	public static void save(ArrayList<DVDRecord> dvds, int dvdsIndex, String file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);
		for (int i = 0; i <= dvdsIndex; i++) {
			if (dvds.isEmpty()) {
				break;
			}
			DVDRecord d = dvds.get(i);
			writer.println(d.getTitle() + "▩" + d.getDirector() + "▩" + d.getGenre() + "▩" + d.getStar());
		}
		writer.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		// make inventory = "None"
		String dir = "/home/rjslater/Documents/EclipseWorkspace/DVDInventoryProject/inventories/", inventory = "";
		Scanner input = new Scanner(System.in);
		ArrayList<DVDRecord> dvds = new ArrayList<DVDRecord>();
		int dvdsIndex = -1;

		while (true) {
			// Get Selection
			printOptions(inventory);
			int option;
			System.out.println("\nPlease select an option:");
			while (true) {
				String selection = input.nextLine().toLowerCase();
				if (selection.contains("open") || "open".contains(selection)) {
					option = 1;
					break;
				} else if (selection.contains("save") || "save".contains(selection)) {
					option = 2;
					break;
				} else if (selection.contains("display") || "display".contains(selection)) {
					option = 3;
					break;
				} else if (selection.contains("add") || "add".contains(selection)) {
					option = 4;
					break;
				} else if (selection.contains("remove") || "remove".contains(selection)) {
					option = 5;
					break;
				} else if (selection.contains("quit") || "quit".contains(selection)) {
					option = 6;
					break;
				} else {
					System.out.println("Please enter a one of the options");
				}
			}

			// Selection
			if (option == 1) {
				// Open an inventory file – Ask the user for the file name. You may hard-code the path.
				// Assume that if a new inventory file is opened, any existing information in the inventory will be replaced.

				// Prompting save of current inventory before changing
				if (!inventory.equals("")) {
					System.out.println("Would you like to save the current inventory?\n◦ Yes\n◦ No");
					while (true) {
						String saving = input.nextLine().toLowerCase();
						if (saving.contains("yes") || "yes".contains(saving)) {
							System.out.println("Saving inventory " + inventory);
							save(dvds, dvdsIndex, dir + inventory);
							break;
						} else if (saving.contains("no") || "no".contains(saving)) {
							System.out.println("Not saving inventory " + inventory);
							break;
						}
					}
				}

				// Getting list of all inventories
				File folder = new File(dir);
				File[] files = folder.listFiles();
				if (files.length == 0) {
					System.out.println("You have no inventories");
				} else {
					System.out.print("Your inventories: ");
					for (int i = 0; i < files.length; i++) {
						if (files.length - i == 1) {
							System.out.println(files[i].getName());
						} else {
							System.out.print(files[i].getName() + ", ");
						}
					}
					System.out.println("");
				}

				System.out.println("Enter the inventory name:");
				String newInventory = input.nextLine();
				while (true) {
					if (newInventory.length() > 20) {
						System.out.println("Max character length is 20");
						newInventory = input.nextLine();
					} else {
						break;
					}
				}

				File file = new File(dir + newInventory);
				dvds = new ArrayList<DVDRecord>();
				dvdsIndex = -1;
				if (file.exists()) {
					System.out.println("Opening " + newInventory);
					inventory = newInventory;
				} else {
					while (true) {
						int spaceCount = 0;
						for (int i = 0; i < newInventory.length(); i++) {
							if (newInventory.charAt(i) == ' ') {
								spaceCount++;
							}

						}
						if (spaceCount == 0) {
							break;
						} else {
							System.out.println("This inventory name contains spaces, which can corrupt files and cause damage to data.\nAre you sure you want to use this name?");
							String ok = input.nextLine().toLowerCase();
							if (ok.contains("yes") || "yes".contains(ok)) {
								break;
							} else {
								System.out.println("Enter the inventory name:");
								newInventory = input.nextLine();
							}
						}
					}
					inventory = newInventory;
					file = new File(dir + inventory);
					try {
						file.createNewFile();
						System.out.println("\nCreating new inventory \"" + inventory + "\"");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				// Loading inventory
				Scanner reader = new Scanner(new File(dir + inventory));
				while (reader.hasNext()) {
					dvdsIndex++;
					String title = "", director = "", genre = "", star = "";
					String data = reader.nextLine();
					int[] breakCharacters = new int[3];
					int count = 0;
					for (int i = 0; i < data.length(); i++) {
						if (data.charAt(i) == '▩') {
							breakCharacters[count] = i;
							count++;
						}
					}
					title = data.substring(0, breakCharacters[0]);
					director = data.substring(breakCharacters[0] + 1, breakCharacters[1]);
					genre = data.substring(breakCharacters[1] + 1, breakCharacters[2]);
					star = data.substring(breakCharacters[2] + 1, data.length());
					dvds.add(dvdsIndex, new DVDRecord(title, director, genre, star));
				}
				reader.close();

			} else if (option == 2) {
				// Save an inventory file – Ask the user for the file name. You may hard-code the path.
				if (inventory.equals("")) {
					System.out.println("No inventory is loaded!");
				} else {
					save(dvds, dvdsIndex, dir + inventory);
				}

			} else if (option == 3) {
				// Display the inventory – Display the state of each DVD in the inventory.
				if (inventory.equals("")) {
					System.out.println("No inventory is loaded!");
				} else {
					if (dvdsIndex == -1) {
						System.out.println("\n" + inventory + " is empty\n");
					} else {
						System.out.println("\n\nDVDs in " + inventory + ":\n");
						for (int i = 0; i <= dvdsIndex; i++) {
							if (dvds.isEmpty()) {
								break;
							}
							DVDRecord d = dvds.get(i);
							System.out.println(d.toString());
						}
					}
				}

			} else if (option == 4) {
				// Add a DVD – Manually add a DVD to the inventory.
				if (inventory.equals("")) {
					System.out.println("No inventory is loaded!");
				} else {
					System.out.println("Plese enter the title of the movie:");
					String title = input.nextLine();
					System.out.println("Plese enter the director of the movie:");
					String director = input.nextLine();
					System.out.println("Plese enter the genre of the movie:");
					String genre = input.nextLine();
					System.out.println("Plese enter the star of the movie:");
					String star = input.nextLine();
					dvdsIndex++;
					dvds.add(dvdsIndex, new DVDRecord(title, director, genre, star));
				}

			} else if (option == 5) {
				// Remove – Select and remove a DVD from an inventory
				if (dvds.isEmpty()) {
					System.out.println("There are no DVDs in this inventory to remove");
				} else {
					System.out.println("\n\nDVDs in " + inventory + ":\n");
					for (int i = 0; i <= dvdsIndex; i++) {
						if (dvds.isEmpty()) {
							break;
						}
						DVDRecord d = dvds.get(i);
						System.out.println(d.toString());
					}
					System.out.println("Please enter the title of the movie you want to remove:");
					boolean done = false;
					while (!done) {
						String selection = input.nextLine().toLowerCase();
						for (int i = 0; i <= dvdsIndex; i++) {
							DVDRecord d = dvds.get(i);
							if (d.getTitle().equals(selection)) {
								dvds.remove(i);
								done = true;
								dvdsIndex--;
								break;
							}
						}
					}
				}

			} else if (option == 6) {
				// Quit – End the program.
				if (!inventory.equals("")) {
					System.out.println("Would you like save before quitting?");
					System.out.println("◦ Yes");
					System.out.println("◦ No");
					System.out.println("◦ Cancel");
					int selection;
					while (true) {
						String answer = input.nextLine().toLowerCase();
						if (answer.contains("yes") || "yes".contains(answer)) {
							selection = 1;
							break;
						} else if (answer.contains("no") || "no".contains(answer)) {
							selection = 2;
							break;
						} else if (answer.contains("cancel") || "cancel".contains(answer)) {
							selection = 3;
							break;
						} else {
							System.out.println("Please enter \"yes\", \"no\", or \"cancel\"");
						}
					}
					if (selection == 1) {
						save(dvds, dvdsIndex, dir + inventory);
						System.out.println("Saving and quitting...");
						break;
					} else if (selection == 2) {
						System.out.println("Quiting without saving...");
						break;
					} else if (selection == 3) {
						continue;
					}
				} else {
					break;
				}
			}
		}
		input.close();
		System.out.println("Done");
	}
}