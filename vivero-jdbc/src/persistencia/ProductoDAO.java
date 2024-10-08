package persistencia;

import java.sql.SQLException;

public class ProductoDAO extends DAO {

	public void eliminarProductoPorCodigo(int id_producto) throws Exception, SQLException {
		try {
			String sql = String.format("DELETE FROM producto WHERE id_producto = %d", id_producto);
			insertarModificarEliminarDataBase(sql);
			System.out.println("Se elimino el producto con id: "+id_producto);
			
		} catch (SQLException e) {
			System.out.println("Error al ingresar query.");
			throw e;

		} catch (Exception e) {
			throw e;
		}
	}
}
