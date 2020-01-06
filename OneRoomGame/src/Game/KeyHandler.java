package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KeyHandler implements KeyListener {
	private Player player = OneRoomGame.player;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setMoveLeft(true);

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setMoveRight(true);

		} 
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setMoveUp(true);

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setMoveDown(true);

		}

	}

	public Level level;

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setMoveLeft(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setMoveRight(false);

		} 
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setMoveUp(false);

		} 
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setMoveDown(false);

		}
		
		if (e.getKeyCode() == KeyEvent.VK_M && OneRoomGame.editor == true) {
			OneRoomGame.editor = false;
			System.out.println("Editor: " + OneRoomGame.editor);

		} else if (e.getKeyCode() == KeyEvent.VK_M && OneRoomGame.editor == false) {
			OneRoomGame.editor = true;
			System.out.println("Editor: " + OneRoomGame.editor);

		}

		if (OneRoomGame.editor) {
			if (e.getKeyCode() == KeyEvent.VK_R && Panel.grid == true) {
				Panel.grid = false;
				System.out.println("Grid: " + Panel.grid);

			} else if (e.getKeyCode() == KeyEvent.VK_R && Panel.grid == false) {
				Panel.grid = true;
				System.out.println("Grid: " + Panel.grid);

			}
			
			if (e.getKeyCode() == KeyEvent.VK_S && Panel.showWarpers == true) {
				Panel.showWarpers = false;
				System.out.println("ShowWarpers: " + Panel.showWarpers);

			} else if (e.getKeyCode() == KeyEvent.VK_S && Panel.showWarpers == false) {
				Panel.showWarpers = true;
				System.out.println("ShowWarpers: " + Panel.showWarpers);

			}

			if (e.getKeyCode() == KeyEvent.VK_F && Panel.fill == true) {
				Panel.fill = false;
				System.out.println("Fill: " + Panel.fill);

			} else if (e.getKeyCode() == KeyEvent.VK_F && Panel.fill == false) {
				Panel.fill = true;
				

			}

			for (int i = 0; i < OneRoomGame.levels.size(); i++) {
				level = OneRoomGame.levels.get(i);

				if (e.getKeyCode() == KeyEvent.VK_N) {
					for (int j = 0; j < level.getBlocks().size(); j++) {
						System.out.println(level.getBlocks().get(j).getPosX() + " "
								+ level.getBlocks().get(j).getPosY() + " " + level.getBlocks().get(j).getWidth()
								+ " , " + level.getBlocks().get(j).getHeight() + " "
								+ level.getBlocks().get(j).isColisionLeft() + " "
								+ level.getBlocks().get(j).isColisionRight() + " "
								+ level.getBlocks().get(j).isColisionUp() + " "
								+ level.getBlocks().get(j).isColisionDown());
					}

				}

				if (e.getKeyCode() == KeyEvent.VK_W) {
					try {
						PrintWriter writer = new PrintWriter(level.getFile());
						writer.println(level.getBlocks().size());
						for (int j = 0; j < level.getBlocks().size(); j++) {
							writer.print("B ");
							writer.print(level.getBlocks().get(j).getPosX() + " ");
							writer.print(level.getBlocks().get(j).getPosY() + " ");
							writer.print(level.getBlocks().get(j).getWidth() + " ");
							writer.print(level.getBlocks().get(j).getHeight() + " ");
							writer.print(true + " ");
							writer.print(true + " ");
							writer.print(true + " ");
							writer.println(true);
						}
						for (int j = 0; j < level.getWarpes().size(); j++) {
							writer.print("W ");
							writer.print(level.getWarpes().get(j).getArea().getPosX() + " ");
							writer.print(level.getWarpes().get(j).getArea().getPosY() + " ");
							writer.print(level.getWarpes().get(j).getArea().getWidth() + " ");
							writer.print(level.getWarpes().get(j).getArea().getHeight() + " ");
							writer.println(level.getWarpes().get(j).getDestination());
						}
						writer.close();

					} catch (IOException e1) {
						e1.printStackTrace();

					}

				}

				if (e.getKeyCode() == KeyEvent.VK_L) {
					try {
						for (int j = 0; j < level.getBlocks().size(); j++) {
							level.getBlocks().clear();
						}
						
						Scanner reader = new Scanner(level.getFile());
						
						int current = 0;
						float objects = reader.nextInt();
						
						while (reader.hasNextLine()) {
							if (reader.hasNext("B")) {
								reader.next();
								level.getBlocks().add(new Block(reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(),
										reader.nextBoolean(), reader.nextBoolean(), reader.nextBoolean(), reader.nextBoolean()));
							} else if (reader.hasNext("W")) {
								reader.next();
								level.getWarpes().add(new Warper(new WarpArea(reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt()), reader.nextInt()));
								
							} else {
								reader.nextLine();
							}
							current++;
							System.out.println("Level is Loaded " + (int) (current / objects * 100) + "%");

						}
						reader.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();

					}

				}

				if (e.getKeyCode() == KeyEvent.VK_D) {
					level.getBlocks().remove(level.getBlocks().size() - 1);
				}
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
