/*
Isaac Pang
Created 2016, 2017
 */
// TODO: TO BE UPDATED W/ A GUI IN THE NEAR FUTURE
// currently only works in the console

// TODO: when prompting user for an equation in a form
// where they can type input, make sure that they have
// it inputted in a specific way
// TODO: also have it so the user can choose whether
// improper or mixed
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FracCalcMastered extends JFrame {


	
	private static final long serialVersionUID = 1L;
	private String currChar;
	private String fracTotal;
//	private Dimension size;
//	private boolean improper;
//	private JPanel calcScreen;
//	private JPanel dualPanel;
//	private JLabel[] buttons;
	
//	public FracCalcMastered() {
//		super("Super Fraction Calculator");
//		size = new Dimension(400, 600);
//		setSize(size); setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
//		calcScreen = new JPanel() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				g.drawRect(0, 0, size.width, size.height);
//				g.setColor(Color.BLACK);
//
//			}
//
//		};
//		add(calcScreen);
//		calcScreen.setVisible(true); calcScreen.setSize(size);
//		buttons = new JLabel[12];
//		for (int i = 0 ; i < buttons.length; i++) {
//			buttons[i] = new JLabel(new ImageIcon());
//			try {
//				buttons[i].setIcon(new ImageIcon(ImageIO.read(getURL(i + 1 + ".png", "images"))));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			calcScreen.add(buttons[i]);
//			buttons[i].setLocation(i*20, i*20);
//			buttons[i].setVisible(true); buttons[i].setSize(getSize());
//		}
//		currChar = "";
//		improper = true;
//
//	}

	public FracCalcMastered() {}

	public void fracCalcHelp() {
		Scanner s = new Scanner(System.in);
		System.out.println("Give me a fraction equation (Type \"quit\" to stop):");
		String equation = s.nextLine();
		// TODO: exiting might not be processed with the 
		// input of quit anymore
		if (equation.toLowerCase().equals("quit")) {
			System.exit(1);
		} else {
			// TODO: separate the processing of the equation 
			// from the spitting out of the answer
			System.out.println(produceAnswer(equation));
			fracCalcHelp();
		}
		
	}
	public String produceAnswer(String input) { 

		// 0 is frac1, 1 is the operation, and 2 is frac2
		String[] eqParts = {"","",""};
		
		String mainDump = input + " ";
		fracTotal = "";
		int[] frac1parts = new int[3];
		int[] frac2parts = new int[3];
		
		//////
		int frac1w = 0;
		int frac1n = 0;
		int frac1d = 0;
		int frac2w = 0;
		int frac2n = 0;
		int frac2d = 0;
		
		int spaceCount = 0;
		int stringInd = 0;
		for (int i = 0; i < 3; i++) {
			while (mainDump.charAt(stringInd) != ' ') {
				eqParts[i] += mainDump.charAt(stringInd);
				stringInd++;
			}
			stringInd++;
			if (stringInd >= mainDump.length()) {
				return "Please format your equation properly,"
						+ " or please provide a valid equation";
			}
			spaceCount++;
		}


		if (eqParts[1].length() != 1) {
			return "Please format your equation properly,"
					+ " or please provide a valid equation";
		} else if (spaceCount > 3) {		
			// TODO: loop through produceAnswer???
		}

		
		if (!eqParts[2].contains("/")) {	
			frac2w = intSub(eqParts[2]);
			frac2n = 0;
			frac2d = 1;	
		} else if (!eqParts[2].contains("_")) {
			frac2w = 0;
			for(int i = 0; i < eqParts[2].length(); i++) {
				if (eqParts[2].charAt(i) != '/'){
					currChar += eqParts[2].charAt(i);
				} else if (eqParts[2].charAt(i) == '/') {
					frac2n = intSub(currChar);
				}
			}
			frac2d = intSub(currChar);
		} else {
			for(int i = 0; i < eqParts[2].length(); i++) {
				if (eqParts[2].charAt(i) != '_' && eqParts[2].charAt(i) != '/'){
					currChar += eqParts[2].charAt(i);
				} else if (eqParts[2].charAt(i) == '_') {
					frac2w = intSub(currChar);
				} else if (eqParts[2].charAt(i) == '/') {
					frac2n = intSub(currChar);
				}
			}
			frac2d = intSub(currChar);
		}
 
		if (!eqParts[0].contains("/")) {
			frac1w = intSub(eqParts[0]);
			frac1n = 0;
			frac1d = 1;
		} else if (!eqParts[0].contains("_")) {	
			frac1w = 0;
			for(int i = 0; i < eqParts[0].length(); i++) {
				if (eqParts[0].charAt(i) != '/'){
					currChar += eqParts[0].charAt(i);
				} else if (eqParts[0].charAt(i) == '/') {
					frac1n = intSub(currChar);
				}
			}
			frac1d = intSub(currChar);
		} else {
			for(int i = 0; i < eqParts[0].length(); i++) {
				if (eqParts[0].charAt(i) != '_' && eqParts[0].charAt(i) != '/'){
					currChar += eqParts[0].charAt(i);
				} else if (eqParts[0].charAt(i) == '_') {
					frac1w = intSub(currChar);
				} else if (eqParts[0].charAt(i) == '/') {
					frac1n = intSub(currChar);
				}
			}
			frac1d = intSub(currChar);
		}
		
		if (frac1w < 0) {
			frac1n = (frac1w * frac1d) - frac1n;
		} else {
			frac1n = frac1n + (frac1w * frac1d);
		}
		if (frac2w < 0) {
			frac2n = (frac2w * frac2d) - frac2n;
		} else {
			frac2n = frac2n + (frac2w * frac2d);			
		}
			if (eqParts[1].contains("/")) {
				if (frac2w == 0 && frac2n == 0) {
					return "ERROR: Cannot divide by zero.";
				} else {	
					int prevNumr = frac2n;
					frac2n = frac2d;
					frac2d = prevNumr;
					fracTotal = (frac1n * frac2n) + "/" + (frac1d * frac2d);
				}
			} else if (eqParts[1].contains("*")) {
				fracTotal = (frac1n * frac2n) + "/" + (frac1d * frac2d);
			} else if (eqParts[1].contains("-")) {
				if (frac1d != frac2d) {
					frac1n = frac1n * frac2d;
					frac2n = frac2n * frac1d;
					frac1d = frac1d * frac2d;
				}
				fracTotal = (frac1n - frac2n) + "/" + frac1d;
			} else if (eqParts[1].contains("+")) {
				if (frac1d != frac2d) {
					frac1n = frac1n * frac2d;
					frac2n = frac2n * frac1d;
					frac1d = frac1d * frac2d;
				}
				fracTotal = (frac1n + frac2n) + "/" + frac1d;
			}
			return fracTotal;
		}
	
	private int intSub(String frac) {
		currChar = "";
		return Integer.parseInt(frac);
	}
	
	public URL getURL(String filename, String custFolder) {
		URL url = this.getClass().getResource("/FracCalcMastered.class");
			try {
				if (custFolder == null && filename != null) { 
			        URL fileURL = new URL(url, ("../" + filename));
			        url = fileURL;
				} else if (!(custFolder == null && filename == null)) {
					URL fileURL = new URL(url, ("../" + custFolder + "/" + filename));
			        url = fileURL;
				} else if (filename == null && custFolder == null) {
					URL fileURL = new URL(url, ("../"));
			        url = fileURL;
				} else {
					URL fileURL = new URL(url, ("../" + custFolder + "/"));
			        url = fileURL;
				}
			}
			catch (Exception e) {}
			return url;
	}

	public static void main(String[] args) {
		FracCalcMastered fcm = new FracCalcMastered();
		fcm.fracCalcHelp();
	}
	

	
		
}

