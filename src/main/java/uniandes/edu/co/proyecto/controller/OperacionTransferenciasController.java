package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.OperacionTransferencia;
import uniandes.edu.co.proyecto.repositorio.OperacionTransferenciaRepository;

@Controller
public class OperacionTransferenciasController {
    @Autowired
    private OperacionTransferenciaRepository operacionTransferenciaRepository;

    @GetMapping("/operacionTransferencias")
    public String operacionTransferencias (Model model){
        model.addAttribute("operacionTransferencias", operacionTransferenciaRepository.darOperacionTransferencias());
         return "operacionTransferencias";
    }

    @GetMapping("/operacionTransferencias/new")
    public String operacionTransferenciaForm(Model model) {
        model.addAttribute("operacionTransferencia", new OperacionTransferencia());
        return "operacionTransferenciaNuevo";
    }

    @PostMapping("/operacionTransferencias/new/save")
    public String operacionTransferenciaGuardar(@ModelAttribute OperacionTransferencia operacionTransferencia) {
        operacionTransferenciaRepository.insertarOperacionTransferencia(operacionTransferencia.getMonto(), operacionTransferencia.getFecha(), operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), operacionTransferencia.getIDPUNTOATENCION().getIdPuntoAtencion());
        return "redirect:/operacionTransferencias";
    }

    @GetMapping("/operacionTransferencias/{id}/edit")
    public String operacionTransferenciaEditarForm(@PathVariable("id") int id, Model model) {
        OperacionTransferencia operacionTransferencia = operacionTransferenciaRepository.darOperacionTransferencia(id);
        if (operacionTransferencia != null) {
            model.addAttribute("operacionTransferencia", operacionTransferencia);
            return "operacionTransferenciaEditar";
        } else {
            return "redirect:/operacionTransferencias";
        }
    }

    @PostMapping("/operacionTransferencias/{id}/edit/save")
    public String operacionTransferenciaEditarGuardar(@PathVariable("id") int id, @ModelAttribute OperacionTransferencia operacionTransferencia) {
        operacionTransferenciaRepository.actualizarOperacionTransferencia(((int) id), operacionTransferencia.getMonto(), operacionTransferencia.getFecha(), operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), operacionTransferencia.getIDPUNTOATENCION().getIdPuntoAtencion());
        return "redirect:/operacionTransferencias";
    }

    @GetMapping("/operacionTransferencias/{id}/delete")
    public String operacionTransferenciaEliminar(@PathVariable("id") int id) {
        operacionTransferenciaRepository.eliminarOperacionTransferencia(id);
        return "redirect:/operacionTransferencias";
    }
}
