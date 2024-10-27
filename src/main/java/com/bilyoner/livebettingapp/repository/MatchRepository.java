package com.bilyoner.livebettingapp.repository;

import com.bilyoner.livebettingapp.model.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
