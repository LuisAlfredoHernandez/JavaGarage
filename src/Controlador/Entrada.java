package Controlador;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Entrada extends JFrame {
	private static final long serialVersionUID = 1L;
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
				Salida salida = new Salida();
				salida.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(25, 184, 147, 64);
		panel.add(btnNewButton);
		
		JButton btnDesconectar = new JButton("Ingresar Vehiculo");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 Registro rg = new Registro();
			 rg.setVisible(true);
		     dispose();
			}
		});
		btnDesconectar.setBounds(25, 79, 147, 64);
		panel.add(btnDesconectar);
		
		JButton btnBuscarVehiculo = new JButton("Ver Vehiculos");
		btnBuscarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Garage garage = new Garage();
				garage.setVisible(true);
				dispose();
			}
		});
		btnBuscarVehiculo.setBounds(252, 77, 147, 64);
		panel.add(btnBuscarVehiculo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(252, 184, 147, 64);
		panel.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(180, 26, 62, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 322, 192);
		contentPane.add(lblNewLabel);
	}
}
