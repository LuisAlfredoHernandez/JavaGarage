package Controlador;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.Queryes;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Garage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					frame.setResizable(false);
				
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
		setBounds(100, 100, 613, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolverAlMenu = new JButton("Volver al Menu");
		
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada();
				entrada.setVisible(true);
				dispose();
			}
		});
		btnVolverAlMenu.setBounds(229, 299, 138, 31);
		contentPane.add(btnVolverAlMenu);
		
		
		cargarDBInfo();
	}

	private void cargarDBInfo() {
		Queryes.getConnection();
		
		String[] columnNames = {
			    "Marca", "Modelo", "Año", "Matricula", 
				"Dueño_cedula", "Fecha_entrada", "Fecha_salida", "Estado"
				};
		
		String [] [] data = Queryes.getAllVehiculos();	
			
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table_1 = new JTable(model);
		table_1.setBounds(26, 35, 406, 218);
		table_1.setShowGrid(true);
		table_1.setShowVerticalLines(true);
		JScrollPane pane = new JScrollPane(table_1);
		pane.setSize(577, 192);
		pane.setLocation(10, 69);
		contentPane.add(pane);
		
		JLabel lblNewLabel = new JLabel("Vehiculos en Garaje");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(195, 24, 215, 23);
		contentPane.add(lblNewLabel);
	}
}



