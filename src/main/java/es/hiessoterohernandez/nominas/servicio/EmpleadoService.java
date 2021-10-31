package es.hiessoterohernandez.nominas.servicio;

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
	public Optional<Empleado> listarDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Empleado> listarNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
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
