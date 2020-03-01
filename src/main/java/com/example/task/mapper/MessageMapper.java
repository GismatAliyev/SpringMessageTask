package com.example.task.mapper;

import com.example.task.dao.entity.Message;
import com.example.task.model.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class MessageMapper {

    public static final MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mappings(
            @Mapping(target = "status",source = "message.messageStatus")
    )
    public abstract MessageDto entityToDto(Message message);


    @Mappings({
            @Mapping(target = "messageStatus", source = "message.status"),
            @Mapping(target = "id", ignore = true)
    })
    public abstract Message dtoToEntity(MessageDto message);

}
