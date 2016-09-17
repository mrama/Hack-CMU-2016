public class Main {

	private static double height, width;
	private static boolean multiple;

	public static void updateMenuVars(double height, double width, boolean multiple) {
		Main.height = height;
		Main.width = width;
		Main.multiple = multiple;
		System.out.println(height + ", " + width + ", " + multiple);
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
