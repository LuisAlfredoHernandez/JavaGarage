package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class Garage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Garage frame = new Garage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Garage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table.setBounds(23, 22, 402, 243);
		contentPane.add(table);
		
		JButton btnVolverAlMenu = new JButton("Volver al Menu");
		btnVolverAlMenu.setBounds(143, 301, 138, 31);
		contentPane.add(btnVolverAlMenu);
		
		table_1 = new JTable();
		table_1.setBounds(26, 35, 406, 218);
		contentPane.add(table_1);
	}
}
