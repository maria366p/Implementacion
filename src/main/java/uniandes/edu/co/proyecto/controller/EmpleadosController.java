package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cargo;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.repositorio.CargoRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;

@Controller
public class EmpleadosController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private OficinaRepository oficinaRepository;


    @GetMapping("/empleados")
    public String empleados (Model model){
        model.addAttribute("empleados", empleadoRepository.darEmpleados());
        return "empleados";
    }

    @GetMapping("/empleados/new")
    public String empleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("personas", personaRepository.darPersonas());
        model.addAttribute("cargos", cargoRepository.darCargos());
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "empleadoNuevo";
    }

    @PostMapping("/empleados/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado, @RequestParam("IDEMPLEADO") int IDEMPLEADO,  @RequestParam("IDCARGO") int IDCARGO, @RequestParam("IDOFICINA") int IDOFICINA ) {
        Persona persona = personaRepository.darPersona(IDEMPLEADO);
        Cargo cargo = cargoRepository.darCargo(IDCARGO);
        Oficina oficina = oficinaRepository.darOficina(IDOFICINA);
        empleadoRepository.insertarEmpleado(persona.ID(), cargo.getIDCARGO(), oficina.getIDOFICINA());
        return "redirect:/usuariosEmpleados/new";
    }

    @GetMapping("/empleados/{id}/edit")
    public String empleadoEditarForm(@PathVariable("id") int id, Model model) {
        Empleado empleado = empleadoRepository.darEmpleado(id);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";
        } else {
            return "redirect:/empleados";
        }
    }

    @PostMapping("/empleados/{id}/edit/save")
    public String empleadoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Empleado empleado) {
        empleadoRepository.actualizarEmpleado(id, empleado.getIDCARGO().getIDCARGO(), empleado.getIDOFICINA().getIDOFICINA());
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}/delete")
    public String empleadoEliminar(@PathVariable("id") int id) {
        empleadoRepository.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
