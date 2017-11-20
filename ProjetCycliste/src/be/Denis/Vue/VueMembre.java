package be.Denis.Vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import be.Denis.Model.Membre;
import be.Denis.Model.Personne;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class VueMembre {

	private JFrame vueMembre;
	private JLabel lblBienvenue;

	/**
	 * Launch the application.
	 */
	public static void init(Membre m) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMembre window = new VueMembre();
					window.vueMembre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueMembre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vueMembre = new JFrame();
		vueMembre.setBackground(Color.CYAN);
		vueMembre.setBounds(100, 100, 450, 300);
		vueMembre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vueMembre.getContentPane().setLayout(null);
		
		lblBienvenue = new JLabel();
		lblBienvenue.setForeground(Color.BLUE);
		lblBienvenue.setBounds(170, 11, 102, 26);
		lblBienvenue.setText("Bienvenue ");
		vueMembre.getContentPane().add(lblBienvenue);
		
		JLabel lblTitre = new JLabel("Que voulez-vous faire?");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitre.setBounds(123, 32, 192, 54);
		vueMembre.getContentPane().add(lblTitre);
		
		JButton btnSeeBalade = new JButton("Voir");
		btnSeeBalade.setBounds(295, 95, 89, 23);
		vueMembre.getContentPane().add(btnSeeBalade);
		
		JButton btnNextBalade = new JButton("Voir");
		btnNextBalade.setBounds(295, 129, 89, 23);
		vueMembre.getContentPane().add(btnNextBalade);
		
		JButton btnCompte = new JButton("Param\u00E8tre");
		btnCompte.setBounds(295, 160, 89, 23);
		vueMembre.getContentPane().add(btnCompte);
		
		JLabel lblBalade = new JLabel("Voir les prochaines balades");
		lblBalade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBalade.setBounds(58, 97, 214, 14);
		vueMembre.getContentPane().add(lblBalade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 414, 2);
		vueMembre.getContentPane().add(separator);
		
		JLabel lblInscrit = new JLabel("Mes prochaines balades");
		lblInscrit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscrit.setBounds(58, 131, 214, 14);
		vueMembre.getContentPane().add(lblInscrit);
		
		JLabel lblCompte = new JLabel("G\u00E9rer mon compte");
		lblCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompte.setBounds(58, 160, 214, 19);
		vueMembre.getContentPane().add(lblCompte);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 205, 424, 2);
		vueMembre.getContentPane().add(separator_1);
		
		JButton btnDeconnexion = new JButton("D\u00E9connexion");
		btnDeconnexion.setBackground(Color.RED);
		btnDeconnexion.setForeground(Color.WHITE);
		btnDeconnexion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeconnexion.setBounds(157, 218, 129, 23);
		vueMembre.getContentPane().add(btnDeconnexion);
		
	}
}
