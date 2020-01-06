package Game;

public class Enemy {
	private int posX;
	private int posY;
	private int width;
	private int height;

	private int speed;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
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

	private EnemyStops stops;
	private int lenght;

	public EnemyStops getStops() {
		return stops;
	}

	public void setStops(EnemyStops stops) {
		this.stops = stops;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	private boolean moveLeft = false;
	private boolean moveRight = false;
	private boolean moveUp = false;
	private boolean moveDown = false;

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

	public Enemy(int x, int y, int w, int h, int speed, int lenght) {
		setPosX(x);
		setPosY(y);
		setWidth(w);
		setHeight(h);

		setSpeed(speed);

		setLenght(lenght);
		setStops(new EnemyStops(this, getLenght()));

	}
	public void Move(){
		if (isMoveLeft()) {
			setPosX(getPosX() - getSpeed());

		} else if (isMoveRight()) {
			setPosX(getPosX() + getSpeed());

		} else if (isMoveUp()) {
			setPosY(getPosY() - getSpeed());

		} else if (isMoveDown()) {
			setPosY(getPosY() + getSpeed());

		}
	}

	public void Colisions() {
		stopColisions();
		
	}

	public void stopColisions() {
		for (int i = 0; i < getLenght(); i++) {
			enemyStopColision(getStops().getEnemyDirections()[i], 2, getStops().getEnemyStops()[i][0],
					getStops().getEnemyStops()[i][1], 20, 20);
			
		}
		
	}

	private boolean leftStopSide(int bX, int bY, int bW, int bH) {
		if (getPosX() < bX + bW && isMoveLeft()) {
			if (getPosY() < bY + bH) {
				if (getPosX() + getWidth() > bX + (bW / 2)) {
					if (getPosY() + getHeight() > bY) {
						System.out.println("Left stop");
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

	private boolean rightStopSide(int bX, int bY, int bW, int bH) {
		if (getPosX() + getWidth() > bX && isMoveRight()) {
			if (getPosY() + getHeight() > bY) {
				if (getPosX() < bX + (bW / 2)) {
					if (getPosY() < bY + bH) {
						System.out.println("Right stop");
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

	private boolean bottomStopSide(int bX, int bY, int bW, int bH) {
		if (getPosY() < bY + bH && isMoveUp()) {
			if (getPosX() + getWidth() > bX) {
				if (getPosX() < bX + bW) {
					if (getPosY() + getHeight() > bY + (bH / 2)) {
						System.out.println("Up stop");
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

	private boolean topStopSide(int bX, int bY, int bW, int bH) {
		if (getPosY() + getHeight() > bY && isMoveDown()) {
			if (getPosX() + getWidth() > bX) {
				if (getPosX() < bX + bW) {
					if (getPosY() < bY + (bH / 2)) {
						System.out.println("down stop");
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

	private void enemyStopColision(int direction, int pushBackSpeed, int bX, int bY, int bW, int bH) {
		if (rightStopSide(bX, bY, bW, bH)) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);

			setPosX(getPosX() - pushBackSpeed);
			while (getPosX() + getWidth() < bX) {
				setPosX(getPosX() + 1);
				System.out.println("Right");
			}

			if (direction == 0) {
				setMoveLeft(true);
			} else if (direction == 1) {
				setMoveRight(true);
			} else if (direction == 2) {
				setMoveUp(true);
			} else if (direction == 3) {
				setMoveDown(true);
			}

		}
		if (leftStopSide(bX, bY, bW, bH)) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);

			setPosX(getPosX() + pushBackSpeed);
			while (getPosX() > bX + bW) {
				setPosX(getPosX() - 1);
				System.out.println("Left");
			}

			if (direction == 0) {
				setMoveLeft(true);
			} else if (direction == 1) {
				setMoveRight(true);
			} else if (direction == 2) {
				setMoveUp(true);
			} else if (direction == 3) {
				setMoveDown(true);
			}

		}
		if (topStopSide(bX, bY, bW, bH)) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);

			setPosY(getPosY() - pushBackSpeed);
			while (getPosY() + getHeight() < bY) {
				setPosY(getPosY() + 1);
				System.out.println("Down");
			}

			if (direction == 0) {
				setMoveLeft(true);
			} else if (direction == 1) {
				setMoveRight(true);
			} else if (direction == 2) {
				setMoveUp(true);
			} else if (direction == 3) {
				setMoveDown(true);
			}

		}
		if (bottomStopSide(bX, bY, bW, bH)) {
			setMoveRight(false);
			setMoveLeft(false);
			setMoveUp(false);
			setMoveDown(false);

			setPosY(getPosY() + pushBackSpeed);
			while (getPosY() > bY + bH) {
				setPosY(getPosY() - 1);
				System.out.println("Up");
			}

			if (direction == 0) {
				setMoveLeft(true);
			} else if (direction == 1) {
				setMoveRight(true);
			} else if (direction == 2) {
				setMoveUp(true);
			} else if (direction == 3) {
				setMoveDown(true);
			}

		}
	}

}
