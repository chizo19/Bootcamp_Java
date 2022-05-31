package com.example.spring02.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Schema(description = "Información de Persona")
@Data
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre de Persona")
    @Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
    @Column(name="Nombres", nullable = false, length = 70)
    private String nombres;

    @Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
    @Column(name="Apellidos", nullable = false, length = 70)
    private String apellidos;

    @Pattern(regexp = "^[0-9]*$" , message = "DNI no cumple con la expresion ^[0-9]*$")
    @Size(min = 8,max = 8, message = "DNI debe tener 8 caracteres")
    @Column(name="Dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Size(min = 9,max = 9, message = "Teléfono debe tener 9 caracteres")
    @Column(name="Teléfono", nullable = false, length = 9)
    private String telefono;

    @Pattern(regexp = "^(.+)@(.+)$" , message = "El correo ingresado no cuenta con el formato correcto")
    @Size(min = 6,max = 100, message = "El correo debe tener minímo 6 caracteres")
    @Column(name="Correo", nullable = false, length = 100)
    private String correo;

    @Column(name="Afp", nullable = false, length = 100)
    private String afp;

    @Column(name = "estado", nullable = false)
    private boolean estado = true;
}
