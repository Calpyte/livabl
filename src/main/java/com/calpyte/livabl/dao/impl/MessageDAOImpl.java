package com.calpyte.livabl.dao.impl;

import com.calpyte.livabl.dao.MessageDAO;
import com.calpyte.livabl.domain.Message;
import com.calpyte.livabl.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageDAOImpl implements MessageDAO{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Optional<Message> findById(String id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> saveAll(List<Message> messages) {
        return messageRepository.saveAll(messages);
    }
}
