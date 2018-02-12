import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FracCalcFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Dimension WINDW_SIZE = new Dimension(800, 720);
	public static final Color DEFAULT_COLOR = new Color(248, 129, 146);
	
	private JPanel calcScreen;

	public FracCalcFrame() {
		super("Super Fraction Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(WINDW_SIZE);
		calcScreen = new JPanel() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(DEFAULT_COLOR.getRed()/2, DEFAULT_COLOR.getGreen()/2,
						DEFAULT_COLOR.getBlue()/2));
				g.fillRect(0, 0, WINDW_SIZE.width, WINDW_SIZE.height);
				g.setColor(new Color(DEFAULT_COLOR.getRed()/3, DEFAULT_COLOR.getGreen()/3,
						DEFAULT_COLOR.getBlue()/3));
				g.fillRect(0, 0, WINDW_SIZE.width, 120);
				
			}
			
		};
		this.add(calcScreen);
	}
	
	
	
	
}
