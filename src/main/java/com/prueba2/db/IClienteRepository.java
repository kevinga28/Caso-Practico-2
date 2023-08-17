/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba2.db;

import com.prueba2.entitites.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LABORATORIO 04
 */
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {    
    Cliente findByNombre_usuario(String nombre_usuario);
}
