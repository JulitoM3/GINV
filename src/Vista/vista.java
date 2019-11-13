package Vista;

import Controlador.*;
import Modelo.*;
import java.util.Scanner;

public class vista {
	public static void main(String[] args) {
		String nombreProducto, ID = null;
		double precio;
		int cantidad, op = 0, opV = 0, opG = 0;
		Producto prod = null;
		Contro Inventario = new Contro();
		ControCarrito carrito = new ControCarrito();

		Scanner leerS = new Scanner(System.in);
		Scanner leerIn = new Scanner(System.in);
		Scanner leerDo = new Scanner(System.in);
		do {
			System.out.println("Bienvenido al gestor de inventarios");
			System.out.println("***************************************");
			System.out.println("* 1.- Control de almacen: \t      *\n" + "* 2.-Punto de venta\t              *");
			System.out.println("***************************************");
			opG = leerIn.nextInt();
			switch (opG) {
			case 1:
				do {
					System.out.println("***************************************");
					System.out.println("* 1.- Agregar productos al inventario *\n"
							+ "* 2.- Revisar inventario\t      *\n" + "* 3.- Editar inventario \t      *\n");
					System.out.println("***************************************");
					System.out.println("Ingresa la opción: ");
					op = leerIn.nextInt();
					switch (op) {
					case 1:
						prod = new Producto();
						System.out.println("Ingresa el Nombre: ");
						nombreProducto = leerS.nextLine().trim();
						prod.setNombre(nombreProducto);
						System.out.println("Ingresa el ID: ");
						ID = leerS.nextLine().trim();
						prod.setID(ID);
						System.out.println("Ingresa el precio unitario: ");
						precio = leerDo.nextDouble();
						prod.setPrecio(precio);
						System.out.println("Ingresa la cantidad: ");
						cantidad = leerIn.nextInt();
						prod.setCantidad(cantidad);
						Inventario.agregar(prod);
						break;
					case 2:
						if (Inventario.getInventario().size() > 0) {
							System.out.println("Producto:\t   ID:\t  precio:\t  cantidad:\t ");
							System.out.println("-----------------------------------------------------------");
							Inventario.imprimirInventario();
						}
						break;
					case 3:
						System.out.println("Para editar el inventario es necesario ingresar el ID del producto: ");
						ID = leerS.nextLine().trim();
						int pos = Inventario.buscarID(ID);
						if (pos >= 0) {
							System.out.println("Se encontró el ID, por favor ingrese el numero de elementos nuevos: ");
							int nuevaCantidad = leerIn.nextInt();
							Inventario.getInventario().get(pos).setNuevaCantidad(nuevaCantidad);
						} else {
							System.out.println("ID no existente o incorrecto");
						}
						System.out.println("Se modificó la cantidad correctamente!");
						break;
					default:
						System.out.println("Guardando cambios...");
					}
				} while (op != 6);
				break;
			case 2:
				do {
					System.out.println("Bienvenido al punto de venta...... Indica que deseas hacer:");
					System.out.println("***************************************");
					System.out.println("* 1.- Agregar productos al carrito    *\n"
							+ "* 2.- Revisar carrito\t              *\n" + "* 3.- Checkout \t                      *");
					System.out.println("***************************************");
					opV = leerIn.nextInt();
					switch (opV) {
					case 1:
						if (Inventario.getInventario().size() > 0) {
							System.out.println("Ingresa el ID del producto: ");
							ID = leerS.nextLine().trim();
							int posi = Inventario.buscarID(ID);
							if (posi >= 0) {
								System.out.println("Producto: " + Inventario.getInventario().get(posi).getNombre()
										+ "\n Existencias: " + Inventario.getInventario().get(posi).getCantidad());
								System.out.println("Ingresa la cantidad de productos a comprar: ");
								int cantProd = leerIn.nextInt();
								carrito.agregarCarrito(ID, cantProd);
							} else {
								System.out.println("ID incorrecto o inexistente");
							}
						} else {
							System.out.println("Inventario vacio!");
						}
						break;
					case 2:
						if (carrito.getCarrito().size() > 0) {
							carrito.revisarCarrito();
						} else {
							System.out.println("Carrito vacio!");
						}
						break;
					case 3:
						if (carrito.getCarrito().size() > 0) {
							carrito.obtenerCuenta();
						} else {
							System.out.println("Carrito vacio!");
						}
						break;
					}// fin switch opV

				} while (opV != -1);
				break;
			}
		} while (opV != 3);

		leerS.close();
		leerIn.close();
		leerDo.close();

	}
}
