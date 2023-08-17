
package com.prueba2.controllers;


import com.prueba2.service.IVueloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    private final IVueloService vueloService;

    public IndexController(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/")
    public String index(Model model) {
        var vuelos = this.vueloService.getAll();
        model.addAttribute("vuelos", vuelos);
        return "index";
    }
}