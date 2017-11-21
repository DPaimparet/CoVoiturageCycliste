package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import be.Denis.Model.Tresorier;

public class VueTresorier {

	private JFrame VueTresorier;
	private JButton btnQuitter;
	private JButton btnVoirCompte;
	private JButton btnParametre;
	private Tresorier Tresorier = null;

	/**
	 * Launch the application.
	 */
	public static void init(Tresorier r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueTresorier window = new VueTresorier(r);
					window.VueTresorier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueTresorier(Tresorier r) {
		this.Tresorier = r;
		initialize();
		eventHandler();
	}

	/***
	 * Events sur les boutons
	 */
	private void eventHandler() {
		/***
		 * Vers la vue de création d'une balade
		 */
		btnVoirCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueTresorier.dispose();
				VueCreationBalade.init();
			}
		});
		/***
		 * Quitter l'interface Tresorier vers l'interface d'accueil
		 */
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueTresorier.dispose();
				VueAccueil.init();
			}
		});
		
		/***
		 * 
		 */
		btnParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueTresorier.dispose();
				VueCompteTresorier.init(Tresorier);
			}
		});
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VueTresorier = new JFrame();
		VueTresorier.setBounds(100, 100, 507, 333);
		VueTresorier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VueTresorier.getContentPane().setLayout(null);
		
		JLabel lblTitreRespo = new JLabel("Bienvenue " + Tresorier.getPrenom());
		lblTitreRespo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitreRespo.setBounds(161, 11, 199, 20);
		VueTresorier.getContentPane().add(lblTitreRespo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 471, 2);
		VueTresorier.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Voir Compte N\u00E9gatif");
		lblNewLabel.setBounds(85, 75, 114, 14);
		VueTresorier.getContentPane().add(lblNewLabel);
		
		btnVoirCompte = new JButton("Voir");
		btnVoirCompte.setBounds(254, 71, 109, 23);
		VueTresorier.getContentPane().add(btnVoirCompte);
		
		JLabel lblNewLabel_2 = new JLabel("G\u00E9rer mon compte");
		lblNewLabel_2.setBounds(85, 127, 114, 14);
		VueTresorier.getContentPane().add(lblNewLabel_2);
		
		btnParametre = new JButton("Param\u00E8tres");
		btnParametre.setBounds(254, 123, 109, 23);
		VueTresorier.getContentPane().add(btnParametre);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 217, 471, 2);
		VueTresorier.getContentPane().add(separator_1);
		
		btnQuitter = new JButton("D\u00E9connexion");
		btnQuitter.setBounds(196, 230, 109, 23);
		VueTresorier.getContentPane().add(btnQuitter);
	}
}