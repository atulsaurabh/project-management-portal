package org.parul.pmp.repository;

import org.parul.pmp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepository extends JpaRepository<Department, String> {
}
