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

	public static void paint(int[] ar, int swap1, int swap2) {
		double HeightPixelsPerNumber = image.getHeight() / ar.length;
		double WidthPixelsPerColumn = image.getWidth() / ar.length;

		for (int i = image.getHeight() - 1; i >= 0; i--) {
			for (int j = 0; j < image.getWidth(); j++) {
				Color c = new Color(255, 255, 255);
				int number = (int) (j / WidthPixelsPerColumn);
				if (j % WidthPixelsPerColumn < WidthPixelsPerColumn - 1
						&& (image.getHeight() - i) < HeightPixelsPerNumber * ar[number]) {
					if (number == swap1) {
						c = new Color(255, 0, 0);
					} else if (number == swap2) {
						c = new Color(0, 255, 0);
					} else {
						c = new Color(0, 0, 0);
					}
				}
				image.setRGB(j, i, c.getRGB());
			}
		}

		frame.invalidate();
		frame.validate();
		// frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.pack();
		frame.repaint();
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
			paint(array, j, i);
			Thread.sleep(25);
		}
		paint(array, -1, -1);
	}
}