package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = 3858767732457225513L;

	public static boolean grid = false;
	public static boolean fill = false;
	public static boolean showWarpers = false;
	public static boolean showEnemyColiders = false;

	public static int tileSize = Block.minBlockSize;
	public static float a = (float) 0.2;

	private ArrayList<Block> blocks = OneRoomGame.levels.get(OneRoomGame.level).getBlocks();
	private Player player = OneRoomGame.player;

	Level level = OneRoomGame.levels.get(OneRoomGame.level);

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		if (OneRoomGame.editor) {
			if (grid) {
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());

				for (int x = 0; x < Frame.Width / tileSize; x++) {
					g.setColor(Color.GREEN);
					g.drawLine(tileSize * x, 0, tileSize * x, this.getHeight());
					if (x % 2 == 0) {
						g.setColor(Color.BLUE);
						g.drawLine(tileSize * 2 * x / 2, 0, tileSize * 2 * x / 2, this.getHeight());
					}
				}
				for (int y = 0; y < Frame.Height / tileSize; y++) {
					g.setColor(Color.GREEN);
					g.drawLine(0, tileSize * y, this.getWidth(), tileSize * y);
					if (y % 2 == 0) {
						g.setColor(Color.BLUE);
						g.drawLine(0, tileSize * 2 * y / 2, this.getWidth(), tileSize * 2 * y / 2);
					}
				}
			}

			g.setColor(Color.black);

			if (!fill) {
				for (int i = 0; i < blocks.size(); i++) {
					blocks.get(i).draw(g);
				}
			} else {
				for (int i = 0; i < blocks.size(); i++) {
					blocks.get(i).drawFilled(g);
				}
			}

			if (grid) {
				g.setColor(Color.WHITE);
				for (int i = 0; i < level.getBlocks().size(); i++) {
					g.drawString("" + i, level.getBlocks().get(i).getPosX(), level.getBlocks().get(i).getPosY() + 10);
				}
			}
			
			g.setColor(Color.RED);

			if (showWarpers) {
				for (int i = 0; i < level.getWarpes().size(); i++) {
					level.getWarpes().get(i).show(g);
				}
			}

		}else if (!OneRoomGame.editor){
			g.setColor(Color.BLACK);
			for (int i = 0; i < blocks.size(); i++) {
				blocks.get(i).drawFilled(g);
			}
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Dialog", Font.BOLD, 15));
			g.drawString("Press 'M' to activate", 560, 400);
			g.drawString("editor mode", 560, 420);
		}

		g.setColor(Color.orange);
		player.draw(g);

		g.setColor(Color.getHSBColor(a, a, a));
		g.fillRect(100, 525, 25, 25);

		repaint();
	}

}
