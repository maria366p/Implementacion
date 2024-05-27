package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.PuntoAtencion;
import uniandes.edu.co.proyecto.Repository.PuntoAtencionRepository;

@Controller
public class PuntosAtencionController {
    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/puntosAtencion")
    public String puntosAtencion (Model model){
        List<PuntoAtencion> puntos = puntoAtencionRepository.findAll();
        model.addAttribute("puntosAtencion", puntos);
        model.addAttribute("NewPuntoAtencion",  new PuntoAtencion());
        return "puntosAtencion";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String newPunto(@ModelAttribute("puntoAtencion") PuntoAtencion puntoAtencion) {
        puntoAtencionRepository.save(new PuntoAtencion(puntoAtencion.getTipo(), puntoAtencion.getLatitud(), puntoAtencion.getLongitud()));
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/delete/{id}")
    public String puntoAtencionEliminar(@PathVariable("id") ObjectId id) {
        puntoAtencionRepository.deleteById(id);
        return "redirect:/puntosAtencion";
    }
}
