package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.configuration.CustomException;
import com.calpyte.livabl.dao.ClientDAO;
import com.calpyte.livabl.domain.Client;
import com.calpyte.livabl.dto.ClientUpdateDTO;
import com.calpyte.livabl.repository.ClientRepository;
import com.calpyte.livabl.service.ClientService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) throws CustomException {
        validate(client);
        Mapper.setAuditable(client);
        return clientDAO.save(client);
    }

    @Override
    public ClientUpdateDTO update(ClientUpdateDTO updateDTO) throws CustomException {

       Client client =  clientRepository.findByEmail(updateDTO.getRemail());
       if(client!=null && !ObjectUtils.isEmpty(client)){
           if(updateDTO.getRactive().equals("remove")) clientRepository.delete(client);
           else {
               client.setActive(updateDTO.getRactive());
               clientDAO.save(client);
           }
           return updateDTO;
       }else{
           throw new CustomException("No Client Found");
       }
    }

    private void validate(Client client) throws CustomException {
        Client client1 = clientRepository.findByEmail(client.getEmail());
        if(client1!=null && !ObjectUtils.isEmpty(client1)) throw new CustomException("Email is Already Exists");
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
