package Game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	public static JFrame frame;
	public static JPanel panel;

	public static int borderWidth = 16;
	public static int borderHeight = 38;
	public static int Width = 800;
	public static int Height = Width / 4 * 3;
	
	public Frame() {
		frame = new JFrame();
		frame.setSize(new Dimension(Width + borderWidth, Height+ borderHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new KeyHandler());
		frame.setTitle("OneRoomGame");
		
		frame.setVisible(true);
		
		panel = new Panel();
		panel.setSize(Width + borderWidth, Height + borderHeight);
		panel.setBackground(Color.WHITE);
		panel.addMouseListener(new MouseHandler());
		panel.setVisible(true);
		
		frame.add(panel);

	}

}
