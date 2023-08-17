
package com.prueba2.controllers;


import com.prueba2.service.IVueloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    private final IVueloService vueloService;

    // Constructor que recibe una instancia de IVueloService a través de la inyección de dependencias
    public IndexController(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/") // Maneja solicitudes GET a la raíz del sitio ("/")
    public String index(Model model) {
        var vuelos = this.vueloService.getAll(); // Llama al método getAll() de IVueloService para obtener todos los vuelos
        model.addAttribute("vuelos", vuelos); // Agrega la lista de vuelos al modelo para que esté disponible en la vista
        return "index"; // Devuelve el nombre de la vista que se debe renderizar (normalmente un archivo HTML o plantilla)
    }
}