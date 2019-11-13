package Controlador;

import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class Contro {
	private List<Producto> inventario = new ArrayList<>();

	// Metodo estatico que agrega un producto al inventario
	public void agregar(Producto p) {
		inventario.add(p);
	}

	// metodo estatico que edita un producto
	public void editarProducto(Producto p, int pos) {
		inventario.set(pos, p);
	}

	// Metodo estatico que elimina un producto del inventario
	public void eliminarProducto(int pos) {
		inventario.remove(pos);
	}

	// metodo estatico que imprime el inventario
	public void imprimirInventario() {
		for (int i = 0; i < inventario.size(); i++) {
			System.out.println(inventario.get(i));
		}
	}

	// metodo estatico que busca un proucto por su ID
	public int buscarID(String id) {
		int posi = -1;
		for (int i = 0; i < inventario.size(); i++) {
			if (inventario.get(i).getID().equals(id)) {
				posi = i;
			}
		}
		return posi;
	}

	public List<Producto> getInventario() {
		return inventario;
	}

	public void setInventario(List<Producto> inventario) {
		this.inventario = inventario;
	}

}
