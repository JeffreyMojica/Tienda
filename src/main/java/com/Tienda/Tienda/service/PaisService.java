/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.service;

import com.Tienda.Tienda.entity.Pais;
import com.Tienda.Tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeffrey Mojica S
 */
@Service
public class PaisService implements IPaisService {

    @Autowired
    private PaisRepository paisRepository;
       
    @Override
    public List<Pais> listCountry() {
       return (List<Pais>)paisRepository.findAll();
    }
    
}
