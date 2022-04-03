package com.escala.app.repositories;

import com.escala.app.models.CompositionModel;

import org.springframework.data.jpa.repository.JpaRepository;
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
    
}
