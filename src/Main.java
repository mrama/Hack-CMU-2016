package src;

import java.awt.image.BufferedImage;
import java.io.IOException;

import src.gui.Menu;
import src.gui.Posters;
import src.algo.Algo;


public class Main
{
	private static BufferedImage processed;
	public static String posterPath;

	public static void updateDotsVars(String path, int[][] dotCoords)
	{
		Main.processed = Algo.algo(Main.posterPath, path, dotCoords);
		Posters posters = new Posters(Main.processed);
		posters.setVisible(true);
	}

	public static void main(String[] args)
	{
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
