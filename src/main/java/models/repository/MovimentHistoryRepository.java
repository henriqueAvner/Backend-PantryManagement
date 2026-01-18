package models.repository;

import models.entity.MovimentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentHistoryRepository extends JpaRepository<MovimentHistory, Long> {}
