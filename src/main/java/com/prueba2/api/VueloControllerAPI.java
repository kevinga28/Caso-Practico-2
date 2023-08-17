/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba2.api;

import com.prueba2.entitites.Vuelo;
import com.prueba2.service.IVueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("api/vuelo")
public class VueloControllerAPI {
    private final IVueloService vueloService;

    public VueloControllerAPI(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/all")
    public List<Vuelo> getAll() {
        return this.vueloService.getAll();
    }

    @GetMapping()
    public Vuelo getById(@RequestParam("id") int id) {
        var vuelo = this.vueloService.getById(id);
        if (vuelo.isPresent()) {
            return vuelo.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PostMapping()
    public Vuelo save(@RequestBody Vuelo vuelo) {
        return this.vueloService.save(vuelo);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestBody Vuelo vuelo) {
        this.vueloService.delete(vuelo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}