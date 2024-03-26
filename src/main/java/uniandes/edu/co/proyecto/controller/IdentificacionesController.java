package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Identificacion;
import uniandes.edu.co.proyecto.repositorio.IdentificacionRepository;

@Controller
public class IdentificacionesController {
    @Autowired
    private IdentificacionRepository identificacionRepository;

    @GetMapping("/identificaciones")
    public String identificaciones (Model model){
        model.addAttribute("identificaciones", identificacionRepository.darIdentificaciones());
        return "identificaciones";
    }

     @GetMapping("/identificaciones/new")
    public String identificacionForm(Model model) {
        model.addAttribute("identificacion", new Identificacion());
        return "identificacionNuevo";
    }

    @PostMapping("/identificaciones/new/save")
    public String identificacionGuardar(@ModelAttribute Identificacion identificacion) {
        identificacionRepository.insertarIdentificacion(identificacion.getNumero(), identificacion.getTipo());
        return "redirect:/identificaciones";
    }

    @GetMapping("/identificaciones/{id}/edit")
    public String identificacionEditarForm(@PathVariable("id") int id, Model model) {
        Identificacion identificacion = identificacionRepository.darIdentificacion(id);
        if (identificacion != null) {
            model.addAttribute("identificacion", identificacion);
            return "identificacionEditar";
        } else {
            return "redirect:/identificaciones";
        }
    }

    @PostMapping("/identificaciones/{id}/edit/save")
    public String identificacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Identificacion identificacion) {
        identificacionRepository.actualizarIdentificacion(((int) id), identificacion.getTipo());
        return "redirect:/identificaciones";
    }

    @GetMapping("/identificaciones/{id}/delete")
    public String identificacionEliminar(@PathVariable("id") int id) {
        identificacionRepository.eliminarIdentificacion(id);
        return "redirect:/identificaciones";
    }
}
