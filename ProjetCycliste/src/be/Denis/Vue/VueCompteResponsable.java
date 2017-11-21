package be.Denis.Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

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

import be.Denis.Model.Responsable;
@SuppressWarnings("deprecation")
public class VueCompteResponsable {

	private JFrame vueCompteResponsable;
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
	private JTextField textPassword;
	private JButton btnInscription;
	private JButton btnAnnuler;
	private JRadioButton rdbtnSexeM;
	private JRadioButton rdbtnSexeF;
	private JComboBox<String> comboBoxCategorie;
	private JLabel lblError;
	private Responsable responsable = null;

	/**
	 * Launch the application.
	 */
	public static void init(Responsable r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCompteResponsable window = new VueCompteResponsable(r);
					window.vueCompteResponsable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueCompteResponsable(Responsable r) {
		this.responsable = r;
		initialize(r);
		eventHandler();
	}
	
	/***
	 * Events sur les boutons
	 */
	private void eventHandler() {
		/***
		 * Mise a jour du compte de la personne
		 */
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textNom.getText();
				String prenom = textPrenom.getText();
				
				int jour = Integer.parseInt(textDateJour.getText());
				int mois = Integer.parseInt(textDateMois.getText());
				int annee = Integer.parseInt(textDateAnnee.getText());
				Date date = new Date (annee-1900,mois-1,jour);
				String sexe;
				String categorie = (String) comboBoxCategorie.getSelectedItem();
				String adresse = textAdresse.getText();
				int rue = Integer.parseInt(textNumRue.getText());
				int codePostal = Integer.parseInt(textCodePostal.getText());
				String ville  = textVille.getText();
				long numTel = Long.parseLong(textTel.getText());
				String mail = textMail.getText();
				String password = textPassword.getText();
				
				
				
				if(rdbtnSexeM.isSelected()) {
					sexe="H";
				}
				else {
					sexe="F";
				}
				
				if(!textNom.getText().equals("") && !textPrenom.getText().equals("") && !textDateJour.getText().equals("") && !textDateMois.getText().equals("") && !textDateAnnee.getText().equals("") && !textAdresse.getText().equals("") && !textNumRue.getText().equals("") && !textCodePostal.getText().equals("") && !textVille.getText().equals("") && !textTel.getText().equals("") && !textMail.getText().equals("") && !textPassword.getText().equals("")){
					
					responsable.setNom(nom);
					responsable.setPrenom(prenom);
					responsable.setDate(date);
					responsable.setSexe(sexe);
					responsable.setCategorie(categorie);
					responsable.setAdresse(adresse);
					responsable.setNumeroMaison(rue);
					responsable.setVille(ville);
					responsable.setCodePostal(codePostal);
					responsable.setNumTel(numTel);
					responsable.seteMail(mail);
					responsable.setPassword(password);
					
					responsable.updateCompte();
					vueCompteResponsable.dispose();
					VueResponsable.init(responsable);
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
				vueCompteResponsable.dispose();
				VueResponsable.init(responsable);
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
	private void initialize(Responsable m) {
		
		vueCompteResponsable = new JFrame();
		vueCompteResponsable.setBounds(100, 100, 694, 447);
		vueCompteResponsable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitre = new JLabel("Inscription");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		JSeparator separator = new JSeparator();
		JLabel lblNom = new JLabel("Nom");
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setText(m.getNom());
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setText(m.getPrenom());
		
		if(m.getDate()== null) {
			m.setDate(new Date(50,00,1));
		}

		java.sql.Date dat = java.sql.Date.valueOf(m.getDate().toString());
		//create calander instance and get required params
		Calendar cal = Calendar.getInstance();
		cal.setTime(dat);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		JLabel lblDateNaiss = new JLabel("Date de Naissance");
		textDateJour = new JTextField();
		textDateJour.setColumns(10);
		textDateJour.setText(Integer.toString(day));
		
		JLabel lblNewLabel = new JLabel("/");
		
		textDateMois = new JTextField();
		textDateMois.setColumns(10);
		textDateMois.setText(Integer.toString(month+1));
		
		JLabel lblNewLabel_1 = new JLabel("/");
		
		textDateAnnee = new JTextField();
		textDateAnnee.setColumns(10);
		textDateAnnee.setText(Integer.toString(year));
		
		JLabel lblAdresse = new JLabel("Adresse");
		
		textAdresse = new JTextField();
		textAdresse.setColumns(10);
		textAdresse.setText(m.getAdresse());
		
		JLabel lblNumeroMaison = new JLabel("Numero");
		
		textNumRue = new JTextField();
		textNumRue.setColumns(10);
		textNumRue.setText(Integer.toString(m.getNumeroMaison()));
		
		JLabel lblNewLabel_2 = new JLabel("Code Postal");
		
		textCodePostal = new JTextField();
		textCodePostal.setColumns(10);
		textCodePostal.setText(Integer.toString(m.getCodePostal()));
		
		JLabel lblNewLabel_3 = new JLabel("Ville");
		
		textVille = new JTextField();
		textVille.setColumns(10);
		textVille.setText(m.getVille());
		
		JLabel lblNewLabel_4 = new JLabel("T\u00E9l/GSM");
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setText(Long.toString(m.getNumTel()));
		
		JLabel lblNewLabel_5 = new JLabel("E-Mail");
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setText(m.geteMail());
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setText(m.getPassword());
		
		JSeparator separator_1 = new JSeparator();
		
		btnInscription = new JButton("Mettre \u00E0 jour");
		btnAnnuler = new JButton("Annuler");
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie");
		
		comboBoxCategorie = new JComboBox<String>();
		comboBoxCategorie.setModel(new DefaultComboBoxModel(new String[] {"VTT - Descende", "VTT - Randonneur", "VTT - Trialiste", "Cyclo sur route"}));
		
		lblError = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(vueCompteResponsable.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCategorie)
							.addGap(18)
							.addComponent(comboBoxCategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textTel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(65)
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
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAdresse)
									.addGap(10)
									.addComponent(textAdresse, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(284)
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(5, Short.MAX_VALUE))
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
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(textTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5))
						.addComponent(textMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCategorie))
						.addComponent(comboBoxCategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		vueCompteResponsable.getContentPane().setLayout(groupLayout);
	}

}