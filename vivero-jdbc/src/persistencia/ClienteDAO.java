package persistencia;

import java.sql.SQLException;
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
			String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto, limite_credito FROM cliente";
			consultarDataBase(sql);
			
			while(resultSet.next()) {
				cliente = new Cliente();
				
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setNombre_contacto(resultSet.getString("nombre_contacto"));
				cliente.setApellido_contacto(resultSet.getString("apellido_contacto"));
				cliente.setLimite_credito(resultSet.getDouble("limite_credito"));
				
				clientes.add(cliente);
			}
			
			System.out.printf("%-3s %-20s %-20s %-15s\n", "ID", "Nombre", "Apellido", "Límite_credito");
			for (Cliente clt : clientes) {
				System.out.printf("%-3d %-20s %-20s %.2f\n", clt.getId_cliente(), clt.getNombre_contacto(), clt.getApellido_contacto(), clt.getLimite_credito());
			}
			
			desconectarDataBase();
			
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}
	
	public void buscarClientePorCodigo(int id_cliente) throws Exception {
		try {
			Cliente cliente = new Cliente();
			String sql = String.format("SELECT * FROM cliente WHERE id_cliente = %d", id_cliente);
			consultarDataBase(sql);
			
			if(resultSet.next()) {
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setCodigo_cliente(resultSet.getInt("codigo_cliente"));
				cliente.setNombre_cliente(resultSet.getString("nombre_cliente"));
				cliente.setNombre_contacto(resultSet.getString("nombre_contacto"));
				cliente.setApellido_contacto(resultSet.getString("apellido_contacto"));
				cliente.setTelefono(resultSet.getString("telefono"));
				cliente.setFax(resultSet.getString("fax"));
				cliente.setCiudad(resultSet.getString("ciudad"));
				cliente.setRegion(resultSet.getString("region"));
				cliente.setPais(resultSet.getString("pais"));
				cliente.setCodigo_postal(resultSet.getString("codigo_postal"));
				cliente.setId_empleado(resultSet.getInt("id_empleado"));
				cliente.setLimite_credito(resultSet.getDouble("limite_credito"));
				
				System.out.println(cliente.toString());
			} else {
				System.out.println("- ID de cliente no encontrado");
			}
			
			desconectarDataBase();
			
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}
	
	public void eliminarClientePorCodigo(int id_cliente) throws SQLException, Exception {
		try {
			String sql = String.format("DELETE FROM cliente WHERE id_cliente = %d", id_cliente);
			insertarModificarEliminarDataBase(sql);
			System.out.println("Se elimino el cliente con id: " + id_cliente);
			
		} catch (SQLException e) {
			System.out.println("Error al ingresar query.");
			desconectarDataBase();
			throw e;
			
		} catch (Exception e) {
			System.out.println("Error del método.");
			desconectarDataBase();
			throw e;
		}
	}
	
	public void buscarClientesAtendidosPorEmpleado(int id_empleado) throws Exception {
		try {
			Cliente cliente = null;
			List<Cliente> clientes = new ArrayList<>();
			String sql = String.format("SELECT id_cliente, nombre_contacto, apellido_contacto, id_empleado FROM cliente WHERE id_empleado = %d", id_empleado);
			consultarDataBase(sql);
			
			if (resultSet.next()) {
				do {
					cliente = new Cliente();
				
					cliente.setId_cliente(resultSet.getInt("id_cliente"));
					cliente.setNombre_contacto(resultSet.getString("nombre_contacto"));
					cliente.setApellido_contacto(resultSet.getString("apellido_contacto"));
					cliente.setId_empleado(resultSet.getInt("id_empleado"));
				
					clientes.add(cliente);
				} while (resultSet.next());
			
				System.out.println("Clientes atendidos por el empleado con id: " + id_empleado);
				System.out.printf("%-3s %-20s %-20s %-15s\n", "ID", "Nombre", "Apellido", "ID_Vendedor");
				for (Cliente clt : clientes) {
					System.out.printf("%-3d %-20s %-20s\n", clt.getId_cliente(), clt.getNombre_contacto(), clt.getApellido_contacto());
				}
				
			} else {
				System.out.println("- No se encontraron coincidencias.");
			}
			
			desconectarDataBase();
			
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}
	
	public void aumentarCreditoClientes(double cantidad_aumentar) throws Exception {
		try {
			String sql = String.format("UPDATE cliente SET limite_credito = limite_credito * %.2f", cantidad_aumentar);
			insertarModificarEliminarDataBase(sql);
			System.out.println("--> Se aplicaron los cambios.");
			
		} catch (Exception e) {
			e.printStackTrace();
			desconectarDataBase();
			throw e;
		}
	}
}
