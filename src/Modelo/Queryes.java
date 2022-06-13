package Modelo;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Controlador.Vehiculo;

	public class Queryes {
		
		public static Connection getConnection(){
			  String URL ="jdbc:mysql://localhost/java_projectdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			  String User = "root";
			  String Pass = "19998399";
			  Connection conexion = null;
			  
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection(URL, User, Pass);
			} catch(ClassNotFoundException e){
		        e.printStackTrace();
			  } 
			catch (SQLException e) {
				e.printStackTrace();
			   } 
			return conexion;            
		}   
	   
		
		 public static int saveVehiculo(Vehiculo e){  
		        int status = 0;  
		        try{  
		            Connection con= Queryes.getConnection();  
		            PreparedStatement ps=con.prepareStatement("insert into Vehiculos (Marca, Modelo, Matricula, Año,"
		            		+ "Dueño_cedula, Fecha_entrada, Estado, Tipo_Vehiculo) values (?,?,?,?,?,?,?,?)");  
		            ps.setString(1,e.getMarca());  
		            ps.setString(2,e.getModelo()); 
		            ps.setString(3,e.getMatricula()); 
		            ps.setString(4,e.getAño());  
		            ps.setString(5,e.getDueño_cedula());  
		            ps.setString(6,e.getFecha_entrada());  
		            ps.setString(7,e.getEstado());  
		            ps.setString(8,e.getTipo_Vehiculo());  
		
		            status=ps.executeUpdate();  
		            con.close();  
		        }catch(SQLException e1){
		        	e1.printStackTrace();
		         }  
		        return status;
		    }  
	
		 
		 public static int updateVehiculoStatus(Vehiculo e){  
		        int status = 0;  
		        try{  
		            Connection con= Queryes.getConnection();  
		            PreparedStatement ps=con.prepareStatement("Update Vehiculos Set Fecha_salida=?, Estado=? where matricula=?");  
		            ps.setString(1,e.getFecha_salida());  
		            ps.setString(2,e.getEstado());
		            ps.setInt(3, Integer.parseInt(e.getMatricula()));
		            status = ps.executeUpdate();  
		            con.close();  
		        }catch(SQLException e1){
		        	e1.printStackTrace();
		          }  
		        return status;
		    }  
	
		 
		 
		 public static String [][] getAllVehiculos(){   
			 String [][]data = null;  
			 	try{  
		            Connection con = Queryes.getConnection();  
		            PreparedStatement ps =con.prepareStatement("select Marca, Modelo, Matricula, Año, Dueño_cedula,"
		            		+ " Fecha_entrada, Fecha_salida, Tipo_vehiculo, Estado from Vehiculos");  
		            ResultSet res = ps.executeQuery();  
		         	data = new String[8][20];
		         	int i = 0;
	         	
					while (res.next()) {
						String marca = res.getString("Marca");
						String modelo = res.getString("Modelo");
						int año = res.getInt("Año");
						int matricula = res.getInt("Matricula");
						int dueño_cedula = res.getInt("Dueño_cedula");
						String fecha_entrada = res.getString("Fecha_entrada");
						String fecha_salida = res.getString("Fecha_salida");
						String estado = res.getString("Estado");
						data[i][0] = marca;
						data[i][1] = modelo;
						data[i][2] = año+"";
						data[i][3] = matricula+"";
						data[i][4] = dueño_cedula+"";
						data[i][5] = fecha_entrada;
						data[i][6] = fecha_salida;
						data[i][7] = estado;
						i++;
					}
		             con.close();  
		        }catch(Exception e){e.printStackTrace();}         
				return data;  
		    }  
	
	}