package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;

@Controller
public class PrestamosController {
    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/prestamos")
    public String prestamos (Model model, String ciudad, String tipo){
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo) {
        prestamoRepository.insertarPrestamo(prestamo.getMONTO(), prestamo.getINTERES(), prestamo.getNUMEROCUOTAS(), prestamo.getDIAPAGOCUOTA(), prestamo.getVALORCUOTA(), prestamo.getESTADOP().name(),prestamo.getIDCLIENTE().getIDCLIENTE());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("id") int id, Model model, @RequestParam("saldoActual") int saldoActual) {
        Prestamo prestamo = prestamoRepository.darPrestamo(id);
        model.addAttribute("saldoActual", saldoActual);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        } else {
            return "redirect:/prestamos";
        }
    }

    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Prestamo prestamo, @RequestParam("saldoActual")  int saldoActual) {
        
        System.out.println("Saldo Prestamo  recibido: " + saldoActual);
        if (saldoActual == 0){
            prestamoRepository.actualizarEstado(((int) id), prestamo.getESTADOP().name());
            return "redirect:/prestamos";
        }
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/prestamos/{id}/delete")
    public String prestamoEliminar(@PathVariable("id") int id) {
        prestamoRepository.eliminarPrestamo(id);
        return "redirect:/prestamos";
    }
}
