package com.example.task.dao.repository;

import com.example.task.dao.entity.Message;
import com.example.task.enums.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findByMessageStatus(MessageStatus messageStatus);

}
