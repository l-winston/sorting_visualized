import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SortingMain {
	public static final int N = 250;

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Sorting Visualized");
		frame.setVisible(true);
		//frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit when frame
		frame.pack();

		int[] array = new int[N];
		
		for(int i = 0; i < N; i++){
			array[i] = i+1;
		}
		
		int len = array.length;
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < len; i++) {
			int change = i + random.nextInt(len - i);
			array = swap(array, i, change);
		}
		
		BufferedImage image = new BufferedImage(750, 750, BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i < image.getHeight(); i++){
			for(int j = 0; j < image.getWidth(); j++){
				image.setRGB(i, j, new Color(255, 255, 255).getRGB());
			}
		}
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		new InsertionSort (frame, image, array).run();
		
		
		//System.out.println(Arrays.toString(array));
	}

	static int[] swap (int[] a, int i, int change) {
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
		return a;
	}
}