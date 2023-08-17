/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba2.controllers;


import com.prueba2.entitites.Vuelo;
import com.prueba2.service.IVueloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VueloController {

    private final IVueloService vueloService;
// Constructor que recibe una instancia de IVueloService a través de la inyección de dependencias
    public VueloController(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/vuelo") // Maneja solicitudes GET a "/vuelo"
    public String index(Model model) {
        var baseVuelo = new Vuelo(); // Crea una nueva instancia de Vuelo (posiblemente para inicialización)

        model.addAttribute("vueloDefault", baseVuelo); // Agrega el objeto baseVuelo al modelo con el nombre "vueloDefault"
        model.addAttribute("vuelos", this.vueloService.getAll()); // Agrega la lista de vuelos al modelo con el nombre "vuelos"

        return "vuelo"; // Devuelve el nombre de la vista que se debe renderizar (normalmente un archivo HTML o plantilla)
    }
}