package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uniandes.edu.co.proyecto.modelo.PuntoAtencion;
import uniandes.edu.co.proyecto.modelo.TipoA;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

@Controller
public class PuntosAtencionController {
    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/puntosAtencion")
    public String puntosAtencion (Model model, String ciudad, String tipo){
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntoAtencions());
        return "puntosAtencion";
    }

    @GetMapping("/puntosAtencion/new")
    public String puntoAtencionForm(Model model) {
        model.addAttribute("puntoAtencion", new PuntoAtencion());
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "puntoAtencionNuevo";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String puntoAtencionGuardar(@ModelAttribute PuntoAtencion puntoAtencion, RedirectAttributes redirectAttributes) {
        // Verificar que TIPO no sea null antes de comparar.
        if (puntoAtencion.getTIPO() == null) {
            redirectAttributes.addFlashAttribute("error", "Debe seleccionar un tipo de punto de atención.");
            return "redirect:/puntosAtencion/new";
        }
    
        Integer idOficina = null; // Define idOficina como Integer para que pueda ser null.
        if (puntoAtencion.getTIPO().equals(TipoA.Digital)) {
            // Si el tipo es "Digital", se permite que idOficina sea null.
            idOficina = null;
        } else {
            // Si no es Digital, asegúrate de que una oficina haya sido seleccionada.
            if (puntoAtencion.getIDOFICINA() == null || puntoAtencion.getIDOFICINA().getIDOFICINA() == null) {
                redirectAttributes.addFlashAttribute("error", "Debe seleccionar una oficina para tipos de punto de atención no digitales.");
                return "redirect:/puntosAtencion/new";
            }
            idOficina = puntoAtencion.getIDOFICINA().getIDOFICINA();
        }
    
        puntoAtencionRepository.insertarPuntoAtencion(
            puntoAtencion.getTIPO().name(),
            puntoAtencion.getUBICACIONGEOGRAFICA(),
            puntoAtencion.getESTADO(),
            idOficina
        );
        return "redirect:/puntosAtencion";
    }
    
    
    

    @GetMapping("/puntosAtencion/{id}/edit")
    public String puntoAtencionEditarForm(@PathVariable("id") int id, Model model) {
        PuntoAtencion puntoAtencion = puntoAtencionRepository.darPuntoAtencion(id);
        if (puntoAtencion != null) {
            model.addAttribute("puntoAtencion", puntoAtencion);
            return "puntoAtencionEditar";
        } else {
            return "redirect:/puntosAtencion";
        }
    }

    @PostMapping("/puntosAtencion/{id}/edit/save")
    public String puntoAtencionEditarGuardar(@PathVariable("id") int id, @ModelAttribute PuntoAtencion puntoAtencion) {
        puntoAtencionRepository.actualizarPuntoAtencion(((int) id), puntoAtencion.getTIPO().name(), puntoAtencion.getUBICACIONGEOGRAFICA(), puntoAtencion.getESTADO(), puntoAtencion.getIDOFICINA().getIDOFICINA());
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{id}/delete")
    public String puntoAtencionEliminar(@PathVariable("id") int id) {
        Integer puntoOC = null;
        Integer puntoOP = null;
        puntoOC = puntoAtencionRepository.darPuntosOC(id);
        puntoOP = puntoAtencionRepository.darPuntosOP(id);
        if (puntoOC == null || puntoOP == null){
            puntoAtencionRepository.eliminarPuntoAtencion(id);
        }

        

        return "redirect:/puntosAtencion";
    }
}
