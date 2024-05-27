package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Repository.ClienteRepository;
import uniandes.edu.co.proyecto.Repository.CuentaRepository;
import uniandes.edu.co.proyecto.Repository.PuntoAtencionRepository;
import uniandes.edu.co.proyecto.model.Cliente;
import uniandes.edu.co.proyecto.model.Cuenta;
import uniandes.edu.co.proyecto.model.Operacion;
import uniandes.edu.co.proyecto.model.PuntoAtencion;

@Controller
public class CuentasController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/cuentas")
    public String getCuentass(Model model) {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("NewCuenta",  new Cuenta());
        model.addAttribute("NewOperacion",  new Operacion());
        return "cuentas";
    }

    @GetMapping("/cuentas/getOperaciones")
    public String getOperaciones(@RequestParam("id") ObjectId id, Model model){
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);
        List<Cuenta> cuentas = cuentaRepository.findAll();
        if(cuentaOptional.isPresent()){
            Cuenta cuenta = cuentaOptional.get();
            List<Operacion> operaciones = cuenta.getOperaciones();
            model.addAttribute("operaciones", operaciones);
        }
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("NewCuenta",  new Cuenta());
        model.addAttribute("NewOperacion",  new Operacion());
        return "cuentas";
    }

    @PostMapping("/cuentas/new/operacion/save")
    public String newOperacion(@ModelAttribute("operacion") Operacion operacion, @RequestParam("cuenta") String cuentaId) {
        ObjectId cuObjectId = new ObjectId(cuentaId);
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(cuObjectId);
        Double saldo = cuentaOptional.get().getSaldo();
        
        LocalDate fechaActual = LocalDate.now();
        if(operacion.getTipo().equals("Transferir")){

            Double valorNuevo = saldo - operacion.getValor();
            cuentaRepository.registrarTransaccion(cuObjectId, operacion.getValor(), operacion.getTipo(), fechaActual, operacion.getPuntoAtencion(), operacion.getCuentaDestino());
            cuentaRepository.actualizarSaldo(cuObjectId, valorNuevo);
            
            ObjectId cuentaLlegada = new ObjectId(operacion.getCuentaDestino());
            Double saldoSalida = cuentaRepository.findSaldoById(cuentaLlegada).getSaldo();
            Double valorSalida = saldoSalida - operacion.getValor();
            cuentaRepository.actualizarSaldo(cuentaLlegada, valorSalida);
        }else if (operacion.getTipo().equals("retirar")){
            Double valor = saldo - operacion.getValor();
            cuentaRepository.registrarOperacion(cuObjectId, saldo, operacion.getTipo(), fechaActual, operacion.getPuntoAtencion());
            cuentaRepository.actualizarSaldo(cuObjectId, valor);
        }else{
            Double valor = saldo + operacion.getValor();
            cuentaRepository.registrarOperacion(cuObjectId, saldo, operacion.getTipo(), fechaActual, operacion.getPuntoAtencion());
            cuentaRepository.actualizarSaldo(cuObjectId, valor);
        }
        cuentaRepository.actualizarUltima(cuObjectId, fechaActual);
        return "redirect:/cuentas";
    }

    @PostMapping("/cuentas/new/save")
    public String newCuenta(@ModelAttribute("cuenta") Cuenta cuenta) {
        LocalDate fechaActual = LocalDate.now();
        Random rand = new Random();
        int numero = rand.nextInt(10000000);
        cuentaRepository.save(new Cuenta(numero, cuenta.getTipo(), cuenta.getSaldo(), "activa", fechaActual, cuenta.getCliente()));
        return "redirect:/cuentas";
    }

    @ModelAttribute("valores")
    public List<Cliente> obtenerValores() {
        return clienteRepository.findAll();
    }

    @GetMapping("/cuentas/cerrar/{id}")
    public String cerrarCuenta(@PathVariable("id") ObjectId id) {
        cuentaRepository.estadoCerrado(id, "cerrada");
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/desactivar/{id}")
    public String desactivarCuenta(@PathVariable("id") ObjectId id) {
        cuentaRepository.estadoCerrado(id, "desactivada");
        return "redirect:/cuentas";
    }

    @ModelAttribute("puntos")
    public List<PuntoAtencion> obtenerPuntos() {
        return puntoAtencionRepository.findAll();
    }
}
