package com.escala.app.dtos;

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
    private @NotBlank String date;

    // Constructors
    public TeamRegisterDTO() {
    }

    public TeamRegisterDTO(String date) {
        this.date = date;
    }

    // Getters and Setters
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
