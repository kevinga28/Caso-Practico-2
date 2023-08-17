
package com.prueba2.db;

import com.prueba2.entitites.Roles;
import org.springframework.data.repository.CrudRepository;


public interface IRolRepository extends CrudRepository<Roles, Long> {
}
