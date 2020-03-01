package com.example.task.service;

import com.example.task.model.QueueMessageDto;

import java.util.List;

public interface QueueMessageService {

    List<QueueMessageDto> getMessageList();

}
