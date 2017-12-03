import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/* Java program for Merge Sort */
class MergeSort {
	public static JFrame frame;
	static BufferedImage image;
	public static int[] array;

	public MergeSort(JFrame frame, BufferedImage image, int[] array) {
		this.frame = frame;
		this.image = image;
		this.array = array;
	}

	public static void run() throws InterruptedException {
		sort(0, array.length - 1);
		SortingMain.draw(new int[] {-1}, new int[] {-1});
	}

	static void merge(int l, int m, int r) throws InterruptedException {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
			SortingMain.draw(new int[] {-1}, new int[] {k});
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int l, int r) throws InterruptedException {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(l, m);
			sort(m + 1, r);

			// Merge the sorted halves
			merge(l, m, r);
		}
	}

}
