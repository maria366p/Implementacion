package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioEmpleadoRepository;
import uniandes.edu.co.proyecto.servicios.cuentasServicio;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
@Controller
public class CuentasController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private cuentasServicio cuentaServicio;

    @GetMapping("/cuentas")
    public String cuentas(Model model, @RequestParam(required = false) Integer IDEMP, @RequestParam String tipo, @RequestParam(required = false) Integer IDCLI,  @RequestParam(required = false) String TipoCF, 
    @RequestParam(required = false) Integer saldoMin, @RequestParam(required = false) Integer saldoMax,  @RequestParam(required = false)   Date fechaUltima,@RequestParam(required = false) Integer IDCLIN) {
        System.out.println("IDGERENTE"+IDEMP);
        System.out.println("TIPO" + tipo);
        System.out.println("IDCLIENTE" + IDCLI);
        System.out.println("FECHA" + fechaUltima);
        System.out.println("SALDOMIN" + saldoMin);
        System.out.println("SALDOMAX" + saldoMax);


        


        if (tipo.equals("gerenteOficina")) {
            if (IDEMP != null ){
                if(TipoCF == null || saldoMin==null || saldoMax==null  || fechaUltima==null){
                    model.addAttribute("cuentas", cuentaRepository.darCuentasIDGer(IDEMP));
                    model.addAttribute("IDEMP", IDEMP);
                    model.addAttribute("tipoA", tipo);
                }
                else{
                    model.addAttribute("clientes", clienteRepository.darClientes());
                    model.addAttribute("cuentas", cuentaRepository.darCuentasEF(IDEMP, TipoCF,saldoMin,saldoMax, fechaUltima));
                    
                }
                
                return "cuentasE";

            }
            else{
                // Agrega un mensaje de error al modelo que será mostrado en la vista
            model.addAttribute("error", "No se pueden mostrar las cuentas sin poner tu ID de GERENTE.");
            }
           
            
        } else if (tipo.equals("cliente") && IDCLI != null){
            if(TipoCF == null|| saldoMin==null || saldoMax==null  || fechaUltima==null){
                model.addAttribute("cuentas", cuentaRepository.darCuentasC(IDCLI));
                model.addAttribute("IDCLIA", IDCLI);
                model.addAttribute("tipoA", tipo);
            }
            else {
                model.addAttribute("cuentas", cuentaRepository.darCuentasCF( IDCLI, TipoCF, saldoMin, saldoMax, fechaUltima));
            }
            return "cuentasC";
        }
        else if(tipo.equals("gerenteGeneral")){
            if(TipoCF == null|| saldoMin==null || saldoMax==null|| fechaUltima==null || IDCLIN ==null){
                model.addAttribute("cuentas", cuentaRepository.darCuentas());
                model.addAttribute("IDEMP", IDEMP);
                model.addAttribute("tipoA", tipo);
            }
            else {
                model.addAttribute("clientes", clienteRepository.darClientes());
                model.addAttribute("cuentas", cuentaRepository.darCuentasCF(IDCLIN,TipoCF,saldoMin,saldoMax, fechaUltima));
            }
            return "cuentasE";
        }

        


        return "cuentasE";

        
    }

    @GetMapping("/cuentas/extracto")
    public String todasLasCuentas(Model model,
                                  @RequestParam(required = false) Integer idCuenta,
                                  @RequestParam(required = false)  Date fechaInicio,
                                  @RequestParam(required = false)  Date fechaFin) {
        System.out.println("IDCUENTA"+idCuenta);
        System.out.println("fechaInicio" + fechaInicio);
        System.out.println("fechaFin" + fechaFin);
        if (idCuenta != null && fechaInicio != null && fechaFin != null) {
            System.out.println("IDCUENTA"+idCuenta);
            System.out.println("fechaInicio" + fechaInicio);
            System.out.println("fechaFin" + fechaFin);
            model.addAttribute("idCuenta", idCuenta);
            model.addAttribute("saldoI", cuentaRepository.obtenerSaldoInicial(idCuenta, fechaInicio));
            model.addAttribute("Consignaciones", cuentaRepository.obtenerOperacionesConsignacionRetiro(idCuenta, fechaInicio, fechaFin));
            model.addAttribute("transferencias", cuentaRepository.obtenerOperacionesTransferencias(idCuenta, fechaInicio, fechaFin));
            model.addAttribute("saldoF", cuentaRepository.obtenerSaldoFinal(idCuenta));
        }


        return "extractoCuenta";
    }
    
    @GetMapping("cuentas/bloqueoS")
    public String consultarOperacionesC(Model model, RedirectAttributes redirectAttributes, @RequestParam(required = false) Integer idCuenta){
        int retryCount = 0; // Contador de reintentos
        while (true) {

            try{
                

                if (idCuenta != null) {
                    Calendar calendar = Calendar.getInstance();
                    Date fechaFin = new Date(calendar.getTime().getTime()); // Fecha actual como java.sql.Date
                
                    calendar.add(Calendar.DAY_OF_MONTH, -30); // Retrocede 30 días
                    Date fechaInicio = new Date(calendar.getTime().getTime()); // Fecha de inicio hace 30 días como java.sql.Date
                    System.out.println("IDCUENTA"+idCuenta);
                    System.out.println("fechaInicio" + fechaInicio);
                    System.out.println("fechaFin" + fechaFin);
                //indicar el id de la cuenta a consultar
                model.addAttribute("idCuenta", idCuenta);
                model.addAttribute("saldoI", cuentaRepository.obtenerSaldoInicial(idCuenta, fechaInicio));
                model.addAttribute("Consignaciones",cuentaServicio.consultarConsu(idCuenta, fechaInicio, fechaFin));
                model.addAttribute("transferencias",cuentaServicio.consultarTrans(idCuenta, fechaInicio, fechaFin));
                model.addAttribute("saldoF", cuentaRepository.obtenerSaldoFinal(idCuenta));
                }

                return "extractoCuenta2";
            }

            catch (Exception e){
                System.out.println("Intento " + (retryCount + 1) + ": " + e);
                System.err.println("Error durante la consulta de Cuentas: " + e.getMessage());
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo consultar las cuentas correctamente.");
                return "redirect:/usuariosEmpleados";
            }
        }
    }

    @GetMapping("cuentas/bloqueoR")
    public String consultarOperacionesR(Model model, RedirectAttributes redirectAttributes, @RequestParam(required = false) Integer idCuenta){
        int retryCount = 0; // Contador de reintentos
        while (true) {

            try{
                

                if (idCuenta != null) {
                    Calendar calendar = Calendar.getInstance();
                    Date fechaFin = new Date(calendar.getTime().getTime()); // Fecha actual como java.sql.Date
                
                    calendar.add(Calendar.DAY_OF_MONTH, -30); // Retrocede 30 días
                    Date fechaInicio = new Date(calendar.getTime().getTime()); // Fecha de inicio hace 30 días como java.sql.Date
                    System.out.println("IDCUENTA"+idCuenta);
                    System.out.println("fechaInicio" + fechaInicio);
                    System.out.println("fechaFin" + fechaFin);
                //indicar el id de la cuenta a consultar
                model.addAttribute("idCuenta", idCuenta);
                model.addAttribute("saldoI", cuentaRepository.obtenerSaldoInicial(idCuenta, fechaInicio));
                model.addAttribute("Consignaciones",cuentaServicio.consultarConsuR(idCuenta, fechaInicio, fechaFin));
                model.addAttribute("transferencias",cuentaServicio.consultarTransR(idCuenta, fechaInicio, fechaFin));
                model.addAttribute("saldoF", cuentaRepository.obtenerSaldoFinal(idCuenta));
                }

                return "extractoCuenta3";
            }

            catch (Exception e){
                System.out.println("Intento " + (retryCount + 1) + ": " + e);
                System.err.println("Error durante la consulta de Cuentas: " + e.getMessage());
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo consultar las cuentas correctamente.");
                return "redirect:/usuariosEmpleados";
            }
        }
    }
    
    

    

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("clientes", clienteRepository.darClientes());
        model.addAttribute("gerentes", usuarioEmpleadoRepository.darPersdeGerenteO());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta, @RequestParam("MONTO") Float MONTO) {
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
