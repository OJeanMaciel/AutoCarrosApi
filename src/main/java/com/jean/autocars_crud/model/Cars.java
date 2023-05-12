package com.jean.autocars_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String marca;
    @Column(length = 20, nullable = false)
    private String modelo;
    @Column(length = 20, nullable = false)
    private String cor;
    @Column(length = 10, nullable = false)
    private String combustivel;
    @Column(length = 10, nullable = false)
    private double preco;
    @Column(length = 4, nullable = false)
    private int ano;
    @Column(length = 1, nullable = false)
    private int portas;
    @Column(nullable = false)
    private String imagem;
}
