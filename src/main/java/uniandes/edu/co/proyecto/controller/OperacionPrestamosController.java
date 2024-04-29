package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.repositorio.OperacionPrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

@Controller
public class OperacionPrestamosController {
    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/operacionPrestamos")
    public String operacionPrestamos (Model model){
        model.addAttribute("operacionPrestamos", operacionPrestamoRepository.darOperacionPrestamos());
        return "operacionPrestamos";
    }

    @GetMapping("/operacionPrestamos/new")
    public String operacionPrestamoForm(Model model, @RequestParam("tipo") String tipo) {
        model.addAttribute("opPre", new OperacionPrestamo());
        model.addAttribute("tipo", tipo); // Pasar el tipo al modelo para que pueda ser utilizado en el formulario
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntoAtencions());
        if (tipo.equals("PagarCuota")){
            return "operacionPrestamoNC";
        }

        else if (tipo.equals("PagarCuotaExtraordinaria")){
            return "operacionPrestamoNE";
        }


        
        return "usuariosEmpleados";
    }

    @PostMapping("/operacionPrestamos/new/save")
    public String operacionPrestamoGuardar(@ModelAttribute OperacionPrestamo operacionPrestamo,@RequestParam("tipo") String tipo ) {
        System.out.println("TIPO recibido: " + tipo);
        System.out.println("IDPRESTAMO: " + operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO());
        System.out.println("MontoActualizar"+operacionPrestamo.getIDPRESTAMO().getVALORCUOTA());
        if (tipo.equals("PagarCuota") && operacionPrestamo.getIDPRESTAMO().getMONTO()-operacionPrestamo.getIDPRESTAMO().getVALORCUOTA()>0){
            prestamoRepository.actualizarMonto(operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getIDPRESTAMO().getVALORCUOTA() );
            operacionPrestamoRepository.insertarOperacionPrestamo(tipo, operacionPrestamo.getIDPRESTAMO().getVALORCUOTA(), operacionPrestamo.getFECHA(), operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getIDPUNTOATENCION().getIDPUNTOATENCION());
            
            return "redirect:/operacionPrestamos";
        }
        else if (tipo.equals("PagarCuotaExtraordinaria") && operacionPrestamo.getIDPRESTAMO().getMONTO()-operacionPrestamo.getMONTO()>0){
            prestamoRepository.actualizarMonto(operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getMONTO() );
            operacionPrestamoRepository.insertarOperacionPrestamo(tipo, operacionPrestamo.getMONTO(), operacionPrestamo.getFECHA(), operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getIDPUNTOATENCION().getIDPUNTOATENCION());
            return "redirect:/operacionPrestamos";
            
        }
       
        return "redirect:/usuariosEmpleados";
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
        operacionPrestamoRepository.actualizarOperacionPrestamo(((int) id), operacionPrestamo.getTIPO().name(), operacionPrestamo.getMONTO(), operacionPrestamo.getFECHA(), operacionPrestamo.getIDPRESTAMO().getIDPRESTAMO(),operacionPrestamo.getIDPUNTOATENCION().getIDPUNTOATENCION());
        return "redirect:/operacionPrestamos";
    }

    @GetMapping("/operacionPrestamos/{id}/delete")
    public String operacionPrestamoEliminar(@PathVariable("id") int id) {
        operacionPrestamoRepository.eliminarOperacionPrestamo(id);
        return "redirect:/operacionPrestamos";
    }
}
