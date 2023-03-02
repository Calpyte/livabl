package com.calpyte.livabl.dao;

import com.calpyte.livabl.domain.Message;

import java.util.List;
import java.util.Optional;

public interface MessageDAO {
    Message save(Message message);

    Optional<Message> findById(String id);

    List<Message> findAll();

    List<Message> saveAll(List<Message> messages);
}
