package com.joaolucas.moviegalerysas.services;

import com.joaolucas.moviegalerysas.domain.Client;
import com.joaolucas.moviegalerysas.repositories.interfaces.ClientRepository;
import com.joaolucas.moviegalerysas.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    public UserDetailsServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSpringSecurity(client.getEmail(), client.getPassword());
    }
}
