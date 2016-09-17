package src;

import java.awt.image.BufferedImage;
import java.io.IOException;

import src.gui.Dots;
import src.gui.Menu;
import src.gui.Posters;
import src.algo.Algo;

public class Main
{
	private static double height, width;
	private static int[][] dotCoords;
	private static boolean multiple;
	private static BufferedImage processed;

	public static void updateMenuVars(
		double height,
		double width,
		boolean multiple
	) {
		Main.height = height;
		Main.width = width;
		Main.multiple = multiple;
		Dots dots = new Dots();
		dots.setVisible(true);
	}

	public static void updateDotsVars(int[][] dotCoords)
	{
		Main.dotCoords = dotCoords;
		Main.processed = Algo.algo(dotCoords);
		Posters posters = new Posters(Main.processed);
		posters.setVisible(true);
	}

	public static void main(String[] args)
	{
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
