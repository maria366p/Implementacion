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
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.repositorio.IdentificacionRepository;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;

@Controller
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private IdentificacionRepository identificacionRepository;

    @GetMapping("/personas")
    public String personas (Model model){
        model.addAttribute("personas", personaRepository.darPersonas());
        return "personas";
    }

    @GetMapping("/personas/new")
    public String personaForm(Model model, @RequestParam String tipo) {
        // Añadir el tipo al modelo para que pueda ser utilizado en la vista
        model.addAttribute("persona", new Persona());
        model.addAttribute("identificaciones", identificacionRepository.darIdentificaciones());
        model.addAttribute("tipo", tipo);
        return "personaNuevo";
    }
    @PostMapping("/personas/new/save")
    public String personaGuardar(@ModelAttribute Persona persona, @RequestParam("DOCID") int DOCID, @RequestParam("tipo") String tipo) {
        System.out.println("DOCID recibido: " + DOCID);
        // Encuentra la entidad Identificacion usando el ID proporcionado por el formulario.
        Identificacion identificacion = identificacionRepository.darIdentificacion(DOCID);
        System.out.println("Identificacion encontrada: " + identificacion); // Verificar si se encontró
        
        if (identificacion != null) {
            // Si la identificación existe, entonces llama a insertarPersona con todos los datos.
            personaRepository.insertarPersona(
                persona.getNOMBRE(), 
                persona.getDATOSCONTACTO(), 
                persona.getDIRECCIONFISICA(), 
                persona.getDIRECCIONELECTRONICA(), 
                persona.getTELEFONO(), 
                persona.getCIUDAD(), 
                persona.getDEPARTAMENTO(), 
                persona.getCODIGOPOSTAL(), 
                persona.getFECHAREGISTRO(), 
                identificacion.getNUMERO()  // Usar el ID de la Identificacion encontrada
            );
        } else {
            // Mensaje de error.
        }
        
        // Redirigir basado en el tipo de acción
        if ("empleado".equals(tipo)) {
            return "redirect:/empleados/new";
        } else if ("cliente".equals(tipo)) {
            return "redirect:/clientes/new";
        } else {
            // Por defecto, en caso de un valor inesperado, redirigir a una página segura
            return "redirect:/";
    }
        
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
        personaRepository.actualizarPersona(((int) id), persona.getNOMBRE(), persona.getDATOSCONTACTO(), persona.getDIRECCIONFISICA(), persona.getDIRECCIONELECTRONICA(), persona.getTELEFONO(), persona.getCIUDAD(), persona.getDEPARTAMENTO(), persona.getCODIGOPOSTAL(), persona.getFECHAREGISTRO(), persona.getDOCID().getNUMERO());
        return "redirect:/personas";
    }

    @GetMapping("/personas/{id}/delete")
    public String personaEliminar(@PathVariable("id") int id) {
        personaRepository.eliminarPersona(id);
        return "redirect:/personas";
    }
}
