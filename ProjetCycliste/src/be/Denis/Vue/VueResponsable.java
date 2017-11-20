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

	/**
	 * Launch the application.
	 */
	public static void init(Responsable r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueResponsable window = new VueResponsable();
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
	public VueResponsable() {
		initialize();
		eventHandler();
	}

	/***
	 * Events sur les boutons
	 */
	private void eventHandler() {
		
		/***
		 * Quitter l'interface responsable vers l'interface d'accueil
		 */
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VueResponsable.dispose();
				VueAccueil.init();
			}
		});
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VueResponsable = new JFrame();
		VueResponsable.setBounds(100, 100, 450, 300);
		VueResponsable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VueResponsable.getContentPane().setLayout(null);
		
		JLabel lblTitreRespo = new JLabel("Bienvenue");
		lblTitreRespo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitreRespo.setBounds(175, 11, 92, 20);
		VueResponsable.getContentPane().add(lblTitreRespo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 414, 2);
		VueResponsable.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Ajouter une balade");
		lblNewLabel.setBounds(85, 75, 98, 14);
		VueResponsable.getContentPane().add(lblNewLabel);
		
		JButton btnCreerBalade = new JButton("Cr\u00E9er");
		btnCreerBalade.setBounds(254, 71, 89, 23);
		VueResponsable.getContentPane().add(btnCreerBalade);
		
		JLabel lblNewLabel_1 = new JLabel("Mes balades");
		lblNewLabel_1.setBounds(85, 126, 98, 14);
		VueResponsable.getContentPane().add(lblNewLabel_1);
		
		JButton btnGererBalade = new JButton("G\u00E9rer");
		btnGererBalade.setBounds(254, 122, 89, 23);
		VueResponsable.getContentPane().add(btnGererBalade);
		
		JLabel lblNewLabel_2 = new JLabel("G\u00E9rer mon compte");
		lblNewLabel_2.setBounds(85, 181, 98, 14);
		VueResponsable.getContentPane().add(lblNewLabel_2);
		
		JButton btnParametre = new JButton("Param\u00E8tres");
		btnParametre.setBounds(254, 177, 89, 23);
		VueResponsable.getContentPane().add(btnParametre);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 217, 414, 2);
		VueResponsable.getContentPane().add(separator_1);
		
		btnQuitter = new JButton("D\u00E9connexion");
		btnQuitter.setBounds(175, 230, 109, 23);
		VueResponsable.getContentPane().add(btnQuitter);
	}
}
