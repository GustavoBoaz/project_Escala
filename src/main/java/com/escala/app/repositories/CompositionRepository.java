package com.escala.app.repositories;

import java.util.List;

import com.escala.app.dtos.FranchiseMostFamousDTO;
import com.escala.app.dtos.MemberMostUsedDTO;
import com.escala.app.dtos.RoleMostCommonDTO;
import com.escala.app.dtos.TeamMostCommonDTO;
import com.escala.app.dtos.TeamToDateDTO;
import com.escala.app.models.CompositionModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for CompositionModel.
 * 
 * @author Boaz
 * @version 1.0
 * @Date 02/04/2022
 */
@Repository
public interface CompositionRepository extends JpaRepository<CompositionModel, Long> {
    
    /**
     * Find name members compositions by date.
     * 
     * @param date
     * @return List<TimeDaDataDTO>
     */
    @Query(value =
        "SELECT m.name " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date = :date", nativeQuery = true)
    List<TeamToDateDTO> findTeamToDate(@Param("date") String date);

    /**
     * Find member most used in date range.
     * 
     * @param initialDate
     * @param finalDate
     * @return MemberMostUsedDTO
     */
    @Query(value =
        "SELECT m.name, COUNT(m.name) AS incidences " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date BETWEEN :initialDate AND :finalDate " +
        "GROUP BY m.name " +
        "ORDER BY incidences DESC LIMIT 1", nativeQuery = true)
    public MemberMostUsedDTO findMemberMostUsed(
        @Param("initialDate") String initialDate,
        @Param("finalDate") String finalDate);

    /**
     * Find members most used in date range.
     * 
     * @param initialDate
     * @param finalDate
     * @return List<TeamMostCommonDTO>
     */
    @Query(value =
        "SELECT m.name, COUNT(m.name) AS incidences " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date BETWEEN :initialDate AND :finalDate " +
        "GROUP BY m.name " +
        "ORDER BY incidences DESC", nativeQuery = true)
    public List<TeamMostCommonDTO> findMembersMostUsed(
        @Param("initialDate") String initialDate,
        @Param("finalDate") String finalDate);

    /**
     * Find role most used in date range.
     * 
     * @param initialDate
     * @param finalDate
     * @return RoleMostCommonDTO
     */
    @Query(value =
        "SELECT m.role, COUNT(m.role) AS incidences " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date BETWEEN :initialDate AND :finalDate " +
        "GROUP BY m.role " +
        "ORDER BY incidences DESC LIMIT 1", nativeQuery = true)
    public RoleMostCommonDTO findRoleMostUsed(
        @Param("initialDate") String initialDate,
        @Param("finalDate") String finalDate);

    /**
     * Find franchise most famous in date range.
     * 
     * @param initialDate
     * @param finalDate
     * @return FranchiseMostFamousDTO
     */
    @Query(value =
        "SELECT m.franchise, COUNT(m.franchise) AS incidences " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date BETWEEN :initialDate AND :finalDate " +
        "GROUP BY m.franchise " +
        "ORDER BY incidences DESC LIMIT 1", nativeQuery = true)
    public FranchiseMostFamousDTO findFranchiseMostFamous(
        @Param("initialDate") String initialDate,
        @Param("finalDate") String finalDate);

    /**
     * Find count by franchises in date range.
     * 
     * @param initialDate
     * @param finalDate
     * @return List<FranchiseMostFamousDTO>
     */
    @Query(value =
        "SELECT m.franchise, COUNT(m.franchise) AS incidences " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date BETWEEN :initialDate AND :finalDate " +
        "GROUP BY m.franchise " +
        "ORDER BY incidences DESC", nativeQuery = true)
    public List<FranchiseMostFamousDTO> findCountByFranchises(
        @Param("initialDate") String initialDate, 
        @Param("finalDate") String finalDate);

    /**
     * Find count by roles in date range.
     * 
     * @param initialDate
     * @param finalDate
     * @return List<RoleMostCommonDTO>
     */
    @Query(value =
        "SELECT m.role, COUNT(m.role) AS incidences " +
        "FROM tb_teams t " +
        "INNER JOIN tb_compositions c ON c.team_id = t.id " +
        "INNER JOIN tb_members m ON m.id = c.member_id " +
        "WHERE t.date BETWEEN :initialDate AND :finalDate " +
        "GROUP BY m.role " +
        "ORDER BY incidences DESC", nativeQuery = true)
    public List<RoleMostCommonDTO> findCountByRoles(
        @Param("initialDate") String initialDate,
        @Param("finalDate") String finalDate);
}
