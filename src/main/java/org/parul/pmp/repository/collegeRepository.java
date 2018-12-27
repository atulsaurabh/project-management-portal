package org.parul.pmp.repository;

import org.parul.pmp.dto.college;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface collegeRepository extends JpaRepository<college,Integer> {
}
