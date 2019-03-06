package org.parul.pmp.repository;

import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByFacultyCode(Long facultyCode);
   

    Optional<Faculty> findByEmail(String faculty);

    List<Faculty> findByDepartment(Department department);


    //Optional<Faculty> findByFaculty_code(String faculty_code);


}
