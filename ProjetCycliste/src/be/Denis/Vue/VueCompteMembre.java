package be.Denis.Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import be.Denis.Model.Personne;

public class VueCompteMembre {

	private JFrame vueCompteMembre;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textDateJour;
	private JTextField textDateMois;
	private JTextField textDateAnnee;
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
	private JRadioButton rdbtnSexeM;
	private JRadioButton rdbtnSexeF;
	private JComboBox<String> comboBoxCategorie;
	private JComboBox<String> comboBoxFonction;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCompteMembre window = new VueCompteMembre();
					window.vueCompteMembre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueCompteMembre() {
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
				
				
				int jour = Integer.parseInt(textDateJour.getText());
				int mois = Integer.parseInt(textDateMois.getText());
				int annee = Integer.parseInt(textDateAnnee.getText());
				Date date = new Date (annee,mois,jour);
				String sexe;
				String categorie = (String) comboBoxCategorie.getSelectedItem();
				String adresse = textAdresse.getText();
				int rue = Integer.parseInt(textNumRue.getText());
				int codePostal = Integer.parseInt(textCodePostal.getText());
				String ville  = textVille.getText();
				long numTel = Long.parseLong(textTel.getText());
				String mail = textMail.getText();
				String login = textLogin.getText();
				String password = textPassword.getText();
				String fonction = (String) comboBoxFonction.getSelectedItem();
				
				
				if(rdbtnSexeM.isSelected()) {
					sexe="H";
				}
				else {
					sexe="F";
				}
				
				if(!textNom.getText().equals("") || !textPrenom.getText().equals("")){
					Personne p = new Personne(nom ,prenom , date, sexe, categorie, adresse, rue, codePostal, ville, numTel , mail, login, password, fonction);
					//Personne p = new Personne("Paimparet","Denis",date,"H","","Rue Borfilet",33,6040,"Jumet",3197580,"Paimparet.Denis@gmail.com","Denis","1234","Membre");
					p.inscription();
					vueCompteMembre.dispose();
					VueAccueil.init();
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
				vueCompteMembre.dispose();
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
		vueCompteMembre = new JFrame();
		vueCompteMembre.setBounds(100, 100, 694, 447);
		vueCompteMembre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		textDateJour = new JTextField();
		textDateJour.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("/");
		
		textDateMois = new JTextField();
		textDateMois.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		
		textDateAnnee = new JTextField();
		textDateAnnee.setColumns(10);
		
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
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie");
		
		comboBoxFonction = new JComboBox<String>();
		comboBoxFonction.setModel(new DefaultComboBoxModel<String>(new String[] {"Membre", "Responsable", "Tresorier"}));
		
		JLabel lblFonction = new JLabel("Fonction dans le club");
		
		comboBoxCategorie = new JComboBox<String>();
		comboBoxCategorie.setModel(new DefaultComboBoxModel<String>(new String[] {"VTT - Descende", "VTT - Randonneur", "VTT - Trialoste", "Cyclo sur route"}));
		
		lblError = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(vueCompteMembre.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(311)
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_6)
							.addGap(18)
							.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_7)
							.addGap(4)
							.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCategorie)
							.addGap(18)
							.addComponent(comboBoxCategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(121)
							.addComponent(lblFonction)
							.addGap(58)
							.addComponent(comboBoxFonction, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(238)
							.addComponent(btnInscription)
							.addGap(72)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(textNom, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(46)
									.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textPrenom, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDateNaiss, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addComponent(textDateJour, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(13)
											.addComponent(textDateMois, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(textDateAnnee, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
							.addGap(102)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addGap(65)
									.addComponent(textTel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblNewLabel_5)
									.addGap(10)
									.addComponent(textMail))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNumeroMaison)
									.addGap(14)
									.addComponent(textNumRue, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2)
									.addGap(10)
									.addComponent(textCodePostal, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textVille))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblAdresse)
									.addGap(10)
									.addComponent(textAdresse, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
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
								.addComponent(textDateJour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDateMois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(textDateAnnee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblAdresse))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumeroMaison))
						.addComponent(textNumRue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(textCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3))
						.addComponent(textVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4))
						.addComponent(textTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5))
						.addComponent(textMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_6))
						.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_7))
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCategorie))
						.addComponent(comboBoxCategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFonction))
						.addComponent(comboBoxFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInscription)
						.addComponent(btnAnnuler))
					.addGap(44))
		);
		
		JLabel lblSexe = new JLabel("Sexe");
		panel.add(lblSexe);
		
		rdbtnSexeM = new JRadioButton("M");
		panel.add(rdbtnSexeM);
		rdbtnSexeM.setSelected(true);
		rdbtnSexeF = new JRadioButton("F");
		panel.add(rdbtnSexeF);
		vueCompteMembre.getContentPane().setLayout(groupLayout);
	}

}
