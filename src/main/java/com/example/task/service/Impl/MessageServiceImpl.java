package com.example.task.service.Impl;

import com.example.task.dao.entity.Message;
import com.example.task.dao.repository.MessageRepository;
import com.example.task.enums.MessageStatus;
import com.example.task.mapper.MessageMapper;
import com.example.task.model.MessageDto;
import com.example.task.service.MessageService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDto saveMessage(MessageDto message) {
        Message m = MessageMapper.INSTANCE.dtoToEntity(message);
        m.setMessageStatus(MessageStatus.CREATED);
        MessageDto messageDto = MessageMapper.INSTANCE.entityToDto(messageRepository.save(m));
        return messageDto;
    }

    @Override
    public List<MessageDto> getList() {
        List<MessageDto> messages = new ArrayList<>();
        messageRepository.findAll()
                .forEach(message -> {
                    messages.add(MessageMapper.INSTANCE.entityToDto(message));
                });
        return messages;
    }
}
