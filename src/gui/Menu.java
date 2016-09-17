package src.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.Main;

public class Menu extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAddSinglePoster, btnAddMultiplePosters;
	// true for multiple, false for single
	private boolean multiple;
	private double height, width;

	public Menu()
	{
		height = 0;
		width = 0;
		multiple = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(425, 250, 448, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel welcome
			= new JLabel("Welcome to PrePoster®.");
		welcome.setBounds(50, 0, 300, 50);
		contentPane.add(welcome);
		JLabel instruct
			= new JLabel("Please select an image for the background.");
		instruct.setBounds(50, 20, 300, 50);
		contentPane.add(instruct);

		btnAddSinglePoster = new JButton("OK");
		btnAddSinglePoster.addActionListener(this);
		btnAddSinglePoster.setBounds(135, 100, 190, 41);
		contentPane.add(btnAddSinglePoster);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		height = Double.parseDouble(textField.getText());
		width = Double.parseDouble(textField_1.getText());
		Main.updateMenuVars(height, width, multiple);
		this.dispose();
	}
}
