package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String identificacionForm(Model model, @RequestParam("tipo") String tipo) { 
        model.addAttribute("identificacion", new Identificacion());
        model.addAttribute("tipo", tipo); // Pasar el tipo al modelo para que pueda ser utilizado en el formulario
        return "identificacionNuevo";
    }

    @PostMapping("/identificaciones/new/save")
    public String identificacionGuardar(@ModelAttribute Identificacion identificacion, @RequestParam String tipo) {
        identificacionRepository.insertarIdentificacion(identificacion.getNUMERO(), identificacion.getTIPO());
        return "redirect:/personas/new?tipo=" + tipo;
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
        identificacionRepository.actualizarIdentificacion(((int) id), identificacion.getTIPO());
        return "redirect:/identificaciones";
    }

    @GetMapping("/identificaciones/{id}/delete")
    public String identificacionEliminar(@PathVariable("id") int id) {
        identificacionRepository.eliminarIdentificacion(id);
        return "redirect:/identificaciones";
    }
}
