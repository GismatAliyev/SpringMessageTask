package com.example.task.mapper;

import com.example.task.dao.entity.Message;
import com.example.task.dao.entity.QueueMessage;
import com.example.task.dao.repository.QueueMessageRepository;
import com.example.task.model.MessageDto;
import com.example.task.model.QueueMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class QueueMessageMapper {

    public static final QueueMessageMapper INSTANCE = Mappers.getMapper(QueueMessageMapper.class);

    public abstract QueueMessageDto entityToDto(QueueMessage queueMessage);

    @Mappings({
            @Mapping(target = "message", source = "message.message"),
            @Mapping(target = "id", ignore = true)
    })
    public abstract QueueMessage dtoToEntity(Message message);

}
