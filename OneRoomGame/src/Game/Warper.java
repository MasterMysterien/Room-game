package Game;

import java.awt.Graphics;

public class Warper {
	private WarpArea area;
	private int destination;

	private boolean coliding = false;

	public WarpArea getArea() {
		return area;
	}

	public void setArea(WarpArea area) {
		this.area = area;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public boolean isColiding() {
		return coliding;
	}

	public void setColiding(boolean coliding) {
		this.coliding = coliding;
	}

	public Warper(WarpArea area, int destination) {
		setArea(area);
		setDestination(destination);

	}
	
	public void colision(Player player) {
		area.colision(player);
		if (area.isColiding()) {
			setColiding(true);
			System.out.println("Player Colided with a Warper");
		}
		
	}
	
	public void show(Graphics g){
		g.fillRect(area.getPosX(), area.getPosY(), area.getWidth(), area.getHeight());
		
	}

}
