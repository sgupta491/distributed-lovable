package com.coding.distributed_lovable.intelligence_service.mapper;

import com.coding.distributed_lovable.intelligence_service.dto.chat.ChatResponse;
import com.coding.distributed_lovable.intelligence_service.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
