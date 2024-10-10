package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Producto;

public class ProductoDAO extends DAO {

	public void eliminarProductoPorCodigo(int id_producto) throws Exception, SQLException {
		try {
			String sql = String.format("DELETE FROM producto WHERE id_producto = %d", id_producto);
			insertarModificarEliminarDataBase(sql);
			System.out.println("Se elimino el producto con id: " + id_producto);

		} catch (SQLException e) {
			System.out.println("Error al ingresar query.");
			throw e;

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void listarProductosConStockDebajo(int cantidad_en_stock) throws Exception {
		try {
			List<Producto> productos = new ArrayList<>();
			Producto producto = null;
			String sql = String.format("SELECT id_producto, codigo_producto, nombre, cantidad_en_stock FROM producto WHERE cantidad_en_stock < %d", (short)cantidad_en_stock);
			consultarDataBase(sql);
			
			if (resultSet.next()) {
				do {
					producto = new Producto();
					
					producto.setId_producto(resultSet.getInt("id_producto"));
					producto.setCodigo_producto(resultSet.getString("codigo_producto"));
					producto.setNombre(resultSet.getString("nombre"));
					producto.setCantidad_en_stock(resultSet.getShort("cantidad_en_stock"));
					
					productos.add(producto);
				} while (resultSet.next());
				
				System.out.println("Productos con stock por debajo de: " + cantidad_en_stock);
				System.out.printf("%-3s %-10s %-50s %-15s\n", "ID", "Código", "Nombre_Producto", "Cantidad_Stock");
				for (Producto pdto : productos) {
					System.out.printf("%-3d %-10s %-50s %-5d\n", pdto.getId_producto(), pdto.getCodigo_producto(), pdto.getNombre(), pdto.getCantidad_en_stock());
				}
				
			} else {
				System.out.println("-> No se encontraron productos por debajo de ese stock.");
			}
			
			desconectarDataBase();
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}
	
	public void listarProductosMenorPrecio(int cantidad_listar) throws SQLException, Exception {
		try {
			List<Producto> productos = new ArrayList<>();
			Producto producto = null;
			String sql = String.format("SELECT id_producto, codigo_producto, nombre, precio_venta FROM producto ORDER BY precio_venta ASC LIMIT %d", cantidad_listar);
			consultarDataBase(sql);
			
			if (resultSet.next()) {
				do {
					producto = new Producto();
					
					producto.setId_producto(resultSet.getInt("id_producto"));
					producto.setCodigo_producto(resultSet.getString("codigo_producto"));
					producto.setNombre(resultSet.getString("nombre"));
					producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
					
					productos.add(producto);
				} while (resultSet.next());
				
				System.out.printf("Los %d productos con los precios más bajos.\n", cantidad_listar);
				System.out.printf("%-3s %-10s %-50s %-15s\n", "ID", "Código", "Nombre_Producto", "Precio_venta");
				for (Producto pdto : productos) {
					System.out.printf("%-3d %-10s %-50s %-5.2f\n", pdto.getId_producto(), pdto.getCodigo_producto(), pdto.getNombre(), pdto.getPrecio_venta());
				}
				
			} else {
				System.out.println("-> Ingrese un valor diferente de 0.");
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
}
