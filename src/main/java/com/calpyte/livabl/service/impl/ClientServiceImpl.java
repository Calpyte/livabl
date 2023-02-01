package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.ClientDAO;
import com.calpyte.livabl.domain.Client;
import com.calpyte.livabl.service.ClientService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client save(Client client) {
        Mapper.setAuditable(client);
        return clientDAO.save(client);
    }

    @Override
    public Client findById(String id) {
        return clientDAO.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public List<Client> saveAll(List<Client> clients) {
        return clientDAO.saveAll(clients);
    }
}
