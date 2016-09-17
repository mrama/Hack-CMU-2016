package src.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Posters extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JButton btnOneMore, btnStartOver, btnExit;

	public Posters(BufferedImage bi)
	{
		// double scaleFactor = 0.25;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1420, 1080);
		double scaleFactor = 0.75 * (bi.getHeight() < bi.getWidth() ? (1.0*this.getWidth())/bi.getWidth() : (1.0*this.getHeight())/bi.getHeight());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image image = bi.getScaledInstance(
				(int) (4640 * 0.75*scaleFactor),
				(int) (3480 * 0.75*scaleFactor),
					Image.SCALE_SMOOTH
				);
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		lblNewLabel.setBounds(
			90,
			-25,
			(int) (4640 * scaleFactor),
			(int) (3480 * scaleFactor)
		);
		contentPane.add(lblNewLabel);

		btnOneMore = new JButton("One More!");
		btnOneMore.addActionListener(this);
		btnOneMore.setBounds(
			this.getWidth() / 8,
			this.getHeight() - 400,
			171,
			41
		);
		contentPane.add(btnOneMore);

		btnStartOver = new JButton("Start Over");
		btnStartOver.addActionListener(this);
		btnStartOver.setBounds(
			3 * this.getWidth() / 8,
			this.getHeight() - 400,
			171,
			41
		);
		contentPane.add(btnStartOver);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnExit.setBounds(
			5 * this.getWidth() / 8,
			this.getHeight() - 400,
			171,
			41
		);
		contentPane.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOneMore)
		{
			// TODO
		}
		else if(e.getSource() == btnStartOver)
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
