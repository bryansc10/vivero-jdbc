package entidades;

import java.sql.Date;

public class Pedido {
	private int id_pedido;
	private int codigo_pedido;
	private Date fecha_pedido;
	private Date fecha_esperada;
	private Date fecha_entrega;
	private String estado;
	private String comentarios;
	private int id_cliente;
	
	public Pedido(int id_pedido, int codigo_pedido, Date fecha_pedido, Date fecha_esperada, Date fecha_entrega,
			String estado, String comentarios, int id_cliente) {
		this.id_pedido = id_pedido;
		this.codigo_pedido = codigo_pedido;
		this.fecha_pedido = fecha_pedido;
		this.fecha_esperada = fecha_esperada;
		this.fecha_entrega = fecha_entrega;
		this.estado = estado;
		this.comentarios = comentarios;
		this.id_cliente = id_cliente;
	}

	public Pedido(int codigo_pedido, Date fecha_pedido, Date fecha_esperada, Date fecha_entrega, String estado,
			String comentarios, int id_cliente) {
		this.codigo_pedido = codigo_pedido;
		this.fecha_pedido = fecha_pedido;
		this.fecha_esperada = fecha_esperada;
		this.fecha_entrega = fecha_entrega;
		this.estado = estado;
		this.comentarios = comentarios;
		this.id_cliente = id_cliente;
	}

	public Pedido() {
	}

	// Getters and setters
	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getCodigo_pedido() {
		return codigo_pedido;
	}

	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Date getFecha_esperada() {
		return fecha_esperada;
	}

	public void setFecha_esperada(Date fecha_esperada) {
		this.fecha_esperada = fecha_esperada;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", codigo_pedido=" + codigo_pedido + ", fecha_pedido=" + fecha_pedido
				+ ", fecha_esperada=" + fecha_esperada + ", fecha_entrega=" + fecha_entrega + ", estado=" + estado
				+ ", comentarios=" + comentarios + ", id_cliente=" + id_cliente + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
