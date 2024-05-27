package uniandes.edu.co.proyecto.controller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Cliente;
import uniandes.edu.co.proyecto.Repository.ClienteRepository;

@Controller
public class ClientesController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String getClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        model.addAttribute("NewCliente",  new Cliente());
        return "clientes";
    }

    @PostMapping("/clientes/new/save")
    public String newCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(new Cliente(cliente.getTipoDni(), cliente.getDni(), cliente.getNombre(), cliente.getNacionalidad(), cliente.getDireccion(), cliente.getEmail(), cliente.getTelefono(), cliente.getCiudad(), cliente.getDepartamento(), cliente.getCodigoPostal(), cliente.getTipo()));
        return "redirect:/clientes";
    }
}
