package org.parul.pmp.repository;

import org.parul.pmp.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long>{


    University findByUniversityCode(String university_id);
}
