package org.parul.pmp.service;


import org.parul.pmp.dto.LoginDTO;
import org.parul.pmp.entity.Credential;
import org.parul.pmp.exception.UserNotExistException;
import org.parul.pmp.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcountService {
    @Autowired
    private CredentialRepository credentialRepository;

    public Credential performLoginAndFetchRole(LoginDTO loginDTO) throws UserNotExistException
    {
         Optional<Credential> expectedCredential=credentialRepository.findByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword());
         expectedCredential.orElseThrow(()->new UserNotExistException());
         return expectedCredential.get();
    }
}
