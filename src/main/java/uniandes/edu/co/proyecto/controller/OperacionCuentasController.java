package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

@Controller
public class OperacionCuentasController {
    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/operacionCuentas")
    public String operacionCuentas (Model model){
        model.addAttribute("operacionCuentas", operacionCuentaRepository.darOperacionCuentas());
         return model.toString() ; //return "operacionCuentas";
    }

    @GetMapping("/operacionCuentas/new")
    public String operacionCuentaForm(Model model) {
        model.addAttribute("opCu", new OperacionCuenta());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntoAtencions());
        return "operacionCuentaNuevo";
    }

    @PostMapping("/operacionCuentas/new/save")
    public String operacionCuentaGuardar(@ModelAttribute OperacionCuenta operacionCuenta) {
        operacionCuentaRepository.insertarOperacionCuenta(operacionCuenta.getTIPOOC().name(),  operacionCuenta.getMONTO(), operacionCuenta.getFECHA(), operacionCuenta.getIDCUENTA().getIDCUENTA(), operacionCuenta.getIDPUNTOATENCION().getIDPUNTOATENCION());
       //TODO:Actualizar el saldo de la cuenta creando un query en el cuentaRepository que haga update del saldo, llamar el saldo del html de este par ahacer el update
       
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/operacionCuentas/{id}/edit")
    public String operacionCuentaEditarForm(@PathVariable("id") int id, Model model) {
        OperacionCuenta operacionCuenta = operacionCuentaRepository.darOperacionCuenta(id);
        if (operacionCuenta != null) {
            model.addAttribute("opCu", operacionCuenta);
            return "operacionCuentaEditar";
        } else {
            return "redirect:/operacionCuentas";
        }
    }

    @PostMapping("/operacionCuentas/{id}/edit/save")
    public String operacionCuentaEditarGuardar(@PathVariable("id") int id, @ModelAttribute OperacionCuenta operacionCuenta) {
        operacionCuentaRepository.actualizarOperacionCuenta(((int) id), operacionCuenta.getTIPOOC().name(),  operacionCuenta.getMONTO(), operacionCuenta.getFECHA(), operacionCuenta.getIDCUENTA().getIDCUENTA(), operacionCuenta.getIDPUNTOATENCION().getIDPUNTOATENCION());
        return "redirect:/operacionCuentas";
    }

    @GetMapping("/operacionCuentas/{id}/delete")
    public String operacionCuentaEliminar(@PathVariable("id") int id) {
        operacionCuentaRepository.eliminarOperacionCuenta(id);
        return "redirect:/operacionCuentas";
    }
}
