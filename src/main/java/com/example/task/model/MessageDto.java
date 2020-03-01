package com.example.task.model;

import com.example.task.enums.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private long id;
    private String message;
    private MessageStatus status;


}
