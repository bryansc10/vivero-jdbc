package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;

public class ClienteDAO extends DAO {
	
	public void guardarCliente(Cliente cliente) throws Exception {
		try {
			if (cliente == null) {
				System.out.println("El cliente no puede ser nulo.");
			}
			
			String sql = String.format("INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, "
		                                     + "telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito) "
		                                     + "VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %.2f)", 
		                                     cliente.getCodigo_cliente(),
		                                     cliente.getNombre_cliente(),
		                                     cliente.getNombre_contacto(),
		                                     cliente.getApellido_contacto(),
		                                     cliente.getTelefono(),
		                                     cliente.getFax(),
		                                     cliente.getCiudad(),
		                                     cliente.getRegion(),
		                                     cliente.getPais(),
		                                     cliente.getCodigo_postal(),
		                                     cliente.getId_empleado(),
		                                     cliente.getLimite_credito());
			
			insertarModificarEliminarDataBase(sql);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void listarTodosLosClientes() throws Exception {
		try {
			List<Cliente> clientes = new ArrayList<>();
			Cliente cliente = null;
			String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente";
			consultarDataBase(sql);
			
			while(resultSet.next()) {
				cliente = new Cliente();
				
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setNombre_contacto(resultSet.getString("nombre_contacto"));
				cliente.setApellido_contacto(resultSet.getString("apellido_contacto"));
				
				clientes.add(cliente);
			}
			
			System.out.printf("%-3s %-20s %-20s\n", "ID", "Nombre", "Apellido");
			for (Cliente clt : clientes) {
				System.out.printf("%-3d %-20s %-20s\n", clt.getId_cliente(), clt.getNombre_contacto(), clt.getApellido_contacto());
			}
			
			desconectarDataBase();
			
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}
}
