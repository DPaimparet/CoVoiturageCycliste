package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import be.Denis.Model.Responsable;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class VueCreationBalade {

	private JFrame vueBalade;
	private JTextField textTitre;
	private JTextField textDateJour;
	private JTextField textPrixTrajet;
	private JButton btnAnnuler;
	private JButton btnCreer;
	Responsable responsable = null;
	private JTextField textDateMois;
	private JTextField textDateAnnee;
	private JEditorPane editorDesciption;

	/**
	 * Launch the application.
	 */
	public static void init(Responsable r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCreationBalade window = new VueCreationBalade(r);
					window.vueBalade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueCreationBalade(Responsable r) {
		this.responsable = r;
		initialize();
		eventHandler();
	}
	
	private void eventHandler() {
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueBalade.dispose();
				VueResponsable.init(responsable);
			}
		});
		
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int jour = Integer.parseInt(textDateJour.getText());
				int mois = Integer.parseInt(textDateMois.getText());
				int annee = Integer.parseInt(textDateAnnee.getText());
				Date dateB = new Date (annee-1900,mois-1,jour);
				String titreB = textTitre.getText();
				String descriptionB = editorDesciption.getText();
				int prixTrajet = Integer.parseInt(textPrixTrajet.getText());
				
				responsable.creer(responsable.getCategorie(), dateB, titreB, descriptionB, prixTrajet);
				vueBalade.dispose();
				VueResponsable.init(responsable);
			}
		});
	}
	

	/**
	 * Initialize the contents of the vueBalade.
	 */
	private void initialize() {
		vueBalade = new JFrame();
		vueBalade.setBackground(Color.CYAN);
		vueBalade.setBounds(100, 100, 450, 300);
		vueBalade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vueBalade.getContentPane().setLayout(null);
		
		JLabel lblTitre = new JLabel("Cr\u00E9ation d'une Balade");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitre.setBounds(121, 11, 185, 14);
		vueBalade.getContentPane().add(lblTitre);
		
		JLabel lblNewLabel = new JLabel("Balade");
		lblNewLabel.setBounds(10, 49, 46, 14);
		vueBalade.getContentPane().add(lblNewLabel);
		
		textTitre = new JTextField();
		textTitre.setBounds(57, 46, 213, 20);
		vueBalade.getContentPane().add(textTitre);
		textTitre.setColumns(10);
		
		JLabel lblDescritpion = new JLabel("Description");
		lblDescritpion.setBounds(10, 98, 63, 14);
		vueBalade.getContentPane().add(lblDescritpion);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 73, 46, 14);
		vueBalade.getContentPane().add(lblDate);
		
		textDateJour = new JTextField();
		textDateJour.setBounds(57, 67, 40, 20);
		vueBalade.getContentPane().add(textDateJour);
		textDateJour.setColumns(10);
		
		JLabel lblPrixTrajet = new JLabel("Prix du trajet");
		lblPrixTrajet.setBounds(10, 198, 63, 14);
		vueBalade.getContentPane().add(lblPrixTrajet);
		
		textPrixTrajet = new JTextField();
		textPrixTrajet.setBounds(83, 195, 86, 20);
		vueBalade.getContentPane().add(textPrixTrajet);
		textPrixTrajet.setColumns(10);
		
		btnCreer = new JButton("Cr\u00E9er");
		btnCreer.setBounds(110, 227, 89, 23);
		vueBalade.getContentPane().add(btnCreer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(245, 227, 89, 23);
		vueBalade.getContentPane().add(btnAnnuler);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		vueBalade.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 218, 414, 8);
		vueBalade.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(107, 70, 27, 14);
		vueBalade.getContentPane().add(lblNewLabel_1);
		
		textDateMois = new JTextField();
		textDateMois.setColumns(10);
		textDateMois.setBounds(114, 67, 40, 20);
		vueBalade.getContentPane().add(textDateMois);
		
		textDateAnnee = new JTextField();
		textDateAnnee.setColumns(10);
		textDateAnnee.setBounds(176, 67, 40, 20);
		vueBalade.getContentPane().add(textDateAnnee);
		
		JLabel label = new JLabel("/");
		label.setBounds(159, 70, 27, 14);
		vueBalade.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setBounds(179, 198, 46, 14);
		vueBalade.getContentPane().add(label_1);
		
		editorDesciption = new JEditorPane();
		editorDesciption.setBounds(67, 98, 287, 89);
		vueBalade.getContentPane().add(editorDesciption);
	}
}
