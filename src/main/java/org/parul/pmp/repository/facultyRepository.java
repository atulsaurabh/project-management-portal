package org.parul.pmp.repository;

import org.parul.pmp.dto.faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface facultyRepository extends JpaRepository<faculty, Integer> {
}
