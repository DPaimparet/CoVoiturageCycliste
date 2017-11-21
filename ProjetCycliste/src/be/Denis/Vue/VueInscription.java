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
import java.sql.Date;
import java.awt.event.ActionEvent;

import be.Denis.Model.Personne;
import be.Denis.Vue.VueAccueil;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class VueInscription {

	private JFrame vueInscription;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textLogin;
	private JTextField textPassword;
	private JButton btnInscription;
	private JButton btnAnnuler;
	private JRadioButton rdbtnSexeM;
	private JRadioButton rdbtnSexeF;
	private JComboBox<String> comboBoxFonction;
	private JLabel lblError;
	

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
				String nom = textNom.getText();
				String prenom = textPrenom.getText();
				String sexe;
				String login = textLogin.getText();
				String password = textPassword.getText();
				String fonction = (String) comboBoxFonction.getSelectedItem();

				if(rdbtnSexeM.isSelected()) {
					sexe="H";
				}
				else {
					sexe="F";
				}
				
				if(!textNom.getText().equals("") && !textPrenom.getText().equals("") && !textLogin.getText().equals("") && !textPassword.getText().equals("") ){
					Personne p = new Personne (nom, prenom, sexe, login, password, fonction);
					if(!p.exist(login)) {
						p.inscription();
						vueInscription.dispose();
						VueAccueil.init();
					}else
						lblError.setText("Un compte existe déjà avec ce nom, veuillez choisir un autre nom de compte");
				}
				else
					lblError.setText("Tous les champs ne sont pas remplis");
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
		
		rdbtnSexeF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSexeM.setSelected(false);
			}
		});
		
		rdbtnSexeM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSexeF.setSelected(false);
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vueInscription = new JFrame();
		vueInscription.setBounds(100, 100, 690, 476);
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
		
		JLabel lblNewLabel_6 = new JLabel("Login");
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		
		btnInscription = new JButton("Enregistrer");
		btnAnnuler = new JButton("Annuler");
		
		comboBoxFonction = new JComboBox<String>();
		comboBoxFonction.setModel(new DefaultComboBoxModel<String>(new String[] {"Membre", "Responsable", "Tresorier"}));
		comboBoxFonction.setSelectedIndex(0);
		
		JLabel lblFonction = new JLabel("Fonction dans le club");
		
		lblError = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(vueInscription.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_7)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblFonction)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(comboBoxFonction, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_6)
														.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
													.addGap(64)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(textLogin)
														.addComponent(textPrenom, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
														.addComponent(textNom)
														.addComponent(textPassword))))
											.addGap(44)
											.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
									.addGap(75))
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE)
									.addGap(25))))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(168)
							.addComponent(btnInscription)
							.addGap(166)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNom)
							.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPrenom)
									.addComponent(textPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFonction)
						.addComponent(comboBoxFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInscription)
						.addComponent(btnAnnuler))
					.addGap(59))
		);
		
		JLabel lblSexe = new JLabel("Sexe");
		panel.add(lblSexe);
		
		rdbtnSexeM = new JRadioButton("M");
		panel.add(rdbtnSexeM);
		rdbtnSexeM.setSelected(true);
		rdbtnSexeF = new JRadioButton("F");
		panel.add(rdbtnSexeF);
		vueInscription.getContentPane().setLayout(groupLayout);
	}
}
