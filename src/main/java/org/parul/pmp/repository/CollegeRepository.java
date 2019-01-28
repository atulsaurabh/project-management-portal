package org.parul.pmp.repository;

import org.parul.pmp.entity.College;
import org.parul.pmp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    College findByCollegeCode(String college_id);
}
