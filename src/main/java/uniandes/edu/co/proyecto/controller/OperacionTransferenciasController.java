package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import uniandes.edu.co.proyecto.modelo.OperacionTransferencia;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionTransferenciaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

@Controller
public class OperacionTransferenciasController {
    @Autowired
    private OperacionTransferenciaRepository operacionTransferenciaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/operacionTransferencias")
    public String operacionTransferencias (Model model){
        model.addAttribute("operacionTransferencias", operacionTransferenciaRepository.darOperacionTransferencias());
         return "operacionTransferencias";
    }

    @GetMapping("/operacionTransferencias/new")
    public String operacionTransferenciaForm(Model model) {
        model.addAttribute("opTran", new OperacionTransferencia());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntoAtencions());
        return "operacionTransferenciaNuevo";
    }

    @PostMapping("/operacionTransferencias/new/save")
    public String operacionTransferenciaGuardar(@ModelAttribute OperacionTransferencia operacionTransferencia, @RequestParam("MONTO") Float MONTO) {
        Float saldoO = operacionTransferencia.getIDCUENTAORIGEN().getSALDO();
        String estadoO = operacionTransferencia.getIDCUENTAORIGEN().getESTADOCUENTA().name();
        String estadoD = operacionTransferencia.getIDCUENTADESTINO().getESTADOCUENTA().name();

        if (saldoO-MONTO>0 && estadoO.equals("Activa")&& estadoD.equals("Activa")){
            operacionTransferenciaRepository.insertarOperacionTransferencia(operacionTransferencia.getMONTO(), operacionTransferencia.getFECHA(), operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), operacionTransferencia.getIDPUNTOATENCION().getIDPUNTOATENCION());
            cuentaRepository.consignarSaldo(operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), MONTO);
            cuentaRepository.retirarSaldo(operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), MONTO);
        }
        
        return "redirect:/usuariosEmpleados";
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
        operacionTransferenciaRepository.actualizarOperacionTransferencia(((int) id), operacionTransferencia.getMONTO(), operacionTransferencia.getFECHA(), operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), operacionTransferencia.getIDPUNTOATENCION().getIDPUNTOATENCION());
        return "redirect:/operacionTransferencias";
    }

    @GetMapping("/operacionTransferencias/{id}/delete")
    public String operacionTransferenciaEliminar(@PathVariable("id") int id) {
        operacionTransferenciaRepository.eliminarOperacionTransferencia(id);
        return "redirect:/operacionTransferencias";
    }
}
