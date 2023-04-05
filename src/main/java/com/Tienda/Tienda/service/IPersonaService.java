/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.service;

import com.Tienda.Tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author Jeffrey Mojica S
 */

public interface IPersonaService {
    public List<Persona> listAll(String palabraClave);
    public List<Persona> getAllPersona();
    public Persona getPersonaById (long id);
    public void savePersona(Persona persona);
    public void delete (long id);
    /*public Persona findByNombre(String username);*/ /*Se agrega aqui para pode utilizar en el User Service*/

    public Persona findByNombre(String username);
}
