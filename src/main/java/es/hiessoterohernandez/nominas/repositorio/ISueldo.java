package es.hiessoterohernandez.nominas.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.hiessoterohernandez.nominas.modelo.Sueldo;

@Repository
public interface ISueldo extends CrudRepository<Sueldo, Integer> {

}
