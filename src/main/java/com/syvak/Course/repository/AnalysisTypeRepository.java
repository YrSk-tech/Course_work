package com.syvak.Course.repository;

import com.syvak.Course.domain.imp.AnalysisType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisTypeRepository extends JpaRepository<AnalysisType, Integer> {
}
