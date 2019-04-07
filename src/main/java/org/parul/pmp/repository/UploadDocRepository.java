package org.parul.pmp.repository;

import org.parul.pmp.entity.UplodedDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDocRepository extends JpaRepository<UplodedDocuments,Long> {
}
