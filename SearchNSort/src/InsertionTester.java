import java.util.Random;

public class InsertionTester {

	public static void main(String[] args) {
		SearchNSort s = new SearchNSort();
		Random rand = new Random();

		for (int j = 0; j < 10; j++) {

			int[] array = { rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10),
					rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10) };
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			s.insertionSort(array);
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("\n\n");
		}
	}

}