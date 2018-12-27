package org.parul.pmp.repository;

import org.parul.pmp.dto.university;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface universityRepository extends JpaRepository<university,Integer> {
}
