package persistencia;

public class ProductoDAO extends DAO {
	
	public void eliminarProductoPorCodigo(int id_producto) throws Exception {
		try {
			String sql = String.format("DELETE FROM producto WHERE id = %d", id_producto);
			insertarModificarEliminarDataBase(sql);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
