package es.hiessoterohernandez.nominas.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.hiessoterohernandez.nominas.modelo.Empleado;

@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer> {

}
