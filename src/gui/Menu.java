package src.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.io.File;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.Main;
import src.gui.Dots;

public class Menu
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAddSinglePoster, btnAddMultiplePosters;

	public Menu()
	{
		JOptionPane.showMessageDialog(
			null,
			"Welcome to PrePoster®! " +
			"Choose a poster image."
		);
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter textFileOnlyFilter =
			new FileNameExtensionFilter(".jpg", "jpg", "jpg");
		fileChooser.setFileFilter(textFileOnlyFilter);
		fileChooser.showOpenDialog(new JFrame());
		File file = fileChooser.getSelectedFile();
		Main.posterPath = file.getPath();

		JOptionPane.showMessageDialog(
			null,
			"Please select an image for the background."
		);

		Dots dots = new Dots();
		dots.setVisible(true);
	}

}
