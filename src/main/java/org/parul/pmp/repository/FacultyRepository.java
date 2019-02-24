package org.parul.pmp.repository;

import org.parul.pmp.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByFacultyCode(Long facultyCode);
    Faculty findByDepartment(Long department_id);
}
