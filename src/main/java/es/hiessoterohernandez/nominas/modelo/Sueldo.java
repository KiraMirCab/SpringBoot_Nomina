package es.hiessoterohernandez.nominas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "sueldo")
public class Sueldo {
	
	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000,
			150000, 170000, 190000, 210000, 230000};
	
	@Id
	@Column(columnDefinition = "VARCHAR(9)", nullable = false, unique = true)
	@JoinColumn(foreignKey = @ForeignKey(name="empleado.dni"))
	private String dni;
	
	@Column(nullable = false)
	@Min(0)
	private int sueldo;
	
	public Sueldo() {
		super();
	}

	public Sueldo(Empleado emp) {
		super();
		this.dni = emp.getDni();
		int sueldoBase = SUELDO_BASE[emp.getCategoria()-1];
		this.sueldo = sueldoBase + 5000 * emp.getAnyos();
	}

	public String getDni() {
		return dni;
	}

	public int getSueldo() {
		return sueldo;
	}

	@Override
	public String toString() {
		return "Sueldo [dni=" + dni + ", sueldo=" + sueldo + "]";
	}
	
}
