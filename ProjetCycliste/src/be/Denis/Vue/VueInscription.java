package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import be.Denis.Vue.VueAccueil;

public class VueInscription {

	private JFrame vueInscription;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textAdresse;
	private JTextField textNumRue;
	private JTextField textCodePostal;
	private JTextField textVille;
	private JTextField textTel;
	private JTextField textMail;
	private JTextField textLogin;
	private JTextField textPassword;
	private JButton btnInscription;
	private JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueInscription window = new VueInscription();
					window.vueInscription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueInscription() {
		initialize();
		eventHandler();
	}
	
	/***
	 * Events sur les boutons
	 */
	private void eventHandler() {
		/***
		 * création d'un nouveau membre
		 */
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		/***
		 * Quitter l'insciption sans sauvegarder et revenir à l'accueil
		 */
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueInscription.dispose();
				VueAccueil.init();
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vueInscription = new JFrame();
		vueInscription.setBounds(100, 100, 579, 300);
		vueInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitre = new JLabel("Inscription");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNom = new JLabel("Nom");
		
		textNom = new JTextField();
		textNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		
		JLabel lblDateNaiss = new JLabel("Date de Naissance");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("/");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblSexe = new JLabel("Sexe");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		
		JLabel lblAdresse = new JLabel("Adresse");
		
		textAdresse = new JTextField();
		textAdresse.setColumns(10);
		
		JLabel lblNumeroMaison = new JLabel("Numero");
		
		textNumRue = new JTextField();
		textNumRue.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Code Postal");
		
		textCodePostal = new JTextField();
		textCodePostal.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ville");
		
		textVille = new JTextField();
		textVille.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("T\u00E9l/GSM");
		
		textTel = new JTextField();
		textTel.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("E-Mail");
		
		textMail = new JTextField();
		textMail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Login");
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		
		btnInscription = new JButton("Enregistrer");
		btnAnnuler = new JButton("Annuler");
		
		GroupLayout groupLayout = new GroupLayout(vueInscription.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDateNaiss, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(13)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
									.addComponent(lblSexe)
									.addGap(32)
									.addComponent(rdbtnNewRadioButton)
									.addGap(18)
									.addComponent(rdbtnNewRadioButton_1)
									.addGap(55))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(textNom, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(46)
									.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textPrenom, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAdresse)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(textNumRue, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textCodePostal, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textVille, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(textAdresse, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumeroMaison)
					.addContainerGap(399, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textLogin)
						.addComponent(textTel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(240, Short.MAX_VALUE)
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(227))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(btnInscription)
					.addGap(60)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNom))
						.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPrenom))
						.addComponent(textPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDateNaiss))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSexe)
							.addComponent(rdbtnNewRadioButton)
							.addComponent(rdbtnNewRadioButton_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresse)
						.addComponent(textAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroMaison)
						.addComponent(textNumRue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(textVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(textMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInscription)
						.addComponent(btnAnnuler))
					.addContainerGap())
		);
		vueInscription.getContentPane().setLayout(groupLayout);
	}
}
