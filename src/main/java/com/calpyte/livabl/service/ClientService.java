package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.Client;

import java.util.List;

public interface ClientService {

    Client save (Client client);

    Client findById(String id);

    List<Client> findAll();

    List<Client> saveAll(List<Client> clients);
}
