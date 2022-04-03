package com.escala.app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class that represents a Member in the database.
 * 
 * @author Boaz
 * @version 1.0
 * @Date 02/04/2022
 * @see TeamModel
 * @See CompositionModel
 */
@Entity
@Table(name = "tb_members")
public class MemberModel {
    
    // System generated
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    
    // Admin defined
    private String franchise;
    private String name;
    private String role;

    // Relational 
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<CompositionModel> compositions = new ArrayList<>();

    // Constructors
    public MemberModel() {
    }

    public MemberModel(String franchise, String name, String role) {
        this.franchise = franchise;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
