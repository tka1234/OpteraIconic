import java.awt.Color;
public class DisplayProgram {
	public static void main(String args[]) {
		GraphicOutput a = new GraphicOutput();
		a.setColor(Color.BLACK);
		a.rectangle(0, 0, 1280, 960);
		a.setColor(Color.WHITE);
		a.writeFontLeft(10, 0, 50, GraphicOutput.AiT, "12:00 pm");
		a.writeFontCenter(640, 0, 35, GraphicOutput.AiL, "Artist Name Here - Song Title Here");
		a.writeFontCenter(640, 35, 28, GraphicOutput.AiL, "FM 100.0 MHz");
		a.writeFontRight(1270, 0, 50, GraphicOutput.AiT, "FPSSW");
		
		a.writeFontCenter(128, 900, 40, GraphicOutput.AiL, "Audio");
		a.writeFontCenter(384, 900, 40, GraphicOutput.AiL, "GPS");
		a.writeFontCenter(640, 900, 40, GraphicOutput.AiL, "Apps");
		a.writeFontCenter(896, 900, 40, GraphicOutput.AiL, "Phone");
		a.writeFontCenter(1152, 900, 40, GraphicOutput.AiL, "Settings");
		
		a.makeImage();
	}

}
