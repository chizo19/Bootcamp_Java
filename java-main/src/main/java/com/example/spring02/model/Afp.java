package com.example.spring02.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Schema(description = "Información de Afp")
@Data
@Entity
@Table(name = "afp")
public class Afp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre de afp")
    @Size(min = 5, message = "La descripción debe tener minimo 8 caracteres")
    @Column(name="Descripcion", nullable = false, length = 100)
    private String descripcion;
}
