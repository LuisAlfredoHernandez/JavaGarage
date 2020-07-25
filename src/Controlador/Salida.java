package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Salida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salida frame = new Salida();
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
	public Salida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox.setBounds(169, 145, 48, 20);
		contentPane.add(comboBox);
		
		JLabel lblNumeroDeNoches = new JLabel("Numero de noches en el garage");
		lblNumeroDeNoches.setBounds(10, 148, 198, 14);
		contentPane.add(lblNumeroDeNoches);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setBounds(10, 51, 57, 14);
		contentPane.add(lblVehiculo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Default", "Carro", "Motocicleta", "Camioneta"}));
		comboBox_1.setBounds(77, 48, 151, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 82, 48, 14);
		contentPane.add(lblPlaca);
		
		textField = new JTextField();
		textField.setBounds(56, 79, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPropietario = new JLabel(" Propietario");
		lblPropietario.setBounds(10, 110, 67, 14);
		contentPane.add(lblPropietario);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 107, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular total");
		btnNewButton.setBounds(234, 227, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver al menu");
		btnNewButton_1.setBounds(102, 227, 103, 23);
		contentPane.add(btnNewButton_1);
	}
}
