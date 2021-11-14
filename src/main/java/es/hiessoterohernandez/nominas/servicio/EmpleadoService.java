package es.hiessoterohernandez.nominas.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hiessoterohernandez.nominas.interfaceService.IEmpleadoService;
import es.hiessoterohernandez.nominas.modelo.Empleado;
import es.hiessoterohernandez.nominas.modelo.Sueldo;
import es.hiessoterohernandez.nominas.repositorio.IEmpleado;
import es.hiessoterohernandez.nominas.repositorio.ISueldo;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleado data;
	@Autowired
	private ISueldo sueldo;

	@Override
	public ArrayList<Empleado> listar() {
		return (ArrayList<Empleado>) data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public Empleado listarDNI(String dni) {
		ArrayList<Empleado> empleados = listar();
		Empleado emp = new Empleado();
		for (Empleado empleado : empleados) {
			if (empleado.getDni().equalsIgnoreCase(dni))
				emp = empleado;
		}
		return emp;
	}

	@Override
	public ArrayList<Empleado> listarNombre(String nombre) {
		ArrayList<Empleado> todosEmpleados = listar();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		for (Empleado empleado : todosEmpleados) {
			if (empleado.getNombre().contains(nombre))
				empleados.add(empleado);
		}
		return empleados;
	}

	@Override
	public int save(Empleado e) {
		int res = 0;
		Empleado emp = data.save(e);
		Sueldo s = new Sueldo(emp);
		System.out.println(s);
		sueldo.save(s);
		Sueldo su = sueldo.save(s);
		if (!emp.equals(null) && !su.equals(null))
			res = 1;
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

	@Override
	public int salario(String dni) {
		ArrayList<Sueldo> salarios = (ArrayList<Sueldo>) sueldo.findAll();
		for (Sueldo salario : salarios) {
			if (salario.getDni().equalsIgnoreCase(dni))
				return salario.getSueldo();
		}
		return 0;
	}

}
