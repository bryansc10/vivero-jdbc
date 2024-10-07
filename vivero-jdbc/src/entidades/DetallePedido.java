package entidades;

public class DetallePedido {
	private int id_detalle_pedido;
	private int id_pedido;
	private int id_producto;
	private int cantidad;
	private double precio_unidad;
	private short numero_linea;
	
	public DetallePedido(int id_detalle_pedido, int id_pedido, int id_producto, int cantidad, double precio_unidad,
			short numero_linea) {
		this.id_detalle_pedido = id_detalle_pedido;
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unidad = precio_unidad;
		this.numero_linea = numero_linea;
	}

	public DetallePedido(int id_pedido, int id_producto, int cantidad, double precio_unidad, short numero_linea) {
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unidad = precio_unidad;
		this.numero_linea = numero_linea;
	}

	public DetallePedido() {
	}

	// Getters and setters
	public int getId_detalle_pedido() {
		return id_detalle_pedido;
	}

	public void setId_detalle_pedido(int id_detalle_pedido) {
		this.id_detalle_pedido = id_detalle_pedido;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public short getNumero_linea() {
		return numero_linea;
	}

	public void setNumero_linea(short numero_linea) {
		this.numero_linea = numero_linea;
	}

	@Override
	public String toString() {
		return "DetallePedido [id_detalle_pedido=" + id_detalle_pedido + ", id_pedido=" + id_pedido + ", id_producto="
				+ id_producto + ", cantidad=" + cantidad + ", precio_unidad=" + precio_unidad + ", numero_linea="
				+ numero_linea + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
