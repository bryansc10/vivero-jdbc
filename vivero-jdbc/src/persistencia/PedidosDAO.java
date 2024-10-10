package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entidades.Pedido;

public class PedidosDAO extends DAO {

	public void listarPedidosCliente(int id_cliente) throws SQLException, Exception {
		try {
			Pedido pedido = null;
			List<Pedido> pedidos = new ArrayList<>();
			String sql = String.format(
					"SELECT id_pedido, codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado FROM pedido WHERE id_cliente = %d",
					id_cliente);
			consultarDataBase(sql);

			if (resultSet.next()) {
				do {
					pedido = new Pedido();

					pedido.setId_pedido(resultSet.getInt("id_pedido"));
					pedido.setCodigo_pedido(resultSet.getInt("codigo_pedido"));
					pedido.setFecha_pedido(resultSet.getDate("fecha_pedido"));
					pedido.setFecha_esperada(resultSet.getDate("fecha_esperada"));
					pedido.setFecha_entrega(resultSet.getDate("fecha_entrega"));
					pedido.setEstado(resultSet.getString("estado"));

					pedidos.add(pedido);
				} while (resultSet.next());

				System.out.println("Pedidos del cliente: " + id_cliente);
				System.out.printf("%-3s %-10s %-15s %-15s %-15s %-10s\n", "ID", "Cod_Pedido", "Fecha_pedido",
						"Fecha_esperada", "Fecha_entrega", "estado");
				for (Pedido ped : pedidos) {
					System.out.printf("%-3d %-10d %-15s %-15s %-15s %-10s\n", ped.getId_pedido(),
							ped.getCodigo_pedido(),
							ped.getFecha_pedido() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getFecha_esperada() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getFecha_entrega() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getEstado());
				}

			} else {
				System.out.println("No se encontraron resultados.");
			}

			desconectarDataBase();
		} catch (SQLException e) {
			System.out.println("Ingrese un valor valido.");
			desconectarDataBase();
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}

	public void listarPedidosPorEstado(String estado) throws Exception {
		try {
			Pedido pedido = null;
			List<Pedido> pedidos = new ArrayList<>();
			List<String> estados = Arrays.asList("Rechazado", "Entregado", "Pendiente");
			String sql = String.format(
					"SELECT id_pedido, codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, id_cliente FROM pedido WHERE estado = '%s'",
					estado);
			consultarDataBase(sql);

			if (resultSet.next() && estados.contains(estado)) {
				do {
					pedido = new Pedido();

					pedido.setId_pedido(resultSet.getInt("id_pedido"));
					pedido.setCodigo_pedido(resultSet.getInt("codigo_pedido"));
					pedido.setFecha_pedido(resultSet.getDate("fecha_pedido"));
					pedido.setFecha_esperada(resultSet.getDate("fecha_esperada"));
					pedido.setFecha_entrega(resultSet.getDate("fecha_entrega"));
					pedido.setId_cliente(resultSet.getInt("id_cliente"));

					pedidos.add(pedido);
				} while (resultSet.next());

				System.out.println("Pedidos en estado: " + estado);
				System.out.printf("%-3s %-10s %-15s %-15s %-15s %-10s\n", "ID", "Cod_Pedido", "Fecha_pedido",
						"Fecha_esperada", "Fecha_entrega", "Id_Cliente");
				for (Pedido ped : pedidos) {
					System.out.printf("%-3d %-10d %-15s %-15s %-15s %-10d\n", ped.getId_pedido(),
							ped.getCodigo_pedido(),
							ped.getFecha_pedido() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getFecha_esperada() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getFecha_entrega() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getId_cliente());
				}

			} else {
				System.out.println("No se encontraron resultados.");
				if (!estados.contains(estado))
					System.out.println("Estados válidos: 'Rechazado', 'Pendiente', 'Entregado'");
			}

			desconectarDataBase();
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}

	}

	public void listarPedidosPorIDProducto(int id_producto) throws Exception {
		try {
			Pedido pedido = null;
			List<Pedido> pedidos = new ArrayList<>();
			String sql = String.format(
					"SELECT p.id_pedido, codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, id_cliente "
							+ "FROM pedido p JOIN detalle_pedido dp ON p.id_pedido = dp.id_pedido "
							+ "WHERE id_producto = %d",
					id_producto);
			consultarDataBase(sql);

			if (resultSet.next()) {
				do {
					pedido = new Pedido();

					pedido.setId_pedido(resultSet.getInt("p.id_pedido"));
					pedido.setCodigo_pedido(resultSet.getInt("codigo_pedido"));
					pedido.setFecha_pedido(resultSet.getDate("fecha_pedido"));
					pedido.setFecha_esperada(resultSet.getDate("fecha_esperada"));
					pedido.setFecha_entrega(resultSet.getDate("fecha_entrega"));
					pedido.setId_cliente(resultSet.getInt("id_cliente"));

					pedidos.add(pedido);
				} while (resultSet.next());

				System.out.println("Pedidos del producto con id: " + id_producto);
				System.out.printf("%-3s %-10s %-15s %-15s %-15s %-10s\n", "ID", "Cod_Pedido", "Fecha_pedido",
						"Fecha_esperada", "Fecha_entrega", "Id_Cliente");
				for (Pedido ped : pedidos) {
					System.out.printf("%-3d %-10d %-15s %-15s %-15s %-10d\n", ped.getId_pedido(),
							ped.getCodigo_pedido(),
							ped.getFecha_pedido() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getFecha_esperada() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getFecha_entrega() == null ? "Sin registro" : ped.getFecha_esperada().toString(),
							ped.getId_cliente());
				}

			} else {
				System.out.println("No se encontraron resultados.");
			}

			desconectarDataBase();
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}

	}

}
