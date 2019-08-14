package Modelo;

public class Producto {
	private String nombreProducto, ID;
	private double precio;
	private int cantidad, cantRet;
	public void setNombre(String nombre) {
		this.nombreProducto = nombre;
	}
	public void setID(String id) {
		this.ID = id;
	}
	public void setPrecio (Double precio) {
		if(precio>0) {
			this.precio = precio;	
		}else {
			System.out.println("Precio menor a 0");
		}
	}
	public void setCantidad(int cantidad) {
		if(cantidad>0) {
			this.cantidad = cantidad;

		}else {
			System.out.println("Cantidad menor a 0");
		}
	}
	public void setRetirarProd(int cantProd) {
		cantidad -=cantProd;
	}
	public void  setNuevaCantidad(int Nuevacantidad) {
		if(cantidad>0) {
			cantidad += Nuevacantidad;
		}else {
			System.out.println("La cantidad es menor a 0");
		}
	}
	public void setCantidadRet(int cantidadRet) {
		this.cantRet = cantidadRet;
	}
	public String getNombre() {
		return nombreProducto;
	}
	public String getID() {
		return ID;
	}
	public Double getPrecio() {
		return precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public int getCantidadRet() {
		return cantRet;
	}
	
	public String toString() {
		return   nombreProducto+"\t\t"  + ID+"\t\t"  +"$"+ precio +"\t\t"+  cantidad ;
	}
	
}
