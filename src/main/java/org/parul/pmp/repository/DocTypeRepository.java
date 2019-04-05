package org.parul.pmp.repository;

import org.parul.pmp.entity.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocTypeRepository extends JpaRepository<DocType, Long> {
    //List<DocType> findByDepartment();
}
