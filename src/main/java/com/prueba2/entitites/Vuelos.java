/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba2.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author LABORATORIO 04
 */
public class Vuelos {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero_vuelo;
    private String destino;
    private String lugar_salida;
    private LocalTime hora_salida;
    private Date fecha_salida;
    private Date fecha_llegada;
    private String modelo_avion ;
}
