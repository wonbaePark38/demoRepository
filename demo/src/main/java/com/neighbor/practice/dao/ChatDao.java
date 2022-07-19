package com.neighbor.practice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neighbor.practice.domain.VmsDto;

@Repository
public class ChatDao {
	
	@Resource(name = "oracleSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Transactional
	public List<VmsDto> roomList(){
		//List<ChatRoomDTO> result = new ArrayList<ChatRoomDTO>();
		return sqlSession.selectList("selectVmsList");
	}
	
	public void testDao(BusLocationVo vo) {
		int ss = 0;
		int count = 0;
		for(int i=0; i<10; i++) {
			ss = sqlSession.update("mergeBusLocation", vo);
			if(ss > 0) {
				count++;
			}
		}
		
		System.out.println("count > " + count);
	}
	
}
