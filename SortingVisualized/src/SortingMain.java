import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SortingMain {
	public static final int N = 150;
	public static Random random = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Sorting Visualized");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit when frame
		frame.pack();

		int[] array = new int[N];
		randomize(array);
		
		BufferedImage image = new BufferedImage(750, 750, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < image.getHeight(); i++){
			for(int j = 0; j < image.getWidth(); j++){
				image.setRGB(i, j, new Color(255, 255, 255).getRGB());
			}
		}
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		new InsertionSort (frame, image, array).run();
		
		randomize(array);
		new MergeSort(frame, image, array).run();

	}
	public static void randomize(int[] array){
		for(int i = 0; i < N; i++){
			array[i] = i+1;
		}
		
		int len = array.length;
		random.nextInt();
		for (int i = 0; i < len; i++) {
			int change = i + random.nextInt(len - i);
			array = swap(array, i, change);
		}
	}
	
	static int[] swap (int[] a, int i, int change) {
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
		return a;
	}
	public static void paint(int[] ar, int swap1, int swap2, BufferedImage image, JFrame frame) {
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
}