
public class LuhnTester {

	public static void main(String[] args) {
		LuhnI l = new LuhnI();
		int[] a = {1, 2, 1, 4};
		System.out.println(l.isValid(a) + " YES");
		int[] b = {1, 7, 2, 3, 6};
		System.out.println(l.isValid(b) + " YES");
		int[] c = {7, 8, 3};
		System.out.println(l.isValid(c) + " NO");
		int[] d = {4, 3, 2, 1};
		System.out.println(l.isValid(d) + " NO");
		int[] e = {1, 1, 1, 1, 1, 1, 1};
		System.out.println(l.isValid(e) + " YES");

	}

}
