package com.example.spring02.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Schema(description = "Información de Solicitudes")
@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "^[0-9]*$" , message = "DNI no cumple con la expresion ^[0-9]*$")
    @Size(min = 8,max = 8, message = "DNI debe tener 8 caracteres")
    @Column(name="Dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name="Monto")
    private Double monto;

    @Column(name="Afp", nullable = false, length = 100)
    private String afp;
}
