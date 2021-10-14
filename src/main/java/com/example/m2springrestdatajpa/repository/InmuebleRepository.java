package com.example.m2springrestdatajpa.repository;

import com.example.m2springrestdatajpa.entities.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InmuebleRepository extends JpaRepository <Inmueble, Long> {

    List<Inmueble> findByInmobiliaria (String Inmobiliaria);
}
