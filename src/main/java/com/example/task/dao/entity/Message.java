package com.example.task.dao.entity;


import com.example.task.enums.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private MessageStatus messageStatus;

}
