package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
	private ArrayList<Block> blocks = new ArrayList<>();
	private ArrayList<Warper> warpes = new ArrayList<>();

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	public ArrayList<Warper> getWarpes() {
		return warpes;
	}

	public void setWarpes(ArrayList<Warper> warpes) {
		this.warpes = warpes;
	}

	private boolean inIt;

	public boolean isInIt() {
		return inIt;
	}

	public void setInIt(boolean inIt) {
		this.inIt = inIt;
	}

	private File file;
	public Scanner reader;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Level(String fileURL) {
		setFile(new File(fileURL));

		System.out.println(getFile().toString());

		try {
			reader = new Scanner(getFile());

			int current = 0;
			float objects = reader.nextInt();
			
			int procent = 0;

			while (reader.hasNextLine()) {
				if (reader.hasNext("B")) {
					reader.next();
					getBlocks().add(new Block(reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(),
							reader.nextBoolean(), reader.nextBoolean(), reader.nextBoolean(), reader.nextBoolean()));
				} else if (reader.hasNext("W")) {
					reader.next();
					getWarpes().add(new Warper(
							new WarpArea(reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt()),
							reader.nextInt()));

				} else {
					reader.nextLine();
				}
				current++;
				procent = (int)(current / objects * 1000);
				System.out.println("Level is Loaded " + (float)(procent / 10) + "%");

			}
			reader.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		}

		// blocks.add(new Block(0, 40, 40, 510, true, true, true, true)); // 0
		// blocks.add(new Block(120, 160, 10, 70, true, true, true, true)); // 1
		// blocks.add(new Block(110, 140, 10, 100, true, true, true, true)); //
		// 2
		// blocks.add(new Block(90, 130, 20, 110, true, true, true, true)); // 3
		// blocks.add(new Block(70, 130, 20, 120, true, true, true, true)); // 4
		// blocks.add(new Block(60, 130, 10, 130, true, true, true, true)); // 5
		// blocks.add(new Block(50, 120, 10, 160, true, true, true, true)); // 6
		// blocks.add(new Block(40, 100, 10, 210, true, true, true, true)); // 7
		// blocks.add(new Block(150, 40, 10, 30, true, true, true, true)); // 8
		// blocks.add(new Block(140, 40, 10, 10, true, true, true, true)); // 9
		// blocks.add(new Block(40, 40, 10, 20, true, true, true, true)); // 10
		// blocks.add(new Block(50, 40, 20, 10, true, true, true, true)); // 11
		// blocks.add(new Block(160, 40, 10, 130, true, true, true, true)); //
		// 12
		// blocks.add(new Block(170, 40, 10, 150, true, true, true, true)); //
		// 13
		// blocks.add(new Block(180, 40, 10, 160, true, true, true, true)); //
		// 14
		// blocks.add(new Block(190, 40, 20, 170, true, true, true, true)); //
		// 15
		// blocks.add(new Block(210, 40, 30, 180, true, true, true, true)); //
		// 16
		// blocks.add(new Block(240, 40, 20, 170, true, true, true, true)); //
		// 17
		// blocks.add(new Block(260, 40, 10, 160, true, true, true, true)); //
		// 18
		// blocks.add(new Block(270, 40, 10, 140, true, true, true, true)); //
		// 19
		// blocks.add(new Block(280, 40, 10, 110, true, true, true, true)); //
		// 20
		// blocks.add(new Block(290, 40, 10, 60, true, true, true, true)); // 21
		// blocks.add(new Block(300, 40, 10, 40, true, true, true, true)); // 22
		// blocks.add(new Block(310, 40, 20, 30, true, true, true, true)); // 23
		// blocks.add(new Block(330, 40, 30, 20, true, true, true, true)); // 24
		// blocks.add(new Block(360, 40, 70, 10, true, true, true, true)); // 25
		// blocks.add(new Block(170, 530, 40, 20, true, true, true, true)); //
		// 26
		// blocks.add(new Block(150, 520, 20, 30, true, true, true, true)); //
		// 27
		// blocks.add(new Block(140, 510, 10, 40, true, true, true, true)); //
		// 28
		// blocks.add(new Block(120, 500, 20, 50, true, true, true, true)); //
		// 29
		// blocks.add(new Block(110, 490, 10, 60, true, true, true, true)); //
		// 30
		// blocks.add(new Block(100, 470, 10, 80, true, true, true, true)); //
		// 31
		// blocks.add(new Block(90, 450, 10, 100, true, true, true, true)); //
		// 32
		// blocks.add(new Block(80, 440, 10, 110, true, true, true, true)); //
		// 33
		// blocks.add(new Block(60, 430, 20, 120, true, true, true, true)); //
		// 34
		// blocks.add(new Block(50, 420, 10, 130, true, true, true, true)); //
		// 35
		// blocks.add(new Block(40, 400, 10, 150, true, true, true, true)); //
		// 36
		// blocks.add(new Block(210, 540, 10, 10, true, true, true, true)); //
		// 37
		// blocks.add(new Block(0, 0, 530, 40, true, true, true, true)); // 38
		// blocks.add(new Block(530, 0, 20, 30, true, true, true, true)); // 39
		// blocks.add(new Block(550, 0, 10, 20, true, true, true, true)); // 40
		// blocks.add(new Block(600, 0, 10, 20, true, true, true, true)); // 41
		// blocks.add(new Block(610, 0, 20, 30, true, true, true, true)); // 42
		// blocks.add(new Block(630, 0, 170, 40, true, true, true, true)); // 43
		// blocks.add(new Block(660, 40, 100, 10, true, true, true, true)); //
		// 44
		// blocks.add(new Block(700, 50, 60, 10, true, true, true, true)); // 45
		// blocks.add(new Block(730, 60, 30, 10, true, true, true, true)); // 46
		// blocks.add(new Block(740, 70, 20, 20, true, true, true, true)); // 47
		// blocks.add(new Block(310, 500, 10, 50, true, true, true, true)); //
		// 48
		// blocks.add(new Block(300, 520, 10, 30, true, true, true, true)); //
		// 49
		// blocks.add(new Block(280, 530, 20, 20, true, true, true, true)); //
		// 50
		// blocks.add(new Block(260, 540, 20, 10, true, true, true, true)); //
		// 51
		// blocks.add(new Block(710, 250, 10, 110, true, true, true, true)); //
		// 52
		// blocks.add(new Block(720, 220, 10, 140, true, true, true, true)); //
		// 53
		// blocks.add(new Block(730, 180, 10, 190, true, true, true, true)); //
		// 54
		// blocks.add(new Block(740, 160, 10, 220, true, true, true, true)); //
		// 55
		// blocks.add(new Block(750, 90, 10, 310, true, true, true, true)); //
		// 56
		// blocks.add(new Block(700, 540, 20, 10, true, true, true, true)); //
		// 57
		// blocks.add(new Block(720, 530, 10, 20, true, true, true, true)); //
		// 58
		// blocks.add(new Block(730, 520, 20, 30, true, true, true, true)); //
		// 59
		// blocks.add(new Block(750, 510, 30, 40, true, true, true, true)); //
		// 60
		// blocks.add(new Block(780, 500, 20, 50, true, true, true, true)); //
		// 61
		// blocks.add(new Block(780, 40, 20, 420, true, true, true, true)); //
		// 62
		// blocks.add(new Block(770, 40, 10, 410, true, true, true, true)); //
		// 63
		// blocks.add(new Block(760, 40, 10, 380, true, true, true, true)); //
		// 64
		// blocks.add(new Block(320, 480, 10, 70, true, true, true, true)); //
		// 65
		// blocks.add(new Block(330, 460, 10, 90, true, true, true, true)); //
		// 66
		// blocks.add(new Block(340, 450, 10, 100, true, true, true, true)); //
		// 67
		// blocks.add(new Block(350, 440, 10, 110, true, true, true, true)); //
		// 68
		// blocks.add(new Block(530, 350, 10, 40, true, true, true, true)); //
		// 69
		// blocks.add(new Block(540, 340, 10, 50, true, true, true, true)); //
		// 70
		// blocks.add(new Block(360, 430, 10, 120, true, true, true, true)); //
		// 71
		// blocks.add(new Block(370, 430, 10, 120, true, true, true, true)); //
		// 72
		// blocks.add(new Block(380, 420, 10, 130, true, true, true, true)); //
		// 73
		// blocks.add(new Block(390, 420, 10, 130, true, true, true, true)); //
		// 74
		// blocks.add(new Block(400, 410, 10, 140, true, true, true, true)); //
		// 75
		// blocks.add(new Block(410, 410, 10, 140, true, true, true, true)); //
		// 76
		// blocks.add(new Block(420, 500, 10, 50, true, true, true, true)); //
		// 77
		// blocks.add(new Block(430, 520, 10, 30, true, true, true, true)); //
		// 78
		// blocks.add(new Block(440, 530, 10, 20, true, true, true, true)); //
		// 79
		// blocks.add(new Block(450, 540, 20, 10, true, true, true, true)); //
		// 80
		// blocks.add(new Block(520, 350, 10, 50, true, true, true, true)); //
		// 81
		// blocks.add(new Block(500, 360, 10, 50, true, true, true, true)); //
		// 82
		// blocks.add(new Block(480, 370, 10, 50, true, true, true, true)); //
		// 83
		// blocks.add(new Block(490, 370, 10, 40, true, true, true, true)); //
		// 84
		// blocks.add(new Block(460, 380, 10, 50, true, true, true, true)); //
		// 85
		// blocks.add(new Block(470, 380, 10, 40, true, true, true, true)); //
		// 86
		// blocks.add(new Block(450, 390, 10, 40, true, true, true, true)); //
		// 87
		// blocks.add(new Block(440, 390, 10, 50, true, true, true, true)); //
		// 88
		// blocks.add(new Block(430, 400, 10, 50, true, true, true, true)); //
		// 89
		// blocks.add(new Block(420, 400, 10, 70, true, true, true, true)); //
		// 90
		// blocks.add(new Block(580, 310, 10, 60, true, true, true, true)); //
		// 91
		// blocks.add(new Block(510, 360, 10, 40, true, true, true, true)); //
		// 92
		// blocks.add(new Block(550, 330, 10, 50, true, true, true, true)); //
		// 93
		// blocks.add(new Block(560, 320, 10, 60, true, true, true, true)); //
		// 94
		// blocks.add(new Block(570, 310, 10, 60, true, true, true, true)); //
		// 95
		// blocks.add(new Block(590, 300, 10, 60, true, true, true, true)); //
		// 96
		// blocks.add(new Block(600, 300, 10, 60, true, true, true, true)); //
		// 97
		// blocks.add(new Block(610, 290, 10, 60, true, true, true, true)); //
		// 98
		// blocks.add(new Block(620, 290, 10, 60, true, true, true, true)); //
		// 99
		// blocks.add(new Block(630, 290, 10, 60, true, true, true, true)); //
		// 100
		// blocks.add(new Block(640, 280, 10, 60, true, true, true, true)); //
		// 101
		// blocks.add(new Block(650, 280, 10, 60, true, true, true, true)); //
		// 102
		// blocks.add(new Block(660, 280, 10, 60, true, true, true, true)); //
		// 103
		// blocks.add(new Block(670, 280, 20, 60, true, true, true, true)); //
		// 104
		// blocks.add(new Block(690, 270, 10, 80, true, true, true, true)); //
		// 105
		// blocks.add(new Block(700, 260, 10, 90, true, true, true, true)); //
		// 106

	}

}
