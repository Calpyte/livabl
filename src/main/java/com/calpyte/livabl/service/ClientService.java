package com.calpyte.livabl.service;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.domain.Client;
import com.calpyte.livabl.dto.ClientUpdateDTO;

import java.util.List;

public interface ClientService {

    Client save (Client client) throws CustomException;

    ClientUpdateDTO update(ClientUpdateDTO client) throws CustomException;

    Client findById(String id);

    List<Client> findAll();

    List<Client> saveAll(List<Client> clients);
}
