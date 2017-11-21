package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import be.Denis.Model.Responsable;

public class VueResponsable {

	private JFrame VueResponsable;
	private JButton btnQuitter;
	private JButton btnCreerBalade;
	private JButton btnParametre;
	private Responsable responsable = null;

	/**
	 * Launch the application.
	 */
	public static void init(Responsable r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueResponsable window = new VueResponsable(r);
					window.VueResponsable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueResponsable(Responsable r) {
		this.responsable = r;
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
		btnCreerBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueResponsable.dispose();
				VueCreationBalade.init();
			}
		});
		/***
		 * Quitter l'interface responsable vers l'interface d'accueil
		 */
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueResponsable.dispose();
				VueAccueil.init();
			}
		});
		
		/***
		 * 
		 */
		btnParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueResponsable.dispose();
				VueCompteResponsable.init(responsable);
			}
		});
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VueResponsable = new JFrame();
		VueResponsable.setBounds(100, 100, 507, 333);
		VueResponsable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VueResponsable.getContentPane().setLayout(null);
		
		JLabel lblTitreRespo = new JLabel("Bienvenue " + responsable.getPrenom());
		lblTitreRespo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitreRespo.setBounds(161, 11, 199, 20);
		VueResponsable.getContentPane().add(lblTitreRespo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 471, 2);
		VueResponsable.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Ajouter une balade");
		lblNewLabel.setBounds(85, 75, 114, 14);
		VueResponsable.getContentPane().add(lblNewLabel);
		
		btnCreerBalade = new JButton("Cr\u00E9er");
		btnCreerBalade.setBounds(254, 71, 109, 23);
		VueResponsable.getContentPane().add(btnCreerBalade);
		
		JLabel lblNewLabel_1 = new JLabel("Mes balades");
		lblNewLabel_1.setBounds(85, 126, 114, 14);
		VueResponsable.getContentPane().add(lblNewLabel_1);
		
		JButton btnGererBalade = new JButton("G\u00E9rer");
		btnGererBalade.setBounds(254, 122, 109, 23);
		VueResponsable.getContentPane().add(btnGererBalade);
		
		JLabel lblNewLabel_2 = new JLabel("G\u00E9rer mon compte");
		lblNewLabel_2.setBounds(85, 181, 114, 14);
		VueResponsable.getContentPane().add(lblNewLabel_2);
		
		btnParametre = new JButton("Param\u00E8tres");
		btnParametre.setBounds(254, 177, 109, 23);
		VueResponsable.getContentPane().add(btnParametre);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 217, 471, 2);
		VueResponsable.getContentPane().add(separator_1);
		
		btnQuitter = new JButton("D\u00E9connexion");
		btnQuitter.setBounds(196, 230, 109, 23);
		VueResponsable.getContentPane().add(btnQuitter);
	}
}
