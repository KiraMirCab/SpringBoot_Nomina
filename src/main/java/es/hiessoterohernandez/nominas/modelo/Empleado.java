package es.hiessoterohernandez.nominas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "empleado")
public class Empleado{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false, unique = true)
	private String dni;
	
	@Column(columnDefinition = "CHAR(1) CHECK (sexo in ('H', 'M'))")
	private char sexo;
	
	@Column(nullable = false)
	@Min(1)
	@Max(10)
	private int categoria;
	
	@Column(nullable = false)
	@Min(0)
	private int anyos;

	public Empleado() {
		super();
	}

	public Empleado(int id, String dni, String nombre, char sexo, int categoria, int anyos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}
}


