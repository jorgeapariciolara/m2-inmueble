package com.example.m2springrestdatajpa.controller;

import com.example.m2springrestdatajpa.entities.Inmueble;
import com.example.m2springrestdatajpa.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @DeleteMapping ("/inmuebles/{id}")
    public void findById (@PathVariable Long id) {
        if (repository.existsById(id))
            repository.findById(id);
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

    // Crear Registros
    @PostMapping ("/inmuebles")
    public void create (@RequestBody Inmueble inmueble) {
        if (inmueble.getId() == null)
            repository.save(inmueble);
    }

    // Actualizar Registros
    @PutMapping ("/inmuebles")
    public void update (@RequestBody Inmueble inmueble) {
        if (inmueble.getId() != null && repository.existsById(inmueble.getId()))
            repository.save(inmueble);
    }

    // Borrar un Registro
    @DeleteMapping ("/inmuebles/{id}")
    public void deleteById (@PathVariable Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
    }

    // Borrar todos los Registros
    @DeleteMapping ("/inmuebles")
    public void deleteAll () {
        repository.deleteAll();
    }

}
