
public class BagelTester {

	public static void main(String[] args) {
		Bagels b = new Bagels();
		int[] orders = {1, 3, 5, 7};
		System.out.println(b.bagelCount(orders) + " 16");
		int[] a = {11, 22, 33, 44, 55};
		System.out.println(b.bagelCount(a) + " 175");
		int[] B = {1, 1, 1, 12};
		System.out.println(b.bagelCount(B) + " 16");
		int[] c = {12, 12, 12, 12};
		System.out.println(b.bagelCount(c) + " 52");
		
		
	}

}
