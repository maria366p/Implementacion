package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;

@Controller
public class OperacionCuentasController {
    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @GetMapping("/operacionCuentas")
    public String operacionCuentas (Model model){
        model.addAttribute("operacionCuentas", operacionCuentaRepository.darOperacionCuentas());
         return model.toString() ; //return "operacionCuentas";
    }

    @GetMapping("/operacionCuentas/new")
    public String operacionCuentaForm(Model model) {
        model.addAttribute("operacionCuenta", new OperacionCuenta());
        return "operacionCuentaNuevo";
    }

    @PostMapping("/operacionCuentas/new/save")
    public String operacionCuentaGuardar(@ModelAttribute OperacionCuenta operacionCuenta) {
        operacionCuentaRepository.insertarOperacionCuenta(operacionCuenta.getTipoOc().name(),  operacionCuenta.getMonto(), operacionCuenta.getFecha(), operacionCuenta.getIDCUENTA().getIDCUENTA(), operacionCuenta.getIDPUNTOATENCION().getIdPuntoAtencion());
        return "redirect:/operacionCuentas";
    }

    @GetMapping("/operacionCuentas/{id}/edit")
    public String operacionCuentaEditarForm(@PathVariable("id") int id, Model model) {
        OperacionCuenta operacionCuenta = operacionCuentaRepository.darOperacionCuenta(id);
        if (operacionCuenta != null) {
            model.addAttribute("operacionCuenta", operacionCuenta);
            return "operacionCuentaEditar";
        } else {
            return "redirect:/operacionCuentas";
        }
    }

    @PostMapping("/operacionCuentas/{id}/edit/save")
    public String operacionCuentaEditarGuardar(@PathVariable("id") int id, @ModelAttribute OperacionCuenta operacionCuenta) {
        operacionCuentaRepository.actualizarOperacionCuenta(((int) id), operacionCuenta.getTipoOc().name(),  operacionCuenta.getMonto(), operacionCuenta.getFecha(), operacionCuenta.getIDCUENTA().getIDCUENTA(), operacionCuenta.getIDPUNTOATENCION().getIdPuntoAtencion());
        return "redirect:/operacionCuentas";
    }

    @GetMapping("/operacionCuentas/{id}/delete")
    public String operacionCuentaEliminar(@PathVariable("id") int id) {
        operacionCuentaRepository.eliminarOperacionCuenta(id);
        return "redirect:/operacionCuentas";
    }
}
