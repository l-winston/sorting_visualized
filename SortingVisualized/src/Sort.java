import java.awt.image.BufferedImage;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;

public class Sort {
	public static JFrame frame;
	static BufferedImage image;
	public static int[] array;

	public Sort(JFrame frame, BufferedImage image, int[] array) {
		this.frame = frame;
		this.image = image;
		this.array = array;
	}

	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();  
		final MidiChannel[] mc = synth.getChannels();
		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instr[90]);
		mc[0].noteOn(90,600);
		Thread.sleep(1000);
	}
}
