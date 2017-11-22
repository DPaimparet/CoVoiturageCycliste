package be.Denis.Vue;

import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import be.Denis.Model.Balade;
import be.Denis.Model.Membre;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class VueBaladeDisponible {

	private JFrame vueBaladeDisponible;
	private Membre membre = null;
	private JButton btnNewButton;
	private JTable table;
	private JButton btnReserver;

	/**
	 * Launch the application.
	 */
	public static void init(Membre m) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueBaladeDisponible window = new VueBaladeDisponible(m);
					window.vueBaladeDisponible.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueBaladeDisponible(Membre m) {
		this.membre = m;
		initialize();
		eventHandler();
	}
	
	private void eventHandler() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueBaladeDisponible.dispose();
				VueMembre.init(membre);
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		vueBaladeDisponible = new JFrame();
		vueBaladeDisponible.setBounds(100, 100, 450, 300);
		vueBaladeDisponible.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(80, 80, 381, 143);
		vueBaladeDisponible.getContentPane().setLayout(null);
		
		
		JLabel lblTitre = new JLabel("Vos Balades");
		lblTitre.setBounds(181, 11, 85, 14);
		vueBaladeDisponible.getContentPane().add(lblTitre);
		
		LinkedList<Balade> listBalade = membre.voirMesBalades();
		Object [][] tabBalade = new Object[listBalade.size()][4];
		int count = 0;
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		for(Balade b : listBalade) {
			tabBalade[count][0]=b.getTitreB();
			tabBalade[count][1]=simpleFormat.format(b.getDateB());
			tabBalade[count][2]=b.getDesciptionB();
			tabBalade[count][3]=b.getPrixTrajet();
			count++;
		}
		
		btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(285, 194, 116, 36);
		vueBaladeDisponible.getContentPane().add(btnNewButton);
		
		btnReserver = new JButton("Reserver");
		btnReserver.setBounds(73, 197, 110, 30);
		vueBaladeDisponible.getContentPane().add(btnReserver);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			tabBalade,
			new String[] {
				"Titre", "Date", "Description", "Prix du Trajet"
			}
		));
		table.setBounds(31, 36, 370, 131);
		vueBaladeDisponible.getContentPane().add(table);
	}

}
