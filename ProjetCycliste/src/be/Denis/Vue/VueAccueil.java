package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueAccueil {

	private JFrame frame;
	private JTextField textUserName;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAccueil window = new VueAccueil();
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
	public VueAccueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAccueil = new JLabel("Club Cycliste du Pays Noir");
		lblAccueil.setForeground(Color.BLUE);
		lblAccueil.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblAccueil.setBackground(Color.WHITE);
		lblAccueil.setBounds(122, 11, 274, 30);
		frame.getContentPane().add(lblAccueil);
		
		JLabel lblLogin = new JLabel("Utilisateur");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setBounds(65, 72, 73, 17);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(65, 100, 99, 14);
		frame.getContentPane().add(lblPassword);
		
		textUserName = new JTextField();
		textUserName.setBounds(168, 72, 152, 20);
		frame.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(168, 99, 152, 20);
		frame.getContentPane().add(password);
		
		//Bouton de connection
		JButton btnConnexion = new JButton("Connection");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String motDePasse = password.getText();
				String utilisateur = textUserName.getText();
				
				
				
			}
		});
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConnexion.setBackground(Color.GREEN);
		btnConnexion.setForeground(Color.BLUE);
		btnConnexion.setBounds(55, 152, 99, 23);
		frame.getContentPane().add(btnConnexion);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUserName.setText(null);
				password.setText(null);
			}
		});
		btnReset.setBackground(new Color(255, 200, 0));
		btnReset.setForeground(Color.BLUE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(195, 152, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInscription.setBackground(Color.LIGHT_GRAY);
		btnInscription.setForeground(Color.BLUE);
		btnInscription.setBounds(349, 152, 99, 23);
		frame.getContentPane().add(btnInscription);
		
		JButton btnClose = new JButton("Quitter");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Quitter");
				if(JOptionPane.showConfirmDialog(frame, "Voulez-vous quitter?","Le programme",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
					System.exit(0);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClose.setBackground(Color.RED);
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(168, 227, 117, 23);
		frame.getContentPane().add(btnClose);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 52, 453, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 206, 453, 2);
		frame.getContentPane().add(separator);
	}
}
