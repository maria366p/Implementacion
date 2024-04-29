package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.PersonaRepository;

@Controller
public class ClientesController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository; 
    @GetMapping("/clientes")
    public String clientes (Model model, @RequestParam(required = false) Integer IDEMP, @RequestParam String tipo, @RequestParam(required = false) Integer IDCLI ){

        if(tipo.equals("gerenteOficina")){
            model.addAttribute("cuentas", clienteRepository.obtenerInfoCuentasPorGerenteOficina(IDEMP));
            model.addAttribute("prestamos", clienteRepository.obtenerPrestamosPorGerenteOficina(IDEMP));

        }
        else if (tipo.equals("cliente")){
            model.addAttribute("cuentas", clienteRepository.obtenerInfoCliente(IDCLI));
            model.addAttribute("prestamos", clienteRepository.obtenerPrestamosCliente(IDCLI));

        }
        else if (tipo.equals("gerenteGeneral")){
            model.addAttribute("cuentas", clienteRepository.obtenerInfoCuentasParaGerenteGeneral());
            model.addAttribute("prestamos", clienteRepository.obtenerInfoPrestamosParaGerenteGeneral());

        }
       
        model.addAttribute("tipo", tipo);
        return "clientes";
    }

     @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("personas", personaRepository.darPersonas());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente, @RequestParam("IDCLIENTE") int ID) {
        Persona persona = personaRepository.darPersona(ID);
        clienteRepository.insertarCliente(persona.ID(),cliente.getROLC().name());
        return "redirect:/usuariosClientes/new";
    }

    @GetMapping("/clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") int id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cliente cliente) {
        clienteRepository.actualizarCliente(((int) id), cliente.getROLC().name());
        return "redirect:/usuariosClientes/new";
    }

    @GetMapping("/clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") int id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
