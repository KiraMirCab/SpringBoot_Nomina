package es.hiessoterohernandez.nominas.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hiessoterohernandez.nominas.interfaceService.IEmpleadoService;
import es.hiessoterohernandez.nominas.modelo.Empleado;
import es.hiessoterohernandez.nominas.repositorio.IEmpleado;

@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	private IEmpleado data;
	
	@Override
	public List<Empleado> listar() {
		return (List<Empleado>) data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public Empleado listarDNI(String dni) {
		List<Empleado> empleados = listar();
		Empleado emp = new Empleado();
		for (Empleado empleado : empleados) {
			if (empleado.getDni().equalsIgnoreCase(dni)) emp = empleado; 
		}
		return emp;
	}

	@Override
	public List<Empleado> listarNombre(String nombre) {
		List<Empleado> todosEmpleados = listar();
		List<Empleado> empleados = new ArrayList<Empleado>();
		for (Empleado empleado : todosEmpleados) {
			if (empleado.getNombre().contains(nombre)) empleados.add(empleado); 
		}
		return empleados;
	}

	@Override
	public int save(Empleado e) {
		int res = 0;
		Empleado emp = data.save(e);
		if (!emp.equals(null)) res = 1;
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);		
	}


}
