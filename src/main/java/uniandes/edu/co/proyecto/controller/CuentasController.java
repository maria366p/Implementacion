package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioEmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
@Controller
public class CuentasController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model, @RequestParam(required = false) Integer IDGERENTE) {
        if (IDGERENTE != null) {
            model.addAttribute("cuentas", cuentaRepository.darCuentasIDGer(IDGERENTE));
        } else {
            // Agrega un mensaje de error al modelo que será mostrado en la vista
            model.addAttribute("error", "No se pueden mostrar las cuentas sin poner tu ID de GERENTE.");
        }

        return "cuentas";
    }


    

     @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("clientes", clienteRepository.darClientes());
        model.addAttribute("gerentes", usuarioEmpleadoRepository.darPersdeGerenteO());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getTIPOCUENTA().name(), cuenta.getSALDO(), cuenta.getFECHAULTIMATRANSACCION(), cuenta.getIDCLIENTE().getIDCLIENTE(), cuenta.getESTADOCUENTA().name(), cuenta.getIDGERENTE());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/cuentas/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") int id, Model model, @RequestParam("estado") String estado) {
        Cuenta cuenta = cuentaRepository.darCuenta(id);
        model.addAttribute("estado", estado);
    
        if (cuenta == null) {
            model.addAttribute("error", "La cuenta especificada no existe.");
            return "redirect:/cuentas";
        } 
            
        model.addAttribute("cuenta", cuenta);

    
        return "cuentaEditar";
    }
    
    


    @PostMapping("/cuentas/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cuenta cuenta, @RequestParam("estadoOriginal")  String estado, @RequestParam("ESTADOCUENTA") String estadoNuevo) {  
        int saldo = cuentaRepository.darSaldo(id);
        System.out.println("Estado recibido: " + estado);
        System.out.println("Saldo actual: " + saldo);
        System.out.println("Nuevo estado: " + estadoNuevo);
        if (saldo == 0 && estado.equals("Activa") && estadoNuevo.equals("Cerrada")){
            cuentaRepository.actualizarCuentaP(((int) id),  cuenta.getSALDO(), cuenta.getESTADOCUENTA().name());
            return "redirect:/cuentas";
        }
        else if (estado.equals("Activa") && estadoNuevo.equals("Desactivada") ){
            cuentaRepository.actualizarCuentaP(((int) id),  cuenta.getSALDO(), cuenta.getESTADOCUENTA().name());
            return "redirect:/cuentas";
        }

        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/cuentas/{id}/delete")
    public String cuentaEliminar(@PathVariable("id") int id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
}
