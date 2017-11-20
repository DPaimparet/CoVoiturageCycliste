package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;

public class VueCreationBalade {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCreationBalade window = new VueCreationBalade();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueCreationBalade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitre = new JLabel("Cr\u00E9ation d'une Balade");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitre.setBounds(121, 11, 185, 14);
		frame.getContentPane().add(lblTitre);
		
		JLabel lblNewLabel = new JLabel("Balade");
		lblNewLabel.setBounds(10, 49, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(57, 46, 213, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDescritpion = new JLabel("Description");
		lblDescritpion.setBounds(10, 98, 63, 14);
		frame.getContentPane().add(lblDescritpion);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 73, 46, 14);
		frame.getContentPane().add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(57, 67, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(83, 98, 317, 89);
		frame.getContentPane().add(textPane);
		
		JLabel lblPrixTrajet = new JLabel("Prix du trajet");
		lblPrixTrajet.setBounds(10, 198, 63, 14);
		frame.getContentPane().add(lblPrixTrajet);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 195, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCreer = new JButton("Cr\u00E9er");
		btnCreer.setBounds(110, 227, 89, 23);
		frame.getContentPane().add(btnCreer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(245, 227, 89, 23);
		frame.getContentPane().add(btnAnnuler);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 218, 414, 8);
		frame.getContentPane().add(separator_1);
	}
}
