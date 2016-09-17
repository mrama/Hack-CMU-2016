package src.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.EventQueue;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.Main;

public class Dots extends JFrame implements MouseListener
{
	private JPanel contentPane;
	private BufferedImage img;
	private int clicks;
	private int[][] dotCoords;
	private double scaleFactor = 0.25;
	private File file = null;

	public Dots()
	{
		clicks = 0;
		dotCoords = new int[4][2];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1620, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// pulls image
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter textFileOnlyFilter =
			new FileNameExtensionFilter(".jpg", "jpg", "jpg");
		fileChooser.setFileFilter(textFileOnlyFilter);
		fileChooser.showOpenDialog(new JFrame());
		file = fileChooser.getSelectedFile();
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(file);
		}
		catch (IOException e)
		{
			System.err.println("Getting the background image failed");
			System.exit(1);
		}
		Image resizedImage = image.getScaledInstance(
			(int) (4640 * scaleFactor),
			(int) (3480 * scaleFactor),
			Image.SCALE_SMOOTH
		);
		JLabel lblNewLabel1 = new JLabel(new ImageIcon(resizedImage));

		// 4:3 aspect ratio
		lblNewLabel1.setBounds(
			0,
			0,
			(int) (4640 * scaleFactor),
			(int) (3480 * scaleFactor)
		);
		contentPane.add(lblNewLabel1);
		addMouseListener(this);
		JOptionPane.showMessageDialog(
			null,
			"Select the four corners of the poster's position " +
			"clockwise from the top left corner."
		);
	}

	// already scales the dot coordinates to native area
	public void mousePressed(MouseEvent e)
	{
		dotCoords[clicks][0] = (int)(e.getX() * (1 / scaleFactor));
		dotCoords[clicks][1] = (int)(e.getY() * (1 / scaleFactor) - 100);
		System.out.println("x: " + dotCoords[clicks][0]);
		System.out.println("y: " + dotCoords[clicks][1]);
		clicks++;

		if (clicks == 4)
		{
			Main.updateDotsVars(file.getPath(), dotCoords);
			this.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
