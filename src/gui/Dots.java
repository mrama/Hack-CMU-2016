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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dots extends JFrame implements MouseListener {

	private JPanel contentPane;
	private BufferedImage img;
	private int clicks;
	private double[][] dotCoords;
	private double scaleFactor = 0.3;

	/**
	 * Create the frame.
	 *
	 * @throws IOException
	 */
	public Dots() throws IOException {
		clicks = 0;
		dotCoords = new double[2][4];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1620, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// pulls image

		File file = null;
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter textFileOnlyFilter = new FileNameExtensionFilter(".jpg", "jpg", "jpg");
		fileChooser.setFileFilter(textFileOnlyFilter);
		int returnVal = fileChooser.showOpenDialog(new JFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		}
		file = fileChooser.getSelectedFile();
		// String path = file.getAbsolutePath();
		BufferedImage image = ImageIO.read(file);
		Image resizedImage = image.getScaledInstance((int) (4640 * scaleFactor), (int) (3480 * scaleFactor), Image.SCALE_SMOOTH);
		/*
		 * BufferedImage apple = new BufferedImage(image.getWidth(),
		 * image.getHeight(), BufferedImage.TYPE_INT_ARGB); AffineTransform at =
		 * new AffineTransform(); at.scale(0.25, 0.25); AffineTransformOp
		 * scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		 * apple = scaleOp.filter(image, apple);
		 */

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

		// Create a buffered image with transparency
		BufferedImage biToBeWritten = new BufferedImage(resizedImage.getWidth(null), resizedImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = biToBeWritten.createGraphics();
		bGr.drawImage(resizedImage, 0, 0, null);
		bGr.dispose();
		ImageIO.write(biToBeWritten, "jpg", file);

	}

	public void mousePressed(MouseEvent e) {
		System.out.println("x: " + e.getX());
		System.out.println("y: " + e.getY());

		dotCoords[0][clicks] = (e.getX() * (1/scaleFactor));
		dotCoords[1][clicks] = (e.getY() * (1/scaleFactor));
		clicks++;

		if (clicks == 4) {
			Main.updateDotsVars(dotCoords);
			this.dispose();
		}
	}

	// @Override
	// public void mouseClicked(MouseEvent arg0) {
	// 	// TODO Auto-generated method stub
	// }

	// @Override
	// public void mouseEntered(MouseEvent arg0) {
	// 	// TODO Auto-generated method stub
	// }

	// @Override
	// public void mouseExited(MouseEvent arg0) {
	// 	// TODO Auto-generated method stub
	// }

	// @Override
	// public void mouseReleased(MouseEvent arg0) {
	// 	// TODO Auto-generated method stub
	// }
}
