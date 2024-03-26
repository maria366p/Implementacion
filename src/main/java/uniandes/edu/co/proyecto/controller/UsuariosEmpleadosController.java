package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.UsuarioEmpleado;
import uniandes.edu.co.proyecto.repositorio.UsuarioEmpleadoRepository;

public class UsuariosEmpleadosController {
    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @GetMapping("/usuariosEmpleados")
    public String usuariosEmpleados (Model model){
        model.addAttribute("usuariosEmpleados", usuarioEmpleadoRepository.darUsuarioEmpleados());
         return model.toString() ; //return "usuariosEmpleados";
    }

    @GetMapping("/usuariosEmpleados/new")
    public String usuarioEmpleadoForm(Model model) {
        model.addAttribute("usuarioEmpleado", new UsuarioEmpleado());
        return "usuarioEmpleadoNuevo";
    }

    @PostMapping("/usuariosEmpleados/new/save")
    public String usuarioEmpleadoGuardar(@ModelAttribute UsuarioEmpleado usuarioEmpleado) {
        usuarioEmpleadoRepository.insertarUsuarioEmpleado(usuarioEmpleado.getID(), usuarioEmpleado.getPASSWORD());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/usuariosEmpleados/{id}/edit")
    public String usuarioEmpleadoEditarForm(@PathVariable("id") int id, Model model) {
        UsuarioEmpleado usuarioEmpleado = usuarioEmpleadoRepository.darUsuarioEmpleado(id);
        if (usuarioEmpleado != null) {
            model.addAttribute("usuarioEmpleado", usuarioEmpleado);
            return "usuarioEmpleadoEditar";
        } else {
            return "redirect:/usuariosEmpleados";
        }
    }

    @PostMapping("/usuariosEmpleados/{id}/edit/save")
    public String usuarioEmpleadoEditarGuardar(@PathVariable("id") int id, @ModelAttribute UsuarioEmpleado usuarioEmpleado) {
        usuarioEmpleadoRepository.actualizarUsuarioEmpleado(((int) id), usuarioEmpleado.getPASSWORD());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/usuariosEmpleados/{id}/delete")
    public String usuarioEmpleadoEliminar(@PathVariable("id") int id) {
        usuarioEmpleadoRepository.eliminarUsuarioEmpleado(id);
        return "redirect:/usuariosEmpleados";
    }
}
