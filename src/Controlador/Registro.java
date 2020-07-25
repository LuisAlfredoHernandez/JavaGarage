package Controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField placa;
	private JTextField nombrePropietario;
    JRadioButton rdbtnCarro; 
	JRadioButton rdbtnMotocicleta;
	JRadioButton rdbtnCamioneta;
	ButtonGroup group = new ButtonGroup();
	java.sql.Statement statement;
	Connection conection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 366);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(21, 99, 46, 14);
		panel.add(lblPlaca);
		
		placa = new JTextField();
		placa.setBounds(56, 96, 130, 20);
		panel.add(placa);
		placa.setColumns(10);
		
		JLabel lblNombreDelPropietario = new JLabel("Nombre del propietario");
		lblNombreDelPropietario.setBounds(21, 142, 130, 14);
		panel.add(lblNombreDelPropietario);
		
		nombrePropietario = new JTextField();
		nombrePropietario.setBounds(152, 139, 136, 20);
		panel.add(nombrePropietario);
		nombrePropietario.setColumns(10);
		
		rdbtnCarro = new JRadioButton("Carro");
		rdbtnCarro.setBounds(21, 221, 59, 23);
		panel.add(rdbtnCarro);
		
		rdbtnMotocicleta = new JRadioButton("Motocicleta");
		rdbtnMotocicleta.setBounds(21, 247, 104, 23);
		panel.add(rdbtnMotocicleta);
		
		rdbtnCamioneta = new JRadioButton("Camioneta");
		rdbtnCamioneta.setBounds(21, 273, 94, 23);
		panel.add(rdbtnCamioneta);
		
		JLabel lblTipoDeVehiculo = new JLabel("Tipo de Vehiculo");
		lblTipoDeVehiculo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipoDeVehiculo.setBounds(21, 187, 140, 20);
		panel.add(lblTipoDeVehiculo);
		
		group.add(rdbtnCarro);
		group.add(rdbtnMotocicleta);
		group.add(rdbtnCamioneta);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion con = new Conexion();
			    String placaTxt = placa.getText();
			    String propietarioNombre = nombrePropietario.getText();
			    if(placaTxt.equals("") || propietarioNombre.equals("")) {
			    	JOptionPane.showMessageDialog(null, "Llene Los campos vacios!");
			    }
			    
			    else {
			        String vehiculo="";
			    	if(rdbtnCarro.isSelected()) {
			    		vehiculo = "Carro";
			    	} else if(rdbtnMotocicleta.isSelected()){
			    		vehiculo = "Motocicleta";
			    	} else if(rdbtnCamioneta.isSelected()) {
			    		vehiculo = "Camioneta";
			    	} 
			    	
			    	if(vehiculo.equals("")) {
			    		JOptionPane.showMessageDialog(null, "El tipo de vehiculo aun no se ha seleccionado!");
			    } else {
			    	
			    	String status = "Adentro";
			    	String sql ="INSERT INTO PARKING (Placa, Propietario, Tipo_Vehiculo, Estado) values ('"+placaTxt+"','"+propietarioNombre+"','"+vehiculo+"', 'Adentro')"; 
			    	  try {
			    		   conection = con.getConnection();
					       statement = conection.createStatement();
					       statement.execute(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			  }
			}
		});
		btnGuardar.setBounds(227, 313, 136, 31);
		panel.add(btnGuardar);
		
		JLabel lblEntradaDeVehiculo = new JLabel("Entrada de Vehiculo");
		lblEntradaDeVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEntradaDeVehiculo.setBounds(110, 22, 233, 20);
		panel.add(lblEntradaDeVehiculo);
		
		JButton btnNewButton = new JButton("Menu principal");
		btnNewButton.setBounds(71, 313, 125, 31);
		panel.add(btnNewButton);
	}
}
