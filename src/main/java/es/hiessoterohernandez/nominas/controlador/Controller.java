package es.hiessoterohernandez.nominas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/listarDNI")
	public String listarDNI(@RequestParam("dni") String dni, Model model) {
		Empleado emp = service.listarDNI(dni);
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(emp);
		model.addAttribute("empleados", empleados);
		return "lista";
	}
	
	@PostMapping("/listarNombre")
	public String listarNombre(@RequestParam("nombre") String nombre,Model model) {
		List<Empleado> empleados = service.listarNombre(nombre);
		model.addAttribute("empleados", empleados);
		return "lista";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Empleado e, Model model) {
		service.save(e);
		return "redirect:/listar";
	}
	
	
	@PostMapping("/editar")
	public String editar(@RequestParam("id") int id, Model model) {
		Optional<Empleado> empleado = service.listarId(id);
		model.addAttribute("empleado", empleado);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/buscar")
	public String buscar() {
		return "buscar";
	}
	
	@PostMapping("/verSalario")
	public String verSalario(@RequestParam("dni") String dni, Model model)  {
		int salario = service.salario(dni);
		model.addAttribute("dni", dni);
		model.addAttribute("salario", salario);
		return "salario";
	}
	
	@GetMapping("/buscarSalario")
	public String buscarSalario() {
		return "buscarSalario";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
