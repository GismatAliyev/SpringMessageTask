package com.example.task.service.Impl;

import com.example.task.dao.entity.QueueMessage;
import com.example.task.dao.repository.QueueMessageRepository;
import com.example.task.mapper.QueueMessageMapper;
import com.example.task.model.QueueMessageDto;
import com.example.task.service.QueueMessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueMessageServiceImpl implements QueueMessageService {

    private QueueMessageRepository queueMessageRepository;


    public QueueMessageServiceImpl(QueueMessageRepository queueMessageRepository) {
        this.queueMessageRepository = queueMessageRepository;
    }

    @Override
    public List<QueueMessageDto> getMessageList() {
        List<QueueMessageDto> messageDtos =new ArrayList<>();
        queueMessageRepository
                .findAll()
                .forEach(queueMessage -> {
                    messageDtos.add(QueueMessageMapper.INSTANCE.entityToDto(queueMessage));
                });
        return messageDtos;
    }
}
