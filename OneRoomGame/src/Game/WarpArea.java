package Game;

public class WarpArea {
	private int posX;
	private int posY;
	private int width;
	private int height;

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

	private boolean coliding = false;

	public boolean isColiding() {
		return coliding;
	}

	public void setColiding(boolean coniding) {
		this.coliding = coniding;
	}

	public WarpArea(int x, int y, int w, int h) {
		setPosX(x);
		setPosY(y);
		setWidth(w);
		setHeight(h);

		setColiding(false);

	}

	public void colision(Player player) {
		if (player.getposX() <= getPosX() + getWidth()) {
			if (player.getposX() + player.getWidth() >= getPosX()) {
				if (player.getposY() <= getPosY() + getHeight()) {
					if (player.getposY() + player.getHeight() >= getPosY()) {
						setColiding(true);

					} else {
						setColiding(false);
					}
				} else {
					setColiding(false);
				}
			} else {
				setColiding(false);
			}
		} else {
			setColiding(false);
		}
	}

}
