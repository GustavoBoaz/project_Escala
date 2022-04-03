package com.escala.app.controllers;

import java.util.List;

import com.escala.app.dtos.FranchiseMostFamousDTO;
import com.escala.app.dtos.MemberMostUsedDTO;
import com.escala.app.dtos.RoleMostCommonDTO;
import com.escala.app.dtos.TeamMostCommonDTO;
import com.escala.app.dtos.TeamToDateDTO;
import com.escala.app.repositories.CompositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/process")
public class DataProcessController {

    private @Autowired CompositionRepository repository;

    @GetMapping("/TeamToDate")
    public ResponseEntity<List<TeamToDateDTO>> getTeamToDate(@RequestParam String date) {
        return ResponseEntity.ok(repository.findTeamToDate(date));
    }

    @GetMapping("/MemberMostUsed")
    public ResponseEntity<MemberMostUsedDTO> getMemberMostUsed(
        @RequestParam String initialDate,
        @RequestParam String finalDate) {
        return ResponseEntity.ok(repository.findMemberMostUsed(initialDate, finalDate));
    }

    @GetMapping("/TeamMostCommon")
    public ResponseEntity<List<TeamMostCommonDTO>> getTeamMostCommon(
        @RequestParam String initialDate,
        @RequestParam String finalDate) {
        return ResponseEntity.ok(repository.findMembersMostUsed(initialDate, finalDate));
    }

    @GetMapping("/RoleMostCommon")
    public ResponseEntity<RoleMostCommonDTO> getRoleMostCommon(
        @RequestParam String initialDate,
        @RequestParam String finalDate) {
        return ResponseEntity.ok(repository.findRoleMostUsed(initialDate, finalDate));
    }

    @GetMapping("/FranchiseMostFamous")
    public ResponseEntity<FranchiseMostFamousDTO> getFranchiseMostFamous(
        @RequestParam String initialDate,
        @RequestParam String finalDate) {
        return ResponseEntity.ok(repository.findFranchiseMostFamous(initialDate, finalDate));
    }

    @GetMapping("/FranchiseMostFamous/list")
    public ResponseEntity<List<FranchiseMostFamousDTO>> getFranchiseMostFamousList(
        @RequestParam String initialDate,
        @RequestParam String finalDate) {
        return ResponseEntity.ok(repository.findCountByFranchises(initialDate, finalDate));
    }

    @GetMapping("/RoleMostCommon/list")
    public ResponseEntity<List<RoleMostCommonDTO>> getRoleMostCommonList(
        @RequestParam String initialDate,
        @RequestParam String finalDate) {
        return ResponseEntity.ok(repository.findCountByRoles(initialDate, finalDate));
    }
    
}
