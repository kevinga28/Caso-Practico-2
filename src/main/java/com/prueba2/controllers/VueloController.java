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


    public VueloController(IVueloService vueloService) {
        this.vueloService = vueloService;

    }

    @GetMapping("/vuelo")
    public String index(Model model) {

        var baseVuelo = new Vuelo();
  
        model.addAttribute("vueloDefault", baseVuelo);
        model.addAttribute("vuelos", this.vueloService.getAll());
  
        return "vuelo";
    }

}