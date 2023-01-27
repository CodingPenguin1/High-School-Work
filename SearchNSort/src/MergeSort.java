/* Title: Merge Sort
 * Author: Ryan J Slater
 * Date: 2/20/2018
 */
public class MergeSort {

	public static void main(String[] args) {

		 int[] a = new int[100];
		 for (int i = 0; i < a.length; i++) {
			 a[i] = (int)(Math.random()*100);
		 }
		System.out.println("Unsorted:");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\nSorted:");
		mergeSort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int[] a, int l, int h) {
		if (h > l) {
			int m = ((l + h) / 2);
			mergeSort(a, l, m);
			mergeSort(a, m + 1, h);
			merge(a, l, m, h);
		}
	}

	public static void merge(int[] a, int l, int m, int h) {
		int lLen = m - l + 1;
		int rLen = h - m;
		int[] la = new int[lLen];
		int[] ra = new int[rLen];
        for (int i = 0; i < lLen; i++) {
			la[i] = a[l+i];
		}
        for (int i = 0; i<rLen; i++) {
			ra[i] = a[m+1+i];
		}
        int lCounter = 0;
        int rCounter = 0;
        int i = l;
        while (lCounter < lLen && rCounter < rLen) {
            if (la[lCounter] <= ra[rCounter]) {
                a[i] = la[lCounter];
                lCounter++;
            } else {
                a[i] = ra[rCounter];
                rCounter++;
            }
            i++;
        }
        while (lCounter < lLen) {
            a[i] = la[lCounter];
            lCounter++;
            i++;
        }
        while (rCounter < rLen ){
            a[i] = ra[rCounter];
            rCounter++;
            i++;
        }
		
	}

}