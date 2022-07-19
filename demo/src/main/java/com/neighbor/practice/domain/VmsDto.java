package com.neighbor.practice.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VmsDto {

    private String vmsId;
    private String vmsDesc;
    private String routeNo;
    
    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    public static VmsDto create(String name){
        VmsDto room = new VmsDto();

        room.vmsId = UUID.randomUUID().toString();
        room.vmsDesc = name;
        return room;
    }
}