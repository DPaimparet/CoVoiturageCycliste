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
				
				if(!textNom.getText().equals("") || !textPrenom.getText().equals("")){
					//String nom, String prenom,String sexe,String login,String password,String fonction,Date dateInscr
					Personne p = new Personne (nom, prenom, sexe, login, password, fonction);
					//Personne p = new Personne("Paimparet","Denis",date,"H","","Rue Borfilet",33,6040,"Jumet",3197580,"Paimparet.Denis@gmail.com","Denis","1234","Membre");
					p.inscription();
					vueInscription.dispose();
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(311)
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(677)
							.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textNom, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addContainerGap()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_6))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textLogin, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
												.addComponent(textPrenom))))
									.addGap(110))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblFonction)
									.addGap(36)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(38)
									.addComponent(comboBoxFonction, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(btnInscription)
							.addGap(67)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNom)
								.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrenom)
								.addComponent(textPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFonction)
								.addComponent(comboBoxFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
					.addGap(74)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAnnuler)
								.addComponent(btnInscription))))
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
