package org.parul.pmp.repository;

import org.parul.pmp.entity.PmpLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<PmpLogin,Integer> {
}
