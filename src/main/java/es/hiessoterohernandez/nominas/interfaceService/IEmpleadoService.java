package es.hiessoterohernandez.nominas.interfaceService;

import java.util.List;
import java.util.Optional;

import es.hiessoterohernandez.nominas.modelo.Empleado;

public interface IEmpleadoService {
	public List<Empleado> listar();
	public Optional<Empleado> listarDNI(String dni);
	public Optional<Empleado> listarNombre(String nombre);
	public int save(Empleado e);
	public void delete(int id);
}
