package com.testConexion.app;

import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.PedidosDAO;
import persistencia.ProductoDAO;

public class App {

	public static void main(String[] args) {
		// Crea una instancia de tu clase ClienteDao para poder acceder a los métodos de la clase.
		ClienteDAO pruebasClientes = new ClienteDAO();
		ProductoDAO pruebaProductos = new ProductoDAO();
		PedidosDAO pruebaPedidos = new PedidosDAO();
		
		//Inserta 2 registros a tu BBDD, utilizando el constructor que recibe parámetros (sin enviar el id_cliente)
		Cliente cliente1 = new Cliente(24, "Abel", "Abel", "Grow", "3432245", 
				"343434", "Loreto", "Iquitos", "Perú", "24006", 5, 4999);
		Cliente cliente2 = new Cliente(24, "María", "María", "Pérez", "987745", 
				"343434", "Lima Metropolitana", "Lima", "Perú", "24006", 7, 2349);
		
		try {
			//pruebasClientes.guardarCliente(cliente1);
			//pruebasClientes.guardarCliente(cliente2);
			
		} catch (Exception e) {
			System.out.println("No se guardo.");
		}
		
		//Invoca al método para verificar que recuperes la información de tu base de datos de manera correcta. 
		try {
			//pruebasClientes.listarTodosLosClientes();
			//pruebasClientes.buscarClientePorCodigo(2);
			//pruebasClientes.buscarClientesAtendidosPorEmpleado(12);
			//pruebasClientes.aumentarCreditoClientes(1.15);
			
			//pruebaProductos.listarProductosConStockDebajo(60);
			//pruebaProductos.listarProductosMenorPrecio(15);
			
			//pruebaPedidos.listarPedidosCliente(3);
			//pruebaPedidos.listarPedidosPorEstado("Pendiente");
			//pruebaPedidos.listarPedidosPorIDProducto(3);
			
		} catch (Exception e) {
			System.out.println("Error al listar.");
		}
		
		// Eliminar un registro
		try {
			//pruebaProductos.eliminarProductoPorCodigo(50);
			//pruebasClientes.eliminarClientePorCodigo(2);
		} catch (Exception e) {
			System.out.println("Error al eliminar.");
		}

	}

}
