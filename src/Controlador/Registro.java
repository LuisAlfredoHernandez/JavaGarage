package Controlador;


import Modelo.Queryes;
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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtplaca;
	private JTextField txtcedula;
	

	private JTextField txtmarca;
	private JTextField txtmodelo;
	private JTextField txtmatricula;
	private JTextField txtanio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
		lblPlaca.setBounds(20, 112, 38, 14);
		panel.add(lblPlaca);
		
		txtplaca = new JTextField();
		txtplaca.setBounds(55, 108, 130, 20);
		panel.add(txtplaca);
		txtplaca.setColumns(10);
		
		JLabel lblNombreDelPropietario = new JLabel("Cedula del propietario");
		lblNombreDelPropietario.setBounds(20, 137, 130, 14);
		panel.add(lblNombreDelPropietario);
		
		txtcedula = new JTextField();
		txtcedula.setBounds(148, 134, 121, 20);
		panel.add(txtcedula);
		txtcedula.setColumns(10);
		
		JRadioButton rdbtnCarro = new JRadioButton("Carro");
		rdbtnCarro.setBounds(20, 266, 59, 23);
		panel.add(rdbtnCarro);
		
		JRadioButton rdbtnMotocicleta = new JRadioButton("Motocicleta");
		rdbtnMotocicleta.setBounds(20, 292, 104, 23);
		panel.add(rdbtnMotocicleta);
		
		JRadioButton rdbtnCamioneta = new JRadioButton("Camioneta");
		rdbtnCamioneta.setBounds(20, 318, 94, 23);
		panel.add(rdbtnCamioneta);
		
		JLabel lblTipoDeVehiculo = new JLabel("Tipo de Vehiculo");
		lblTipoDeVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeVehiculo.setBounds(10, 238, 175, 20);
		panel.add(lblTipoDeVehiculo);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCarro);
		group.add(rdbtnMotocicleta);
		group.add(rdbtnCamioneta);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String placaTxt = txtplaca.getText();
			    String propietarioNombre = txtcedula.getText();
			    String matricula = txtmatricula.getText();
			    String modelo = txtmodelo.getText();
			    String anio = txtanio.getText();
			    String marca = txtmarca.getText();
			 
			    if(placaTxt.equals("") || propietarioNombre.equals("")) {
			    	JOptionPane.showMessageDialog(null, "Llene Los campos vacios!");
			    }else {
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
			    } else{
				  	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			    	  LocalDateTime now = LocalDateTime.now();
			    	  String fechaActual = dtf.format(now);
			    	  
			    	  Vehiculo v1 = new Vehiculo();
			    	  v1.setDueño_cedula(propietarioNombre);
			    	  v1.setAño(anio);
			    	  v1.setFecha_entrada(fechaActual);
			    	  v1.setMarca(marca);
			    	  v1.setTipo_Vehiculo(vehiculo);
			    	  v1.setMatricula(matricula);
			    	  v1.setModelo(modelo);
			    	  v1.setEstado("Adentro");
			    	  System.out.print("Code:"+Queryes.saveVehiculo(v1)+". Success!");
			    }
			  }
			}
		});
		
		btnGuardar.setBounds(252, 305, 157, 39);
		panel.add(btnGuardar);
		
		JLabel lblEntradaDeVehiculo = new JLabel("Entrada de Vehiculo");
		lblEntradaDeVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEntradaDeVehiculo.setBounds(113, 11, 233, 20);
		panel.add(lblEntradaDeVehiculo);
		
		JButton btnNewButton = new JButton("Menu principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada();
				entrada.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(252, 252, 157, 39);
		panel.add(btnNewButton);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 55, 46, 14);
		panel.add(lblMarca);
		
		txtmarca = new JTextField();
		txtmarca.setColumns(10);
		txtmarca.setBounds(60, 52, 130, 20);
		panel.add(txtmarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 83, 46, 14);
		panel.add(lblModelo);
		
		txtmodelo = new JTextField();
		txtmodelo.setColumns(10);
		txtmodelo.setBounds(65, 83, 130, 20);
		panel.add(txtmodelo);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(20, 165, 59, 14);
		panel.add(lblMatricula);
		
		txtmatricula = new JTextField();
		txtmatricula.setColumns(10);
		txtmatricula.setBounds(77, 162, 136, 20);
		panel.add(txtmatricula);
		
		JLabel lblAnio = new JLabel("A\u00F1o");
		lblAnio.setBounds(20, 190, 38, 14);
		panel.add(lblAnio);
		
		txtanio = new JTextField();
		txtanio.setColumns(10);
		txtanio.setBounds(49, 187, 74, 20);
		panel.add(txtanio);
	}
}