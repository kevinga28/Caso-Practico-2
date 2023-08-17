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

    // Constructor que recibe una instancia de IVueloService a través de las dependencias
    public VueloControllerAPI(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/all") // Maneja solicitudes GET a "/api/vuelo/all"
    public List<Vuelo> getAll() {
        return this.vueloService.getAll(); // Llama al método getAll() de IVueloService para obtener todos los vuelos
    }

    @GetMapping() // Maneja solicitudes GET a "/api/vuelo"
    public Vuelo getById(@RequestParam("id") int id) {
        var vuelo = this.vueloService.getById(id); // Llama al método getById() de IVueloService con el ID proporcionado
        if (vuelo.isPresent()) {
            return vuelo.get(); // Devuelve el vuelo si se encuentra, de lo contrario, lanza una excepción
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PostMapping() // Maneja solicitudes POST a "/api/vuelo"
    public Vuelo save(@RequestBody Vuelo vuelo) {
        return this.vueloService.save(vuelo); // Llama al método save() de IVueloService para guardar el vuelo
    }

    @DeleteMapping() // Maneja solicitudes DELETE a "/api/vuelo"
    public ResponseEntity<String> delete(@RequestBody Vuelo vuelo) {
        this.vueloService.delete(vuelo); // Llama al método delete() de IVueloService para eliminar el vuelo
        return new ResponseEntity<>(HttpStatus.OK); // Devuelve una respuesta exitosa 
    }
}
