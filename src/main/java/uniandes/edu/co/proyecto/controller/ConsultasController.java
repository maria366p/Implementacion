package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Repository.CuentaRepository;
import uniandes.edu.co.proyecto.model.Cuenta;
import uniandes.edu.co.proyecto.model.Operacion;

@Controller
public class ConsultasController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/consultas")
    public String consultas(Model model) {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        model.addAttribute("cuentas", cuentas);
        return "consultas";
    }
    
    @GetMapping("/consultas/tipo")
    public String obtenerCuentasPorTipo(Model model, @RequestParam("tipo") String tipo) {
        List<Cuenta> cuentas = cuentaRepository.findByTipo(tipo);
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("NewCuenta",  new Cuenta());
        model.addAttribute("NewOperacion",  new Operacion());
        return "consultas";
    }

    @GetMapping("/consultas/saldo")
    public String obtenerCuentasPorRangoDeSaldo(Model model, @RequestParam("saldoMin") Double saldoMin, @RequestParam("saldoMax") Double saldoMax) {
        List<Cuenta> cuentas = cuentaRepository.findBySaldoBetween(saldoMin, saldoMax);
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("NewCuenta",  new Cuenta());
        model.addAttribute("NewOperacion",  new Operacion());
        return "consultas";
    }

 
    @GetMapping("/consultas/fecha-ultimo-movimiento")
    public String obtenerCuentasPorFechaDeUltimoMovimiento(Model model, @RequestParam("fecha") LocalDate date) {
        List<Cuenta> cuentas = cuentaRepository.findByFechaUltimaTransaccionBetween(date);
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("NewCuenta",  new Cuenta());
        model.addAttribute("NewOperacion",  new Operacion());
        return "consultas";
    }
}
