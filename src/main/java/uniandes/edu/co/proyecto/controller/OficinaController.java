package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Repository.EmpleadoRepository;
import uniandes.edu.co.proyecto.Repository.OficinaRepository;
import uniandes.edu.co.proyecto.Repository.PuntoAtencionRepository;
import uniandes.edu.co.proyecto.model.Empleado;
import uniandes.edu.co.proyecto.model.Oficina;
import uniandes.edu.co.proyecto.model.PuntoAtencion;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/oficinas")
    public String oficinas (Model model){
        List<Oficina> oficinas = oficinaRepository.findAll();
        model.addAttribute("oficinas", oficinas);
        model.addAttribute("NewOficina",  new Oficina());
        return "oficinas";
    }

    @GetMapping("/oficinas/getEmpleados")
    public String getEmpleados(@RequestParam("id") ObjectId id, Model model){

        Optional<Oficina> oficinaOptional = oficinaRepository.findById(id);
        List<Empleado> oficinas = empleadoRepository.findAll();
        if(oficinaOptional.isPresent()){
            Oficina oficina = oficinaOptional.get();
            List<ObjectId> empleadoIds = oficina.getEmpleados();
            List<Empleado> empleados = empleadoRepository.findByIds(empleadoIds);
            model.addAttribute("empleados", empleados);
        }
        model.addAttribute("oficinas", oficinas);
        model.addAttribute("NewOficina",  new Oficina());
        return "oficinas";
    }

    @GetMapping("/oficinas/getPuntos")
    public String getPuntos(@RequestParam("id") ObjectId id, Model model){

        Optional<Oficina> oficinaOptional = oficinaRepository.findById(id);
        List<Empleado> oficinas = empleadoRepository.findAll();
        if(oficinaOptional.isPresent()){
            Oficina oficina = oficinaOptional.get();
            List<ObjectId> puntoIds = oficina.getPuntosAtencion();
            List<PuntoAtencion> puntos = puntoAtencionRepository.findByIds(puntoIds);
            model.addAttribute("puntos", puntos);
        }
        model.addAttribute("oficinas", oficinas);
        model.addAttribute("NewOficina",  new Oficina());
        return "oficinas";
    }

    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute("oficina") Oficina oficina) {
        
        oficinaRepository.save(new Oficina(oficina.getNombre(), oficina.getDireccion(), oficina.getNumPuntos(), oficina.getGerente()));
        return "redirect:/oficinas";
    }

    @ModelAttribute("valores")
    public List<Empleado> obtenerValores() {
        return empleadoRepository.findByCargo("Gerente de oficina");
    }
}
