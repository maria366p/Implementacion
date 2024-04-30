package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import uniandes.edu.co.proyecto.modelo.OperacionTransferencia;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionTransferenciaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;
import uniandes.edu.co.proyecto.servicios.cuentasServicio;
import uniandes.edu.co.proyecto.servicios.operacionTransferenciasServicio;

@Controller
public class OperacionTransferenciasController {
    @Autowired
    private OperacionTransferenciaRepository operacionTransferenciaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @Autowired
    private cuentasServicio cuentasServicio;

    @Autowired
    private operacionTransferenciasServicio operacionTransferenciasServicio;

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
    public String operacionTransferenciaGuardar(@ModelAttribute OperacionTransferencia operacionTransferencia, @RequestParam("MONTO") Float MONTO, RedirectAttributes redirectAttributes) {
        Float saldoO = operacionTransferencia.getIDCUENTAORIGEN().getSALDO();
        String estadoO = operacionTransferencia.getIDCUENTAORIGEN().getESTADOCUENTA().name();
        String estadoD = operacionTransferencia.getIDCUENTADESTINO().getESTADOCUENTA().name();

        if (saldoO-MONTO>0 && estadoO.equals("Activa")&& estadoD.equals("Activa")){

            try {
                operacionTransferenciasServicio.actualizar(operacionTransferencia.getMONTO(), operacionTransferencia.getFECHA(), operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), operacionTransferencia.getIDPUNTOATENCION().getIDPUNTOATENCION());
            } catch (InterruptedException e) {
                System.err.println("Error insertando la operacion transferencia: " + e.getMessage());
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo insertar la operacion transferencia (log).");
            }

            
            try {
                cuentasServicio.consignar(operacionTransferencia.getIDCUENTADESTINO().getIDCUENTA(), MONTO);
            } catch (InterruptedException e) {
                System.err.println("Error consignando a la cuenta: " + e.getMessage());
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar la consignacion de la cuenta.");
            }
            try {
                cuentasServicio.retirar(operacionTransferencia.getIDCUENTAORIGEN().getIDCUENTA(), MONTO);
            } catch (InterruptedException e) {
                System.err.println("Error retirando de la cuenta: " + e.getMessage());
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar el retiro de la cuenta.");
            }
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
