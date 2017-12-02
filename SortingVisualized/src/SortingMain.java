import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.sound.midi.MidiUnavailableException;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SortingMain {
	public static final int N = 17;
	public static Random random = new Random();
	public static final int IMAGE_WIDTH = 300;
	public static final int IMAGE_HEIGHT = 600;

	public static void main(String[] args)
			throws InterruptedException, LineUnavailableException, MidiUnavailableException {
		JFrame frame = new JFrame("Sorting Visualized");
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit when frame
		frame.pack();
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));

		int[] array = new int[N];
		randomize(array);

		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				image.setRGB(j, i, new Color(255, 255, 255).getRGB());
			}
		}

		new InsertionSort(frame, image, array).run();

		randomize(array);

		new MergeSort(frame, image, array).run();

		randomize(array);

		// new QuickSort(frame, image, array).run();

	}

	public static void randomize(int[] array) {
		for (int i = 0; i < N; i++) {
			array[i] = i + 1;
		}

		int len = array.length;
		random.nextInt();
		for (int i = 0; i < len; i++) {
			int change = i + random.nextInt(len - i);
			array = swap(array, i, change);
		}
	}

	static int[] swap(int[] a, int i, int change) {
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
		return a;
	}

	public static void draw(int[] ar, int[] red, int[] green, BufferedImage image, JFrame frame)
			throws InterruptedException {
		int imageWidth = image.getWidth() - (image.getWidth() % ar.length);
		int imageHeight = image.getHeight() - (image.getHeight() % ar.length);
		int HeightPixelsPerNumber = imageHeight / ar.length;
		int WidthPixelsPerColumn = imageWidth / ar.length;

		setBlack(image);

		for (int i = image.getHeight() - 1; i >= image.getHeight() % ar.length; i--) {
			for (int j = 0; j < imageWidth; j++) {
				Color c = new Color(0, 0, 0);
				int number = j / WidthPixelsPerColumn;
				if (j % WidthPixelsPerColumn < WidthPixelsPerColumn
						&& (imageHeight - i) < HeightPixelsPerNumber * ar[number] - (image.getHeight() % ar.length)) {
					c = new Color(255, 255, 255);

					for (int reds = 0; reds < red.length; reds++) {
						if (number == red[reds]) {
							c = new Color(255, 0, 0);
						}
					}

					for (int greens = 0; greens < green.length; greens++) {
						if (number == green[greens]) {
							c = new Color(0, 255, 0);
						}
					}
				}
				if (j > imageWidth) {
					c = new Color(0, 0, 0);
				}
				image.setRGB(j, i, c.getRGB());
			}
		}

		// frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.pack();
		frame.repaint();

		// Synthesizer synth = MidiSystem.getSynthesizer();
		// synth.open();
		// final MidiChannel[] mc = synth.getChannels();
		// Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
		// synth.loadInstrument(instr[53]);
		// mc[0].noteOn((int) ((ar[red[0]]*1.0/N) * 60 + 30), 600);

		Thread.sleep(25);

	}

	public static void setBlack(BufferedImage image) {
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				image.setRGB(j, i, new Color(0, 0, 0).getRGB());
			}
		}
	}
}