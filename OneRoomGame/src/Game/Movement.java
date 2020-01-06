package Game;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
	public static Timer timer;
	public static Player player = OneRoomGame.player;
	
	private Level level = OneRoomGame.levels.get(OneRoomGame.level);

	public Movement() {

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				movement();

			}

		}, 2, 8);

	}
	
	public void movement(){
		if (player.isMoveLeft()) {
			player.setposX(player.getposX() - player.getSpeed());

		} else if (player.isMoveRight()) {
			player.setposX(player.getposX() + player.getSpeed());

		} else if (player.isMoveUp()) {
			player.setposY(player.getposY() - player.getSpeed());

		} else if (player.isMoveDown()) {
			player.setposY(player.getposY() + player.getSpeed());

		}

		if (player.getposY() + player.getHeight() > Frame.Height) {
			player.setMoveDown(false);
			player.setposY(player.getposY() - player.getSpeed());

			while (player.getposY() + player.getHeight() < Frame.Height) {
				player.setposY(player.getposY() + 1);
			}
		} else if (player.getposX() < 0) {
			player.setMoveLeft(false);
			player.setposX(player.getposX() + player.getSpeed());
			while (player.getposX() > 0) {
				player.setposX(player.getposX() - 1);
			}
		} else if (player.getposX() + player.getWidth() > Frame.Width) {
			player.setMoveRight(false);
			player.setposX(player.getposX() - player.getSpeed());
			while (player.getposX() + player.getWidth() < Frame.Width) {
				player.setposX(player.getposX() + 1);
			}
		} else if (player.getposY() < 0) {
			player.setMoveUp(false);
			player.setposY(player.getposY() + player.getSpeed());
			while (player.getposY() > 0) {
				player.setposY(player.getposY() - 1);
			}

		}

		oneWayBoxColision(player, 0, 3, 100, 525, 25, 25);

		player.blockColisions();
		
		level.getWarpes().get(0).colision(player);
		
//		for(int i = 0; i < OneRoomGame.levels.get(OneRoomGame.level).getEnemies().size(); i++){
//			 OneRoomGame.levels.get(OneRoomGame.level).getEnemies().get(i).Move();
//			 OneRoomGame.levels.get(OneRoomGame.level).getEnemies().get(i).Colisions();
//			
//		}
	}

	private static boolean leftSide(Player player, int bX, int bY, int bW, int bH) {
		if (player.getposX() < bX + bW) {
			if (player.getposY() < bY + bH) {
				if (player.getposX() + player.getWidth() > bX + (bW / 2)) {
					if (player.getposY() + player.getHeight() > bY) {
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

	private static boolean rightSide(Player player, int bX, int bY, int bW, int bH) {
		if (player.getposX() + player.getWidth() > bX) {
			if (player.getposY() + player.getHeight() > bY) {
				if (player.getposX() < bX + (bW / 2)) {
					if (player.getposY() < bY + bH) {
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

	private static boolean bottomSide(Player player, int bX, int bY, int bW, int bH) {
		if (player.getposY() < bY + bH) {
			if (player.getposX() + player.getWidth() > bX) {
				if (player.getposX() < bX + bW) {
					if (player.getposY() + player.getHeight() > bY + (bH / 2)) {
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

	private static boolean topSide(Player player, int bX, int bY, int bW, int bH) {
		if (player.getposY() + player.getHeight() > bY) {
			if (player.getposX() + player.getWidth() > bX) {
				if (player.getposX() < bX + bW) {
					if (player.getposY() < bY + (bH / 2)) {
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

	public static void oneWayBoxColision(Player player, int direction, int pushBackSpeed, int bX, int bY, int bW, int bH) {
		if (rightSide(player, bX, bY, bW, bH) && player.isMoveRight() && direction == 0) {
			player.setMoveRight(false);
			player.setMoveLeft(false);
			player.setMoveUp(false);
			player.setMoveDown(false);
			player.setposX(player.getposX() - pushBackSpeed);
			while (player.getposX() + player.getWidth() < bX) {
				player.setposX(player.getposX() + 1);
				System.out.println("Right");
			}

		}
		if (leftSide(player, bX, bY, bW, bH) && player.isMoveLeft() && direction == 1) {
			player.setMoveRight(false);
			player.setMoveLeft(false);
			player.setMoveUp(false);
			player.setMoveDown(false);
			player.setposX(player.getposX() + pushBackSpeed);
			while (player.getposX() > bX + bW) {
				player.setposX(player.getposX() - 1);
				System.out.println("Left");
			}

		}
		if (topSide(player, bX, bY, bW, bH) && player.isMoveDown() && direction == 2) {
			player.setMoveRight(false);
			player.setMoveLeft(false);
			player.setMoveUp(false);
			player.setMoveDown(false);
			player.setposY(player.getposY() + pushBackSpeed);
			while (player.getposY() + player.getHeight() < bY) {
				player.setposY(player.getposY() + 1);
				System.out.println("Down");
			}

		}
		if (bottomSide(player, bX, bY, bW, bH) && player.isMoveUp() && direction == 3) {
			player.setMoveRight(false);
			player.setMoveLeft(false);
			player.setMoveUp(false);
			player.setMoveDown(false);
			player.setposY(player.getposY() + pushBackSpeed);
			while (player.getposY() > bY + bH) {
				player.setposY(player.getposY() - 1);
				System.out.println("Up");
			}
		}
	}
}
