package Controlador;

public class Vehiculo {
 
		private int id;  
		private String marca, modelo, matricula, a�o, due�o_cedula, fecha_entrada, fecha_salida, estado, Tipo_Vehiculo;  
		
		public int getId() {  
		    return id;  
		}  
		public void setMarca(String marca) {  
		    this.marca = marca;  
		}  
		public String getMarca() {  
		    return marca;  
		}  
		public void setId(int id) {  
		    this.id = id;  
		}  
		public String getDue�o_cedula() {  
		    return due�o_cedula;  
		}  
		public void setDue�o_cedula(String due�o_cedula) {  
		    this.due�o_cedula = due�o_cedula;  
		}  
		public String getModelo() {  
		    return modelo;  
		}  
		public void setModelo(String modelo) {  
		    this.modelo = modelo;  
		}  
		public String getMatricula() {  
		    return matricula;  
		}  
		public void setMatricula(String matricula) {  
		    this.matricula = matricula;  
		}  
		public void setA�o(String a�o) {  
		    this.a�o = a�o;  
		}  
		public String getA�o() {  
		    return a�o;  
		}
		public String getFecha_entrada() {
			return fecha_entrada;
		}  	 
		public void setFecha_entrada(String fecha_entrada) {  
		    this.fecha_entrada = fecha_entrada;  
		}  
		public String getFecha_salida() {
			return fecha_salida;
		}  	 
		public void setFecha_salida (String fecha_salida) {  
		    this.fecha_salida = fecha_salida;  
		}  
		public String getEstado() {
			return estado;
		}  	 
		public void setEstado(String estado) {  
		    this.estado = estado;  
		}
		public String getTipo_Vehiculo() {
			return Tipo_Vehiculo;
		}  	 
		public void setTipo_Vehiculo(String Tipo_Vehiculo) {  
		    this.Tipo_Vehiculo = Tipo_Vehiculo;  
		}  
		
  }
