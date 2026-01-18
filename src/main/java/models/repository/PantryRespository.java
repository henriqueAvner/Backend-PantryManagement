package models.repository;

import models.entity.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantryRespository extends JpaRepository<Pantry, Long> {}
