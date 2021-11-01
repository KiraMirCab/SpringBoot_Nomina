package es.hiessoterohernandez.nominas.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.hiessoterohernandez.nominas.interfaceService.IEmpleadoService;
import es.hiessoterohernandez.nominas.modelo.Empleado;


@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
	
	@Autowired
	private IEmpleadoService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Empleado> empleados = service.listar();
		model.addAttribute("empleados", empleados);
		return "lista";
	}
	
	@GetMapping("/listar/{dni}")
	public String listarDNI(@PathVariable String dni, Model model) {
		Empleado emp = service.listarDNI(dni);
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(emp);
		model.addAttribute("empleados", empleados);
		return "lista";
	}
	
	public String listarNombre(@PathVariable String nombre, Model model) {
		List<Empleado> empleados = service.listarNombre(nombre);
		model.addAttribute("empleados", empleados);
		return "lista";
	}
	
}
