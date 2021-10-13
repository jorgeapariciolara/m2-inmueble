package com.example.m2springrestdatajpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inmueble {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Integer m2;
    private String inmobiliaria;
    private Boolean garden;

    public Inmueble() {}
    public Inmueble(Long id,
                    Double price,
                    Integer m2,
                    String inmobiliaria,
                    Boolean garden) {
        this.id = id;
        this.price = price;
        this.m2 = m2;
        this.inmobiliaria = inmobiliaria;
        this.garden = garden;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public Integer getM2() {return m2;}
    public void setM2(Integer m2) {this.m2 = m2;}
    public String getInmobiliaria() {return inmobiliaria;}
    public void setInmobiliaria(String inmobiliaria) {this.inmobiliaria = inmobiliaria;}
    public Boolean getGarden() {return garden;}
    public void setGarden(Boolean garden) {this.garden = garden;}
    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", price=" + price +
                ", m2=" + m2 +
                ", inmobiliaria='" + inmobiliaria + '\'' +
                ", garden=" + garden +
                '}';
    }
}
