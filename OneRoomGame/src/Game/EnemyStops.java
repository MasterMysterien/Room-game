package Game;

public class EnemyStops {
	private int[][] enemyStops;

	public static final int X = 0;
	public static final int Y = 1;

	public int[][] getEnemyStops() {
		return enemyStops;
	}

	public void setEnemyStops(int[][] enemyStops) {
		this.enemyStops = enemyStops;
	}

	private int[] enemyDirections;

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;

	public int[] getEnemyDirections() {
		return enemyDirections;
	}

	public void setEnemyDirections(int[] enemyDirections) {
		this.enemyDirections = enemyDirections;
	}

	public EnemyStops(Enemy enemy, int lenght) {
		setEnemyStops(new int[lenght][2]);
		setEnemyDirections(new int[lenght]);

	}

}
