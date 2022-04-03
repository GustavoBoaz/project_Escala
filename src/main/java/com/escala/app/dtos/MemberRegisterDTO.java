package com.escala.app.dtos;

import javax.validation.constraints.NotBlank;

/**
 * DTO for register member.
 * 
 * @author Boaz
 * @version 1.0
 * @Date 02/04/2022
 */
public class MemberRegisterDTO {
    
    // Admin create
    private @NotBlank String franchise;
    private @NotBlank String name;
    private @NotBlank String role;

    // Contractor
    public MemberRegisterDTO() {
    }

    public MemberRegisterDTO(String franchise, String name, String role) {
        this.franchise = franchise;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public String getFranchise() {
        return this.franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
