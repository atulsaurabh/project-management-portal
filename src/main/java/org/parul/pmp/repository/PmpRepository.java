package org.parul.pmp.repository;

import org.parul.pmp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PmpRepository extends JpaRepository<Student,Integer> {
}
