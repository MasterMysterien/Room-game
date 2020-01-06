package Game;

import java.awt.Graphics;

public class Block {
	public static int minBlockSize = 10;
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

	private boolean colisionLeft = true;
	private boolean colisionRight = true;
	private boolean colisionUp = true;
	private boolean colisionDown = true;
	
	public boolean isColisionLeft() {
		return colisionLeft;
	}

	public void setColisionLeft(boolean colisionLeft) {
		this.colisionLeft = colisionLeft;
	}

	public boolean isColisionRight() {
		return colisionRight;
	}

	public void setColisionRight(boolean colisionRight) {
		this.colisionRight = colisionRight;
	}

	public boolean isColisionUp() {
		return colisionUp;
	}

	public void setColisionUp(boolean colisionUp) {
		this.colisionUp = colisionUp;
	}

	public boolean isColisionDown() {
		return colisionDown;
	}

	public void setColisionDown(boolean colisionDown) {
		this.colisionDown = colisionDown;
	}

	public Block(int x, int y, int w, int h,boolean cl,boolean cr,boolean cu,boolean cd) {
		setPosX(x);
		setPosY(y);
		setWidth(w);
		setHeight(h);
		
		setColisionLeft(cl);
		setColisionRight(cr);
		setColisionUp(cu);
		setColisionDown(cd);

	}

	public void draw(Graphics g) {
		g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());
	}
	
	public void drawFilled(Graphics g) {
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
	}
	
	public void colisions(){
		
	}
}
