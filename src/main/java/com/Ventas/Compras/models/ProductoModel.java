package com.Ventas.Compras.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "nombre", nullable = false)
    private String nombre;

    @Column(name= "existencia", nullable = false)
    private int existencia;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;

    @Column(name= "nombreProv", nullable = false)
    private String nombreProv;
}