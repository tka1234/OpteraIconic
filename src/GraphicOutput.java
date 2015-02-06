import java.awt.*; import java.awt.image.*; import java.io.File; import javax.swing.*;
public class GraphicOutput extends JFrame {
	private static final long serialVersionUID = 1L;
	public JFrame drawing;
	public Graphics2D image;
	
	//System Variables
	public static int WindowWidth = 1280;
	public static int WindowHeight = 960;
	public static String WindowTitle = "Optera 3.0 Iconic";
	public static Font AiL, AiR, AiT;
	
	//Window Object
	public GraphicOutput() {
		drawing = new JFrame();
		BufferedImage imageB = new BufferedImage(WindowWidth, WindowHeight, BufferedImage.TYPE_INT_ARGB);
		image = imageB.createGraphics();
		image.setColor(Color.WHITE);
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		image.addRenderingHints(hints);
		image.fillRect(0, 0, imageB.getWidth(), imageB.getHeight());
		drawing.setContentPane(new JLabel(new ImageIcon(imageB)));
		drawing.setResizable(false);
		drawing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawing.setTitle(WindowTitle);
		drawing.pack();
		drawing.requestFocusInWindow();
		drawing.setVisible(true);
		
		try {
			AiL = Font.createFont(Font.TRUETYPE_FONT, new File("AiL.otf"));
			AiR = Font.createFont(Font.TRUETYPE_FONT, new File("AiR.otf"));
			AiT = Font.createFont(Font.TRUETYPE_FONT, new File("AiT.otf")); }
		catch (Exception e) {e.printStackTrace(); }
	}
	
	public void makeImage() {drawing.repaint(); }
	
	public void setColor(Color color) {image.setColor(color); }
	
	public void writeFontLeft(double xPos, double yPos, int size, String fontname, String type) {
		try {
			image.setFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontname)).deriveFont((float) size));
			FontMetrics metrics = image.getFontMetrics();
			image.drawString(type, (float) xPos, (float) yPos + metrics.getAscent()); }
		catch (Exception e) {e.printStackTrace(); } }
	
	public void writeFontLeft(double xPos, double yPos, int size, Font f, String type) {
		try {
			image.setFont(f.deriveFont((float) size));
			FontMetrics metrics = image.getFontMetrics();
			image.drawString(type, (float) xPos, (float) yPos + metrics.getAscent()); }
		catch (Exception e) {e.printStackTrace(); } }
	
	public void writeFontRight(double xPos, double yPos, int size, String fontname, String type) {
		try {
			image.setFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontname)).deriveFont((float) size));
			FontMetrics metrics = image.getFontMetrics();
			image.drawString(type, (float) xPos - metrics.stringWidth(type), (float) yPos + metrics.getAscent()); }
		catch (Exception e) {e.printStackTrace(); } }
	
	public void writeFontRight(double xPos, double yPos, int size, Font f, String type) {
		try {
			image.setFont(f.deriveFont((float) size));
			FontMetrics metrics = image.getFontMetrics();
			image.drawString(type, (float) xPos - metrics.stringWidth(type), (float) yPos + metrics.getAscent()); }
		catch (Exception e) {e.printStackTrace(); } }
	
	public void writeFontCenter(double xPos, double yPos, int size, String fontname, String type) {
		try {
			image.setFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontname)).deriveFont((float) size));
			FontMetrics metrics = image.getFontMetrics();
			image.drawString(type, (float) ((2 * xPos) - metrics.stringWidth(type)) / 2, (float) yPos + metrics.getAscent()); }
		catch (Exception e) {e.printStackTrace(); } }
	
	public void writeFontCenter(double xPos, double yPos, int size, Font f, String type) {
		try {
			image.setFont(f.deriveFont((float) size));
			FontMetrics metrics = image.getFontMetrics();
			image.drawString(type, (float) ((2 * xPos) - metrics.stringWidth(type)) / 2, (float) yPos + metrics.getAscent()); }
		catch (Exception e) {e.printStackTrace(); } }
	
	public void rectangle(double xPos, double yPos, double width, double height) {image.fillRect((int) xPos, (int) yPos, (int) width, (int) height); }
	
	//Test Window Generator
	public static void main(String args[]) {
		GraphicOutput x = new GraphicOutput();
		x.setColor(Color.BLACK);
		x.writeFontCenter(640, 0, 32, AiT, "Intended: 8\"diagonal (6.4\"x4.8\") @ 2240x1680x60Hz & 350ppi");
		x.writeFontCenter(640, 50, 32, AiT, "Actual: 1280x960x60Hz");
		x.makeImage();
	}

}
