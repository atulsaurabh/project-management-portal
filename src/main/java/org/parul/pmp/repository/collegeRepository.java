package org.parul.pmp.repository;

import org.parul.pmp.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface collegeRepository extends JpaRepository<College,Integer> {
}