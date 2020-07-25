package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Entrada extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada frame = new Entrada();
					frame.setVisible(true);
					frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Entrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Retirar Vehiculo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion conn = new Conexion();
				conn.getConnection();
				
			}
		});
		btnNewButton.setBounds(25, 271, 128, 31);
		panel.add(btnNewButton);
		
		JButton btnDesconectar = new JButton("Ingresar Vehiculo");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 Registro rg = new Registro();
			 rg.setVisible(true);
			}
		});
		btnDesconectar.setBounds(25, 213, 128, 31);
		panel.add(btnDesconectar);
		
		JButton btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.setBounds(251, 213, 121, 31);
		panel.add(btnBuscarVehiculo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(251, 271, 121, 31);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 322, 192);
		contentPane.add(lblNewLabel);
		
	}
}
