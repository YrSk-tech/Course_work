package com.syvak.Course.repository;

import com.syvak.Course.domain.imp.Analysis;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {
}
