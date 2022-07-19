package com.neighbor.practice.dao;

import java.util.List;

import com.neighbor.practice.domain.BoardEntity;

public interface JpaBoardRepository {
	List<BoardEntity> findAllByBoardIdx();
}
