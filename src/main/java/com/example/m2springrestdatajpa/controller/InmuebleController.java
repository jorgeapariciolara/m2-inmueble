package com.example.m2springrestdatajpa.controller;

import com.example.m2springrestdatajpa.entities.Inmueble;
import com.example.m2springrestdatajpa.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class InmuebleController {

    // Podemos añadir el REPOSITORIO al controlador de dos formas:
    // Opción 1
    // @Autowired
    // InmuebleRepository repository;

    // Opción 2 => Creamos un Atributo y un Constructor
    InmuebleRepository repository;

    public InmuebleController (InmuebleRepository repository) {
        this.repository = repository;
    }

    // Mostrar todos los Registros
    @GetMapping ("/inmuebles")
    public List<Inmueble> findAll(){
        return repository.findAll();
    }

    // Mostrar un Registro
    // Utilizando el id
    @GetMapping ("/inmuebles/{id}")
    public Inmueble findById (@PathVariable Long id) {
        Optional<Inmueble> inmuebleOpt = repository.findById(id);
        if (inmuebleOpt.isPresent())
            return inmuebleOpt.get();
        else
            return null;
        // return inmuebleOpt.orElse(null);
    }
    // Utilizando la inmobiliaria
    @GetMapping ("/inmuebles/{inmobiliaria}")
    public List<Inmueble> findByInmobiliaria (@PathVariable String inmobiliaria) {
        return repository.findByInmobiliaria(inmobiliaria);
    }

    // Creamos un método para tener registros en base de datos
    @GetMapping ("/inmuebles/data")
    public void demoData () {
        Inmueble casa = new Inmueble(null, 187598.75, 79, "Tengokely", false);
        Inmueble chalet = new Inmueble(null, 1875980.75, 719, "Massachussets", true);
        Inmueble piso = new Inmueble(null, 127598.75, 59, "Tengokely", false);
        repository.save(casa);
        repository.save(chalet);
        repository.save(piso);
    }

}
