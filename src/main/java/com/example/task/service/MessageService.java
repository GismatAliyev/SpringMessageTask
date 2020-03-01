package com.example.task.service;

import com.example.task.dao.entity.Message;
import com.example.task.model.MessageDto;

import java.util.List;

public interface MessageService {

    MessageDto saveMessage(MessageDto message);

    List<MessageDto> getList();

}
