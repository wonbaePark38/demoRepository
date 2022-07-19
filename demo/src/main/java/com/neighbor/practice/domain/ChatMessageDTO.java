package com.neighbor.practice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {
    private String vmsId;
    private String writer;
    private String message;
    private String messageType;
    private String receiver;
}