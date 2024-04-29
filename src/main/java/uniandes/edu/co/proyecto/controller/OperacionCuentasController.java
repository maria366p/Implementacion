package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "operacionCuentas";
    }

    @GetMapping("/operacionCuentas/new")
    public String operacionCuentaForm(Model model) {
        model.addAttribute("opCu", new OperacionCuenta());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntoAtencions());
        return "operacionCuentaNuevo";
    }

    @PostMapping("/operacionCuentas/new/save")
    public String operacionCuentaGuardar(@ModelAttribute OperacionCuenta operacionCuenta, @RequestParam("MONTO") Float MONTO, @RequestParam("TIPOOC") String TIPOOC ) {
    
    System.out.println("Monto recibido operacion: " + MONTO);
    System.out.println("TIPOOC actual: " + TIPOOC);
    System.out.println("ID CUENTA recibido: " +  operacionCuenta.getIDCUENTA().getIDCUENTA());
    
   
    if (MONTO != null && TIPOOC != null){
        operacionCuentaRepository.insertarOperacionCuenta(operacionCuenta.getTIPOOC().name(),  operacionCuenta.getMONTO(), operacionCuenta.getFECHA(), operacionCuenta.getIDCUENTA().getIDCUENTA(), operacionCuenta.getIDPUNTOATENCION().getIDPUNTOATENCION());
        int saldoC = cuentaRepository.darSaldo(operacionCuenta.getIDCUENTA().getIDCUENTA());
        String estado = operacionCuenta.getIDCUENTA().getESTADOCUENTA().name();
        System.out.println("Saldo Cuenta Actual : " +  saldoC);
        boolean total = saldoC - MONTO > 0;
        System.out.println("TOTAL : " +  total);

        if (TIPOOC.equals("Consignar")&& estado.equals("Activa")){
            cuentaRepository.consignarSaldo(operacionCuenta.getIDCUENTA().getIDCUENTA(), MONTO);
            return "redirect:/usuariosEmpleados";
        }
        else if (TIPOOC.equals("Retirar") && saldoC - MONTO > 0 && estado.equals("Activa")){
            cuentaRepository.retirarSaldo(operacionCuenta.getIDCUENTA().getIDCUENTA(), MONTO);
            return "redirect:/usuariosEmpleados";
        }
        
    }
        return "index";
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
