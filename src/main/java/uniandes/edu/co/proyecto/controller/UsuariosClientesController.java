package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.UsuarioCliente;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioClienteRepository;

@Controller
public class UsuariosClientesController {
    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @Autowired
    private PersonaRepository personaRepository;


    @GetMapping("/usuariosClientes")
    public String usuariosClientes (Model model){
        model.addAttribute("usuariosClientes", usuarioClienteRepository.darUsuarioClientes());
        return "usuariosClientes";
    }

    @GetMapping("/usuariosClientes/new")
    public String usuarioClienteForm(Model model) {
        model.addAttribute("personas", personaRepository.darPersonas());
        model.addAttribute("usuarioCliente", new UsuarioCliente());
        return "usuarioClienteNuevo";
    }

    @PostMapping("/usuariosClientes/new/save")
    public String usuarioClienteGuardar(@ModelAttribute UsuarioCliente usuarioCliente, @RequestParam("ID") int ID) {
        Persona persona = personaRepository.darPersona(ID);
        usuarioClienteRepository.insertarUsuarioCliente(persona.ID(), usuarioCliente.getPASSWORD());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/usuariosClientes/{id}/edit")
    public String usuarioClienteEditarForm(@PathVariable("id") int id, Model model) {
        UsuarioCliente usuarioCliente = usuarioClienteRepository.darUsuarioCliente(id);
        if (usuarioCliente != null) {
            model.addAttribute("usuarioCliente", usuarioCliente);
            return "usuarioClienteEditar";
        } else {
            return "redirect:/usuariosClientes";
        }
    }

    @PostMapping("/usuariosClientes/{id}/edit/save")
    public String usuarioClienteEditarGuardar(@PathVariable("id") int id, @ModelAttribute UsuarioCliente usuarioCliente) {
        usuarioClienteRepository.actualizarUsuarioCliente(((int) id), usuarioCliente.getPASSWORD());
        return "redirect:/usuariosClientes";
    }

    @GetMapping("/usuariosClientes/{id}/delete")
    public String usuarioClienteEliminar(@PathVariable("id") int id) {
        usuarioClienteRepository.eliminarUsuarioCliente(id);
        return "redirect:/usuariosClientes";
    }
}
