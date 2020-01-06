package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// if (getFieldOfMouseX(e.getX()) % 2 == 0) {
		// Level.blocks.add(new Block((int)((getFieldOfMouseX(e.getX()) - 1) *
		// 12.5 + 13),
		// (int)((getFieldOfMouseY(e.getY()) - 1) * 12.5 + 13), 12, 12));
		// }
		System.out.println("X | Y: " + getFieldOfMouseX(e.getX()) + " | " + getFieldOfMouseY(e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public int mouseXOne = 0;
	public int mouseXTwo = 0;
	public int mouseYOne = 0;
	public int mouseYTwo = 0;

	@Override
	public void mousePressed(MouseEvent e) {
		mouseXOne = getFieldOfMouseX(e.getX()) * Block.minBlockSize;
		mouseYOne = getFieldOfMouseX(e.getY()) * Block.minBlockSize;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseXTwo = (getFieldOfMouseX(e.getX()) + 1) * Block.minBlockSize;
		mouseYTwo = (getFieldOfMouseX(e.getY()) + 1) * Block.minBlockSize;
		boolean blockCL = true;
		boolean blockCR = true;
		boolean blockCU = true;
		boolean blockCD = true;
		if (OneRoomGame.editor) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				OneRoomGame.levels.get(OneRoomGame.level).getBlocks().add(new Block(mouseXOne, mouseYOne,
						mouseXTwo - mouseXOne, mouseYTwo - mouseYOne, blockCL, blockCR, blockCU, blockCD));
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				for (int i = 0; i < OneRoomGame.levels.get(OneRoomGame.level).getBlocks().size(); i++) {
					if (e.getX() >= OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(i).getPosX()) {
						System.out.print(" | first: " + i);
						if (e.getY() >= OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(i).getPosY()) {
							System.out.print(" | scound: " + i);
							if (e.getX() <= OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(i).getPosX()
									+ OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(i).getWidth()) {
								System.out.print(" | thired: " + i);
								if (e.getY() <= OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(i).getPosY()
										+ OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(i).getHeight()) {
									System.out.print(" | fourth: " + i);
									OneRoomGame.levels.get(OneRoomGame.level).getBlocks().remove(i);
									for (int j = i; j < OneRoomGame.levels.get(OneRoomGame.level).getBlocks().size()
											- 1; j++) {
										OneRoomGame.levels.get(OneRoomGame.level).getBlocks().set(j,
												OneRoomGame.levels.get(OneRoomGame.level).getBlocks().get(j));

									}
								}
							}
						}
					}

				}
			}
		}
	}

	private int getFieldOfMouseX(int mouseX) {
		int computed = (int) (mouseX / Block.minBlockSize);

		return computed;

	}

	private int getFieldOfMouseY(int mouseY) {
		int computed = (int) (mouseY / Block.minBlockSize);
		return computed;
	}

}
