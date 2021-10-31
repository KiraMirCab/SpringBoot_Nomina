package es.hiessoterohernandez.nominas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.hiessoterohernandez.nominas.interfaceService.IEmpleadoService;
import es.hiessoterohernandez.nominas.modelo.Empleado;


@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
	
	@Autowired
	private IEmpleadoService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Empleado> empleados = service.listar();
		model.addAttribute("empleados", empleados);
		return "index";
	}
}
