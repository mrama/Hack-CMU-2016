package src.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Main;

public class Posters extends JFrame
{
	private JPanel contentPane;
	private JButton btnOneMore, btnExit;

	public Posters(BufferedImage bi)
	{
		double scaleFactor = 0.1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1420, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		System.out.printf("OH FUCK %b\n", bi == null);
		System.out.println(bi);
		Image image = bi.getScaledInstance(
				(int) (4640 * scaleFactor),
				(int) (3480 * scaleFactor),
					Image.SCALE_SMOOTH
				);
		System.out.println(image);
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		lblNewLabel.setBounds(
			0,
			0,
			(int) (4640 * scaleFactor),
			(int) (3480 * scaleFactor)
		);
		contentPane.add(lblNewLabel);

		JButton btnOneMore = new JButton("One More!");
		btnOneMore.setBounds(30, 923, 171, 41);
		contentPane.add(btnOneMore);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(1173, 923, 171, 41);
		contentPane.add(btnExit);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnOneMore)
		{
			Main.main(new String[] {});
			this.dispose();
		}
		else
		{
			System.exit(0);
		}
	}

}
