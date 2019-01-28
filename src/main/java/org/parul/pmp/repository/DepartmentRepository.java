package org.parul.pmp.repository;

import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
