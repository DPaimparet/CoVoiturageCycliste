package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;

import be.Denis.Model.Balade;
import be.Denis.Model.Responsable;
import java.awt.ScrollPane;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueBaladeResponsable {

	private JFrame vueBaladeResponsable;
	private Responsable responsable = null;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void init(Responsable r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueBaladeResponsable window = new VueBaladeResponsable(r);
					window.vueBaladeResponsable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueBaladeResponsable(Responsable r) {
		this.responsable = r;
		initialize();
		eventHandler();
	}
	private void eventHandler() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueBaladeResponsable.dispose();
				VueResponsable.init(responsable);
			}
		});
	}
	

	/**
	 * Initialize the contents of the vueBaladeResponsable.
	 */
	private void initialize() {
		
		vueBaladeResponsable = new JFrame();
		vueBaladeResponsable.setBounds(100, 100, 549, 420);
		vueBaladeResponsable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vueBaladeResponsable.getContentPane().setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(80, 80, 381, 143);
		
		
		JLabel lblTitre = new JLabel("Vos Balades");
		lblTitre.setBounds(203, 11, 85, 14);
		vueBaladeResponsable.getContentPane().add(lblTitre);
		LinkedList<Balade> listBalade = responsable.voirMesBalades();
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
		
		String titre[] = new String[] {"Balade", "Date", "Description", "Prix du Trajet" };
		table = new JTable(tabBalade, titre);
		table.setBounds(36, 46, 356, 118);
		vueBaladeResponsable.getContentPane().add(scrollPane.add(table));
		
		btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(203, 271, 89, 23);
		vueBaladeResponsable.getContentPane().add(btnNewButton);
	}
}
