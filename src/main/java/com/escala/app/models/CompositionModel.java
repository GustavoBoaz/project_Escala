package com.escala.app.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class that represents a Composition in the database.
 * 
 * @author Boaz
 * @version 1.0
 * @Date 02/04/2022
 * @see MemberModel
 * @See TeamModel
 */
@Entity
@Table(name = "tb_compositions")
public class CompositionModel {

    // System generated
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    // Relational
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @JsonIgnoreProperties({"compositions"})
    private MemberModel member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties({"compositions"})
    private TeamModel team;

    // Constructors
    public CompositionModel() {
    }

    public CompositionModel(MemberModel member, TeamModel team) {
        this.member = member;
        this.team = team;
    }

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MemberModel getMember() {
        return this.member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public TeamModel getTeam() {
        return this.team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

}
