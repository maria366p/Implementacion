package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioEmpleadoRepository;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;
    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @GetMapping("/oficinas")
    public String oficinas (Model model){
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "oficinas";
    }

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model) {
        model.addAttribute("gerentes", usuarioEmpleadoRepository.darPersdeGerenteO());
        model.addAttribute("oficina", new Oficina());
        return "oficinaNuevo";
    }

    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute Oficina oficina) {
        oficinaRepository.insertarOficina(oficina.getNOMBRE(), oficina.getDIRECCION(), oficina.getNUMEROPA(), oficina.getIDGERENTE());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/oficinas/{id}/edit")
    public String oficinaEditarForm(@PathVariable("id") int id, Model model) {
        Oficina oficina = oficinaRepository.darOficina(id);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";
        } else {
            return "redirect:/oficinas";
        }
    }

    @PostMapping("/oficinas/{id}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Oficina oficina) {
        oficinaRepository.actualizarOficina(((int) id), oficina.getNOMBRE(), oficina.getDIRECCION(), oficina.getNUMEROPA(), oficina.getIDGERENTE());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{id}/delete")
    public String oficinaEliminar(@PathVariable("id") int id) {
        oficinaRepository.eliminarOficina(id);
        return "redirect:/oficinas";
    }
}
