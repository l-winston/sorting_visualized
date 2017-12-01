import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class InsertionSort {
	public static JFrame frame;
	static BufferedImage image;
	public static int[] array;

	public InsertionSort(JFrame frame, BufferedImage image, int[] array) {
		this.frame = frame;
		this.image = image;
		this.array = array;
	}

	public static void run() throws InterruptedException {
		// start at 1, 0 starts in right place
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while ((j >= 0) && (array[j] > key)) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
			SortingMain.paint(array, new int[] {j}, new int[] {i}, image, frame);
			Thread.sleep(25);
		}
		SortingMain.paint(array, new int[] {-1}, new int[] {-1}, image, frame);
	}
}