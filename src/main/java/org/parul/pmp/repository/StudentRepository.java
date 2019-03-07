package org.parul.pmp.repository;

import org.parul.pmp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEnrollment(Long enrollment);
    Student findByDepartment(Long department_id);
}
