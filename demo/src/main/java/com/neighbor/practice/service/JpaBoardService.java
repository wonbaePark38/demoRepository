package com.neighbor.practice.service;

import java.util.List;

import com.neighbor.practice.domain.BoardEntity;

public interface JpaBoardService {
	List<BoardEntity> selectBoardList();
	void saveBoard();
	BoardEntity selectBoardDetail();
	void deleteBoard();
}
