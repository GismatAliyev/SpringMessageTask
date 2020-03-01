package com.example.task.controller;


import com.example.task.model.MessageDto;
import com.example.task.service.Impl.MessageServiceImpl;
import com.example.task.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/save")
    public MessageDto save(@RequestBody MessageDto messageDto) {
        return messageService.saveMessage(messageDto);
    }

    @GetMapping("/getList")
    public List<MessageDto> getList() {
        return messageService.getList();
    }





}
