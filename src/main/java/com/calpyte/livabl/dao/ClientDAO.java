package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDAO {
    Client save(Client client);

    Optional<Client> findById(String id);

    List<Client> findAll();

    List<Client> saveAll(List<Client> clients);

}
