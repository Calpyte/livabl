package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.ClientDAO;
import com.calpyte.livabl.domain.Client;
import com.calpyte.livabl.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientDAOImpl implements ClientDAO {
    @Autowired
    public ClientRepository clientRepository;


    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> saveAll(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }
}
