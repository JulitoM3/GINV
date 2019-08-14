package Controlador;
import Modelo.Producto;
import java.util.List;
import java.util.ArrayList;

public class ControCarrito {
	public static double  acumulador = 0 ;
	public static List<Producto>Carrito = new ArrayList<>();
	public static Contro controIn = new Contro();
	public static Producto prod = new Producto ();
	
	public static void agregarCarrito(String ID,int cantProd) {
		for(int i = 0; i<controIn.inventario.size(); i++) {
			if(controIn.inventario.get(i).getID().equals(ID)) {
				Carrito.add(controIn.inventario.get(i));
				prod.setRetirarProd(cantProd);
				controIn.inventario.get(i).setCantidadRet(cantProd);
			}
		}
	}
	
	public static void revisarCarrito() {
		for(Producto ProductoAct : Carrito) {
			System.out.println("Nombre: " + ProductoAct.getNombre() + " Cantidad seleccionada: " + ProductoAct.getCantidadRet());
		}
	}
	
	public static void obtenerCuenta() {
		for(Producto ProductoAct : Carrito) {
			acumulador += (ProductoAct.getPrecio() * ProductoAct.getCantidadRet());
		}
		System.out.println("La cuenta total es:" + acumulador);
		
	}
}
