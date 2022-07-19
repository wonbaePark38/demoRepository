package com.neighbor.practice.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.neighbor.practice.domain.VmsDto;

@Repository
public class ChatRoomRepository {

    private Map<String, VmsDto> chatRoomDTOMap;

    @PostConstruct
    private void init(){
        chatRoomDTOMap = new LinkedHashMap<>();
    }

    public List<VmsDto> findAllRooms(){
        //채팅방 생성 순서 최근 순으로 반환
        List<VmsDto> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    public VmsDto findRoomById(String id){
        return chatRoomDTOMap.get(id);
    }

    /*public VmsDto createChatRoomDTO(String name){
        VmsDto room = VmsDto.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);

        return room;
    }*/
}