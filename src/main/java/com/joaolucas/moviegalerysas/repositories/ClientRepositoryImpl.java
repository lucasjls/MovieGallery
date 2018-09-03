package com.joaolucas.moviegalerysas.repositories;

import com.joaolucas.moviegalerysas.domain.Client;
import com.joaolucas.moviegalerysas.repositories.interfaces.ClientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Override
    public Client findByEmail(String email) {
        return null;
    }
}
