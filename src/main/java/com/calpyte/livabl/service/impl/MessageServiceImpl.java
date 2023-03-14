package com.calpyte.livabl.service.impl;

import com.calpyte.livabl.dao.MessageDAO;
import com.calpyte.livabl.domain.Message;
import com.calpyte.livabl.dto.MessageDTO;
import com.calpyte.livabl.service.MessageService;
import com.calpyte.livabl.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromId;

    @Override
    public Message save(Message message) {
        sendSimpleMessage(message);
        Mapper.setAuditable(message);
        return messageDAO.save(message);
    }

    public void sendSimpleMessage(Message messageObj) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromId);
        message.setTo(messageObj.getToId());
        message.setCc();
        message.setSubject(messageObj.getSubject());
        message.setText(messageObj.getBody());
        emailSender.send(message);
    }

    @Override
    public Message findById(String id) {
        return messageDAO.findById(id).orElse(null);
    }

    @Override
    public List<Message> findAll() {
        return messageDAO.findAll();
    }

    @Override
    public List<Message> saveAll(List<Message> messages) {
        messages.forEach(message -> sendSimpleMessage(message));
        return messageDAO.saveAll(messages.stream().map(message -> {Mapper.setAuditable(message); return message;}).collect(Collectors.toList()));
    }

    @Override
    public MessageDTO sendHelpMessage(MessageDTO messageDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromId);
        String[] toList = {"jyothsna1910@gmail.com" , "manoj.jeganathan93@gmail.com",
        "beyondsustainability2040@gmail.com","beyostech101@gmail.com"};
        message.setTo(toList);
        message.setCc();
        message.setSubject(messageDTO.getSubject());
        message.setText(messageDTO.getBody());
        emailSender.send(message);
        return messageDTO;
    }
}
