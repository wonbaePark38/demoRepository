package com.neighbor.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neighbor.practice.dao.BusLocationVo;
import com.neighbor.practice.dao.ChatDao;
import com.neighbor.practice.domain.VmsDto;

@Service
public class ChatService {
	@Autowired
	private ChatDao dao;
	
	public List<VmsDto> roomListService(){
		return dao.roomList();
	}
	
	public void testService() {
		BusLocationVo vo = new BusLocationVo();
		
		vo.setRouteId("9999");
		vo.setVehId("");
		
		dao.testDao(vo);
	}
}
