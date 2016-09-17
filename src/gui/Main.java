package src.gui;

import java.io.IOException;

public class Main
{

	private static double height, width;
	private static double[][] dotCoords;
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

	public static void updateDotsVars(double[][] dotCoords)
	{
		Main.dotCoords = dotCoords;
	}

	public static void main(String[] args) throws IOException
	{
		System.out.println(System.getProperty("user.dir"));
		Menu menu = new Menu();
		menu.setVisible(true);
		Dots dots = new Dots();
		dots.setVisible(true);
	}
}
