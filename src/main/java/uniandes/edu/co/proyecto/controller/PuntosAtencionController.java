package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PuntoAtencion;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

public class PuntosAtencionController {
    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/puntosAtencion")
    public String puntosAtencion (Model model, String ciudad, String tipo){
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntoAtencions());
         return model.toString() ; //return "puntosAtencion";
    }

    @GetMapping("/puntosAtencion/new")
    public String puntoAtencionForm(Model model) {
        model.addAttribute("puntoAtencion", new PuntoAtencion());
        return "puntoAtencionNuevo";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String puntoAtencionGuardar(@ModelAttribute PuntoAtencion puntoAtencion) {
        puntoAtencionRepository.insertarPuntoAtencion(puntoAtencion.getTipo().name(), puntoAtencion.getUbicacionGeografica(), puntoAtencion.getEstado(), puntoAtencion.getIDOFICINA().getIdOficina());
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
        puntoAtencionRepository.actualizarPuntoAtencion(((int) id), puntoAtencion.getTipo().name(), puntoAtencion.getUbicacionGeografica(), puntoAtencion.getEstado(), puntoAtencion.getIDOFICINA().getIdOficina());
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{id}/delete")
    public String puntoAtencionEliminar(@PathVariable("id") int id) {
        puntoAtencionRepository.eliminarPuntoAtencion(id);
        return "redirect:/puntosAtencion";
    }
}
