package com.escala.app.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

/**
 * DTO for register team.
 * 
 * @author Boaz
 * @version 1.0
 * @Date 02/04/2022
 */
public class TeamRegisterDTO {
    
    // Admin defined
    private @NotBlank LocalDate date;

    // Constructors
    public TeamRegisterDTO() {
    }

    public TeamRegisterDTO(LocalDate date) {
        this.date = date;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
