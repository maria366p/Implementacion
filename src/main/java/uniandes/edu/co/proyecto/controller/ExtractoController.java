package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Repository.CuentaRepository;
import uniandes.edu.co.proyecto.model.Cuenta;
import uniandes.edu.co.proyecto.model.Operacion;
@Controller
public class ExtractoController {
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @GetMapping("/extracto/generar")
    public String generarExtractoBancario(Model model, @RequestParam("cuenta") Integer numCuenta, @RequestParam("fechaInit") LocalDate fechaInit, @RequestParam("fechaFin") LocalDate fechaFin) {
        Cuenta cuenta = cuentaRepository.findByNumber(numCuenta);
        
        model.addAttribute("numCuenta", numCuenta);
        List<Operacion> operaciones = cuenta.getOperaciones();
        List<Operacion> operacionesFiltradas = new ArrayList<Operacion>();
        for(Operacion operacion: operaciones){
            LocalDate targetDate = operacion.getFecha();
            if((targetDate.isEqual(fechaInit) || targetDate.isAfter(fechaInit)) &&
            (targetDate.isEqual(fechaFin) || targetDate.isBefore(fechaFin))){
                operacionesFiltradas.add(operacion);
            }
        }
        Double saldInic = 0.0;
        for(Operacion operacion: operacionesFiltradas){
            if(operacion.getTipo().equals("Consignar")){
                saldInic -= operacion.getValor();
            }else{
                saldInic += operacion.getValor();
            }
        }
        model.addAttribute("saldoFinal", cuenta.getSaldo());
        model.addAttribute("saldoInit", saldInic);
        model.addAttribute("operaciones", operacionesFiltradas);
        return "extracto";
    }

    @GetMapping("/extracto")
    public String extractoBancario(){
        return "extracto";
    }
}
