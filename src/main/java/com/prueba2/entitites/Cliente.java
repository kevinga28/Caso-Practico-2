/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba2.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="Cliente")
public class Cliente  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    @NotEmpty
    private String nombre_usuario;    
    @NotEmpty
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private Integer id_rol;        
    
    @OneToMany
    @JoinColumn(name="id")
    private List<Roles> roles;
}
 

