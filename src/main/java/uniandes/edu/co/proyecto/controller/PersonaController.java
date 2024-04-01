package uniandes.edu.co.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;

@Controller
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public String personas (Model model){
        model.addAttribute("personas", personaRepository.darPersonas());
         return model.toString() ; //return "personas";
    }

    @GetMapping("/personas/new")
    public String personaForm(Model model, HttpSession session) {
        model.addAttribute("persona", new Persona());
        session.setAttribute("formularioActual", "identificacion");  // Establecer el formulario actual
        return "personaNuevo";
    }

    @PostMapping("/personas/new/save")
    public String personaGuardar(@ModelAttribute Persona persona) {
        personaRepository.insertarPersona(persona.getNombre(), persona.getDatosContacto(), persona.getDireccionFisica(), persona.getDireccionElectronica(), persona.getTelefono(), persona.getCiudad(), persona.getDepartamento(), persona.getCodigoPostal(), persona.getFechaRegistro(), persona.getDocId().getNumero());
        return "redirect:/personas";
    }

    @GetMapping("/personas/{id}/edit")
    public String personaEditarForm(@PathVariable("id") int id, Model model) {
        Persona persona = personaRepository.darPersona(id);
        if (persona != null) {
            model.addAttribute("persona", persona);
            return "personaEditar";
        } else {
            return "redirect:/personas";
        }
    }

    @PostMapping("/personas/{id}/edit/save")
    public String personaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Persona persona) {
        personaRepository.actualizarPersona(((int) id), persona.getNombre(), persona.getDatosContacto(), persona.getDireccionFisica(), persona.getDireccionElectronica(), persona.getTelefono(), persona.getCiudad(), persona.getDepartamento(), persona.getCodigoPostal(), persona.getFechaRegistro(), persona.getDocId().getNumero());
        return "redirect:/personas";
    }

    @GetMapping("/personas/{id}/delete")
    public String personaEliminar(@PathVariable("id") int id) {
        personaRepository.eliminarPersona(id);
        return "redirect:/personas";
    }
}
