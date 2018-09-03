package com.joaolucas.moviegalerysas.repositories.interfaces;

import com.joaolucas.moviegalerysas.domain.Client;

public interface ClientRepository {

    Client findByEmail(String email);

}
