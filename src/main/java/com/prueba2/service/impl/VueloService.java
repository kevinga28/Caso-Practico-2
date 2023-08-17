/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba2.service.impl;

import com.prueba2.db.IVueloRepository;
import com.prueba2.entitites.Vuelo;
import com.prueba2.service.IVueloService;
import org.springframework.stereotype.Service;


@Service
public class VueloService extends BaseService<Vuelo, Integer> implements IVueloService {

    private final IVueloRepository vueloRepository;
   
    public VueloService(IVueloRepository vueloRepository) {
        super(vueloRepository);
        this.vueloRepository = vueloRepository;
    }
}
 