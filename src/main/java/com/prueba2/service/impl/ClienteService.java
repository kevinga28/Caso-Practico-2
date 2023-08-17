
package com.prueba2.service.impl;

import com.prueba2.db.IClienteRepository;
import com.prueba2.db.IRolRepository;
import com.prueba2.entitites.Cliente;
import com.prueba2.entitites.Roles;
import com.prueba2.service.IClienteService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LABORATORIO 04
 */
public class ClienteService implements UserDetailsService, IClienteService {

    private final IClienteRepository clienteRepository;
    private final HttpSession session;

    private final IRolRepository roleRepository;

    public ClienteService(IClienteRepository clienteRepository, HttpSession session, IRolRepository roleRepository) {
        this.clienteRepository = clienteRepository;
        this.session = session;
        this.roleRepository = roleRepository;
    }


    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombre_usuario) throws UsernameNotFoundException {
        //Busca el usuario por el username en la tabla
        Cliente cliente = this.clienteRepository.findByNombre_usuario(nombre_usuario);
        //Si no existe el usuario lanza una excepción
        if (cliente == null) {
            throw new UsernameNotFoundException(nombre_usuario);
        }
        //Si está acá es porque existe el usuario... sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        for (Roles rol : cliente.getRoles()) {   //Se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se devuelve User (clase de userDetails)
        return new User(cliente.getNombre_usuario(), cliente.getPassword(), roles);
    }    

 @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }

}
