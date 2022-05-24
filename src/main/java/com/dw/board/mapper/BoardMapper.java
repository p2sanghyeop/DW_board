package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dw.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//저장
	public int insertBoard(BoardVO vo);
	//조회
	public List<Map<String, Object>> selecrAllBoard();
	
}
