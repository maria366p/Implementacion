package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repository.EmpleadoRepository;
import uniandes.edu.co.proyecto.model.Empleado;

@Controller
public class EmpleadosController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleados")
    public String getEmpleados(Model model) {
        List<Empleado> empleados = empleadoRepository.findAll();
        model.addAttribute("empleados", empleados);
        model.addAttribute("NewEmpleado",  new Empleado());
        return "empleados";
    }

    @PostMapping("/empleados/new/save")
    public String newEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoRepository.save(new Empleado(empleado.getTipoDni(), empleado.getDni(), empleado.getNombre(), empleado.getNacionalidad(), empleado.getDireccion(), empleado.getEmail(), empleado.getTelefono(), empleado.getCiudad(), empleado.getDepartamento(), empleado.getCodigoPostal(), empleado.getCargo()));
        return "redirect:/empleados";
    }
}
