package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.repositorio.OperacionPrestamoRepository;

@Controller
public class OperacionPrestamosController {
    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;

    @GetMapping("/operacionPrestamos")
    public String operacionPrestamos (Model model){
        model.addAttribute("operacionPrestamos", operacionPrestamoRepository.darOperacionPrestamos());
         return "operacionPrestamos";
    }

    @GetMapping("/operacionPrestamos/new")
    public String operacionPrestamoForm(Model model) {
        model.addAttribute("operacionPrestamo", new OperacionPrestamo());
        return "operacionPrestamoNuevo";
    }

    @PostMapping("/operacionPrestamos/new/save")
    public String operacionPrestamoGuardar(@ModelAttribute OperacionPrestamo operacionPrestamo) {
        operacionPrestamoRepository.insertarOperacionPrestamo(operacionPrestamo.getTipo().name(), operacionPrestamo.getMonto(), operacionPrestamo.getFecha(), operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getIDPUNTOATENCION().getIDPUNTOATENCION());
        return "redirect:/operacionPrestamos";
    }

    @GetMapping("/operacionPrestamos/{id}/edit")
    public String operacionPrestamoEditarForm(@PathVariable("id") int id, Model model) {
        OperacionPrestamo operacionPrestamo = operacionPrestamoRepository.darOperacionPrestamo(id);
        if (operacionPrestamo != null) {
            model.addAttribute("operacionPrestamo", operacionPrestamo);
            return "operacionPrestamoEditar";
        } else {
            return "redirect:/operacionPrestamos";
        }
    }

    @PostMapping("/operacionPrestamos/{id}/edit/save")
    public String operacionPrestamoEditarGuardar(@PathVariable("id") int id, @ModelAttribute OperacionPrestamo operacionPrestamo) {
        operacionPrestamoRepository.actualizarOperacionPrestamo(((int) id), operacionPrestamo.getTipo().name(), operacionPrestamo.getMonto(), operacionPrestamo.getFecha(), operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getIDPUNTOATENCION().getIDPUNTOATENCION());
        return "redirect:/operacionPrestamos";
    }

    @GetMapping("/operacionPrestamos/{id}/delete")
    public String operacionPrestamoEliminar(@PathVariable("id") int id) {
        operacionPrestamoRepository.eliminarOperacionPrestamo(id);
        return "redirect:/operacionPrestamos";
    }
}
