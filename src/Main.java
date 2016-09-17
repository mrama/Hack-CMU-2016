package src;

import java.io.IOException;

import src.gui.Dots;
import src.gui.Menu;
import src.algo.Algo;

public class Main
{
	private static double height, width;
	private static int[][] dotCoords;
	private static boolean multiple;

	public static void updateMenuVars(
		double height,
		double width,
		boolean multiple
	) {
		Main.height = height;
		Main.width = width;
		Main.multiple = multiple;
	}

	public static void updateDotsVars(int[][] dotCoords)
	{
		Main.dotCoords = dotCoords;
		Algo.algo(dotCoords);
	}

	public static void main(String[] args) throws IOException
	{
		Menu menu = new Menu();
		menu.setVisible(true);
		Dots dots = new Dots();
		dots.setVisible(true);
	}
}
