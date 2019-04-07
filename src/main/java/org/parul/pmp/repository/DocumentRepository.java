package org.parul.pmp.repository;

import org.parul.pmp.entity.DocType;
import org.parul.pmp.entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Documents , Long> {
    Optional<Documents> findByDocType(DocType docType);

}
