package tmp;

public class tmp1 {

	public static void main(String[] args) {
		
		String s = new String("hello");
		String s1 = new String("goodbye");
		int sum = 0;
		for(int i = 0; i<s.length()-1; i++) {
			sum += s.substring(i, i+1).compareTo(s1.substring(i, i+1));
		}
		System.out.println(sum);
		
	}

}
