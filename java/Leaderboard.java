
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a description of class Leaderboard here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class Leaderboard {
	private ArrayList<Integer> x;
	Scanner read;
	static PrintWriter write;
	int c = 0;

	int Score = SampleGamePanel.getScore();

	/**
	 * Constructor for objects of class Leaderboard
	 */
	public Leaderboard() {
		x = new ArrayList<Integer>();
	}

	public void addScore(int score) {

		if (x.size() == 0) {
			x.add(score);
		} else {
			for (int y = 0; y < x.size(); y++) {
				if (score > x.get(y)) {
					x.add(y, score);
					y = x.size();
				} else if (y == x.size() - 1) {
					x.add(score);
				}
			}
		}
	}

	public void loadScores() {
		try {
			read = new Scanner(new FileReader("scores.txt"));

			while (read.hasNext()) {
				x.add(c, read.nextInt());
				c++;
			}
		}

		catch (FileNotFoundException fnfe) {
			System.out.println(fnfe + ": FILE NOT FOUND!");
		} catch (InputMismatchException ime) {
			System.out.println(ime + ": INVALID DATA!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void writeScores() {
		File tempFile = null;
		try {
			// loadScores ();
			Scanner scanner = new Scanner(new File("scores.txt"));
			int[] tall = new int[100];
			int i = 0;
			while (scanner.hasNextInt()) {
				tall[i++] = scanner.nextInt();
				if (SampleGamePanel.getScore() > tall[0]) {
					write = new PrintWriter("scores.txt");
					write.print(SampleGamePanel.getScore() + " ");
					write.close();

				}

			}

		} catch (InputMismatchException ime) {
			System.out.println(ime + ": INVALID DATA!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String display() {
		String result = "HIGHSCORE: \n";
		try {
				read = new Scanner(new FileReader("scores.txt"));
				int lScore;
				while (read.hasNext()) {
					lScore = read.nextInt();
					result += lScore;
				}

		} catch (InputMismatchException ime) {
			System.out.println(ime + ": INVALID DATA!");
		} catch (Exception e) {
			System.out.println(e);
		} 
		return result;
	}
}
