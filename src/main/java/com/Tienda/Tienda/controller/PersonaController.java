/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.entity.Pais;
import com.Tienda.Tienda.entity.Persona;
import com.Tienda.Tienda.service.IPaisService;
import com.Tienda.Tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jeffrey Mojica S
 */
@Controller
public class PersonaController {
   

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;
    
    
    @RequestMapping("/personaApellido1")
    public String buscar(Model model, @Param("palabraClave") String palabraClave){    
         List<Persona> listaPersona = personaService.listAll(palabraClave);
         model.addAttribute("Titulo", "Tabla Personas");
         model.addAttribute("persona", listaPersona);      
          return "personas";
    }

    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("Titulo", "Tabla Personas");
        model.addAttribute("persona", listaPersona);
        return "personas";
    }

    @GetMapping("/personaN")
    public String crearPersona(Model model) {
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona()); //envia el objeto, 
        model.addAttribute("paises", listaPaises);  //refencia la entidad persona
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.savePersona(persona);
        return "redirect:/persona";
    }
    
  
     @GetMapping("/editPersona/{id}")
    public String editPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        personaService.delete(id);
        
         return "redirect:/persona";
    }
 

 }

