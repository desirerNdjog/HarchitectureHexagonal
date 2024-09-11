package com.accenture.spi.persistance.hibernate.models;

import com.accenture.enums.Sexe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserH implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "can't be empty")
    @Column(nullable= false)
    private String nom;
    @NotEmpty(message = "can't be empty")
    @Column(nullable= false)
    private String prenom;
    @NotEmpty(message = "can't be empty")
    @Column(nullable= false)
    private String email;
    @Column(nullable= false)
    private Sexe sexe;

    public UserH() {
    }

    public UserH(String nom, String prenom, String email, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
    }
}
