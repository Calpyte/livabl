package com.calpyte.livabl.service;

import com.calpyte.livabl.domain.Message;
import com.calpyte.livabl.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    Message save (Message messages);

    Message findById(String id);

    List<Message> findAll();

    List<Message> saveAll(List<Message> messages);

    MessageDTO sendHelpMessage(MessageDTO messageDTO);
}
