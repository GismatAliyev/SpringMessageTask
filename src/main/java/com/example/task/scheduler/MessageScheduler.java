package com.example.task.scheduler;

import com.example.task.dao.entity.Message;
import com.example.task.dao.entity.QueueMessage;
import com.example.task.dao.repository.MessageRepository;
import com.example.task.dao.repository.QueueMessageRepository;
import com.example.task.enums.MessageStatus;
import com.example.task.mapper.QueueMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageScheduler {
    private static final Logger logger = LoggerFactory.getLogger(MessageScheduler.class);

    private MessageRepository messageRepository;
    private QueueMessageRepository queueMessageRepository;

    public MessageScheduler(MessageRepository messageRepository,
                            QueueMessageRepository queueMessageRepository) {
        this.messageRepository = messageRepository;
        this.queueMessageRepository = queueMessageRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() {
       logger.info("start scheduling");

       List<Message> messages = messageRepository.findByMessageStatus(MessageStatus.CREATED);
       messages.forEach(message -> {
           try{
               QueueMessage queueMessage = QueueMessageMapper.INSTANCE.dtoToEntity(message);
               queueMessageRepository.save(queueMessage);
               message.setMessageStatus(MessageStatus.SUCCESS);
               messageRepository.save(message);
               logger.info("successfully");


           } catch (Exception ex) {
               logger.error("error occured",ex);
               message.setMessageStatus(MessageStatus.FAILED);
               messageRepository.save(message);
           }
       });

       logger.info("end scheduling");
    }

}
