package Controlador;

import Modelo.Producto;
import java.util.List;
import java.util.ArrayList;

public class ControCarrito {
	private static double acumulador = 0;
	private List<Producto> Carrito;
	private Contro contro;
	private Producto prod;

	public ControCarrito() {

		contro = new Contro();
		prod = new Producto();
		Carrito = new ArrayList<>();

	}

	public void agregarCarrito(String ID, int cantProd) {
		for (int i = 0; i < contro.getInventario().size(); i++) {
			if (contro.getInventario().get(i).getID().equals(ID)) {
				Carrito.add(contro.getInventario().get(i));
				prod.setRetirarProd(cantProd);
				contro.getInventario().get(i).setCantidadRet(cantProd);
			}
		}
	}

	public void revisarCarrito() {
		for (Producto ProductoAct : Carrito) {
			System.out.println(
					"Nombre: " + ProductoAct.getNombre() + " Cantidad seleccionada: " + ProductoAct.getCantidadRet());
		}
	}

	public void obtenerCuenta() {
		for (Producto ProductoAct : Carrito) {
			acumulador += (ProductoAct.getPrecio() * ProductoAct.getCantidadRet());
		}
		System.out.println("La cuenta total es:" + acumulador);

	}

	public List<Producto> getCarrito() {
		return Carrito;
	}

	public void setCarrito(List<Producto> carrito) {
		Carrito = carrito;
	}

}
