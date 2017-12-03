import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

public class QuickSort {
	public static JFrame frame;
	static BufferedImage image;
	public static int[] array;
	public QuickSort(JFrame frame, BufferedImage image, int[] array) {
		this.frame = frame;
		this.image = image;
		this.array = array;
	}
	public static void run() throws InterruptedException {
		// start at 1, 0 starts in right place
		sort(array[array.length-1], array, 0, array.length-1);
	}
	public static void sort(int pivot, int[] ar, int start, int end){
		if(ar.length == 2){
			return;
		}
		
		int len1 = 0;
		int len2 = 0;
		
		for(int i = 0; i < ar.length; i++){
			if(ar[i] <= ar[pivot]){
				len1++;
			}else{
				len2++;
			}
		}
		
		int[] l1 = new int[len1];
		int[] l2 = new int[len2];
		
		len1 = 0;
		len2 = 0;
		
		for(int i = 0; i < ar.length; i++){
			if(ar[i] <= ar[pivot]){
				l1[len1] = ar[i];
				len1++;
			}else{
				l2[len2] = ar[i];
				len2++;
			}
		}
		sort(l1[l1.length-1], l1, start, start+len1);
		System.out.println(Arrays.toString(l2));
		sort(l2[l2.length-1], l2, start+len1, end);
	}
}
