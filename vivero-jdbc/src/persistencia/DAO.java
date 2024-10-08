package persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class DAO {
	protected Connection conexion = null;
	protected ResultSet resultSet = null;
	protected Statement statement = null;

	private final String HOST = obtenerCredenciales("config.host");
	private final String PORT = obtenerCredenciales("config.port");
	private final String USER = obtenerCredenciales("config.user");
	private final String PASSWORD = obtenerCredenciales("config.password");
	private final String DATABASE = obtenerCredenciales("config.database");
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";

	// Antes creamos un archivo config.properties y añadimos (EJ. config.user = tuNombreUsuarioBD) y así con el resto que necesitemos.
	private String obtenerCredenciales(String credencial) {
		Properties props = new Properties();
		try (FileInputStream input = new FileInputStream("config.properties")) {
			props.load(input);
			
		} catch (IOException e) {
			System.out.println("Error al cargar las credenciales de la base de datos: " + e.getMessage());
			return null;
		}
		return props.getProperty(credencial);
	}

	protected void connectarDataBase() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(DRIVER);
			String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
			conexion = DriverManager.getConnection(url, USER, PASSWORD);
			System.out.println("Conexión exitosa a la base de datos.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conexion != null) {
				conexion.close();
				System.out.println("Se cerro la base de datos exitosamente.");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	protected void insertarModificarEliminarDataBase(String sql) throws SQLException, ClassNotFoundException {
		try {
			connectarDataBase();
			statement = conexion.createStatement();
			statement.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;

		} finally {
			desconectarDataBase();
		}
	}

	protected void consultarDataBase(String sql) throws SQLException, ClassNotFoundException {
		try {
			connectarDataBase();
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
