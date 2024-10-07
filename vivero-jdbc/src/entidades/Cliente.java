package entidades;

public class Cliente {
	private int id_cliente;
	private int codigo_cliente;
	private String nombre_cliente;
	private String nombre_contacto;
	private String apellido_contacto;
	private String telefono;
	private String fax;
	private String ciudad;
	private String region;
	private String pais;
	private String codigo_postal;
	private int id_empleado;
	private double limite_credito;

	public Cliente(int id_cliente, int codigo_cliente, String nombre_cliente, String nombre_contacto,
			String apellido_contacto, String telefono, String fax, String ciudad, String region, String pais,
			String codigo_postal, int id_empleado, double limite_credito) {
		this.id_cliente = id_cliente;
		this.codigo_cliente = codigo_cliente;
		this.nombre_cliente = nombre_cliente;
		this.nombre_contacto = nombre_contacto;
		this.apellido_contacto = apellido_contacto;
		this.telefono = telefono;
		this.fax = fax;
		this.ciudad = ciudad;
		this.region = region;
		this.pais = pais;
		this.codigo_postal = codigo_postal;
		this.id_empleado = id_empleado;
		this.limite_credito = limite_credito;
	}

	// Sin usar el id_cliente
	public Cliente(int codigo_cliente, String nombre_cliente, String nombre_contacto, String apellido_contacto,
			String telefono, String fax, String ciudad, String region, String pais, String codigo_postal,
			int id_empleado, double limite_credito) {
		this.codigo_cliente = codigo_cliente;
		this.nombre_cliente = nombre_cliente;
		this.nombre_contacto = nombre_contacto;
		this.apellido_contacto = apellido_contacto;
		this.telefono = telefono;
		this.fax = fax;
		this.ciudad = ciudad;
		this.region = region;
		this.pais = pais;
		this.codigo_postal = codigo_postal;
		this.id_empleado = id_empleado;
		this.limite_credito = limite_credito;
	}

	// Sin usar los atributos
	public Cliente() {
	}

	// Getters and setters
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getApellido_contacto() {
		return apellido_contacto;
	}

	public void setApellido_contacto(String apellido_contacto) {
		this.apellido_contacto = apellido_contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public double getLimite_credito() {
		return limite_credito;
	}

	public void setLimite_credito(double limite_credito) {
		this.limite_credito = limite_credito;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", codigo_cliente=" + codigo_cliente + ", nombre_cliente="
				+ nombre_cliente + ", nombre_contacto=" + nombre_contacto + ", apellido_contacto=" + apellido_contacto
				+ ", telefono=" + telefono + ", fax=" + fax + ", ciudad=" + ciudad + ", region=" + region + ", pais="
				+ pais + ", codigo_postal=" + codigo_postal + ", id_empleado=" + id_empleado + ", limite_credito="
				+ limite_credito + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
