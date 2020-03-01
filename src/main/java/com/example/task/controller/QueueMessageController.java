package com.example.task.controller;


import com.example.task.model.QueueMessageDto;
import com.example.task.service.QueueMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueueMessageController {
    private QueueMessageService queueMessageService;

    public QueueMessageController(QueueMessageService queueMessageService) {
        this.queueMessageService = queueMessageService;
    }

    @GetMapping("/getMessageList")
    public List<QueueMessageDto> getMessageList() {
        return queueMessageService.getMessageList();
    }
}
