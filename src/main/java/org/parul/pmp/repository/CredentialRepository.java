package org.parul.pmp.repository;

import org.parul.pmp.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential,String>
{
    Optional<Credential> findByUsernameAndPassword(String username, String password);
}
