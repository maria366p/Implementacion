package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
@Controller
public class CuentasController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cuentas")
    public String cuentas (Model model){
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "cuentas";
    }

     @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getTIPOCUENTA().name(), cuenta.getSALDO(), cuenta.getFECHAULTIMATRANSACCION(), cuenta.getIDCLIENTE().getIDCLIENTE(), cuenta.getESTADOCUENTA().name());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/cuentas/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") int id, Model model) {
        Cuenta cuenta = cuentaRepository.darCuenta(id);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";
        } else {
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cuenta cuenta) {
        cuentaRepository.actualizarCuenta(((int) id), cuenta.getTIPOCUENTA().name(), cuenta.getSALDO(), cuenta.getFECHAULTIMATRANSACCION(), cuenta.getIDCLIENTE().getIDCLIENTE(), cuenta.getESTADOCUENTA().name());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}/delete")
    public String cuentaEliminar(@PathVariable("id") int id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
}
