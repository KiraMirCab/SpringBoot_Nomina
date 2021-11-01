package es.hiessoterohernandez.nominas.servicio;

import java.util.ArrayList;
import java.util.Iterator;
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
	public Empleado listarDNI(String dni) {
		List<Empleado> empleados = listar();
		for (Empleado empleado : empleados) {
			if (empleado.getDni().equalsIgnoreCase(dni)) return empleado; 
		}
		return null;
	}

	@Override
	public List<Empleado> listarNombre(String nombre) {
		List<Empleado> todosEmpleados = listar();
		List<Empleado> empleados = new ArrayList<Empleado>();
		for (Empleado empleado : todosEmpleados) {
			if (empleado.getNombre().equalsIgnoreCase(nombre)) empleados.add(empleado); 
		}
		return empleados;
	}

	@Override
	public int save(Empleado e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
