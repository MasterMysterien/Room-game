package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
	private int posX;
	private int posY;
	private int width;
	private int height;

	private int speed;

	public int getposX() {
		return this.posX;
	}

	public void setposX(int posX) {
		this.posX = posX;
	}

	public int getposY() {
		return posY;
	}

	public void setposY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public BufferedImage img;

	public BufferedImage getPlayerImg() {
		return img;
	}

	public void setPlayerImg(BufferedImage img) {
		this.img = img;
	}

	public boolean moveLeft = false;
	public boolean moveRight = false;
	public boolean moveUp = false;
	public boolean moveDown = false;

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}

	public static ArrayList<Block> blocks = OneRoomGame.levels.get(OneRoomGame.level).getBlocks();

	public Player(int posX, int posY, int width, int height, int speed) {
		setposX(posX);
		setposY(posY);
		setWidth(width);
		setHeight(height);

		setSpeed(speed);

	}

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(getposX(), getposY(), getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(getposX() - 1, getposY() - 1, getWidth() + 2, getHeight() + 2);
		g.drawRect(getposX(), getposY(), getWidth(), getHeight());
	}

	public void blockColisions() {
		for (int i = 0; i < blocks.size(); i++) {
			boxColision(3, blocks.get(i).getPosX(), blocks.get(i).getPosY(), blocks.get(i).getWidth(),
					blocks.get(i).getHeight(), blocks.get(i).isColisionLeft(), blocks.get(i).isColisionRight(),
					blocks.get(i).isColisionUp(), blocks.get(i).isColisionDown());
		}
	}

	private boolean leftSide(int bX, int bY, int bW, int bH) {
		if (getposX() < bX + bW) {
			if (getposY() < bY + bH) {
				if (getposX() + getWidth() > bX + (bW / 2)) {
					if (getposY() + getHeight() > bY) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	private boolean rightSide(int bX, int bY, int bW, int bH) {
		if (getposX() + getWidth() > bX) {
			if (getposY() + getHeight() > bY) {
				if (getposX() < bX + (bW / 2)) {
					if (getposY() < bY + bH) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	private boolean bottomSide(int bX, int bY, int bW, int bH) {
		if (getposY() < bY + bH) {
			if (getposX() + getWidth() > bX) {
				if (getposX() < bX + bW) {
					if (getposY() + getHeight() > bY + (bH / 2)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	private boolean topSide(int bX, int bY, int bW, int bH) {
		if (getposY() + getHeight() > bY) {
			if (getposX() + getWidth() > bX) {
				if (getposX() < bX + bW) {
					if (getposY() < bY + (bH / 2)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private void boxColision(int pushBackSpeed, int bX, int bY, int bW, int bH, boolean colisionLeft,
			boolean colisionRight, boolean colisionUp, boolean colisionDown) {
		if (rightSide(bX, bY, bW, bH) && isMoveRight() && colisionRight) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);
			setposX(getposX() - pushBackSpeed);
			while (getposX() + getWidth() < bX) {
				setposX(getposX() + 1);
				System.out.println("Right");
			}

		}
		if (leftSide(bX, bY, bW, bH) && isMoveLeft() && colisionLeft) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);
			setposX(getposX() + pushBackSpeed);
			while (getposX() > bX + bW) {
				setposX(getposX() - 1);
				System.out.println("Left");
			}

		}
		if (topSide(bX, bY, bW, bH) && isMoveDown() && colisionUp) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);
			setposY(getposY() - pushBackSpeed);
			while (getposY() + getHeight() < bY) {
				setposY(getposY() + 1);
				System.out.println("Down");
			}

		}
		if (bottomSide(bX, bY, bW, bH) && isMoveUp() && colisionDown) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);
			setposY(getposY() + pushBackSpeed);
			while (getposY() > bY + bH) {
				setposY(getposY() - 1);
				System.out.println("Up");
			}

		}
	}

	// private void oneWayBoxColision(int direction, int pushBackSpeed, int bX,
	// int bY, int bW, int bH) {
	// if (rightSide(bX, bY, bW, bH) && isMoveRight() && direction == 0) {
	// setMoveRight(false);
	// setMoveLeft(false);
	// setMoveUp(false);
	// setMoveDown(false);
	// setposX(getposX() - pushBackSpeed);
	// while (getposX() + getWidth() < bX) {
	// setposX(getposX() + 1);
	// System.out.println("Right");
	// }
	//
	// }
	// if (leftSide(bX, bY, bW, bH) && isMoveLeft() && direction == 1) {
	// setMoveRight(false);
	// setMoveLeft(false);
	// setMoveUp(false);
	// setMoveDown(false);
	// setposX(getposX() + pushBackSpeed);
	// while (getposX() > bX + bW) {
	// setposX(getposX() - 1);
	// System.out.println("Left");
	// }
	//
	// }
	// if (topSide(bX, bY, bW, bH) && isMoveDown() && direction == 2) {
	// setMoveRight(false);
	// setMoveLeft(false);
	// setMoveUp(false);
	// setMoveDown(false);
	// setposY(getposY() + pushBackSpeed);
	// while (getposY() + getHeight() < bY) {
	// setposY(getposY() + 1);
	// System.out.println("Down");
	// }
	//
	// }
	// if (bottomSide(bX, bY, bW, bH) && isMoveUp() && direction == 3) {
	// setMoveRight(false);
	// setMoveLeft(false);
	// setMoveUp(false);
	// setMoveDown(false);
	// setposY(getposY() + pushBackSpeed);
	// while (getposY() > bY + bH) {
	// setposY(getposY() - 1);
	// System.out.println("Up");
	// }
	// }
	// }

}
