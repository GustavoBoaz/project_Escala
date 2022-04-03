package com.escala.app.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Class that represents a Composition in the database.
 * 
 * @author Boaz
 * @version 1.0
 * @Date 02/04/2022
 * @see MemberModel
 * @See CompostionModel
 */
@Entity
@Table(name = "tb_teams")
public class TeamModel {

    // System generated
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    
    // Admin defined
    private @JsonFormat(pattern = "dd/MM/yyyy") LocalDate date;

    // Relational 
    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    private List<CompositionModel> compositions = new ArrayList<>();

    // Constructors
    public TeamModel() {
    }

    public TeamModel(LocalDate date) {
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
