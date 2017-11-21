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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import be.Denis.Model.*;


public class VueAccueil {

	private JFrame ecranAccueil;
	private JTextField textUserName;
	private JPasswordField password;
	private JLabel lblAccueil;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton btnConnexion;
	private JButton btnReset;
	private JLabel lblErreur;
	private JButton btnInscription;
	private JButton btnClose;
	

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAccueil window = new VueAccueil();
					window.ecranAccueil.setVisible(true);
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
		eventHandler();
	}
	/***
	 * Event sur les boutons
	 */
	
	private void eventHandler() {
		/***
		 * Connexion
		 */
		
		btnConnexion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){	
				if(textUserName != null && password != null){
					@SuppressWarnings("deprecation")
					Personne p = new Personne(textUserName.getText(),password.getText());
					try {
						if(p.connexion()){
							ecranAccueil.dispose();
						}else {
							lblErreur.setText("login ou mot de passe incorrect");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}	
		});
			
		/***
		 * Remettre les champs de connexion à vide
		 */
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUserName.setText(null);
				password.setText(null);
			}
		});
		
		/***
		 * Envoie la personne vers l'interface d'inscription
		 */
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecranAccueil.dispose();
				VueInscription.init();
			}
		});
		
		/***
		 * Quitter l'application
		 */
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecranAccueil = new JFrame("Quitter");
				if(JOptionPane.showConfirmDialog(ecranAccueil, "Voulez-vous quitter l'application?","",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
					System.exit(0);
			}
		});
	}
	/**
	 * Initialisation de ma vue
	 */
	private void initialize() {

		ecranAccueil = new JFrame();
		ecranAccueil.getContentPane().setBackground(Color.CYAN);
		ecranAccueil.setBounds(200, 200, 655, 346);
		ecranAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ecranAccueil.getContentPane().setLayout(null);
		
		lblAccueil = new JLabel("Club Cycliste du Pays Noir");
		lblAccueil.setForeground(Color.BLUE);
		lblAccueil.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblAccueil.setBackground(Color.WHITE);
		lblAccueil.setBounds(200, 11, 274, 30);
		ecranAccueil.getContentPane().add(lblAccueil);
		
		lblLogin = new JLabel("Utilisateur");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setBounds(136, 72, 73, 17);
		ecranAccueil.getContentPane().add(lblLogin);
		
		lblPassword = new JLabel("Mot de passe");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(136, 100, 99, 14);
		ecranAccueil.getContentPane().add(lblPassword);
		
		textUserName = new JTextField();
		textUserName.setBounds(268, 72, 152, 20);
		ecranAccueil.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(268, 99, 152, 20);
		ecranAccueil.getContentPane().add(password);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConnexion.setBackground(Color.GREEN);
		btnConnexion.setForeground(Color.BLUE);
		btnConnexion.setBounds(84, 152, 99, 23);
		ecranAccueil.getContentPane().add(btnConnexion);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 200, 0));
		btnReset.setForeground(Color.BLUE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(268, 152, 89, 23);
		ecranAccueil.getContentPane().add(btnReset);
		
		btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInscription.setBackground(Color.LIGHT_GRAY);
		btnInscription.setForeground(Color.BLUE);
		btnInscription.setBounds(473, 152, 99, 23);
		ecranAccueil.getContentPane().add(btnInscription);
		
		btnClose = new JButton("Quitter");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClose.setBackground(Color.RED);
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(268, 231, 117, 23);
		ecranAccueil.getContentPane().add(btnClose);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 52, 608, 2);
		ecranAccueil.getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 206, 619, 2);
		ecranAccueil.getContentPane().add(separator);
		
		lblErreur = new JLabel("");
		lblErreur.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(428, 75, 201, 44);
		ecranAccueil.getContentPane().add(lblErreur);
	}
}
