package com.escala.app.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import com.escala.app.dtos.MemberRegisterDTO;
import com.escala.app.dtos.TeamRegisterDTO;
import com.escala.app.models.CompositionModel;
import com.escala.app.models.MemberModel;
import com.escala.app.models.TeamModel;
import com.escala.app.repositories.CompositionRepository;
import com.escala.app.repositories.MemberRepository;
import com.escala.app.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

    private MemberModel newMember;
    private TeamModel newTeam;
    
    private @Autowired MemberRepository memberRepository;
    private @Autowired TeamRepository teamRepository;
    private @Autowired CompositionRepository compositionRepository;

    @PostMapping("/member")
    public ResponseEntity<MemberModel> registerMember(@Valid @RequestBody MemberRegisterDTO member) {
        
        newMember = new MemberModel(
            member.getFranchise(),
            member.getName(),
            member.getRole());
        
        return ResponseEntity.ok(memberRepository.save(newMember));
    }

    @PostMapping("/team")
    public ResponseEntity<TeamModel> registerTeam(@Valid @RequestBody TeamRegisterDTO team) {
        LocalDate date = LocalDate.parse(team.getDate());
        newTeam = new TeamModel(date);
        
        return ResponseEntity.ok(teamRepository.save(newTeam));
    }

    @PostMapping("/composition")
    public ResponseEntity<CompositionModel> registerComposition(@RequestBody CompositionModel composition) {   
        
        if (teamRepository.existsById(composition.getTeam().getId()) && memberRepository.existsById(composition.getMember().getId())) {
            return ResponseEntity.ok(compositionRepository.save(composition));
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Team or Member not found");
    }

}
