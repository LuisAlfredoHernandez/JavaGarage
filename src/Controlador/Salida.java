package Controlador;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Queryes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Salida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPrice;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salida frame = new Salida();
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
	public Salida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox.setBounds(225, 130, 48, 20);
		contentPane.add(comboBox);
		
		JLabel lblNumeroDeNoches = new JLabel("Numero de noches en el garage");
		lblNumeroDeNoches.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDeNoches.setBounds(10, 130, 218, 18);
		contentPane.add(lblNumeroDeNoches);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVehiculo.setBounds(10, 40, 57, 14);
		contentPane.add(lblVehiculo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Default", "Carro", "Motocicleta", "Camioneta"}));
		comboBox_1.setBounds(65, 37, 151, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlaca.setBounds(10, 71, 48, 14);
		contentPane.add(lblPlaca);
		
		textField = new JTextField();
		textField.setBounds(45, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPropietario = new JLabel(" Propietario");
		lblPropietario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPropietario.setBounds(5, 100, 86, 14);
		contentPane.add(lblPropietario);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 98, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 160, 46, 14);
		contentPane.add(lblNewLabel);

		lblPrice = new JLabel("");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(55, 160, 80, 14);
		contentPane.add(lblPrice);
		
		JButton btnNewButton = new JButton("Calcular total");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo_vehiculo = comboBox_1.getSelectedItem().toString();
				String placa = textField.getText();
				String propietario = textField_1.getText();
				String tiempo_guardado = comboBox.getSelectedItem().toString();
				
				if(tipo_vehiculo == "Default" || placa.isEmpty() || propietario.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Los datos requeridos no han sido introducidos!");
				}else {
					int precio = 0;
					switch(tipo_vehiculo) {
						case "Carro": 
							precio = 100;
							break;
						case "Motocicleta": 
							precio = 75;
							break;
						case "Camioneta": 
							precio = 125;
							break;
						case "Default": 
							break;
					}			
					int precioTotal = precio * (Integer.parseInt(tiempo_guardado));
					lblPrice.setText("RD$"+String.valueOf(precioTotal));			
				}
			}
		});
		btnNewButton.setBounds(172, 227, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver al menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada ent = new Entrada();
				ent.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(21, 227, 129, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Efectuar pago");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo_vehiculo = comboBox_1.getSelectedItem().toString();
				String placa = textField.getText().trim();
				String propietario = textField_1.getText().trim();
				String tiempo_guardado = comboBox.getSelectedItem().toString();

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    	LocalDateTime now = LocalDateTime.now();
		    	String fechaActual = dtf.format(now);
		    	
		    	Vehiculo v1 = new Vehiculo();
		    	v1.setFecha_salida(fechaActual);
		    	v1.setEstado("Fuera");
		    	v1.setMatricula(placa);
		    	Queryes.updateVehiculoStatus(v1);
			}
		});
		btnNewButton_1_1.setBounds(312, 227, 124, 23);
		contentPane.add(btnNewButton_1_1);
	
	}
}
