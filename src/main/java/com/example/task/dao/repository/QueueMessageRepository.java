package com.example.task.dao.repository;

import com.example.task.dao.entity.QueueMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueMessageRepository extends JpaRepository<QueueMessage,Long> {
}
