package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.UsuarioEmpleado;
import uniandes.edu.co.proyecto.repositorio.UsuarioEmpleadoRepository;
@Controller
public class UsuariosEmpleadosController {
    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @GetMapping("/usuariosEmpleados")
    public String usuariosEmpleados(Model model, @RequestParam(required = false) Integer ID, @RequestParam(required = false) String PASSWORD) {
        // Comprueba si el ID y la contraseña están presentes
        if (ID != null && PASSWORD != null && !PASSWORD.isEmpty()) {
            String nombrePersona = usuarioEmpleadoRepository.darNombrePconIDyPas(ID, PASSWORD);
            // Si los credenciales son correctos, se añade el nombre de la persona y su cargo al modelo
            if (nombrePersona != null && !nombrePersona.isEmpty()) {
                String cargo = usuarioEmpleadoRepository.darCargoconID(ID); // Obtiene el cargo basado en el ID
                model.addAttribute("nombrePersona", nombrePersona);
                model.addAttribute("cargo", cargo); // Añade el cargo al modelo
            } else {
                // Si los credenciales son incorrectos, se añade un mensaje de error al modelo
                model.addAttribute("error", "ID o contraseña incorrectos.");
            }
        } 
        return "usuariosEmpleados";
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
