package com.coding.distributed_lovable.intelligence_service.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChatSessionId implements Serializable {

    Long projectId;
    Long userId;
}
