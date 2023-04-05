/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.repository;


import com.Tienda.Tienda.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Jeffrey Mojica S
 */
@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    
    @Query(value="SELECT * FROM personas WHERE personas.apellido1 LIKE %?1%", nativeQuery=true)
    public List<Persona> findAll(String palabraClave);
    
    Persona findByNombre(String username); /*Una vez agregado aqui ya s epuede usar en PersonaService*/
}
