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

	public static void main(String[] args)
	{
		EventQueue.invokeLater(
			new Runnable()
			{
				public void run()
				{
					try {
						Menu frame = new Menu();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		);
	}

	public Menu()
	{
		height = 0;
		width = 0;
		multiple = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHowBigIs = new JLabel("How big is the rectangle?");
		lblHowBigIs.setBounds(166, 0, 304, 33);
		contentPane.add(lblHowBigIs);

		// tall
		textField = new JTextField();
		textField.setBounds(26, 47, 145, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		// wide
		textField_1 = new JTextField();
		textField_1.setBounds(26, 116, 145, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblMTall = new JLabel("m tall");
		lblMTall.setBounds(174, 50, 115, 33);
		contentPane.add(lblMTall);

		JLabel lblMWide = new JLabel("m wide");
		lblMWide.setBounds(174, 119, 115, 33);
		contentPane.add(lblMWide);

		btnAddSinglePoster = new JButton("Add Poster");
		btnAddSinglePoster.addActionListener(this);
		btnAddSinglePoster.setBounds(26, 195, 190, 41);
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
