package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Cargo;
import uniandes.edu.co.proyecto.repositorio.CargoRepository;

@Controller
public class CargosController {
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/cargos")
    public String cargos (Model model){
        model.addAttribute("cargos", cargoRepository.darCargos());
        return "cargos";
    }

     @GetMapping("/cargos/new")
    public String cargoForm(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargoNuevo";
    }

    @PostMapping("/cargos/new/save")
    public String cargoGuardar(@ModelAttribute Cargo cargo) {
        cargoRepository.insertarCargo(cargo.getNombre().name());
        return "redirect:/cargos";
    }

    @GetMapping("/cargos/{id}/edit")
    public String cargoEditarForm(@PathVariable("id") int id, Model model) {
        Cargo cargo = cargoRepository.darCargo(id);
        if (cargo != null) {
            model.addAttribute("cargo", cargo);
            return "cargoEditar";
        } else {
            return "redirect:/cargos";
        }
    }

    @PostMapping("/cargos/{id}/edit/save")
    public String cargoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cargo cargo) {
        cargoRepository.actualizarCargo(((int) id), cargo.getNombre().name());
        return "redirect:/cargos";
    }

    @GetMapping("/cargos/{id}/delete")
    public String cargoEliminar(@PathVariable("id") int id) {
        cargoRepository.eliminarCargo(id);
        return "redirect:/cargos";
    }
}
